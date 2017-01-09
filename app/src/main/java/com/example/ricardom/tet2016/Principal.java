package com.example.ricardom.tet2016;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.estimote.sdk.SystemRequirementsChecker;
import com.example.ricardom.tet2016.receivers.BeaconReceiver;

import java.util.ArrayList;
import java.util.List;


public class Principal extends AppCompatActivity implements View.OnClickListener {

   LinearLayout prog, pon, ubic;


    BeaconReceiver receiver;


    @Override
    protected void onResume() {
        super.onResume();
        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        prog = (LinearLayout) findViewById(R.id.btnHorario);
        pon = (LinearLayout) findViewById(R.id.btnPonentes);
        ubic = (LinearLayout) findViewById(R.id.btnMapa);

        prog.setOnClickListener(this);
        pon.setOnClickListener(this);
        ubic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        int r = 0;

        switch (v.getId()){
           case R.id.btnHorario:
                Intent btnprog = new Intent(Principal.this, Programacion.class);
                startActivity(btnprog);
                break;
            case R.id.btnPonentes:
                Intent btnponentes = new Intent(Principal.this, Ponentes.class);
                startActivity(btnponentes);

                break;
            case R.id.btnMapa:

                Intent btnmaps = new Intent(Principal.this, MapsEvent.class);
                startActivity(btnmaps);

                break;
        }

    }
}
