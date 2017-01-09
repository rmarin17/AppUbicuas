package com.example.ricardom.tet2016.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ricardom.tet2016.Ponentes;
import com.example.ricardom.tet2016.Programacion;
import com.example.ricardom.tet2016.models.Ponente;
import com.example.ricardom.tet2016.R;
import com.example.ricardom.tet2016.adapters.PonenteAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PonenteFragment extends Fragment {

    LinearLayout prog;

    List<Ponente> data;
    PonenteAdapter adapter;
    ListView list;

    int ponente;

    public PonenteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ponente, container, false);

        prog = (LinearLayout) view.findViewById(R.id.btnHorario);

        list = (ListView) view.findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new PonenteAdapter(getContext(), data);

        list.setAdapter(adapter);

        loaddata();

        return view;
    }

    public void loaddata(){

        if (ponente == 0) {

            Ponente p1 = new Ponente();

            p1.setNombre("Alejandra Joaqui T.");
            p1.setEmpresa("ZTE");
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
            p2.setEmpresa("IEEE COMSOC");
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
            p3.setEmpresa("HUAWEI");
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
            p4.setEmpresa("ICESI");
            p4.setImagen("http://seminariotet2016.com/assets/images/conferencistas/AndresICESI.png");
            p4.setEstudios("Ingeniero Electrónico (1993) , con maestría en gerencia de tecnología (1999), ambos títulos otorgados por la universidad PhD en Telecomunicaciones de la universidad politécnica de Valencia en 2003");
            p4.setExperiencia("Posee la membresía “Senior” del IEEE, fue consejero del programa Nacional de innovación en Electrónica, telecomunicaciones e informática del sistema colombiano de I+D+I hasta el año 2014, y miembro del comité asesor de Espectro de la ANE. EXPERTO DE LA UIT número 05228");
            p4.setFormacioninternacional(" ");
            p4.setHabilidad("Sus intereses de investigación son gestión del espectro, planeación de radio móvil, propagación radio y “m-Health”");

            data.add(p4);
        }

        if (ponente == 4) {

            Ponente p5 = new Ponente();

            p5.setNombre("Carlos E. Delgado");
            p5.setEmpresa("TIGO");
            p5.setImagen("http://seminariotet2016.com/assets/images/conferencistas/carlosdelgado.png");
            p5.setEstudios("Ingeniero en Electrónica y Telecomunicaciones con especialización en Gerencia Financiera y en Gerencia de proyectos de Telecomunicacione");
            p5.setExperiencia("tiene un amplio conocimiento en el estándar GSMA y en asuntos técnicos y regulatorios de la industria de las telecomunicaciones");
            p5.setFormacioninternacional(" ");
            p5.setHabilidad("Es un gran experto en MVNO y en negocios internacionales, hábil en negociaciones y manejando relaciones corporativas en todo el mundo, es competente en el liderazgo de equipos internacionales y multidisciplinarios para implementar nuevos proyectos y desarrollar estrategias de crecimiento de negocios");

            data.add(p5);
        }
        //Falta por completar
        if (ponente == 5) {

            Ponente p6 = new Ponente();

            p6.setNombre("Cristian Riaño");
            p6.setEmpresa("CODESCRUM");
            p6.setImagen("http://seminariotet2016.com/assets/images/conferencistas/CristianR.png");
            p6.setEstudios("Ingeniero Electrónico (1993) , con maestría en gerencia de tecnología (1999), ambos títulos otorgados por la universidad PhD en Telecomunicaciones de la universidad politécnica de Valencia en 2003");
            p6.setExperiencia("Posee la membresía “Senior” del IEEE, fue consejero del programa Nacional de innovación en Electrónica, telecomunicaciones e informática del sistema colombiano de I+D+I hasta el año 2014, y miembro del comité asesor de Espectro de la ANE. EXPERTO DE LA UIT número 05228");
            p6.setFormacioninternacional(" ");
            p6.setHabilidad("Sus intereses de investigación son gestión del espectro, planeación de radio móvil, propagación radio y “m-Health”");

            data.add(p6);
        }

        if (ponente == 6) {

            Ponente p7 = new Ponente();

            p7.setNombre("Daniel A. Pajoy");
            p7.setEmpresa("EMTEL");
            p7.setImagen("http://seminariotet2016.com/assets/images/conferencistas/DanielPajoy.jpg");
            p7.setEstudios("Ingeniero en electrónica y telecomunicaciones de la Universidad del Cauca, especialista en gerencia de proyectos y realiza un MBA en la Univesidad ICESI de Cali.");
            p7.setExperiencia("Fue asesor creativo y de tecnología para la Industria Licorera del Cauca. Se ha dedicado en los últimos años al emprendimiento, es socio de la agencia de publicidad Kubik y gracias a la obtención de capital semilla por parte de Fondo Emprender fundó la empresa de cafés especiales Cerro Brujo Trading SAS");
            p7.setFormacioninternacional(" ");
            p7.setHabilidad(" ");

            data.add(p7);
        }

        if (ponente == 7) {

            Ponente p8 = new Ponente();

            p8.setNombre("Diego Gómez S.");
            p8.setEmpresa("ORACLE");
            p8.setImagen("http://seminariotet2016.com/assets/images/conferencistas/diegogomez.jpg");
            p8.setEstudios("Ing. Electrónica y Gerencia Internacional");
            p8.setExperiencia("Le apasiona la tecnología y la innovación, es un ejecutivo entusiasta con: éxito probado en récords de ventas y desarrollo de negocios.");
            p8.setFormacioninternacional(" ");
            p8.setHabilidad(" ");

            data.add(p8);
        }

        if (ponente == 8) {

            Ponente p9 = new Ponente();

            p9.setNombre("Edwin Bravo");
            p9.setEmpresa("ERICSSON");
            p9.setImagen("http://seminariotet2016.com/assets/images/conferencistas/Edwin2015.jpg");
            p9.setEstudios("Ingeniero en Electrónica y Telecomunicaciones, de la Universidad del Cauca");
            p9.setExperiencia(" ");
            p9.setFormacioninternacional("Technical Support Engineer en Colombia, Panamá; Milán (Italia); Product Sales Support para Latino América Norte y el Caribe; Customer Solution Responsible en Centro América y el Caribe; Network Solutions Manager para Latino América Norte y el Caribe; Customer Solutions Sales Manager para Sur América. A la fecha es Engagement Manager para la Región Latino América y El Caribe de dicha compañía sueca");
            p9.setHabilidad(" ");

            data.add(p9);
        }

        if (ponente == 9) {

            Ponente p10 = new Ponente();

            p10.setNombre("Eva j Maya ");
            p10.setEmpresa("Universidad Del Cauca");
            p10.setImagen("http://seminariotet2016.com/assets/images/conferencistas/EvaM.png");
            p10.setEstudios("Ingeniera en Electrónica y Telecomunicaciones, y Magíster en Ingeniería - Área Telemática de la Universidad del Cauca, y especialista en Gestión Pública de la Escuela Superior de Administración Pública.");
            p10.setExperiencia("docente de la Facultad de Ingeniería Electrónica y Telecomunicaciones de la Universidad del Cauca, pertenece al GIT (Grupo de Ingeniería Telemática) y se desempeña como coordinadora de un programa académico y de un semillero, el cual busca fomentar espíritu emprendedor en la comunidad universitaria");
            p10.setFormacioninternacional("Participó en EHAS (Enlace Hispanoamericano de Salud), proyecto financiado por la Unión Europea y también trabajó en CINTEL (Centro de Investigación de las Telecomunicaciones), organización orientada a la generación de conocimiento, investigación aplicada e innovación a través de proyectos TIC.");
            p10.setHabilidad(" ");

            data.add(p10);
        }

        if (ponente == 10) {

            Ponente p11 = new Ponente();

            p11.setNombre("Fabian Muñoz");
            p11.setEmpresa("E3 Consulting");
            p11.setImagen("http://seminariotet2016.com/assets/images/conferencistas/FabMu.jpg");
            p11.setEstudios("Ingeniero Electrónico de la Universidad del Cauca. MBA y una especialización en Gerencia de Empresas de Telecomunicaciones de la Universidad de los Andes");
            p11.setExperiencia("Hace parte del Tanque de Pensamiento TIC Colombia, fue Gerente de Industria de Software y TI del Programa de Transformación Productiva del Ministerio de Comercio, fue CTO del Ministerio TIC. Ha trabajado en LG Eletronics, UNE y Telefónica");
            p11.setFormacioninternacional("Amplia experiencia y conocimiento de la Industria TIC y del ecosistema de Ciencia, Tecnología e Innovación en Colombia");
            p11.setHabilidad("");

            data.add(p11);
        }

        if (ponente == 11) {

            Ponente p = new Ponente();

            p.setNombre("Guillaume LeBlanc");
            p.setEmpresa("Phaxsi");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/guill_paxi.png");
            p.setEstudios("Ingeniero sistemas (Énfasis en desarrollo software para optimización de redes)");
            p.setExperiencia("23 años de experiencia (Francia)");
            p.setFormacioninternacional(" ");
            p.setHabilidad("Tecnología Sigfox, Sigfox Partner’s training Estudio detallado del funcionamiento de la tecnología Investigación y desarrollo Estudio de normas 3GPP para implementación SW LTE & SON: R&D, 3GPP SON workshop GSM, UMTS & LTE: Planificación de frecuencias / Scrambling Codes / PCI Planificación de vecindades Análisis de tráfico y diemsionamiento de red Simulaciones de Monte-Carlo Modelización de RAT (Radio Access Technology)");

            data.add(p);
        }
        if (ponente == 12) {

            Ponente p = new Ponente();

            p.setNombre("Hugo Campos");
            p.setEmpresa("Nokia");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/HugoCampos.png");
            p.setEstudios("Ingeniero Electrónico de la Universidad del Cauca con énfasis en Telecomunicaciones");
            p.setExperiencia("25 años de experiencia en el sector de las telecomunicaciones");
            p.setFormacioninternacional(" ");
            p.setHabilidad("gerente de proyectos y arquitecto de soluciones.");

            data.add(p);
        }
        if (ponente == 13) {

            Ponente p = new Ponente();

            p.setNombre("Ivan Sanchez M.");
            p.setEmpresa("Ufinet");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/IvanSanchez.png");
            p.setEstudios("Ingeniero en Electrónica con énfasis en Telecomunicaciones y Magíster en Telemática");
            p.setExperiencia("veinte años de experiencia en gestión, operación, regulación, gerencia y negociación de redes de comunicaciones, incluyendo administración de personal y de recursos técnicos y logísticos. Amplia experiencia en manejo de procesos de contratación (incluyendo conocimientos financieros y legales asociados), con dedicación especial a evaluación de soluciones tecnológicas para servicios de telecomunicaciones y negociación de tecnología");
            p.setFormacioninternacional(" ");
            p.setHabilidad("Gran capacidad de comunicación oral y escrita, tanto en temas puntuales, como en presentaciones dedicadas a auditorios grandes. Organizado, con orientación al trabajo por actividades, y excelente respuesta bajo presión. Fuerte motivación por asumir trabajos en los cuales se enfrenten nuevos retos y se asuman responsabilidades en tiempo y resultados. Excelente manejo de relaciones personales y presentación personal.");

            data.add(p);
        }
        if (ponente == 14) {

            Ponente p = new Ponente();

            p.setNombre("Jair A. Mazabuel");
            p.setEmpresa("Makrosoft");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mazbuel_makro.png");
            p.setEstudios("Ingeniero de sistemas y Administrador de empresas");
            p.setExperiencia("gerente y fundador de la Empresa Makro Soft Ltda, he desarrollando soluciones TI en diferentes empresas públicas y privadas");
            p.setFormacioninternacional(" ");
            p.setHabilidad(" ");

            data.add(p);
        }
        if (ponente == 15) {

            Ponente p = new Ponente();

            p.setNombre("Jairo Angulo");
            p.setEmpresa("STI");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/jairoangulo.png");
            p.setEstudios("Ingeniero electrónico y de telecomunicaciones de la Universidad del Cauca, especializado en redes de telecomunicaciones, protocolos de datos y comunicaciones satelitales");
            p.setExperiencia("40 años de experiencia en las cuales se ha desempeñado como docente universitario de la Universidad del Cauca, Universidad Javeriana y Universidad Simón Bolívar. Trabajó en Telecom en el área de Transmisión y de Servicios Telemáticos.");
            p.setFormacioninternacional(" ");
            p.setHabilidad("Desde el año de 1992 se desempeña como Gerente de Telecomunicaciones de la empresa STI Soluciones en Telecomunicaciones e Informática SAS, de la cual es socio fundador.");

            data.add(p);
        }
        if (ponente == 16) {

            Ponente p = new Ponente();

            p.setNombre("Diego Felipe Parra");
            p.setEmpresa("YeapData - Avaya");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/jhonnyAvaya.png");
            p.setEstudios("Ingeniero de Sistemas y Telecomunicaciones, con múltiples certificaciones en diferentes arquitecturas de comunicaciones y líder regional en Comunicaciones Unificadas y Colaboración de Avaya para la región andina");
            p.setExperiencia("Siete años de experiencia en el diseño y venta consultiva de redes empresariales y soluciones de colaboración");
            p.setFormacioninternacional(" ");
            p.setHabilidad("Posee un amplio conocimiento en mejores prácticas y soluciones específicas para los diferentes sectores industriales.");

            data.add(p);
        }
        if (ponente == 17) {

            Ponente p = new Ponente();

            p.setNombre("José A. Roure");
            p.setEmpresa("Claro");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/JoseRoure.jpg");
            p.setEstudios("Manager emprendedor");
            p.setExperiencia("diez años de experiencia en desarrollos de negocios IT, planeación estratégica, implementación de sistemas de información, gerencia IT e innovación");
            p.setFormacioninternacional(" ");
            p.setHabilidad("toma de decisiones, en adaptaciones a cambios, gran sentido de compromiso y responsabilidad hacia el trabajo y enfoque en los resultados.");

            data.add(p);
        }
        if (ponente == 18) {

            Ponente p = new Ponente();

            p.setNombre("José G. Acuña R.");
            p.setEmpresa("Infomedia");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/acuna.png");
            p.setEstudios("Ingeniero Electrónico y de Telecomunicaciones de la Universidad del Cauca");
            p.setExperiencia("Empresario para el sector de las TIC’S en Colombia. Su Compañía se llama INFOMEDIA SERVICE S.A. desempeñando el cargo de Gerente General y actualmente es proveedor para grandes compañías del Sector Financiero, Salud y Gobierno, con alianzas importantes de operaciones de Telecom");
            p.setFormacioninternacional(" ");
            p.setHabilidad(" ");

            data.add(p);
        }
        if (ponente == 19) {

            Ponente p = new Ponente();

            p.setNombre("Ma. del Pilar Rivera");
            p.setEmpresa("PMK-360UC Solution");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mariaprivera.jpg");
            p.setEstudios("Ingeniera en Electrónica y Telecomunicaciones, especialista en Gerencia de Mercadeo");
            p.setExperiencia("17 años de experiencia en la definición, diseño e implementación de estrategias de servicio, y gestión comercial de productos de telecomunicaciones. Amplia experiencia liderando y gestionando áreas de Servicio al Cliente, Mercadeo, Comercial, Procesos y Operaciones");
            p.setFormacioninternacional(" ");
            p.setHabilidad("conferencista y asesora en la definición de Modelos de Experiencia de Cliente y estrategias de servicio para empresas del sector real y de servicios");

            data.add(p);
        }
        if (ponente == 20) {

            Ponente p = new Ponente();

            p.setNombre("Miguel Diaz");
            p.setEmpresa("Codescrum");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/MigueD.jpg");
            p.setEstudios("Ingeniero Electrónico egresado de la Universidad del Cauca");
            p.setExperiencia("ofundador de la empresa Codescrum, que se especializa en desarrollo de aplicaciones y sistemas de información web para empresas de diferentes sectores");
            p.setFormacioninternacional(" ");
            p.setHabilidad("Administrador de proyectos. Apasionado por la solución de problemas, la creación de productos, el servicio al cliente y la música.");

            data.add(p);
        }

        if (ponente == 21) {


            Ponente p = new Ponente();

            p.setNombre("Nicolás Silva C.");
            p.setEmpresa("MinTic");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/mintic.jpg");
            p.setEstudios("Ingeniero Electrónico de la Pontificia Universidad Javeriana, con Maestría en Dirección y Gerencia de Empresas y Especialización en Gerencia de Mercadeo de la Universidad del Rosario");
            p.setExperiencia("desempeñó labores de diseño y venta de soluciones de telecomunicaciones y comercio electrónico, laboró promoviendo las estrategias de fomento a la Industria de Tecnologías de Información y de Desarrollo de Contenidos en el marco del programa Agenda de Conectividad del Ministerio de Comunicaciones. Entre 2003 y 2015, estuvo vinculado a la CRC, entidad en la cual se desempeñó inicialmente como asesor técnico, y en la que posteriormente tuvo a su cargo la coordinación de las áreas del Centro de Conocimiento del Negocio, Regulación Postal y Regulación de Infraestructura.");
            p.setFormacioninternacional(" ");
            p.setHabilidad(" ");

            data.add(p);
        }
        if (ponente == 22) {

            Ponente p = new Ponente();

            p.setNombre("Patricia H. Fierro");
            p.setEmpresa("SkyOne");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/PatriciaFierro.jpg");
            p.setEstudios("ingeniera en Electrónica y Telecomunicaciones de la Universidad del Cauca, Especialista en Telecomunicaciones (Pontifica Bolivariana) y Gerencia Estratégica (Universidad de la Sabana), Máster en Innovación (IXL Center) y está certificada en herramientas de Marketing Digital como Google Adwords, Google Analytics y Publicidad en Youtube, Facebook e Instagram");
            p.setExperiencia("(17) años de experiencia en empresas de tecnología y servicios de comercialización y adicionalmente ha sido catedrática de postgrado en Marketing Digital, Innovación y Prospectiva Estratégica de la Universidad EAN para gremios de Empresarios e Instituciones a nivel Nacional y Conferencista en varios Foros Tecnológicos");
            p.setFormacioninternacional(" ");
            p.setHabilidad(" ");

            data.add(p);
        }

        if (ponente == 23) {

            Ponente p = new Ponente();

            p.setNombre("Carolina Campo");
            p.setEmpresa("Makrosoft & Phaxi");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/carolinacampo.png");
            p.setEstudios("Ingeniera en Electrónica y Telecomunicaciones Especialista en redes de telefonía celular");
            p.setExperiencia(" ");
            p.setFormacioninternacional("10 Años de experiencia en planificación y diseñode redes inalambricas (francia)");
            p.setHabilidad("Especialista en creación de empresa e innovación Desde 2012: gerente general de Phaxsi Solutions, operador Sigfox en colombia.");

            data.add(p);
        }

        if (ponente == 24) {

            Ponente p = new Ponente();

            p.setNombre("Alejandro Muñoz G.");
            p.setEmpresa("Doble Click");
            p.setImagen("http://seminariotet2016.com/assets/images/conferencistas/dobleclick.png");
            p.setEstudios("Ing. Físico graduado en la Universidad del Cauca en el año 2003, Egresado como el primer Ing. Físico de Colombia. Con formación en Ingeniería Electrónica y Telecomunicaciones del Mismo año. Candidato a Magister en Gestión de Organizaciones de la Universidad Cooperativa de Colombia 2016.");
            p.setExperiencia("Docente en las Universidad Industrial de Santander y Universidad del Cauca en el año 2004 y 2005 Conferencista invitado en Varias Universidades y eventos del país, en materias de Emprendimiento, innovación y gestión Organizacional");
            p.setFormacioninternacional(" ");
            p.setHabilidad("En el 2006 inicio el emprendimiento Dobleclick Software e Ingeniería, el cual buscaba llegar con tecnologías de la Información y las comunicaciones a las zonas más apartadas de los Departamentos de Nariño Y Cauca. Hoy en Día Gerencia dicha Organización, la cual ya se postula como empresa líder en tecnología de radio de 6 Departamentos del País y que promete ser la empresa Caucana con mayor proyección a nivel nacional.");

            data.add(p);
        }



    }

    public void setPonente(int ponente){

        this.ponente = ponente;

    }

}
