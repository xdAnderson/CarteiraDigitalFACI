package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.widget.AppCompatTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Certidao;
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
        TextView tvNome_Cert = view.findViewById(R.id.tvNome_Cert);
        TextView tvMat_Cert = view.findViewById(R.id.tvMat_Cert);
        TextView tvDNExt_Cert = view.findViewById(R.id.tvDNExt_Cert);
        TextView tvDiaNasc_Cert = view.findViewById(R.id.tvDiaNasc_Cert);
        TextView tvMesNasc_Cert = view.findViewById(R.id.tvMesNasc_Cert);
        TextView tvAnoNasc_Cert = view.findViewById(R.id.tvAnoNasc_Cert);
        TextView tvHoraNasc_Cert = view.findViewById(R.id.tvHoraNasc_Cert);
        TextView tvMunicUFNasc_Cert = view.findViewById(R.id.tvMuncUFNasc_Cert);
        TextView tvMunicUFReg_Cert = view.findViewById(R.id.tvMuncUFReg_Cert);
        TextView tvLocalNasc_Cert = view.findViewById(R.id.tvLocalNasc_Cert);
        TextView tvSexo_Cert = view.findViewById(R.id.tvSexo_Cert);
        TextView tvFiliacao_Cert = view.findViewById(R.id.tvFiliacao_Cert);
        TextView tvAvos_Cert = view.findViewById(R.id.tvAvos_Cert);
        TextView tvQuantGem_Cert = view.findViewById(R.id.tvQuantGem_Cert);
        TextView tvNomeMatGem_Cert = view.findViewById(R.id.tvNomeMatGem_Cert);
        TextView tvDataRegExt_Cert = view.findViewById(R.id.tvDataRegExt_Cert);
        TextView tvDNV = view.findViewById(R.id.tvDNV_Cert);
        TextView tvAverbAnot_Cert = view.findViewById(R.id.tvAverAnot_Cert);
        final DocumentoController documentoController = new DocumentoController(getContext());

        Certidao objCertidao = new Certidao();


        objCertidao = documentoController.buscarCertidao();
        tvNome_Cert.setText(objCertidao.getCERTIDAO_nome());
        tvMat_Cert.setText(objCertidao.getCERTIDAO_matricula());
        tvDNExt_Cert.setText(objCertidao.getCERTIDAO_dn_extenso());

        String[] dn = objCertidao.getCERTIDAO_dn().split("/");
        tvDiaNasc_Cert.setText(dn[0]);
        tvMesNasc_Cert.setText(dn[1]);
        tvAnoNasc_Cert.setText(dn[2]);
        tvHoraNasc_Cert.setText(objCertidao.getCERTIDAO_hora_nasc());
        tvMunicUFNasc_Cert.setText(objCertidao.getCERTIDAO_municipio_nasc()+"/"+objCertidao.getCERTIDAO_federacao_nasc());
        tvMunicUFReg_Cert.setText(objCertidao.getCERTIDAO_municipio_reg()+"/"+objCertidao.getCERTIDAO_federacao_reg());
        tvLocalNasc_Cert.setText(objCertidao.getCERTIDAO_local_nasc());
        tvSexo_Cert.setText(objCertidao.getCERTIDAO_sexo());
        tvFiliacao_Cert.setText(objCertidao.getCERTIDAO_filiacao_mae()+" e "+objCertidao.getCERTIDAO_filiacao_pai());
        tvAvos_Cert.setText("Maternos: "+objCertidao.getCERTIDAO_avom_mat()+" e "+objCertidao.getCERTIDAO_avoh_mat()+
                            "\nPaternos: "+objCertidao.getCERTIDAO_avom_pat()+" e "+objCertidao.getCERTIDAO_avoh_pat());
        tvQuantGem_Cert.setText(objCertidao.getCERTIDAO_gemeo());
        tvNomeMatGem_Cert.setText(objCertidao.getCERTIDAO_nome_mat_gemeos());
        tvDataRegExt_Cert.setText(objCertidao.getCERTIDAO_data_reg_extenso());
        tvDNV.setText(objCertidao.getCERTIDAO_dnv());
        tvAverbAnot_Cert.setText(objCertidao.getCERTIDAO_averb_anot());

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
