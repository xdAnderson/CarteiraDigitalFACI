package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btlogar = findViewById(R.id.bt_entrar);
        TextView tvNovaConta = findViewById(R.id.tvNovaConta);
        TextView tvEsqueci = findViewById(R.id.tvEsqueci);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);

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
                   final UsuarioController usuarioController = new UsuarioController(getBaseContext());
                   String validacao =  usuarioController.logar(etEmail.getText().toString(),etSenha.getText().toString());
                   Toast.makeText(getApplicationContext(), validacao, Toast.LENGTH_SHORT).show();
                   if(validacao.equals("Bem Vindo "+Usuario.USUARIO_ATIVO.getUSER_nome()+"!")){


                       AlertDialog.Builder mensagem = new AlertDialog.Builder(Login.this);
                       mensagem.setTitle("PIN DE ACESSO");
                       mensagem.setMessage("Para manter seus dados seguros e ainda assim com fácil acesso por você, informe um pin de 4 números:");
                       // DECLARACAO DO EDITTEXT
                       final EditText input = new EditText(getBaseContext());
                       input.setTextColor(Color.BLACK);
                       input.setTextSize(30);
                       input.setRawInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                       input.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                       mensagem.setView(input);
                       mensagem.setNeutralButton("Registrar PIN", new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int which) {
                               if(usuarioController.inserirPIN(input.toString())){
                                   Toast.makeText(getApplicationContext(), "PIN registrado",
                                           Toast.LENGTH_SHORT).show();
                                   Intent i = new Intent(Login.this, navigation.class);
                                   startActivity(i);
                                   finish();
                               }else{
                                   Toast.makeText(getApplicationContext(), "ERRO",Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       mensagem.show();
                       // FORÇA O TECLADO APARECER AO ABRIR O ALERT
                       InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                       imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                   }
               }
           }
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
