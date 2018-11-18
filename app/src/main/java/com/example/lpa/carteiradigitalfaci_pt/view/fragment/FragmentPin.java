package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.Login;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentPin extends Fragment {
    View view;
    public FragmentPin() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pin, container, false);

        final EditText etEntradaPIN = view.findViewById(R.id.etEntradaPIN);
        Button btSairPIN = view.findViewById(R.id.btSairPIN);
        Button btConfPIN = view.findViewById(R.id.btConfPIN);
        TextView tvEntradaPIN = view.findViewById(R.id.tvEntradaPIN);
        final UsuarioController usuarioController = new UsuarioController(getContext());

        etEntradaPIN.requestFocus();
        final String[] primNome = Usuario.USUARIO_ATIVO.getUSER_nome().split("\\s");
        tvEntradaPIN.setText("Olá "+primNome[0]+"!");

        btSairPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        etEntradaPIN.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() == 4){
                    String pin = etEntradaPIN.getText().toString();
                    if(usuarioController.recuperarPIN(pin)){
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etEntradaPIN.getWindowToken(), 0);
                        Intent i = new Intent(getActivity(), navigation.class);
                        Toast.makeText(getContext(), "Bem Vindo "+primNome[0]+"!",Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.entrar_direita, R.anim.sair_esquerda);
                        getActivity().finish();
                    }else{
                        Toast.makeText(getContext(), "PIN INCORRETO",Toast.LENGTH_SHORT).show();
                        etEntradaPIN.setError("PIN Incorreto");
                        etEntradaPIN.setText("");
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        btConfPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });











        return view;
    }
}
