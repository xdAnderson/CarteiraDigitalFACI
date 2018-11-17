package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.CriptografiaBase64;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CPF;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentCPFCad extends Fragment {
    View view;

    boolean possui = false;
    public FragmentCPFCad() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cpf_cad, container, false);

        final EditText etNumCPF = view.findViewById(R.id.etNumCPF);
        final EditText etNomeCPF = view.findViewById(R.id.etNomeCPF);
        final EditText etDNCPF = view.findViewById(R.id.etDNCPF);
        final Button btCadCPF = view.findViewById(R.id.btCadCPF);
        final DocumentoController documentoController = new DocumentoController(getContext());
        final CriptografiaBase64 criptografiaBase64 = new CriptografiaBase64();

        if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()), "cpf")){

            CPF objCPF = documentoController.buscarCPF();

            etNumCPF.setText(objCPF.getCPF_numero());
            etNomeCPF.setText(objCPF.getCPF_nome());
            etDNCPF.setText(objCPF.getCPF_dn());
            btCadCPF.setBackgroundResource(R.drawable.botao_atualizar);
            possui = true;
        }

        btCadCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("id_usuario",Usuario.USUARIO_ATIVO.getUSER_id());
                values.put("numero_cpf",criptografiaBase64.encrypt(Usuario.getUserPin(), etNumCPF.getText().toString()));
                values.put("nome_cpf",criptografiaBase64.encrypt(Usuario.getUserPin(), etNomeCPF.getText().toString()));
                values.put("dn_cpf",criptografiaBase64.encrypt(Usuario.getUserPin(), etDNCPF.getText().toString()));

                if(possui){
                    if(documentoController.atualizarDocumento(values, "cpf")){
                        Toast.makeText(getContext(),"CPF atualizado", Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etDNCPF.getWindowToken(), 0);
                        navigation.replaceFragmentWithAnimation(new FragmentCPF(), "fgCPF");
                    }else
                        Toast.makeText(getContext(),"Erro1", Toast.LENGTH_SHORT).show();

                }else{
                    if(documentoController.inserirDocumento(values, "cpf")){
                        Toast.makeText(getContext(),"CPF cadastrado", Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etDNCPF.getWindowToken(), 0);
                        navigation.replaceFragmentWithAnimation(new FragmentCPF(), "fgCPF");
                    }else
                        Toast.makeText(getContext(),"Erro2", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }
}
