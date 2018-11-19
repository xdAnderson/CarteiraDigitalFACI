package com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad;

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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.CriptografiaAES;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Certidao;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentCertidao;
import com.example.lpa.carteiradigitalfaci_pt.view.navigation;


public class FragmentCertidaoCad extends Fragment {
    View view;

    boolean possui = false;
    public FragmentCertidaoCad() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certidao_cad, container, false);
    //Cast dos Edits Text
        final EditText etNome_Cert = view.findViewById(R.id.etNome_Cert);
        final EditText etNumCPF_Cert = view.findViewById(R.id.etNumCPF_Cert);
        final EditText etMatricula_Cert = view.findViewById(R.id.etMatricula_Cert);
        final EditText etDNExt_Cert = view.findViewById(R.id.etDNExt_Cert);
        final EditText etDN_Cert = view.findViewById(R.id.etDN_Cert);
        final EditText etHoraNasc_Cert = view.findViewById(R.id.etHoraNasc_Cert);
        final EditText etNaturalidade_Cert = view.findViewById(R.id.etNaturalidade_Cert);
        final EditText etMunicReg_Cert = view.findViewById(R.id.etMunicReg_Cert);
        final EditText etLocalNasc_Cert = view.findViewById(R.id.etLocalNasc_Cert);
        final EditText etMunicNasc_Cert = view.findViewById(R.id.etMunicNasc_Cert);
        final EditText etFiliaMae_Cert = view.findViewById(R.id.etFiliaMae_Cert);
        final EditText etFiliaPai_Cert = view.findViewById(R.id.etFiliaPai_Cert);
        final EditText etAvomMat_Cert = view.findViewById(R.id.etAvomMat_Cert);
        final EditText etAvohMat_Cert = view.findViewById(R.id.etAvohMat_Cert);
        final EditText etAvomPat_Cert = view.findViewById(R.id.etAvomPat_Cert);
        final EditText etAvohPat_Cert = view.findViewById(R.id.etAvohPat_Cert);
        final EditText etNomeMatGem_Cert = view.findViewById(R.id.etNomMatGem_Cert);
        final EditText etDataRegExt_Cert = view.findViewById(R.id.etDataRegExt_Cert);
        final EditText etDNV_Cert = view.findViewById(R.id.etDNV_Cert);
        final EditText etAverbAnot_Cert = view.findViewById(R.id.etAverbAnot_Cert);//Cast dos Edits Text
    //Cast dos Spinners
        final Spinner spUFNasc_Cert = view.findViewById(R.id.spUFNasc_Cert);
        final Spinner spSexo_Cert = view.findViewById(R.id.spSexo_Cert);
        final Spinner spUFReg_Cert = view.findViewById(R.id.spUFReg_Cert);
        final Spinner spQuantGem_Cert = view.findViewById((R.id.spQuantGem_Cert));
    //Cast do Button
        final Button btCadCPF = view.findViewById(R.id.btCad_Cert);

        final CriptografiaAES criptografiaAES = new CriptografiaAES();
        final DocumentoController documentoController = new DocumentoController(getContext());
    //Verificação de Documento existente
        if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()), "certidao")){
            Certidao objCertidao = documentoController.buscarCertidao();
            etNome_Cert.setText(objCertidao.getCERTIDAO_nome());
            etNumCPF_Cert.setText(objCertidao.getCERTIDAO_cpf());
            etMatricula_Cert.setText(objCertidao.getCERTIDAO_matricula());
            etDNExt_Cert.setText(objCertidao.getCERTIDAO_dn_extenso());
            etDN_Cert.setText(objCertidao.getCERTIDAO_dn());
            etHoraNasc_Cert.setText(objCertidao.getCERTIDAO_hora_nasc());
            etNaturalidade_Cert.setText(objCertidao.getCERTIDAO_naturalidade());
            String sexoSP = objCertidao.getCERTIDAO_sexo();
            spSexo_Cert.setSelection(documentoController.definirItemSpinner(spSexo_Cert, sexoSP));
            etMunicReg_Cert.setText(objCertidao.getCERTIDAO_municipio_reg());
            String ufRSP = objCertidao.getCERTIDAO_federacao_reg();
/*Spinner*/ spUFReg_Cert.setSelection(documentoController.definirItemSpinner(spUFReg_Cert, ufRSP));
            etLocalNasc_Cert.setText(objCertidao.getCERTIDAO_local_nasc());
            etMunicNasc_Cert.setText(objCertidao.getCERTIDAO_municipio_nasc());
            String ufNSP = objCertidao.getCERTIDAO_federacao_nasc();
/*Spinner*/ spUFNasc_Cert.setSelection(documentoController.definirItemSpinner(spUFNasc_Cert,ufNSP));
            etFiliaMae_Cert.setText(objCertidao.getCERTIDAO_filiacao_mae());
            etFiliaPai_Cert.setText(objCertidao.getCERTIDAO_filiacao_pai());
            etAvomMat_Cert.setText(objCertidao.getCERTIDAO_avom_mat());
            etAvohMat_Cert.setText(objCertidao.getCERTIDAO_avoh_mat());
            etAvomPat_Cert.setText(objCertidao.getCERTIDAO_avom_pat());
            etAvohPat_Cert.setText(objCertidao.getCERTIDAO_avoh_pat());
            String quantGemSP = objCertidao.getCERTIDAO_gemeo();
/*Spinner*/ spQuantGem_Cert.setSelection(documentoController.definirItemSpinner(spQuantGem_Cert,quantGemSP));
            etNomeMatGem_Cert.setText(objCertidao.getCERTIDAO_nome_mat_gemeos());
            etDataRegExt_Cert.setText(objCertidao.getCERTIDAO_data_reg_extenso());
            etDNV_Cert.setText(objCertidao.getCERTIDAO_dnv());
            etAverbAnot_Cert.setText(objCertidao.getCERTIDAO_averb_anot());

            btCadCPF.setBackgroundResource(R.drawable.botao_atualizar);
            possui = true;
        }

        btCadCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                values.put("id_usuario",Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()));
                values.put("nome_certidap", criptografiaAES.encrypt(Usuario.getUserPin(), etNome_Cert.getText().toString()));
                values.put("cpf_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etNumCPF_Cert.getText().toString()));
                values.put("matricula_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etMatricula_Cert.getText().toString()));
                values.put("dn_extenso_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etDNExt_Cert.getText().toString()));
                values.put("dn_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etDN_Cert.getText().toString()));
                values.put("hora_nasc_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etHoraNasc_Cert.getText().toString()));
                values.put("municipio_nasc_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etMunicNasc_Cert.getText().toString()));
                values.put("naturalidade_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etNaturalidade_Cert.getText().toString()));
                values.put("federacao_nasc_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), spUFNasc_Cert.getSelectedItem().toString()));
                values.put("municipio_reg_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etMunicReg_Cert.getText().toString()));
                values.put("federacao_reg_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), spUFReg_Cert.getSelectedItem().toString()));
                values.put("local_nasc_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etLocalNasc_Cert.getText().toString()));
                values.put("sexo_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), spSexo_Cert.getSelectedItem().toString()));
                values.put("filiacao_mae_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etFiliaMae_Cert.getText().toString()));
                values.put("filiacao_pai_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etFiliaPai_Cert.getText().toString()));
                values.put("avoh_mat_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etAvohMat_Cert.getText().toString()));
                values.put("avom_mat_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etAvomMat_Cert.getText().toString()));
                values.put("avoh_pat_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etAvohPat_Cert.getText().toString()));
                values.put("avom_pat_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etAvomPat_Cert.getText().toString()));
                values.put("gemeo_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), spQuantGem_Cert.getSelectedItem().toString()));
                values.put("nome_mat_gemeos_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etNomeMatGem_Cert.getText().toString()));
                values.put("data_reg_extenso_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etDataRegExt_Cert.getText().toString()));
                values.put("n_nasc_vivo_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etDNV_Cert.getText().toString()));
                values.put("anot_averb_certidao", criptografiaAES.encrypt(Usuario.getUserPin(), etAverbAnot_Cert.getText().toString()));

                if(possui){
                    if(documentoController.atualizarDocumento(values, "certidao")){
                        Toast.makeText(getContext(),"Certidão atualizada", Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etAverbAnot_Cert.getWindowToken(), 0);
                        navigation.replaceFragmentWithAnimation(new FragmentCertidao(), "fgCert");
                    }else
                        Toast.makeText(getContext(),"Erro1", Toast.LENGTH_SHORT).show();

                }else{
                    if(documentoController.inserirDocumento(values, "certidao")){
                        Toast.makeText(getContext(),"Certidao cadastrada", Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(etAverbAnot_Cert.getWindowToken(), 0);
                        navigation.replaceFragmentWithAnimation(new FragmentCertidao(), "fgCert");
                    }else
                        Toast.makeText(getContext(),"Erro2", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }
}
