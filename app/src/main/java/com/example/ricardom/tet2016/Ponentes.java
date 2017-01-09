package com.example.ricardom.tet2016;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ricardom.tet2016.databinding.ActivityPonentesBinding;
import com.example.ricardom.tet2016.fragments.PonenteFragment;
import com.example.ricardom.tet2016.fragments.PonenteProFragment;

public class Ponentes extends AppCompatActivity implements PonenteProFragment.OnPonenteSelectedListener {

    ActivityPonentesBinding binding;

    PonenteFragment ponente1;
    PonenteProFragment ponentepro;

    boolean secondScreen, firstScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPonentesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ponente1 = new PonenteFragment();
        ponentepro = new PonenteProFragment();

        putFragment(R.id.container, ponentepro);
        firstScreen = true;

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
        secondScreen = true;
    }


    private long pulsacionBackInicial = 0;
    private long pulsacionBackActual = 0;
    private int tiempoEnMilisegundos = 1000;

    @Override
    public void onBackPressed() {
        pulsacionBackActual = System.currentTimeMillis();

        if(secondScreen) {
            putFragment(R.id.container, ponentepro);
        }
        if (pulsacionBackActual - pulsacionBackInicial > tiempoEnMilisegundos) {
            pulsacionBackInicial = pulsacionBackActual;
        }
        else{
            super.onBackPressed();}
    }

}
