package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/futura.ttf");
        Button btlogar = findViewById(R.id.bt_entrar);
        TextView tvNovaConta = findViewById(R.id.tvNovaConta);
        TextView tvEsqueci = findViewById(R.id.tvEsqueci);
        final EditText etEmail = findViewById(R.id.etEmail);
        EditText etSenha = findViewById(R.id.etSenha);

        tvNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, NovaConta.class);
                startActivity(i);
            }
        });

        btlogar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Usuario usu = new Usuario();
                   UsuarioController usuarioController = new UsuarioController(getBaseContext());
                   usu = usuarioController.buscarPeloEmail(etEmail.getText().toString());

                   if(usu!=null){
                       Toast.makeText(getApplicationContext(), "Usuário encontrado com sucesso.\nNome: "+usu.getUSER_nome()+"\nEmail: "+usu.getUSER_email(), Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(getApplicationContext(), "Usuário não encontrado...", Toast.LENGTH_SHORT).show();
                   }
               }
           }

        );


        tvEsqueci.setTypeface(font);
        tvNovaConta.setTypeface(font);
        etEmail.setTypeface(font);
        etSenha.setTypeface(font);
    }
}
