package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCPFCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCertidaoCad;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentCertidao extends Fragment {
    View view;
    public FragmentCertidao() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certidao, container, false);

        Button btEditarCert = view.findViewById(R.id.btEditarCert);
        Button btExluirCert = view.findViewById(R.id.btExcluirCert);
        final DocumentoController documentoController = new DocumentoController(getContext());

        btEditarCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentCertidaoCad(), "fgCertCad");
            }
        });

        btExluirCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Excluir documento...")
                        .setMessage("Deseja realmente excluir os dados deste documento?")
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(documentoController.deletarDocumento("certidao")){
                                            Toast.makeText(getContext(),"Documento excluído",Toast.LENGTH_SHORT).show();
                                            navigation.replaceFragmentWithAnimation(new FragmentMenuPrincipal(), "fgMP");
                                        }
                                    }
                                })
                        .setNegativeButton("Não",null)
                        .show();
            }
        });
        return view;
    }
}
