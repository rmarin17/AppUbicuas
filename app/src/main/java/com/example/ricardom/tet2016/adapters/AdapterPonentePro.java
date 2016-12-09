package com.example.ricardom.tet2016.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardom.tet2016.models.PonentePro;
import com.example.ricardom.tet2016.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by RicardoM on 06/10/2016.
 */

public class AdapterPonentePro extends BaseAdapter {

    Context context;
    List<PonentePro> data;

    public AdapterPonentePro(Context context, List<PonentePro> data) {
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        if (v == null)
            v = View.inflate(context, R.layout.item_ponente_pro, null);

        PonentePro p = data.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        ImageView perfil = (ImageView) v.findViewById(R.id.profile);


        nombre.setText(p.getNombre());

        Picasso.with(context).load(Uri.parse(p.getImagen())).into(perfil);

        return v;
    }
}
