package com.example.ricardom.tet2016.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ricardom.tet2016.models.Dia1;
import com.example.ricardom.tet2016.R;

import java.util.List;

/**
 * Created by RicardoM on 19/09/2016.
 */
public class Dia1Adapter extends BaseAdapter {

    Context context;

    List<Dia1> data;


    public Dia1Adapter(Context context, List<Dia1> data) {
        this.context = context;
        this.data = data;


    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null)
            v = View.inflate(context, R.layout.item_dia_uno, null);

        Dia1 d = data.get(position);

        TextView hora = (TextView) v.findViewById(R.id.hora);
        TextView descripcion = (TextView) v.findViewById(R.id.descripcion);
        TextView ponente = (TextView) v.findViewById(R.id.ponente);
        TextView lugar = (TextView) v.findViewById(R.id.lugar);

        hora.setText(d.getHora());
        descripcion.setText(d.getDescripcion());
        ponente.setText(d.getPonente());
        lugar.setText(d.getLugar());

        return v;
    }
}
