package com.example.ricardom.tet2016.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardom.tet2016.models.Ponente;
import com.example.ricardom.tet2016.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by RicardoM on 04/10/2016.
 */

public class PonenteAdapter extends BaseAdapter {

    Context context;
    List<Ponente> data;

    public PonenteAdapter(Context context, List<Ponente> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = View.inflate(context, R.layout.item_ponente, null);

        Ponente p = data.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView empresa = (TextView) v.findViewById(R.id.empresa);
        TextView estudios = (TextView) v.findViewById(R.id.hora);
        TextView experiencia = (TextView) v.findViewById(R.id.experiencia);
        TextView formacion = (TextView) v.findViewById(R.id.formacion);
        TextView habilidades = (TextView) v.findViewById(R.id.habilidad);
        ImageView perfil = (ImageView) v.findViewById(R.id.profile);


        nombre.setText(p.getNombre());
        empresa.setText(p.getEmpresa());
        estudios.setText(p.getEstudios());
        experiencia.setText(p.getExperiencia());
        formacion.setText(p.getFormacioninternacional());
        habilidades.setText(p.getHabilidad());

        Picasso.with(context).load(Uri.parse(p.getImagen())).into(perfil);

        return v;
    }
}
