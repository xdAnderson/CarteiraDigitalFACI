package com.example.lpa.carteiradigitalfaci_pt.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class NovaConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);

        final EditText etNomeComp = findViewById(R.id.etNomeComp);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);
        EditText etConfSenha = findViewById(R.id.etConfSenha);
        Button btCadastrar = findViewById(R.id.btCadastrar);



        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean criou;
                Usuario usu = new Usuario();
                usu.setUSER_nome(etNomeComp.getText().toString());
                usu.setUSER_email(etEmail.getText().toString());
                usu.setUSER_senha(etSenha.getText().toString());
                usu.setUSER_status("1");
                UsuarioController usuarioController = new UsuarioController(getBaseContext());

                criou = usuarioController.salvarUsuario(usu);

                if(criou){
                    Toast.makeText(getApplicationContext(), "Usuário criado com sucesso.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro ao criar usuário.", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
