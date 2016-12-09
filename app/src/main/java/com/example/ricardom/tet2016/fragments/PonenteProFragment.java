package com.example.ricardom.tet2016.fragments;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ricardom.tet2016.BR;
import com.example.ricardom.tet2016.MapsEvent;
import com.example.ricardom.tet2016.Principal;
import com.example.ricardom.tet2016.Programacion;
import com.example.ricardom.tet2016.models.PonentePro;
import com.example.ricardom.tet2016.R;
import com.example.ricardom.tet2016.adapters.AdapterPonentePro;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PonenteProFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    LinearLayout prog, pon, ubic;

    List<PonentePro> data;
    AdapterPonentePro adapter;
    ListView list;

    @Override
    public void onClick(View v) {

        int r = 0;

        switch (v.getId()){
            case R.id.btnHorario:
                Intent btnprog = new Intent(getContext(), Programacion.class);
                startActivity(btnprog);
                break;
            case R.id.btnPonentes:
                Intent btnprin = new Intent(getContext(), Principal.class);
                startActivity(btnprin);
                break;
            case R.id.btnMapa:
                Intent btnmaps = new Intent(getContext(), MapsEvent.class);
                startActivity(btnmaps);
                break;
        }

    }


    public interface OnPonenteSelectedListener{
        void onPonenteSelected(int ponente);
    }

    OnPonenteSelectedListener onPonenteSelectedListener;
    ViewDataBinding binding;


    public PonenteProFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onPonenteSelectedListener = (OnPonenteSelectedListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_ponente_pro, container, false);

        prog = (LinearLayout) view.findViewById(R.id.btnHorario);
        pon = (LinearLayout) view.findViewById(R.id.btnPonentes);
        ubic = (LinearLayout) view.findViewById(R.id.btnMapa);

        prog.setOnClickListener(this);
        pon.setOnClickListener(this);
        ubic.setOnClickListener(this);


        binding = DataBindingUtil.bind(view);
        binding.setVariable(BR.onItemClick, this);

        // Inflate the layout for this fragment
        if (savedInstanceState == null)
        list = (ListView) view.findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new AdapterPonentePro(getContext(), data);


        list.setAdapter(adapter);

        //list.setOnItemClickListener(new AdapterPonentePro.OnItemClickListener());
        if (savedInstanceState ==  null)
            loaddata();

        return view;


    }



    public void loaddata(){

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

        PonentePro p5 = new PonentePro();
        p5.setNombre("Carlos E. Delgado");
        p5.setImagen("http://seminariotet2016.com/assets/images/conferencistas/carlosdelgado.png");

        PonentePro p6 = new PonentePro();
        p6.setNombre("Cristian Riaño");
        p6.setImagen("http://seminariotet2016.com/assets/images/conferencistas/CristianR.png");

        PonentePro p7 = new PonentePro();
        p7.setNombre("Daniel A. Pajoy");
        p7.setImagen("http://seminariotet2016.com/assets/images/conferencistas/DanielPajoy.jpg");

        PonentePro p8 = new PonentePro();
        p8.setNombre("Diego Gómez S.");
        p8.setImagen("http://seminariotet2016.com/assets/images/conferencistas/diegogomez.jpg");

        PonentePro p9 = new PonentePro();
        p9.setNombre("Edwin Bravo");
        p9.setImagen("http://seminariotet2016.com/assets/images/conferencistas/Edwin2015.jpg");

        PonentePro p10 = new PonentePro();
        p10.setNombre("Eva J. Maya");
        p10.setImagen("http://seminariotet2016.com/assets/images/conferencistas/EvaM.png");

        PonentePro p11 = new PonentePro();
        p11.setNombre("Fabián Muñoz");
        p11.setImagen("http://seminariotet2016.com/assets/images/conferencistas/FabMu.jpg");

        PonentePro p12 = new PonentePro();
        p12.setNombre("Guillaume LeBlanc");
        p12.setImagen("http://seminariotet2016.com/assets/images/conferencistas/guill_paxi.png");

        PonentePro p13 = new PonentePro();
        p13.setNombre("Hugo Campos");
        p13.setImagen("http://seminariotet2016.com/assets/images/conferencistas/HugoCampos.png");

        PonentePro p14 = new PonentePro();
        p14.setNombre("Iván Sánchez M.");
        p14.setImagen("http://seminariotet2016.com/assets/images/conferencistas/IvanSanchez.png");

        PonentePro p15 = new PonentePro();
        p15.setNombre("Jair A. Mazabuel");
        p15.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mazbuel_makro.png");

        PonentePro p16 = new PonentePro();
        p16.setNombre("Jairo Angulo");
        p16.setImagen("http://seminariotet2016.com/assets/images/conferencistas/jairoangulo.png");

        PonentePro p17 = new PonentePro();
        p17.setNombre("Diego Felipe Parra");
        p17.setImagen("http://seminariotet2016.com/assets/images/conferencistas/jhonnyAvaya.png");

        PonentePro p18 = new PonentePro();
        p18.setNombre("José A. Roure");
        p18.setImagen("http://seminariotet2016.com/assets/images/conferencistas/JoseRoure.jpg");

        PonentePro p19 = new PonentePro();
        p19.setNombre("José G. Acuña R.");
        p19.setImagen("http://seminariotet2016.com/assets/images/conferencistas/acuna.png");

        PonentePro p20 = new PonentePro();
        p20.setNombre("Ma. del Pilar Rivera");
        p20.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mariaprivera.jpg");

        PonentePro p21 = new PonentePro();
        p21.setNombre("Miguel Díaz");
        p21.setImagen("http://seminariotet2016.com/assets/images/conferencistas/MigueD.jpg");

        PonentePro p22 = new PonentePro();
        p22.setNombre("Nicolás Silva C.");
        p22.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mintic.jpg");

        PonentePro p23 = new PonentePro();
        p23.setNombre("Patricia H. Fierro");
        p23.setImagen("http://seminariotet2016.com/assets/images/conferencistas/PatriciaFierro.jpg");

        PonentePro p24 = new PonentePro();
        p24.setNombre("Carolina Campo");
        p24.setImagen("http://seminariotet2016.com/assets/images/conferencistas/carolinacampo.png");

        PonentePro p25 = new PonentePro();
        p25.setNombre("Alejandro Muñoz G.");
        p25.setImagen("http://seminariotet2016.com/assets/images/conferencistas/dobleclick.png");


        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);
        data.add(p7);
        data.add(p8);
        data.add(p9);
        data.add(p10);
        data.add(p11);
        data.add(p12);
        data.add(p13);
        data.add(p14);
        data.add(p15);
        data.add(p16);
        data.add(p17);
        data.add(p18);
        data.add(p19);
        data.add(p20);
        data.add(p21);
        data.add(p22);
        data.add(p23);
        data.add(p24);
        data.add(p25);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        onPonenteSelectedListener.onPonenteSelected(position);

    }
}
