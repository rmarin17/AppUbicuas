package com.example.ricardom.tet2016.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ricardom.tet2016.models.Ponente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RicardoM on 13/10/2016.
 */

public class PonenteProDao {
    static final String TABLE = "ponentes";
    static final String C_NAME = "nombre";
    static final String C_IMAGEN = "imagen";
    SQLiteDatabase db;


    public PonenteProDao (Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert (Ponente ponente){
        ContentValues cV = new ContentValues();
        cV.put(C_NAME, ponente.getNombre());
        cV.put(C_IMAGEN, ponente.getImagen());
        long id = db.insert(TABLE,null,cV);
        ponente.setId(id);

    }

    public void update (Ponente ponente){

        ContentValues cV = new ContentValues();
        cV.put(C_NAME, ponente.getNombre());
        cV.put(C_IMAGEN, ponente.getImagen());
        long id = db.update(TABLE,cV,"_id = ?",new String[]{ponente.getId()+" "});
    }

    public void delete (long id){
        db.delete(TABLE,"_id = "+id, null);
    }

    public  Ponente getByid (long id){

        Cursor c = db.rawQuery("SELECT * FROM ponentes WHERE _id="+id,null);
        return cursorToPonente(c);

    }

    public List<Ponente> getAll (){

        Cursor c = db.rawQuery("SELECT * FROM ponentes",null);
        return cursorToList(c);

    }

    public List<Ponente> getAByName (String name){

        Cursor c = db.rawQuery("SELECT * FROM ponentes WHERE nombre LIKE '%"+name+"%'",null);
        return cursorToList(c);
    }

    private Ponente cursorToPonente (Cursor c){
        Ponente ponente= null;
        if (c.moveToNext()){
            ponente = new Ponente();
            ponente.setId(c.getLong(0));
            ponente.setNombre(c.getString(1));
            ponente.setImagen(c.getString(2));
        }
        return ponente;
    }

    private List<Ponente> cursorToList (Cursor c){

        List<Ponente> data = new ArrayList<>();

        for (int i= 0; i< c.getCount();i++){
            Ponente p = cursorToPonente(c);
            data.add(p);
        }

        return data;
    }

}
