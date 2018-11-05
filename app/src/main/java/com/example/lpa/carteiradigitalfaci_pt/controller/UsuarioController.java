package com.example.lpa.carteiradigitalfaci_pt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class UsuarioController extends DataSource {

    public UsuarioController(Context context) {
        super(context);
    }


    public boolean salvarUsuario(Usuario obj){

        ContentValues dados = new ContentValues();
        //dados.put("id_usuario", "");
        dados.put("nome_usuario", obj.getUSER_nome());
        dados.put("email_usuario", obj.getUSER_email());
        dados.put("senha_usuario", obj.getUSER_senha());
        dados.put("status_usuario", "1");

        SQLiteDatabase db = this.getWritableDatabase();

        boolean sucesso = db.insert("usuario", null, dados)>0;
        db.close();
        return sucesso;
    }


    public Usuario buscarPeloEmail(String Email){
        Usuario usu = new Usuario();;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario WHERE email_usuario = \""+Email+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("nome_usuario"));
            String nome = cursor.getString(cursor.getColumnIndex("nome_usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha_usuario"));
            String status = cursor.getString(cursor.getColumnIndex("status_usuario"));

            usu.setUSER_id(id);
            usu.setUSER_nome(nome);
            usu.setUSER_email(Email);
            usu.setUSER_senha(senha);
            usu.setUSER_status(status);
        }else
            usu = null;

        db.close();
        return usu;
    }
}
