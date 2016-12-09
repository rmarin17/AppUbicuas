package com.example.ricardom.tet2016.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RicardoM on 12/10/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="ponentes.db";
    public static int VERSION = 1;


    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(" CREATE TABLE ponentes (_id INTEGER PRIMARY KEY AUTOINCREMENT"
                +", nombre VARCHAR"
                +", empresa VARCHAR"
                +", estudios VARCHAR"
                +", experiencia VARCHAR"
                +", formacioninternacional VARCHAR"
                +", habilidades VARCHAR"
                +", imagen INTEGER"
                +", imagenLocal BOOLEAN"
                +")"
            );
        db.execSQL(" CREATE TABLE dias (_id INTEGER PRIMARY KEY AUTOINCREMENT"
                +", idd INTEGER"
                +", ido INTEGER"
                +", hora VARCHAR"
                +", evento VARCHAR"
                +", titulo VARCHAR"
                +", conferencista VARCHAR"
                +", empresa VARCHAR"
                +", lugar VARCHAR"
                +")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE ponentes");
            db.execSQL("DROP TABLE dias");
            onCreate(db);
    }
}
