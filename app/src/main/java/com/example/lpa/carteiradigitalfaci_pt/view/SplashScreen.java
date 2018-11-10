package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        UsuarioController usuarioController = new UsuarioController(getApplicationContext());
        DataSource ds = new DataSource(getBaseContext());
        if(usuarioController.verificarSeExisteUsuarioLogado()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashScreen.this, navigation.class);
                    startActivity(i);
                    finish();
                }
            }, 1000);
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashScreen.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }, 1000);
        }
    }
    @Override
    public void onBackPressed() {

    }
}
