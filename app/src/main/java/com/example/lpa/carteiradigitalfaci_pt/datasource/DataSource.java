package com.example.lpa.carteiradigitalfaci_pt.datasource;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lpa.carteiradigitalfaci_pt.datamodel.DocumentoDataModel;
import com.example.lpa.carteiradigitalfaci_pt.datamodel.UsuarioDataModel;

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

        try {
            db.execSQL(UsuarioDataModel.criarTabelaUsuario());
            db.execSQL(DocumentoDataModel.criarTabelaCertidao());
            db.execSQL(DocumentoDataModel.criarTabelaCNH());
            db.execSQL(DocumentoDataModel.criarTabelaCPF());
            db.execSQL(DocumentoDataModel.criarTabelaReservista());
            db.execSQL(DocumentoDataModel.criarTabelaRG());
            db.execSQL(DocumentoDataModel.criarTabelaTitulo());
            db.execSQL(DocumentoDataModel.criarTabelaOutros());
            db.execSQL(DocumentoDataModel.criarTabelaCNH());


        } catch (Exception e) {


        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
