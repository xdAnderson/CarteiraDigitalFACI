package com.example.lpa.carteiradigitalfaci_pt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class DocumentoController extends DataSource {
    ContentValues dados;
    public DocumentoController(Context context) {
        super(context);
    }

    public boolean buscarCertidao(String Email, String Senha){

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM certidao WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id_usuario"));
            String nome = cursor.getString(cursor.getColumnIndex("nome_usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha_usuario"));
            String status = cursor.getString(cursor.getColumnIndex("status_usuario"));



            return true;
        }else{
            return true;
        }
    }

}
