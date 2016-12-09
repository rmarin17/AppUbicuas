package com.example.ricardom.tet2016.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ricardom.tet2016.models.Ponente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RicardoM on 12/10/2016.
 */

public class PonenteDao {

    static final String TABLE = "ponentes";
    static final String C_NAME = "nombre";
    static final String C_EMPRESA = "empresa";
    static final String C_EXPERIENCIA = "experiencia";
    static final String C_HABILIDAD = "habilidades";
    static final String C_ESTUDIOS = "estudios";
    static final String C_IMAGEN = "imagen";
    static final String C_INTERNACIONAL = "formacioninternacional";

    SQLiteDatabase db;

    public PonenteDao (Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert (Ponente ponente){
        ContentValues cV = new ContentValues();
        cV.put(C_NAME, ponente.getNombre());
        cV.put(C_EMPRESA, ponente.getEmpresa());
        cV.put(C_ESTUDIOS, ponente.getEstudios());
        cV.put(C_EXPERIENCIA, ponente.getExperiencia());
        cV.put(C_HABILIDAD, ponente.getHabilidad());
        cV.put(C_IMAGEN, ponente.getImagen());
        cV.put(C_INTERNACIONAL, ponente.getFormacioninternacional());
        long id = db.insert(TABLE,null,cV);
        ponente.setId(id);

    }

    public void update (Ponente ponente){

        ContentValues cV = new ContentValues();
        cV.put(C_NAME, ponente.getNombre());
        cV.put(C_EMPRESA, ponente.getEmpresa());
        cV.put(C_ESTUDIOS, ponente.getEstudios());
        cV.put(C_EXPERIENCIA, ponente.getExperiencia());
        cV.put(C_HABILIDAD, ponente.getHabilidad());
        //cV.put(C_IMAGEN, ponente.getImagen());
        cV.put(C_INTERNACIONAL, ponente.getFormacioninternacional());
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
            ponente.setEmpresa(c.getString(2));
            ponente.setEstudios(c.getString(3));
            ponente.setExperiencia(c.getString(4));
            ponente.setFormacioninternacional(c.getString(5));
            ponente.setHabilidad(c.getString(6));
            ponente.setImagen(c.getString(7));
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
