package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentPin;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity  {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        fragmentManager = getSupportFragmentManager();

        Button btlogar = findViewById(R.id.bt_entrar);
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
                finish();
            }
        });

        btlogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String validacao =  usuarioController.logar(etEmail.getText().toString(),etSenha.getText().toString());

                if(validacao.equals("Bem Vindo "+Usuario.USUARIO_ATIVO.getUSER_nome()+"!")){
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.res_anim_fadein, R.anim.res_anim_fadeout).replace(R.id.contentLogin, new FragmentPin()).commit();
                }
            }
        });







}

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
