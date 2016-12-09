package com.example.ricardom.tet2016;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import com.example.ricardom.tet2016.models.Ponente;
import com.example.ricardom.tet2016.receivers.BeaconReceiver;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.example.ricardom.tet2016.AppBeacons.BEACON_UUID;
import static com.example.ricardom.tet2016.R.id.map;

public class MapsEvent extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener,
        BeaconReceiver.OnBeaconListener, DialogInterface.OnClickListener{

    LinearLayout prog, pon, ubic;

    private GoogleMap mMap;

    int beacon;

    Region region;

    BeaconReceiver receiver;

    private BeaconManager beaconManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_event);

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setRangingListener(new BeaconManager.RangingListener(){

            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {

            }
        });

        //beacons
        //SystemRequirementsChecker.checkWithDefaultDialogs(this);
        receiver = new BeaconReceiver(this);
        IntentFilter filter = new IntentFilter(BeaconReceiver.ACTION_BEACON);
        registerReceiver(receiver, filter);
        //fin beacons


        prog = (LinearLayout) findViewById(R.id.btnHorario);
        pon = (LinearLayout) findViewById(R.id.btnPonentes);
        ubic = (LinearLayout) findViewById(R.id.btnMapa);

        prog.setOnClickListener(this);
        pon.setOnClickListener(this);
        ubic.setOnClickListener(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
        //map.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        region = new Region("ranged region", BEACON_UUID, null, null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback(){

            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });

        IntentFilter filter = new IntentFilter(BeaconReceiver.ACTION_BEACON);
        registerReceiver(receiver, filter);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng teatro = new LatLng(2.443176, -76.606018);
            mMap.addMarker(new MarkerOptions().position(teatro).title("Teatro Guillermo Leon Valencia"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teatro,16));

            //chivas
            LatLng chivas = new LatLng(2.444333, -76.605218);
            mMap.addMarker(new MarkerOptions().position(chivas).title("Punto de Encuentro Paseo Turistico en Chivas"));

            //salud
            LatLng salud = new LatLng(2.451072, -76.598935);
            mMap.addMarker(new MarkerOptions().position(salud).title("Facultad de Ciencias de la Salud"));

            //club leones
            LatLng club = new LatLng(2.442702, -76.607193);
            mMap.addMarker(new MarkerOptions().position(club).title("Club de Leones (Fiesta de Clausura)"));

            //casa mosquera
            LatLng mosquera = new LatLng(2.442974, -76.605119);
            mMap.addMarker(new MarkerOptions().position(mosquera).title("Casa Mosquera (Coctel de Bienvenida)"));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnHorario:
                Intent btnprog = new Intent(this, Programacion.class);
                startActivity(btnprog);
                break;
            case R.id.btnPonentes:
                Intent btnponentes = new Intent(this, Ponentes.class);
                startActivity(btnponentes);

                break;
            case R.id.btnMapa:
                Intent btnprin = new Intent(this, Principal.class);
                startActivity(btnprin);
                break;
        }

    }


    @Override
    public void onBeacon(int major, int minor) {

        if (minor == 55001 ) {
            Toast.makeText(this, "BEACON 1", Toast.LENGTH_LONG).show();
            beaconAlert1();
            beacon = 1;
        }

        if (minor == 52843 ) {
            Toast.makeText(this, "BEACON 2", Toast.LENGTH_LONG).show();
            beaconAlert2();
            beacon = 2;
        }

    }

    public void beaconAlert1() {

        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle(R.string.alert_title)
                .setIcon(R.drawable.ic_alert)
                .setMessage(R.string.alert_msg)
                .setPositiveButton(R.string.ok,this)
                .setNegativeButton(R.string.cancel, this)
                .create();
        alert.show();

    }

    public void beaconAlert2() {

        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle(R.string.alert_title2)
                .setIcon(R.drawable.ic_alert)
                .setMessage(R.string.alert_msg)
                .setPositiveButton(R.string.ok,this)
                .setNegativeButton(R.string.cancel, this)
                .create();
        alert.show();

    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if( i == DialogInterface.BUTTON_POSITIVE) {

            if (beacon == 1) {
                LatLng encuentro = new LatLng(3.536249, -76.387255);
                mMap.addMarker(new MarkerOptions().position(encuentro).title("Pabellon 1"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(encuentro, 30));
            }

            if (beacon == 2) {
                LatLng encuentro = new LatLng(3.536827, -76.388341);
                mMap.addMarker(new MarkerOptions().position(encuentro).title("Pabellon 2"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(encuentro, 30));
            }
        }
    }

}
