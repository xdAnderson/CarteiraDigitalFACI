package com.example.lpa.carteiradigitalfaci_pt.util;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

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

public class SincronizarAsyncTask extends AsyncTask<String, String, String> {

        ProgressDialog pd;
        HttpURLConnection conn;
        URL url = null;
        Uri.Builder builder;
        Context context;

        public SincronizarAsyncTask(String email, Context context){
            this.builder = new Uri.Builder();
            this.context=context;
            builder.appendQueryParameter("email_usuario", email);
            builder.appendQueryParameter("app", "8e6e5238628885e114c555afc4bd8288f23d5fec3db662a8fef22a8d3be80eb3361a232455af74d8dbbf9aa90d039dd9c817241680d8d4b7262c37db5e233924");
        }

        @Override
        protected void onPreExecute(){
            pd = new ProgressDialog(context);
            pd.setMessage("Recuperando Dados Criptografados");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                url = new URL(UtilCarteiraDigital.URL_WEB_SERVICE+"APISincronizarSistema.php");
            }catch (MalformedURLException e){
                Log.e("WebService", "MalformedException - "+e.getMessage());
            }catch (Exception erro){
                Log.e("WebService", "Exception - "+erro.getMessage());
            }

            try{
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(UtilCarteiraDigital.CONNECTION_TIMEOUT);
                conn.setReadTimeout(UtilCarteiraDigital.READ_TIMEOUT);
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

            }catch (IOException e){
                Log.e("WebService", "IOException - "+e.getMessage());
            }

            try{
                int response_code = conn.getResponseCode();
                //200 ok
                //403 forbideen
                //404 pg não encontrada
                //500 erro no servidor

                if(response_code == HttpURLConnection.HTTP_OK){
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while((line=reader.readLine()) != null){
                        result.append(line);
                    }
                    return (result.toString());
                }else{
                    return "Erro de conexão";
                }
            }catch (Exception e){
                Log.e("WebService", "Exception - "+e.getMessage());
                return e.toString();
            }finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {


            if (pd != null && pd.isShowing()) {
                pd.dismiss();

            }

        }

}
