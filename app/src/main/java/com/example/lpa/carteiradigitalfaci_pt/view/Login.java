package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final Button btlogar = findViewById(R.id.bt_entrar);
        TextView tvNovaConta = findViewById(R.id.tvNovaConta);
        TextView tvEsqueci = findViewById(R.id.tvEsqueci);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        final UsuarioController usuarioController = new UsuarioController(getBaseContext());
        usuarioController.zerarUltimoUsuario();

        tvNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, NovaConta.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        btlogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int validacao =  usuarioController.logar(etEmail.getText().toString(),etSenha.getText().toString());

                switch (validacao){
                    case 1:
                        Intent i = new Intent(Login.this, SplashScreen.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Senha incorreta",Toast.LENGTH_LONG).show();
                        etSenha.setError("Senha incorreta");
                        etSenha.requestFocus();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Usuário não cadastrado",Toast.LENGTH_LONG).show();
                        etEmail.setError("Usuário não cadastrado");
                        etEmail.requestFocus();
                        break;

                }


            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
