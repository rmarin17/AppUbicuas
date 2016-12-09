package com.example.ricardom.tet2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.estimote.sdk.BeaconManager;
import com.example.ricardom.tet2016.models.Ponente;
import com.example.ricardom.tet2016.adapters.PonenteAdapter;
import com.example.ricardom.tet2016.db.PonenteDao;

import java.util.ArrayList;
import java.util.List;

public class Conferencista extends AppCompatActivity {

    List<Ponente> data;
    PonenteAdapter adapter;
    ListView list;
    PonenteDao dao;

    int ponente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencista);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<>();

        adapter = new PonenteAdapter(this, data);

        //dao = new PonenteDao(this);

        list.setAdapter(adapter);

        loaddata();

    }

    private void loaddata() {

        if (ponente == 0) {

            Ponente p1 = new Ponente();

            p1.setNombre("Alejandra Joaqui T.");
            p1.setImagen("http://seminariotet2016.com/assets/images/conferencistas/alejandraj.png");
            p1.setEstudios("Ingeniera en Electrónica y Telecomunicaciones, con maestría en administración de negocios.");
            p1.setExperiencia("Experiencia en gestión de ofertas comerciales y manejo del portafolio para soluciones corporativas y redes de acceso con ZTE Corporation.");
            p1.setFormacioninternacional("Formación internacional con Siemens y Nokia proporcionando consultoría a ventas y la gerencia de proyectos en despliegues para redes móviles.");
            p1.setHabilidad("Habilidad de comunicación en diferentes niveles organizacionales, para el análisis estratégico y la negociación.");


            data.add(p1);
        }

        if (ponente == 1) {

            Ponente p2 = new Ponente();

            p2.setNombre("Alexander Galvis Q.");
            p2.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AlexGal.jpg");
            p2.setEstudios("Ingeniero en Electrónica y Telecomunicaciones de la Universidad del Cauca (Popayán - Colombia) y candidato a MSc en Ingeniería de la Universidad Pontificia Bolivariana (UPB, Medellín - Colombia.)");
            p2.setFormacioninternacional("* En el 2014 fue investigador invitado en The Metro-Access & Short Range Communications Group de la Universidad Técnica de Dinamarca - DTU (Lyngby - Dinamarca). \n" +
                    "\n" +
                    "*Presidente del Capítulo Colombiano de la Sociedad de Comunicaciones del IEEE entre el 2013 y 2016.");
            p2.setExperiencia("Experiencia en el área de comunicaciones inalámbricas y fue uno de los primeros profesionales en Colombia en ostentar la IEEE Wireless Communication Engineering Technologies Certification.");
            p2.setHabilidad("5G, SDN, NFV, nuevas tecnologías de radiocomunicaciones, mercado móvil.");

            data.add(p2);
        }

        if (ponente == 2) {


            Ponente p3 = new Ponente();

            p3.setNombre("Andrés F. Cosme");
            p3.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AndresCosme.jpg");
            p3.setEstudios("Ingeniero en Electrónica y Telecomunicaciones de la Universidad del Cauca, con Master of Science en Telemática de la Universidad de Twente en Holanda y MBA de la Universidad Sergio Arboleda de Bogotá.");
            p3.setExperiencia("Estrategias de negocio apalancadas en Tecnología, Transformación Digital, estudio, apropiación y aplicación de nuevas tendencias en tecnología (Big data, Cloud, IoT, entre otras), Gerencia de Proyectos, Gerencia de Productos, Gerencia de Operaciones y Preventa de Soluciones.");
            p3.setFormacioninternacional("Tecnologías de la Información y las Comunicaciones (TICs), con amplios conocimientos y experiencia práctica en las mismas en paises como españa, holanda y latinoamerica.");
            p3.setHabilidad("Portafolio Soluciones de Sistemas de Soporte al Negocio (BSS), Big Data, IoT, Billetera Móvil, entre otras.");

            data.add(p3);
        }

        if (ponente == 3) {

            Ponente p4 = new Ponente();

            p4.setNombre("Andrés Navarro");
            p4.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AndresICESI.png");
            p4.setEstudios("Ingeniero Electrónico (1993) , con maestría en gerencia de tecnología (1999), ambos títulos otorgados por la universidad PhD en Telecomunicaciones de la universidad politécnica de Valencia en 2003");
            p4.setExperiencia("Posee la membresía “Senior” del IEEE, fue consejero del programa Nacional de innovación en Electrónica, telecomunicaciones e informática del sistema colombiano de I+D+I hasta el año 2014, y miembro del comité asesor de Espectro de la ANE. EXPERTO DE LA UIT número 05228");
            p4.setFormacioninternacional("--");
            p4.setHabilidad("Sus intereses de investigación son gestión del espectro, planeación de radio móvil, propagación radio y “m-Health”");

            data.add(p4);
        }



    }

    public void setPonente(int ponente){

        this.ponente = ponente;

    }
}
