package com.example.lpa.carteiradigitalfaci_pt.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lpa.carteiradigitalfaci_pt.datamodel.DocumentoDataModel;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "docdigital";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(DocumentoDataModel.criarTabela1());
            db.execSQL(DocumentoDataModel.criarTabela2());
            db.execSQL(DocumentoDataModel.criarTabela3());
            db.execSQL(DocumentoDataModel.criarTabela4());
            db.execSQL(DocumentoDataModel.criarTabela5());
            db.execSQL(DocumentoDataModel.criarTabela6());
            db.execSQL(DocumentoDataModel.criarTabela7());


        }catch(Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
