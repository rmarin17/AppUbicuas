package com.example.ricardom.tet2016;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ricardom.tet2016.adapters.AdapterPonentePro;
import com.example.ricardom.tet2016.databinding.ActivityConferencistaListBinding;
import com.example.ricardom.tet2016.models.PonentePro;

import java.util.ArrayList;
import java.util.List;

public class ConferencistaList extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    LinearLayout prog, pon, ubic;

    List<PonentePro> data;
    AdapterPonentePro adapter;
    ListView list;
    Conferencista ponente1;


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        onPonenteSelectedListener.onPonenteSelected(position);
    }

    @Override
    public void onClick(View v) {

        int r = 0;

        switch (v.getId()){
            case R.id.btnHorario:
                Intent btnprog = new Intent(this, Programacion.class);
                startActivity(btnprog);
                break;
            case R.id.btnPonentes:
                break;
            case R.id.btnMapa:

                Intent btnmaps = new Intent(this, MapsEvent.class);
                startActivity(btnmaps);

                break;
        }

    }


    public interface OnPonenteSelectedListener{
        void onPonenteSelected(int ponente);
    }

    OnPonenteSelectedListener onPonenteSelectedListener;
    ActivityConferencistaListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConferencistaListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setVariable(BR.onItemClick, this);


        prog = (LinearLayout) findViewById(R.id.btnHorario);
        pon = (LinearLayout) findViewById(R.id.btnPonentes);
        ubic = (LinearLayout) findViewById(R.id.btnMapa);
        prog.setOnClickListener(this);
        pon.setOnClickListener(this);
        ubic.setOnClickListener(this);


        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new AdapterPonentePro(this, data);

        List<Conferencista> data = new ArrayList<>();


        Conferencista p1 = new Conferencista();
        p1.setPonente(1);

        Conferencista p2 = new Conferencista();
        p2.setPonente(2);

        Conferencista p3 = new Conferencista();
        p3.setPonente(3);

        Conferencista p4 = new Conferencista();
        p4.setPonente(4);


        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);

        list.setAdapter(adapter);


        loaddata();
    }

    private void loaddata() {


        PonentePro p1 = new PonentePro();

        p1.setNombre("Alejandra Joaqui T.");
        p1.setImagen("http://seminariotet2016.com/assets/images/conferencistas/alejandraj.png");

        PonentePro p2 = new PonentePro();

        p2.setNombre("Alexander Galvis Q.");
        p2.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AlexGal.jpg");

        PonentePro p3 = new PonentePro();

        p3.setNombre("Andrés F. Cosme");
        p3.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AndresCosme.jpg");

        PonentePro p4 = new PonentePro();

        p4.setNombre("Andrés Navarro");
        p4.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AndresICESI.png");


        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);


    }
}
