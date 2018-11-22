package com.example.lpa.carteiradigitalfaci_pt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;

import com.example.lpa.carteiradigitalfaci_pt.datamodel.DocumentoDataModel;
import com.example.lpa.carteiradigitalfaci_pt.datamodel.UsuarioDataModel;
import com.example.lpa.carteiradigitalfaci_pt.datasource.DataSource;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CNH;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CPF;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.CTPS;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Certidao;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Outros;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.RG;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Reservista;
import com.example.lpa.carteiradigitalfaci_pt.model.Documentos.Titulo;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;

public class DocumentoController extends DataSource {

    public DocumentoController(Context context) {
        super(context);
    }

    public Certidao buscarCertidao(){
        Certidao objCertidao = new Certidao();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM certidao WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objCertidao.setCERTIDAO_nome(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_certidao"))));
        objCertidao.setCERTIDAO_matricula(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("matricula_certidao"))));
        objCertidao.setCERTIDAO_dn_extenso(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_extenso_certidao"))));
        objCertidao.setCERTIDAO_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_certidao"))));
        objCertidao.setCERTIDAO_hora_nasc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("hora_nasc_certidao"))));
        objCertidao.setCERTIDAO_municipio_nasc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("municipio_nasc_certidao"))));
        objCertidao.setCERTIDAO_federacao_nasc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("federacao_nasc_certidao"))));
        objCertidao.setCERTIDAO_municipio_reg(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("municipio_reg_certidao"))));
        objCertidao.setCERTIDAO_federacao_reg(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("federacao_reg_certidao"))));
        objCertidao.setCERTIDAO_local_nasc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("local_nasc_certidao"))));
        objCertidao.setCERTIDAO_sexo(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("sexo_certidao"))));
        objCertidao.setCERTIDAO_filiacao_mae(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_mae_certidao"))));
        objCertidao.setCERTIDAO_filiacao_pai(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_pai_certidao"))));
        objCertidao.setCERTIDAO_avoh_mat(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("avoh_mat_certidao"))));
        objCertidao.setCERTIDAO_avom_mat(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("avom_mat_certidao"))));
        objCertidao.setCERTIDAO_avoh_pat(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("avoh_pat_certidao"))));
        objCertidao.setCERTIDAO_avom_pat(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("avom_pat_certidao"))));
        objCertidao.setCERTIDAO_gemeo(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("gemeo_certidao"))));
        objCertidao.setCERTIDAO_nome_mat_gemeos(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_mat_gemeos_certidao"))));
        objCertidao.setCERTIDAO_data_reg_extenso(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("data_reg_extenso_certidao"))));
        objCertidao.setCERTIDAO_n_nasc_vivo(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("n_nasc_vivo_certidao"))));
        objCertidao.setCERTIDAO_averb_anot(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("anot_averb_certidao"))));
        db.close();
        return objCertidao;
    }
    public CPF buscarCPF(){
        CPF objCPF = new CPF();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM cpf WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objCPF.setCPF_numero(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("numero_cpf"))));
        objCPF.setCPF_nome(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_cpf"))));
        objCPF.setCPF_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_cpf"))));
        db.close();
        return objCPF;
    }
    public CNH buscarCNH(){
        CNH objCNH = new CNH();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM cnh WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objCNH.setCNH_numero_reg_cnh(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("numero_reg_cnh_cnh"))));
        objCNH.setCNH_rg_orgao_uf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("rg_orgao_uf_cnh"))));
        objCNH.setCNH_cpf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("cpf_cnh"))));
        objCNH.setCNH_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_cnh"))));
        objCNH.setCNH_filiacao_mae(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_mae_cnh"))));
        objCNH.setCNH_filiacao_pai(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_pai_cnh"))));
        objCNH.setCNH_permissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("permissao_cnh"))));
        objCNH.setCNH_acc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("acc_cnh"))));
        objCNH.setCNH_categoria(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("categoria_cnh"))));
        objCNH.setCNH_validade(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("validade_cnh"))));
        objCNH.setCNH_primeira_cnh(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("primeira_cnh_cnh"))));
        objCNH.setCNH_local(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("local_cnh"))));
        objCNH.setCNH_data_emissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("data_emissao_cnh"))));
        objCNH.setCNH_observacao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("observacao_cnh"))));

        db.close();
        return objCNH;
    }
    public Outros buscarOutros(){
        Outros objOutros = new Outros();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM outros WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objOutros.setOUTROS_campo1(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo1"))));
        objOutros.setOUTROS_campo2(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo2"))));
        objOutros.setOUTROS_campo3(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo3"))));
        objOutros.setOUTROS_campo4(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo4"))));
        objOutros.setOUTROS_campo5(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo5"))));
        objOutros.setOUTROS_campo6(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo6"))));
        objOutros.setOUTROS_campo7(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo7"))));
        objOutros.setOUTROS_campo8(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo8"))));
        objOutros.setOUTROS_campo9(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo9"))));
        objOutros.setOUTROS_campo10(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("campo10"))));
        db.close();
        return objOutros;
    }
    public Reservista buscarReservista(){
        Reservista objReservista = new Reservista();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM reservista WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objReservista.setRESERVISTA_reg_alist(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("reg_alist_reservista"))));
        objReservista.setRESERVISTA_numero(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("numero_reservista"))));
        objReservista.setRESERVISTA_serie(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("serie_reservista"))));
        objReservista.setRESERVISTA_csm(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("csm_reservista"))));
        objReservista.setRESERVISTA_nom(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_reservista"))));
        objReservista.setRESERVISTA_emissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("emissao_reservista"))));
        db.close();
        return objReservista;
    }
    public RG buscarRG(){
        RG objRG = new RG();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM rg WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objRG.setRG_numero_rg(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("numero_rg_rg"))));
        objRG.setRG_data_expedicao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("data_expedicao_rg"))));
        objRG.setRG_nome(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_rg"))));
        objRG.setRG_filiacao_mae(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_mae_rg"))));
        objRG.setRG_filiacao_pai(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_pai_rg"))));
        objRG.setRG_naturalidade(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("naturalidade_rg"))));
        objRG.setRG_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_rg"))));
        objRG.setRG_doc_origem(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("doc_origem_rg"))));
        objRG.setRG_cpf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("cpf_rg"))));

        db.close();
        return objRG;
    }
    public Titulo buscarTitulo(){
        Titulo objTitulo = new Titulo();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM titulo WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objTitulo.setTITULO_num_insc_dv(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("num_insc_dv_titulo"))));
        objTitulo.setTITULO_nome(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_titulo"))));
        objTitulo.setTITULO_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_titulo"))));
        objTitulo.setTITULO_zona(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("zona_titulo"))));
        objTitulo.setTITULO_secao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("secao_titulo"))));
        objTitulo.setTITULO_munic_uf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("munic_uf_titulo"))));
        objTitulo.setTITULO_data_emissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("data_emissao_titulo"))));

        db.close();
        return objTitulo;
    }
    public CTPS buscarCTPS(){
        CTPS objCTPS = new CTPS();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM ctps WHERE id_usuario = \""+Usuario.USUARIO_ATIVO.getUSER_id()+"\";";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        objCTPS.setCTPS_pis_pasep(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("pis_pasep_ctps"))));
        objCTPS.setCTPS_numero(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("numero_ctps"))));
        objCTPS.setCTPS_serie(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("serie_ctps"))));
        objCTPS.setCTPS_uf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("uf_ctps"))));
        objCTPS.setCTPS_nome(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("nome_ctps"))));
        objCTPS.setCTPS_loc_nasc(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("loc_nasc_ctps"))));
        objCTPS.setCTPS_dn(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("dn_ctps"))));
        objCTPS.setCTPS_sexo(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("sexo_ctps"))));
        objCTPS.setCTPS_filiacao_mae(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_mae_ctps"))));
        objCTPS.setCTPS_filiacao_pai(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("filiacao_pai_ctps"))));
        objCTPS.setCTPS_doc_apresentado(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("doc_apresentado_ctps"))));
        objCTPS.setCTPS_est_civil(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("est_civil_ctps"))));
        objCTPS.setCTPS_cnh(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("cnh_ctps"))));
        objCTPS.setCTPS_rg(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("rg_ctps"))));
        objCTPS.setCTPS_titulo(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("titulo_ctps"))));
        objCTPS.setCTPS_tit_secao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("tit_secao_ctps"))));
        objCTPS.setCTPS_tit_zona(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("tit_zona_ctps"))));
        objCTPS.setCTPS_cpf(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("cpf_ctps"))));
        objCTPS.setCTPS_local_emissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("local_emissao_ctps"))));
        objCTPS.setCTPS_data_emissao(CriptografiaAES.decrypt(Usuario.getUserPin(),
                cursor.getBlob(cursor.getColumnIndex("data_emissao_ctps"))));
        db.close();
        return objCTPS;
    }

    public int definirItemSpinner(Spinner spinner, String item){
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(item)){
                return i;
            }
        }
        return 0;
    }
    public boolean verificarSePossuiDocumento(String id_usuario, String documento){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+documento+" WHERE id_usuario = \""+id_usuario+"\";";
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            db.close();
            return true;
        }else {
            db.close();
            return false;
        }
    }
    public boolean inserirDocumento(ContentValues values, String documento){
        SQLiteDatabase db = this.getWritableDatabase();

        boolean inseriu = db.insert(documento, null, values)>0;
        db.close();
        return inseriu;
    }
    public boolean atualizarDocumento(ContentValues values, String documento){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id())};
        boolean atualizou = db.update(documento,  values, "id_usuario = ?", whereArgs)>0;
        db.close();
        return atualizou;
    }
    public boolean deletarDocumento(String documento){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id())};
        boolean excluiu = db.delete(documento,"id_usuario = ?", whereArgs)>0;
        return excluiu;
    }



    public void deletarTabela(){
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS usuario, certidao, cnh, cpf, ctps, titulo, reservista, outros, rg");
        }catch(Exception e){

        }
    }

    public void criarTabela(){
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(UsuarioDataModel.criarTabelaUsuario());
            db.execSQL(DocumentoDataModel.criarTabelaCertidao());
            db.execSQL(DocumentoDataModel.criarTabelaCNH());
            db.execSQL(DocumentoDataModel.criarTabelaCPF());
            db.execSQL(DocumentoDataModel.criarTabelaReservista());
            db.execSQL(DocumentoDataModel.criarTabelaRG());
            db.execSQL(DocumentoDataModel.criarTabelaTitulo());
            db.execSQL(DocumentoDataModel.criarTabelaOutros());
            db.execSQL(DocumentoDataModel.criarTabelaCTPS());
        }catch (Exception e){

        }
    }

}
