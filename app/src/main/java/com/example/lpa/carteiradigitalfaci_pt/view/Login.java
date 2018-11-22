package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.util.SincronizarAsyncTask;
import com.example.lpa.carteiradigitalfaci_pt.util.UtilCarteiraDigital;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity  {
UsuarioController usuarioController;
EditText etEmail;
EditText etSenha;
String ReS= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final Button btlogar = findViewById(R.id.bt_entrar);
        TextView tvNovaConta = findViewById(R.id.tvNovaConta);
        TextView tvEsqueci = findViewById(R.id.tvEsqueci);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        usuarioController = new UsuarioController(getBaseContext());
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
                final Context context = v.getContext();
                SincronizarAsyncTask task = new SincronizarAsyncTask(etEmail.getText().toString(),context);
                try {
                    ReS=task.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DocumentoController documentoController = new DocumentoController(context);
                try{
                    JSONArray jsonArray = new JSONArray(result);
                    if(jsonArray.length()!=0){
                        documentoController.deletarTabela();
                        documentoController.criarTabela();

                        for(int i = 0; i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            Usuario objUsuario = new Usuario();

                            objUsuario.setUSER_id(jsonObject.getInt("id_usuario"));
                            objUsuario.setUSER_nome(jsonObject.getString("nome_usuario"));
                            objUsuario.setUSER_email(jsonObject.getString("email_usuario"));
                            objUsuario.setUSER_senha(jsonObject.getString("senha_usuario"));
                            objUsuario.setPin(jsonObject.getString("pin"));
                            objUsuario.setUSER_status(jsonObject.getString("status_usuario"));

                            ContentValues cv = new ContentValues();
                            cv.put("id_usuario", objUsuario.getUSER_id());
                            cv.put("nome_usuario", objUsuario.getUSER_nome());
                            cv.put("email_usuario", objUsuario.getUSER_email());
                            cv.put("senha_usuario", objUsuario.getUSER_senha());
                            cv.put("pin", objUsuario.getPin());
                            cv.put("status_usuario", objUsuario.getUSER_status());

                            documentoController.inserirDocumento(cv, "usuario");

                        }
                    }else{
                        Toast.makeText(context,"Nenhum Registro encontrado...", Toast.LENGTH_SHORT).show();
                    }
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
