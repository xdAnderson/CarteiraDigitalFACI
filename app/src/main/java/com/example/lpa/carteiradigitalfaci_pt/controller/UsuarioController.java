package com.example.lpa.carteiradigitalfaci_pt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lpa.carteiradigitalfaci_pt.datamodel.DocumentoDataModel;
import com.example.lpa.carteiradigitalfaci_pt.datamodel.UsuarioDataModel;
import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class UsuarioController extends DataSource {
    public UsuarioController(Context context) {
        super(context);
    }

    public boolean salvarUsuario(Usuario usu){
        ContentValues dados = new ContentValues();
        dados.put("nome_usuario", usu.getUSER_nome());
        dados.put("email_usuario", usu.getUSER_email());
        dados.put("senha_usuario", usu.getUSER_senha());
        dados.put("pin", usu.getPin());
        dados.put("status_usuario", "1");
        dados.put("ult_usuario", "0");

        SQLiteDatabase db = this.getWritableDatabase();

        boolean sucesso = db.insert("usuario", null, dados)>0;
        db.close();
        return sucesso;
    }

    public boolean verificarSeExisteUsuarioLogado(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuario WHERE ult_usuario = \"1\"", null);

        if (cursor != null) {

            if (!cursor.moveToFirst()) {
                db.close();
                return false;
            } else {
                db.close();
                return buscarPeloEmail(cursor.getString(cursor.getColumnIndex("email_usuario")));
            }
        }
        db.close();
            return false;
    }

    public boolean definirComoUltimoUsuarioLogado(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE usuario set ult_usuario = \"1\" WHERE email_usuario=\""+Usuario.USUARIO_ATIVO.getUSER_email()+"\";");
        db.close();
        return true;
    }

    public boolean zerarUltimoUsuario(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" UPDATE usuario set ult_usuario = \"0\";");
        db.close();
        return true;
    }

    public boolean buscarPeloEmail(String Email){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario WHERE email_usuario = \""+Email+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id_usuario"));
            String nome = cursor.getString(cursor.getColumnIndex("nome_usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha_usuario"));
            String status = cursor.getString(cursor.getColumnIndex("status_usuario"));

            Usuario.USUARIO_ATIVO.setUSER_id(id);
            Usuario.USUARIO_ATIVO.setUSER_nome(nome);
            Usuario.USUARIO_ATIVO.setUSER_email(Email);
            Usuario.USUARIO_ATIVO.setUSER_senha(senha);
            Usuario.USUARIO_ATIVO.setUSER_status(status);
            definirComoUltimoUsuarioLogado();
            db.close();
            return true;
        }else
            db.close();
            return false;
    }

    public int logar(String email, String Senha){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario WHERE email_usuario = \""+email+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("id_usuario"));
            String nome = cursor.getString(cursor.getColumnIndex("nome_usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha_usuario"));
            String status = cursor.getString(cursor.getColumnIndex("status_usuario"));

            if(CriptografiaHash.criptografar(Senha,"SHA-512").equals(senha)){
                Usuario.USUARIO_ATIVO.setUSER_id(id);
                Usuario.USUARIO_ATIVO.setUSER_nome(nome);
                Usuario.USUARIO_ATIVO.setUSER_email(email);
                Usuario.USUARIO_ATIVO.setUSER_senha(senha);
                Usuario.USUARIO_ATIVO.setUSER_status(status);
                definirComoUltimoUsuarioLogado();

                return 1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }
    }
    public boolean recuperarPIN(String pin){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  = db.rawQuery("SELECT pin FROM usuario WHERE id_usuario = "+Usuario.USUARIO_ATIVO.getUSER_id()+"", null);
        if(cursor.moveToFirst()){
            String entradaPin = CriptografiaHash.criptografar(pin,"SHA-512");
            if(cursor.getString(cursor.getColumnIndex("pin")).equals(entradaPin)) {
                Usuario.setUserPin(CriptografiaHash.criptografar(pin, "MD5"));
                db.close();
                return true;
            }else{
                db.close();
                return false;
            }
        }else{
            db.close();
            return false;
        }

    }
    public boolean inserirPIN(String pin, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String pinCript = CriptografiaHash.criptografar(pin, "SHA-512");
        cv.put("pin", pinCript);
        Usuario.setUserPin(CriptografiaHash.criptografar(pin,"MD5"));
        String[] whereArgs= {email};
        boolean inseriu = db.update("usuario",cv,"email_usuario = ?",whereArgs)>0;
        return inseriu;
    }

    public boolean verificarSePossuiConta(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM usuario WHERE email_usuario = \""+email+"\"";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            db.close();
            return true;
        }else {
            db.close();
            return false;
        }
    }

    public boolean verificarSeAtivo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select status_usuario from usuario where email_usuario='"+Usuario.USUARIO_ATIVO.getUSER_email()+"';",null);
        cursor.moveToFirst();
        if(cursor.getString(cursor.getColumnIndex("status_usuario")).equals("0")){
            db.close();
            return false;
        }else{
            db.close();
            return true;
        }
    }

    public boolean inativarUsuario(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("update usuario set status_usuario=\"0\" where id_usuario="+Usuario.USUARIO_ATIVO.getUSER_email()+";");
        db.close();

        if(verificarSeAtivo()){
            return false;
        }else{
            return true;
        }
    }

    public boolean atualizarDadosUsuario(){
        ContentValues values = new ContentValues();
        values.put("nome_usuario", Usuario.USUARIO_ATIVO.getUSER_nome());
        values.put("email_usuario", Usuario.USUARIO_ATIVO.getUSER_email());
        values.put("senha_usuario", Usuario.USUARIO_ATIVO.getUSER_senha());
        values.put("status_usuario", Usuario.USUARIO_ATIVO.getUSER_status());

        String where = "id_email = ?";
        String[] whereArgs = { Usuario.USUARIO_ATIVO.getUSER_email() };

        SQLiteDatabase db = getWritableDatabase();

        boolean isUpdate = db.update("produto", values, where, whereArgs)>0;
        db.close();
        return isUpdate;
    }


    public void deletarTabela(){
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM usuario");
        }catch(Exception e){

        }
    }

    public void criarTabela() {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(UsuarioDataModel.criarTabelaUsuario());
            db.execSQL(DocumentoDataModel.criarTabelaCertidao());
            db.execSQL(DocumentoDataModel.criarTabelaCNH());
            db.execSQL(DocumentoDataModel.criarTabelaCPF());
            db.execSQL(DocumentoDataModel.criarTabelaReservista());
            db.execSQL(DocumentoDataModel.criarTabelaRG());
            db.execSQL(DocumentoDataModel.criarTabelaTitulo());
            db.execSQL(DocumentoDataModel.criarTabelaOutros());
            db.execSQL(DocumentoDataModel.criarTabelaCTPS());
        } catch (Exception e) {

        }
    }
}