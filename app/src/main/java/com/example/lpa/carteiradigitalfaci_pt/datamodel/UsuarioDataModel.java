package com.example.lpa.carteiradigitalfaci_pt.datamodel;

public class UsuarioDataModel {

    public static String criarTabelaUsuario(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'usuario' (\n" +
                "  'id_usuario' INTEGER primary key AUTOINCREMENT,\n" +
                "  'nome_usuario' VARCHAR(50) NULL,\n" +
                "  'email_usuario' VARCHAR(50) NULL,\n" +
                "  'pin' VARCHAR(50) NULL,\n" +
                "  'senha_usuario' VARCHAR(32) NULL,\n" +
                "  'ult_usuario' VARCHAR(1) NULL,\n" +
                "  'status_usuario' VARCHAR(1) NULL);";

        return qr;
    }
}
