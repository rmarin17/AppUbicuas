package com.example.ricardom.tet2016.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ricardom.tet2016.models.Dias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RicardoM on 13/10/2016.
 */

public class DiasDao {

    static final String TABLE = "dias";
    static final String C_IDD = "idd";
    static final String C_IDO = "ido";
    static final String C_HORA = "hora";
    static final String C_EVENTO = "evento";
    static final String C_TITULO = "titulo";
    static final String C_CONFERENCISTA = "conferencista";
    static final String C_EMPRESA = "empresa";
    static final String C_LUGAR = "lugar";

    SQLiteDatabase db;

    public DiasDao (Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert (Dias dias){
        ContentValues cV = new ContentValues();
        cV.put(C_IDD, dias.getIdd());
        cV.put(C_IDO, dias.getIdo());
        cV.put(C_HORA, dias.getHora());
        cV.put(C_EVENTO, dias.getEvento());
        cV.put(C_TITULO, dias.getTitulo());
        cV.put(C_CONFERENCISTA, dias.getConferencista());
        cV.put(C_EMPRESA, dias.getEmpresa());
        cV.put(C_LUGAR, dias.getLugar());
        long id = db.insert(TABLE,null,cV);
        dias.setId(id);

    }

    public void update (Dias dias){

        ContentValues cV = new ContentValues();
        cV.put(C_IDD, dias.getIdd());
        cV.put(C_IDO, dias.getIdo());
        cV.put(C_HORA, dias.getHora());
        cV.put(C_EVENTO, dias.getEvento());
        cV.put(C_TITULO, dias.getTitulo());
        cV.put(C_CONFERENCISTA, dias.getConferencista());
        cV.put(C_EMPRESA, dias.getEmpresa());
        cV.put(C_LUGAR, dias.getLugar());
        long id = db.update(TABLE,cV,"_id = ?",new String[]{dias.getId()+" "});
    }

    public void delete (long id){
        db.delete(TABLE,"_id = "+id, null);
    }

    public  Dias getByid (long id){

        Cursor c = db.rawQuery("SELECT * FROM dias WHERE _id="+id,null);
        return cursorToDia(c);

    }

    public List<Dias> getAllByDay (int day){

        Cursor c = db.rawQuery("SELECT * FROM dias WHERE idd = "+day,null);
        return cursorToList(c);

    }

    public List<Dias> getAByName (String name){

        Cursor c = db.rawQuery("SELECT * FROM dias WHERE nombre LIKE '%"+name+"%'",null);
        return cursorToList(c);
    }

    private Dias cursorToDia (Cursor c){

        Dias dias= null;

        if (c.moveToNext()){
            dias = new Dias();
            dias.setId(c.getLong(0));
            dias.setIdd(c.getInt(1));
            dias.setIdo(c.getInt(2));
            dias.setHora(c.getString(3));
            dias.setEvento(c.getString(4));
            dias.setTitulo(c.getString(5));
            dias.setConferencista(c.getString(6));
            dias.setEmpresa(c.getString(7));
            dias.setLugar(c.getString(8));
        }
        return dias;
    }

    private List<Dias> cursorToList (Cursor c){

        List<Dias> data = new ArrayList<>();

        for (int i= 0; i< c.getCount();i++){
            Dias d = cursorToDia(c);
            data.add(d);
        }

        return data;
    }
}
