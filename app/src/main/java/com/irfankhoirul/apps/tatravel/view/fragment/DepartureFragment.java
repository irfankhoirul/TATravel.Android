package com.irfankhoirul.apps.tatravel.view.fragment;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
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
import com.irfankhoirul.apps.tatravel.contract.DepartureFragmentContract;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.presenter.DepartureFragmentPresenter;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.util.SnackBarBuilder;
import com.irfankhoirul.apps.tatravel.view.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.view.dialog.CityDialog;
import com.irfankhoirul.apps.tatravel.view.dialog.TravelLocationDialog;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartureFragment extends BaseFragment<MainActivity> implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        DepartureFragmentContract.View {

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
    MapView mapDeparture;
    @BindView(R.id.btSetDeparture)
    Button btSetDeparture;

    private GoogleMap departureMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private LatLng latLng;
    private boolean gotLocation = false;
    private View fragmentView;


    private ProgressDialog progressDialog;
    private DepartureFragmentPresenter departurePresenter;
    private Kota selectedCity;


    public DepartureFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.btSetDeparture)
    public void btSetDeparture() {
        Log.v("Location", departureMap.getCameraPosition().target.toString());
    }

    @OnClick(R.id.tieCity)
    public void tieCity() {
        FragmentManager manager = getFragmentManager();
        CityDialog cityDialog = new CityDialog();
        cityDialog.setTargetFragment(this, ConstantUtils.DIALOG_CITY_REQUEST_CODE);
        cityDialog.show(manager, "city_dialog_fragment");
    }

    @OnClick(R.id.tieLocation)
    public void tieLocation() {
        FragmentManager manager = getFragmentManager();
        TravelLocationDialog travelLocationDialog = TravelLocationDialog.newInstance(selectedCity);
        travelLocationDialog.setTargetFragment(this, ConstantUtils.DIALOG_LOCATION_REQUEST_CODE);
        travelLocationDialog.show(manager, "travel_location_dialog_fragment");
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

        departurePresenter = new DepartureFragmentPresenter(this);


        mapDeparture.onCreate(savedInstanceState);
        mapDeparture.onResume(); // needed to get the map to display immediately
        MapsInitializer.initialize(activity);
        mapDeparture.getMapAsync(this);

        return fragmentView;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
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
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == ConstantUtils.PERMISSION_REQUEST_LOCATIONS) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                }
                departureMap.setMyLocationEnabled(true);
            } else {

            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(activity, "OnConnected", Toast.LENGTH_SHORT).show();
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
            mLocationRequest.setNumUpdates(3); // Maksimum 5 kali update lokasi
            mLocationRequest.setInterval(30000); //30 seconds
            mLocationRequest.setFastestInterval(10000); //10 seconds
            mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            //mLocationRequest.setSmallestDisplacement(0.1F); //1/10 meter

            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
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
        Toast.makeText(activity, "OnLocationChanged", Toast.LENGTH_SHORT).show();
        latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //zoom to current position:
        if (!gotLocation) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLng).zoom(16).build();

            departureMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));

            gotLocation = true;
        }

    }


    @Override
    public void setProgressDialog(boolean visible, String title, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
        }
        if (!visible) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }


    @Override
    public void showSnackBar(int type, String message, String actionName, View.OnClickListener listener) {
        SnackBarBuilder snackBarBuilder = new SnackBarBuilder(activity);
        snackBarBuilder.setMessage(message)
                .setActionName(actionName)
                .setLength(Snackbar.LENGTH_SHORT)
                .setRoot(fragmentView)
                .setType(type)
                .setActionListener(listener)
                .build();
    }

    @Override
    public void showDialogCityDeparture() {

    }

    @Override
    public void showDialogDepartureLocation() {

    }

    @Override
    public void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanan) {

    }

    @Override
    public void updateLocationSpinner(List<Lokasi> lokasi) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ConstantUtils.DIALOG_CITY_RESULT_CODE) {
            selectedCity = Parcels.unwrap(data.getParcelableExtra("kota"));
            tieCity.setText(selectedCity.getNama() + ", " + selectedCity.getProvinsi().getNama());
        } else if (resultCode == ConstantUtils.DIALOG_LOCATION_RESULT_CODE) {
            Lokasi selectedLocation = Parcels.unwrap(data.getParcelableExtra("location"));
            tieLocation.setText(selectedLocation.getOperatorTravel().getNama() + ", " + selectedLocation.getAlamat());
        }
    }

}
