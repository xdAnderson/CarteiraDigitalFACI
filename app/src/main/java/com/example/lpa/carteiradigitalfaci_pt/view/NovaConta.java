package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.CriptografiaHash;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.util.ConnectionBD;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentMenuPrincipal;

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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NovaConta extends AppCompatActivity {
    EditText etNomeComp;
    EditText etEmail;
    EditText etSenha;
    EditText etConfSenha;
    Button btCadastrar;
    Usuario objUsuario;
    UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        etNomeComp = findViewById(R.id.etNomeComp);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etConfSenha = findViewById(R.id.etConfSenha);
        btCadastrar= findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSenha.getText().toString().equals(etConfSenha.getText().toString())){
                    usuarioController = new UsuarioController(getBaseContext());
                    objUsuario = new Usuario();
                    objUsuario.setUSER_nome(etNomeComp.getText().toString());
                    objUsuario.setUSER_email(etEmail.getText().toString());
                    objUsuario.setUSER_senha(CriptografiaHash.criptografar(etSenha.getText().toString(),"SHA-512"));
                    objUsuario.setUSER_status("1");

                    //Pedir PIN
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(NovaConta.this);
                    mensagem.setCancelable(false);
                    mensagem.setTitle("PIN DE ACESSO");
                    mensagem.setMessage("Para manter seus dados seguros e ainda assim com fácil acesso por você, informe um pin de 4 números:");

                    final EditText input = new EditText(getBaseContext());
                    input.setTextColor(Color.BLACK);
                    input.setTextSize(30);
                    input.setWidth(100);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    input.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    mensagem.setView(input);
                    mensagem.setNeutralButton("Registrar PIN", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            String tamPIN = input.getText().toString();
                            if(tamPIN.length()==4) {
                                objUsuario.setPin(CriptografiaHash.criptografar(tamPIN, "SHA-512"));
                                SincronizarSistema pesquisarUsuario = new SincronizarSistema(objUsuario.getUSER_email());
                                pesquisarUsuario.execute();
                            }else{
                                Toast.makeText(getApplicationContext(),"Digite 4 digitos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    mensagem.show();
                    // FORÇA O TECLADO APARECER AO ABRIR O ALERT
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        finish();
    }


    //Salvar Usuário Online
    public class IncluirAsyncTask extends AsyncTask<String, String, String> {

        ProgressDialog progressDialog;

        HttpURLConnection conn;
        URL url = null;
        Uri.Builder builder;
        Context context;


        public IncluirAsyncTask(Usuario obj, Context context) {
            this.builder = new Uri.Builder();

            this.context = context;

            builder.appendQueryParameter("id_usuario", Integer.toString(obj.getUSER_id()));
            builder.appendQueryParameter("nome_usuario", obj.getUSER_nome());
            builder.appendQueryParameter("email_usuario", obj.getUSER_email());
            builder.appendQueryParameter("senha_usuario", obj.getUSER_senha());
            builder.appendQueryParameter("pin", obj.getPin());
            builder.appendQueryParameter("status_usuario", obj.getUSER_status());

        }

        @Override
        protected void onPreExecute() {
            Log.i("WebService", "IncluirAsyncTask()");

            progressDialog = new ProgressDialog(NovaConta.this);

            progressDialog.setMessage("Salvando usuário...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                url = new URL(ConnectionBD.URL_WEB_SERVICE + "APIIncluirDados.php");

            } catch (MalformedURLException e) {

                Log.e("WebService", "MalformedURLException - " + e.getMessage());

            } catch (Exception e) {

                Log.e("WebService", "Exception - " + e.getMessage());

            }

            try {

                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(ConnectionBD.READ_TIMEOUT);
                conn.setConnectTimeout(ConnectionBD.CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("charset", "utf-8");

                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.connect();

                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException erro) {

                Log.e("WebService", "IOException - " + erro.getMessage());

            }

            try {

                int response_code = conn.getResponseCode();

                if (response_code == HttpURLConnection.HTTP_OK) {

                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    return (result.toString());

                } else {
                    return ("Erro de conexão");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }

        }

        @Override
        protected void onPostExecute(String result) {


                usuarioController.deletarTabela();
                usuarioController.criarTabela();
                usuarioController.salvarUsuario(objUsuario);
                usuarioController.buscarPeloEmail(objUsuario.getUSER_email());

                if (progressDialog != null && progressDialog.isShowing()) {
                    Toast.makeText(context,"Usuário Criado com sucesso",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
                navigation.replaceFragmentWithAnimation(new FragmentMenuPrincipal(),"FragMP");
                Usuario.USUARIO_ATIVO=objUsuario;




        }
    }



    //Pesquisar Usuário
    public class SincronizarSistema extends AsyncTask<String, String, String> {

        ProgressDialog pd = new ProgressDialog(NovaConta.this);
        HttpURLConnection conn;
        URL url = null;
        Uri.Builder builder;

        public SincronizarSistema(String email) {
            this.builder = new Uri.Builder();

            builder.appendQueryParameter("email_usuario", email);
        }

        @Override
        protected void onPreExecute() {
            pd.setMessage("Verificando novo usuário...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL(ConnectionBD.URL_WEB_SERVICE + "APISincronizarSistema.php");
            } catch (MalformedURLException e) {
                Log.e("WebService", "MalformedException - " + e.getMessage());
            } catch (Exception erro) {
                Log.e("WebService", "Exception - " + erro.getMessage());
            }

            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(ConnectionBD.CONNECTION_TIMEOUT);
                conn.setReadTimeout(ConnectionBD.READ_TIMEOUT);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("charset", "utf-8");

                conn.setDoInput(true);
                conn.setDoOutput(true);

                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                conn.connect();

            } catch (IOException e) {
                Log.e("WebService", "IOException - " + e.getMessage());
            }

            try {
                int response_code = conn.getResponseCode();
                //200 ok
                //403 forbideen
                //404 pg não encontrada
                //500 erro no servidor

                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    return (result.toString());
                } else {
                    return "Erro de conexão";
                }
            } catch (Exception e) {
                Log.e("WebService", "Exception - " + e.getMessage());
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                if (!result.equals("{\"sucesso1\":false} ")) {
                    IncluirAsyncTask salvarUsuario = new IncluirAsyncTask(objUsuario, getApplicationContext());
                    salvarUsuario.execute();

                } else {
                    Toast.makeText(getApplicationContext(), "Você já possui uma conta ativa, tente logar!", Toast.LENGTH_LONG).show();

                }
            } catch (Exception e) {
                Log.e("WebService", "Erro JSONException - " + e.getMessage());
            } finally {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();

                }
            }
        }

    }
}
