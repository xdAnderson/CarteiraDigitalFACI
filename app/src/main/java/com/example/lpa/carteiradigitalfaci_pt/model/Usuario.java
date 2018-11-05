package com.example.lpa.carteiradigitalfaci_pt.model;

public class Usuario {

    //Cadastro de Usuário
    private int USER_id;
    private String USER_nome;
    private String USER_email;
    private String USER_senha;
    private String USER_status;

    public int getUSER_id() {
        return USER_id;
    }

    public void setUSER_id(int USER_id) {
        this.USER_id = USER_id;
    }

    public String getUSER_nome() {
        return USER_nome;
    }

    public void setUSER_nome(String USER_nome) {
        this.USER_nome = USER_nome;
    }

    public String getUSER_email() {
        return USER_email;
    }

    public void setUSER_email(String USER_email) {
        this.USER_email = USER_email;
    }

    public String getUSER_senha() {
        return USER_senha;
    }

    public void setUSER_senha(String USER_senha) {
        this.USER_senha = USER_senha;
    }

    public String getUSER_status() {
        return USER_status;
    }

    public void setUSER_status(String USER_status) {
        this.USER_status = USER_status;
    }
}