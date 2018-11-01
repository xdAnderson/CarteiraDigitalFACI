package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lpa.carteiradigitalfaci_pt.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/futura.ttf");
        Button btlogar = findViewById(R.id.bt_entrar);

        btlogar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(Login.this, navigation.class);
                   startActivity(i);
                   finish();
               }
           }

        );

        TextView tvEsqueci = findViewById(R.id.tvEsqueci);
        tvEsqueci.setTypeface(font);
        TextView tvNovaConta = findViewById(R.id.tvNovaConta);
        tvNovaConta.setTypeface(font);

        EditText etEmail = findViewById(R.id.etEmail);
        etEmail.setTypeface(font);
        EditText etSenha = findViewById(R.id.etSenha);
        etSenha.setTypeface(font);
    }
}
