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
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.CriptografiaMD5;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NovaConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final EditText etNomeComp = findViewById(R.id.etNomeComp);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);
        final EditText etConfSenha = findViewById(R.id.etConfSenha);
        Button btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean criou;
                if(etSenha.getText().toString().equals(etConfSenha.getText().toString())){


                    final UsuarioController usuarioController = new UsuarioController(getBaseContext());

                    if(usuarioController.verificarSePossuiConta(etEmail.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Você já possui uma conta ativa, tente logar!",Toast.LENGTH_LONG).show();
                    }else {
                        Usuario usu = new Usuario();
                        usu.setUSER_nome(etNomeComp.getText().toString());
                        usu.setUSER_email(etEmail.getText().toString());
                        usu.setUSER_senha(CriptografiaMD5.criptografar(etSenha.getText().toString()));
                        usu.setUSER_status("1");
                        criou = usuarioController.salvarUsuario(usu);

                        if (criou) {
                            usuarioController.buscarPeloEmail(usu.getUSER_email());
                            Toast.makeText(getApplicationContext(), "Usuário criado com sucesso.", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder mensagem = new AlertDialog.Builder(NovaConta.this);
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
                                        Intent i = new Intent(NovaConta.this, navigation.class);
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
                            Usuario.BV = 1;


                        } else {
                            Toast.makeText(getApplicationContext(), "Erro ao criar usuário.", Toast.LENGTH_SHORT).show();
                        }
                     }
                }else{
                    Toast.makeText(getApplicationContext(), "As senhas não coincidem, digite novamente.", Toast.LENGTH_SHORT).show();
                    etSenha.setText("");
                    etConfSenha.setText("");
                    etSenha.requestFocus();
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onBackPressed() {
        Intent i = new Intent(NovaConta.this, Login.class);
        startActivity(i);
        finish();
    }
}
