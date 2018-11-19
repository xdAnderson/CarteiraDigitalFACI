package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CPF;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCPFCad;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentCPF extends Fragment {
    View view;
    public FragmentCPF() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cpf, container, false);

        TextView tvNumCPF = view.findViewById(R.id.tvNumCPF);
        TextView tvNomeCPF = view.findViewById(R.id.tvNomeCPF);
        TextView tvDNCPF = view.findViewById(R.id.tvDNCPF);
        Button btEditarCPF = view.findViewById(R.id.btEditarCPF);
        Button btExcluirCPF = view.findViewById(R.id.btExcluirCPF);

        final DocumentoController documentoController = new DocumentoController(getContext());
        CPF objCPF = documentoController.buscarCPF();
        tvNumCPF.setText(objCPF.getCPF_numero());
        tvNomeCPF.setText(objCPF.getCPF_nome());
        tvDNCPF.setText(objCPF.getCPF_dn());

        btEditarCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentCPFCad(), "fgCPFCad");
            }
        });

        btExcluirCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Excluir documento...")
                        .setMessage("Deseja realmente excluir os dados deste documento?")
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(documentoController.deletarDocumento("cpf")){
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
