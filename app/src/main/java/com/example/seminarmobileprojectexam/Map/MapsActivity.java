package com.example.seminarmobileprojectexam.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.annotation.SuppressLint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seminarmobileprojectexam.CinemaData.CinemaViewModel;
import com.example.seminarmobileprojectexam.Map.MapHelper;
import com.example.seminarmobileprojectexam.R;
import com.example.seminarmobileprojectexam.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener,
        GoogleMap.OnMapLongClickListener {
    private LatLng targetAddress = null;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationClient;
    private MapHelper mapDirectionHelper;

    private volatile LatLng startLatLng, destLatLng;
    private Location lastLocation;

    private TextView edtLoc;
    private SeekBar scaleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        getTargetAddress();
        if (targetAddress!= null)
            destLatLng = targetAddress;
        Log.i("HVVN", String.valueOf(targetAddress));
        Log.i("HVVN", String.valueOf(destLatLng));

        edtLoc = findViewById(R.id.edtLoc);
        scaleBar = findViewById(R.id.skScale);
        scaleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                CameraPosition point = new CameraPosition.Builder()
                        .target(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()))
                        .zoom(i)
                        .build()
                        ;
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(point));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void getTargetAddress() {
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            String address = bundle.getString("address");
            if(address != null)
            {
                Log.i("address send", address);
                targetAddress = getLocationFromAddress(this, address);
                Log.i("after processing", String.valueOf(targetAddress));
            }


        }
    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address1;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address1 = coder.getFromLocationName(strAddress, 5);
            if (address1 == null) {
                return null;
            }

            Address location = address1.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
            Log.i("p1 latlng", String.valueOf(p1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Log.i("HVVN2", String.valueOf(p1));
        return p1;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
//                    123);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);

        LatLng hcmus = new LatLng(10.762912,106.682172);
        CameraPosition point = new CameraPosition.Builder()
                .target(hcmus)
                .zoom(16)
                .bearing(90)
                .tilt(30)
                .build()
                ;
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(point));
        updateLastLocation();

        mapDirectionHelper = new MapHelper(mMap, this);

    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (destLatLng != targetAddress) {
            if (startLatLng == null) {
                startLatLng = latLng;
                Toast.makeText(this,
                        "start:" + latLng.toString(), Toast.LENGTH_SHORT).show();
            } else {
                destLatLng = latLng;
                Toast.makeText(this,
                        "dest:" + latLng.toString(), Toast.LENGTH_SHORT).show();
                mapDirectionHelper.startDirection(startLatLng, destLatLng);
            }
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        destLatLng = null;
        mapDirectionHelper.clearDirectionResult();
        Toast.makeText(this,
                "clear start+dest",
                Toast.LENGTH_SHORT).show();
    }

    private void updateLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
//                    123);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @SuppressLint({"DefaultLocale", "SetTextI18n"})
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            lastLocation = location;
                            startLatLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
                            if (destLatLng != null){
                                Log.i("test", "start");
                                mapDirectionHelper.startDirection(startLatLng, destLatLng);
                                Log.i("test", "finish");
                            }
                            edtLoc.setText("Your location: " +
                                    String.format("%f,%f",
                                            location.getLatitude(),
                                            location.getLongitude()));
                        }
                    }
                });
    }
}