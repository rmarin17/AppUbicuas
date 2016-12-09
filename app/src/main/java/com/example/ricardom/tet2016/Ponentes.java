package com.example.ricardom.tet2016;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ricardom.tet2016.adapters.PagerAdapter;
import com.example.ricardom.tet2016.databinding.ActivityConferencistaListBinding;
import com.example.ricardom.tet2016.databinding.ActivityPonentesBinding;
import com.example.ricardom.tet2016.fragments.PonenteFragment;
import com.example.ricardom.tet2016.fragments.PonenteProFragment;

import java.util.ArrayList;
import java.util.List;

public class Ponentes extends AppCompatActivity implements PonenteProFragment.OnPonenteSelectedListener {


    ViewPager pager;
    PagerAdapter adapter;
    ActivityPonentesBinding binding;

    PonenteFragment ponente1;
    PonenteProFragment ponentepro;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPonentesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ponente1 = new PonenteFragment();
        ponentepro = new PonenteProFragment();

        putFragment(R.id.container, ponentepro);

    }

    private void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();

        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public void onPonenteSelected(int ponente) {
       //Toast.makeText(this, "Ponente :"+ponente, Toast.LENGTH_SHORT).show();
        ponente1.setPonente(ponente);
        //getSupportActionBar().setTitle("Ponente");
        putFragment(R.id.container, ponente1);
    }
}
