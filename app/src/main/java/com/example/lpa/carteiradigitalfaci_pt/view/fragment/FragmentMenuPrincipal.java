package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentMenuPrincipal extends Fragment {
    View view;
    TextView tvCertidao;
    TextView tvRG;
    TextView tvTitulo;
    TextView tvCPF;
    TextView tvCNH;
    TextView tvCTPS;
    TextView tvReservista;
    TextView tvOutros;
    Button btCertidao;
    Button btRG;
    Button btCPF;
    Button btCNH;
    Button btTitulo;
    Button btCTPS;
    Button btReservista;
    Button btOutros;

    public FragmentMenuPrincipal() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_menu_principal, container, false);

        tvCertidao = view.findViewById(R.id.tvCertidao);
        tvRG = view.findViewById(R.id.tvRG);
        tvTitulo = view.findViewById(R.id.tvTitulo);
        tvCPF = view.findViewById(R.id.tvCPF);
        tvCNH = view.findViewById(R.id.tvCNH);
        tvCTPS = view.findViewById(R.id.tvCTPS);
        tvReservista = view.findViewById(R.id.tvReservista);
        tvOutros = view.findViewById(R.id.tvOutros);
        btCertidao = view.findViewById(R.id.btCertidao);
        btRG = view.findViewById(R.id.btRG);
        btCPF = view.findViewById(R.id.btCPF);
        btCNH = view.findViewById(R.id.btCNH);
        btTitulo = view.findViewById(R.id.btTitulo);
        btCTPS = view.findViewById(R.id.btCTPS);
        btReservista = view.findViewById(R.id.btReservista);
        btOutros = view.findViewById(R.id.btOutros);

        final DocumentoController documentoController = new DocumentoController(getContext());

        btCertidao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigation.replaceFragmentWithAnimation(new FragmentCertidao(), "fgCert");
                getActivity().setTitle("Certidão de Nascimento");
            }
        });
        btRG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentRG(), "fgRG");
                getActivity().setTitle("Registro Geral (RG)");
            }
        });
        btCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"cpf")){
                    navigation.replaceFragmentWithAnimation(new FragmentCPF(), "fgCPF");
                }else
                    navigation.replaceFragmentWithAnimation(new FragmentCPFCad(), "fgCPF");
                getActivity().setTitle("Cad. Pessoa Física (CPF)");
            }
        });
        btCNH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentCNH(), "fgCNH");
                getActivity().setTitle("Cart. Nac. de Habilitação");
            }
        });
        btTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentTitulo(), "fgTit");
                getActivity().setTitle("Título de Eleitor");
            }
        });
        btCTPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentCTPS(), "fgCTPS");
                getActivity().setTitle("Cart. Trab. e Previdência Social");
            }
        });
        btReservista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentReservista(), "fgReser");
                getActivity().setTitle("Cert. de Dispença (Reservista)");
            }
        });
        btOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.replaceFragmentWithAnimation(new FragmentOutros(), "fgOut");
                getActivity().setTitle("Outros Documetos");
            }
        });



        return view;
    }
}
