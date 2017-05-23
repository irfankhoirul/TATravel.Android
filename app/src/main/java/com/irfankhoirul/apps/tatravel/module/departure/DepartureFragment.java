package com.irfankhoirul.apps.tatravel.module.departure;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.apps.tatravel.module.travel_choice.DaggerTravelChoiceComponent;
import com.irfankhoirul.apps.tatravel.module.travel_choice.TravelChoiceDialog;
import com.irfankhoirul.apps.tatravel.module.travel_choice.TravelChoiceDialogPresenter;
import com.irfankhoirul.apps.tatravel.module.travel_choice.TravelChoicePresenterModule;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartureFragment extends BaseFragment<MainActivity, DepartureContract.Presenter> implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        TravelChoiceDialog.DialogListener,
        DepartureContract.View {

    @BindView(R.id.tieCity)
    TextInputEditText tieCity;
    @BindView(R.id.tieLocation)
    TextInputEditText tieLocation;
    @BindView(R.id.switchSpecialLocation)
    Switch switchSpecialLocation;
    @BindView(R.id.tvSpecialLocationInformation)
    TextView tvSpecialLocationInformation;
    @BindView(R.id.ivMarkerDeparture)
    ImageView ivMarkerDeparture;
    @BindView(R.id.mapDeparture)
    MapView mapViewDeparture;
    @BindView(R.id.btSetDeparture)
    Button btSetDeparture;
    @BindView(R.id.tvAutocompletePlace)
    TextView tvAutocompletePlace;

    @Inject
    TravelChoiceDialogPresenter travelChoiceDialogPresenter;

    private GoogleMap departureMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private LatLng latLng;

    public DepartureFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Keberangkatan";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_departure, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        setupMap(savedInstanceState);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
    }

    private void setupMap(Bundle savedInstanceState) {
        mapViewDeparture.onCreate(savedInstanceState);
        mapViewDeparture.onResume(); // needed to get the map to display immediately
        mapViewDeparture.getMapAsync(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MapsInitializer.initialize(activity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick(R.id.fabCurrentLocation)
    public void fabCurrentLocation() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng).zoom(16).build();

        departureMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }

    @OnClick(R.id.tvAutocompletePlace)
    public void tvAutocompletePlace() {
        try {
            Intent intent = new PlaceAutocomplete
                    .IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .build(activity);
            startActivityForResult(intent, ConstantUtils.PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btSetDeparture)
    public void btSetDeparture() {
        TravelChoiceDialog travelChoiceDialog = TravelChoiceDialog.newInstance(mPresenter.getLocationList());
        travelChoiceDialog.setListener(this);
        travelChoiceDialog.show(getFragmentManager(), "travelChoiceDialog");

        DaggerTravelChoiceComponent.builder()
                .travelChoicePresenterModule(new TravelChoicePresenterModule(travelChoiceDialog))
                .build().inject(this);
    }

    @OnClick(R.id.btCheckAvailability)
    public void btCheckAvailability() {
        Map<String, String> params = new HashMap<>();
        params.put("latitude", String.valueOf(departureMap.getCameraPosition().target.latitude));
        params.put("longitude", String.valueOf(departureMap.getCameraPosition().target.longitude));
        mPresenter.checkLocationAvailability(params);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ConstantUtils.PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(activity, data);
                Log.v("GooglePlace", "Do! " + place.getName().toString());
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(place.getLatLng()).zoom(16).build();
                tvAutocompletePlace.setText(place.getName());
                departureMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(activity, data);
                Log.v("GooglePlace", "Do! " + status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                Log.v("GooglePlace", "Do! " + "Canceled!");
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        departureMap = googleMap;
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] locationPermissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            requestPermissions(locationPermissions, ConstantUtils.PERMISSION_REQUEST_LOCATIONS);
        } else {
            departureMap.setMyLocationEnabled(true);
            buildGoogleApiClient();
            mGoogleApiClient.connect();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient
                .Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == ConstantUtils.PERMISSION_REQUEST_LOCATIONS) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    departureMap.setMyLocationEnabled(true);
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] locationPermissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            requestPermissions(locationPermissions, ConstantUtils.PERMISSION_REQUEST_LOCATIONS);
        } else {
            Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                //place marker at current position
                //mGoogleMap.clear();
                latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Current Position");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            }

            mLocationRequest = new LocationRequest();
            mLocationRequest.setNumUpdates(2); // Maksimum 2 kali update lokasi
            mLocationRequest.setInterval(30000); //30 seconds
            mLocationRequest.setFastestInterval(10000); //10 seconds
            mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
            //mLocationRequest.setSmallestDisplacement(0.1F); //1/10 meter

            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

            departureMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int i) {
                    departureMap.clear();
                    btSetDeparture.setEnabled(false);
                    btSetDeparture.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_300));
                }
            });
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //zoom to current position:
        if (!mPresenter.isGotLocation()) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLng).zoom(16).build();

            departureMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));

            mPresenter.setGotLocation(true);
        }

    }

    @Override
    public void setPresenter(DepartureContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    @Override
    public void updateMap(List<Lokasi> locations) {
        mPresenter.setLocationList(locations);
        departureMap.clear();
        if (locations.size() > 0) {
            showStatus(ConstantUtils.STATUS_INFO, mPresenter.prepareOperatorTraveldata(locations).size() + " Operator Travel tersedia");
            btSetDeparture.setEnabled(true);
            btSetDeparture.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorAccent));
/*
            for (int i = 0; i < locations.size(); i++) {
                departureMap.addMarker(new MarkerOptions()
                        .position(new LatLng(Double.parseDouble(locations.get(i).getLatitude()),
                                Double.parseDouble(locations.get(i).getLongitude())))
                        .title(locations.get(i).getOperatorTravel().getNama() + " - " + locations.get(i).getNama()));
            }
*/
        } else {
            showStatus(ConstantUtils.STATUS_WARNING, "Operator Travel tidak ditemukan");
            btSetDeparture.setEnabled(false);
            btSetDeparture.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_300));
        }
    }

    @Override
    public void onOperatorTravelChoose(final TravelChoiceDialog travelChoiceDialog, final OperatorTravel operatorTravel, final List<Integer> operatorTravelLocationIds) {
        final double tmpLat = departureMap.getCameraPosition().target.latitude;
        final double tmpLon = departureMap.getCameraPosition().target.longitude;
        setLoadingDialog(true, "Tunggu sebentar...");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<Address> addresses = null;
                try {
                    Locale indonesia = new Locale("in", "ID");
                    addresses = new Geocoder(activity, indonesia).getFromLocation(tmpLat, tmpLon, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                setLoadingDialog(false, null);
                if (addresses != null && addresses.get(0) != null) {
                    Address address = addresses.get(0);
                    Intent intent = new Intent();
                    intent.putExtra("latitude", address.getLatitude()); // Double
                    intent.putExtra("longitude", address.getLongitude()); // Double
                    intent.putExtra("thoroughfare", address.getThoroughfare());
                    intent.putExtra("locality", address.getLocality());
                    intent.putExtra("sub_admin", address.getSubAdminArea());
                    intent.putExtra("admin", address.getAdminArea());
                    intent.putExtra("id_operator_travel", operatorTravel.getId());
                    intent.putExtra("operatorTravelLocationIds", Parcels.wrap(operatorTravelLocationIds));
                    travelChoiceDialog.dismiss();
                    activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS, intent);
                    activity.finish();
                } else {
                    showToast(ConstantUtils.STATUS_ERROR, "Gagal mendapatkan lokasi");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                showToast(ConstantUtils.STATUS_ERROR, "Gagal mendapatkan lokasi");
            }
        });
        thread.start();
    }
}