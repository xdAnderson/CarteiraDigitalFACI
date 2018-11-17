package com.example.lpa.carteiradigitalfaci_pt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CPF;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class DocumentoController extends DataSource {

    public DocumentoController(Context context) {
        super(context);
    }

    public CPF buscarCPF(){
        SQLiteDatabase db = this.getReadableDatabase();
        CriptografiaBase64 cpb64 = new CriptografiaBase64();
        String sql = "SELECT * FROM cpf WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\"";
        Cursor cursor = db.rawQuery(sql,null);
        CPF objCPF = new CPF();
        cursor.moveToFirst();
        objCPF.setCPF_numero(cpb64.decrypt(Usuario.getUserPin(), cursor.getString(cursor.getColumnIndex("numero_cpf"))));
        objCPF.setCPF_nome(cpb64.decrypt(Usuario.getUserPin(), cursor.getString(cursor.getColumnIndex("nome_cpf"))));
        objCPF.setCPF_dn(cpb64.decrypt(Usuario.getUserPin(), cursor.getString(cursor.getColumnIndex("dn_cpf"))));

        return objCPF;
    }

    public boolean verificarSePossuiDocumento(String id_usuario, String documento){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+documento+" WHERE id_usuario = \""+id_usuario+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            db.close();
            return true;
        }else {
            db.close();
            return false;
        }
    }

    public boolean inserirDocumento(ContentValues values, String documento){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean inseriu = db.insert(documento, null, values)>0;
        db.close();
        return inseriu;
    }
    public boolean atualizarDocumento(ContentValues values, String documento){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id())};
        boolean atualizou = db.update(documento,  values, "id_usuario = ?", whereArgs)>0;
        db.close();
        return atualizou;
    }
    public boolean deletarDocumento(String documento){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id())};
        boolean excluiu = db.delete(documento,"id_usuario = ?", whereArgs)>0;
        return excluiu;
    }

}
