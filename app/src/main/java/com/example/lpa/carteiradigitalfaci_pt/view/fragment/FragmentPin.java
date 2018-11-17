package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        tvEntradaPIN.setText("Olá "+Usuario.USUARIO_ATIVO.getUSER_nome());

        btSairPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        btConfPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tamPIN = etEntradaPIN.getText().toString();
                if(tamPIN.length()==4) {
                    if(usuarioController.recuperarPIN(tamPIN)){
                        Intent i = new Intent(getActivity(), navigation.class);
                        startActivity(i);
                        getActivity().finish();
                    }else{
                        Toast.makeText(getContext(), "PIN INCORRETO",Toast.LENGTH_SHORT).show();
                        etEntradaPIN.setError("Incorreto");
                    }
                }else{
                    etEntradaPIN.setError("Exatamente 4 dígitos");
                }
            }
        });











        return view;
    }
}
