package com.irfankhoirul.apps.tatravel.modules.destination;


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
import com.irfankhoirul.apps.tatravel.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinationFragment extends BaseFragment<MainActivity, DestinationContract.Presenter> implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        DestinationContract.View {

    @BindView(R.id.tieCity)
    TextInputEditText tieCity;
    @BindView(R.id.tieLocation)
    TextInputEditText tieLocation;
    @BindView(R.id.switchSpecialLocation)
    Switch switchSpecialLocation;
    @BindView(R.id.tvSpecialLocationInformation)
    TextView tvSpecialLocationInformation;
    @BindView(R.id.ivMarkerDestination)
    ImageView ivMarkerDestination;
    @BindView(R.id.mapDestination)
    MapView mapViewDestination;
    @BindView(R.id.btSetDestination)
    Button btSetDestination;
    @BindView(R.id.tvAutocompletePlace)
    TextView tvAutocompletePlace;

    private GoogleMap destinationMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private LatLng latLng;

    public DestinationFragment() {
        // Required empty public constructor
    }

    public static DestinationFragment newInstance(int idOperatorTravel) {
        DestinationFragment destinationFragment = new DestinationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id_operator_travel", idOperatorTravel);
        destinationFragment.setArguments(bundle);

        return destinationFragment;
    }

    @Override
    protected void setTitle() {
        title = "Tujuan";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_destination, container, false);
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
        mapViewDestination.onCreate(savedInstanceState);
        mapViewDestination.onResume(); // needed to get the map to display immediately
        mapViewDestination.getMapAsync(this);

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        destinationMap = googleMap;

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] locationPermissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            requestPermissions(locationPermissions, ConstantUtils.PERMISSION_REQUEST_LOCATIONS);
        } else {
            destinationMap.setMyLocationEnabled(true);
            buildGoogleApiClient();
            mGoogleApiClient.connect();
        }
    }

    @OnClick(R.id.fabCurrentLocation)
    public void fabCurrentLocation() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng).zoom(16).build();

        destinationMap.animateCamera(CameraUpdateFactory
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

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(LocationServices.API)
                .build();
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
                destinationMap.animateCamera(CameraUpdateFactory
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == ConstantUtils.PERMISSION_REQUEST_LOCATIONS) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    destinationMap.setMyLocationEnabled(true);
                }
                destinationMap.setMyLocationEnabled(true);
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

            destinationMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int i) {
                    destinationMap.clear();
                    btSetDestination.setEnabled(false);
                    btSetDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_300));
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

            destinationMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));

            mPresenter.setGotLocation(true);
        }

    }

    @Override
    public void setPresenter(DestinationContract.Presenter presenter) {
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
        destinationMap.clear();
        if (locations.size() > 0) {
            showStatus(ConstantUtils.STATUS_INFO, "Operator Travel tersedia");
            btSetDestination.setEnabled(true);
            btSetDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorAccent));
/*
            for (int i = 0; i < locations.size(); i++) {
                destinationMap.addMarker(new MarkerOptions()
                        .position(new LatLng(Double.parseDouble(locations.get(i).getLatitude()),
                                Double.parseDouble(locations.get(i).getLongitude())))
                        .title(locations.get(i).getOperatorTravel().getNama() + " - " + locations.get(i).getNama()));
            }
*/
        } else {
            showStatus(ConstantUtils.STATUS_WARNING, "Operator Travel tidak ditemukan");
            btSetDestination.setEnabled(false);
            btSetDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_300));
        }
    }

    @OnClick(R.id.btSetDestination)
    public void btSetDestination() {
        final double tmpLat = destinationMap.getCameraPosition().target.latitude;
        final double tmpLon = destinationMap.getCameraPosition().target.longitude;
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
                    showToast(ConstantUtils.STATUS_ERROR, "Gagal mendapatkan lokasi");
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
                    intent.putExtra("operatorTravelLocationIds", Parcels.wrap(mPresenter.getTravelLocationIds()));
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

    @OnClick(R.id.btCheckAvailability)
    public void btCheckAvailability() {
        Map<String, String> params = new HashMap<>();
        params.put("latitude", String.valueOf(destinationMap.getCameraPosition().target.latitude));
        params.put("longitude", String.valueOf(destinationMap.getCameraPosition().target.longitude));
        params.put("id_operator_travel", String.valueOf(getArguments().getInt("id_operator_travel")));
        mPresenter.checkLocationAvailability(params);
    }

}