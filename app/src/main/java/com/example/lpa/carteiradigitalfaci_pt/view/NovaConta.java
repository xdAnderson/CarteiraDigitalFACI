package com.example.lpa.carteiradigitalfaci_pt.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.Criptografia;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NovaConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);


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


                    UsuarioController usuarioController = new UsuarioController(getBaseContext());

                    if(usuarioController.verificarSePossuiConta(etEmail.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Você já possui uma conta ativa, tente logar!",Toast.LENGTH_LONG).show();
                    }else {
                        Usuario usu = new Usuario();
                        usu.setUSER_nome(etNomeComp.getText().toString());
                        usu.setUSER_email(etEmail.getText().toString());
                        usu.setUSER_senha(Criptografia.criptografar(etSenha.getText().toString()));
                        usu.setUSER_status("1");
                        criou = usuarioController.salvarUsuario(usu);

                        if (criou) {
                            usuarioController.buscarPeloEmail(usu.getUSER_email());
                            Toast.makeText(getApplicationContext(), "Usuário criado com sucesso.", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(NovaConta.this, navigation.class);
                            startActivity(i);
                            Usuario.BV = 1;
                            finish();

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
