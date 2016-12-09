package com.example.ricardom.tet2016;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ricardom.tet2016.adapters.PagerAdapter;
import com.example.ricardom.tet2016.fragments.DiaFragment;
import com.example.ricardom.tet2016.models.Ponente;

import java.util.ArrayList;
import java.util.List;

public class Programacion extends AppCompatActivity implements View.OnClickListener{

    LinearLayout prog, pon, ubic;

    ViewPager pager;
    PagerAdapter adapter;
    TabLayout tabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prog = (LinearLayout) findViewById(R.id.btnHorario);
        pon = (LinearLayout) findViewById(R.id.btnPonentes);
        ubic = (LinearLayout) findViewById(R.id.btnMapa);

        if (savedInstanceState == null) {
            tabs = (TabLayout) findViewById(R.id.tabs);
            pager = (ViewPager) findViewById(R.id.pager);
            List<Fragment> data = new ArrayList<>();

            DiaFragment dia1 = DiaFragment.newInstance(1, "http://www.unicauca.edu.co/moocmaker/pagapp/consultandroid.php?idd=1");
            DiaFragment dia2 = DiaFragment.newInstance(2, "http://www.unicauca.edu.co/moocmaker/pagapp/consultandroid.php?idd=2");
            DiaFragment dia3 = DiaFragment.newInstance(3, "http://www.unicauca.edu.co/moocmaker/pagapp/consultandroid.php?idd=3");

            data.add(dia1);
            data.add(dia2);
            data.add(dia3);

            adapter = new PagerAdapter(getSupportFragmentManager(), data);
            pager.setAdapter(adapter);

            tabs.setupWithViewPager(pager);
        }

        prog.setOnClickListener(this);
        pon.setOnClickListener(this);
        ubic.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        int r = 0;

        switch (v.getId()){
            case R.id.btnHorario:
                Intent btnprin = new Intent(this, Principal.class);
                startActivity(btnprin);
                break;
            case R.id.btnPonentes:
                Intent btnponentes = new Intent(this, Ponentes.class);
                startActivity(btnponentes);
                break;
            case R.id.btnMapa:
                Intent btnmaps = new Intent(this, MapsEvent.class);
                startActivity(btnmaps);
                break;
        }

    }

}
