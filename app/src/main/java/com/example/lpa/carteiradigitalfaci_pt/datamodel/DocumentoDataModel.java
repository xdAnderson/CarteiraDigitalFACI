package com.example.lpa.carteiradigitalfaci_pt.datamodel;

public class DocumentoDataModel {

    public static String criarTabelaCertidao() {
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'certidao' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'cpf_certidao' BLOB NULL,\n" +
                "  'nome_certidao' BLOB NULL,\n" +
                "  'matricula_certidao' BLOB NULL,\n" +
                "  'dn_extenso_certidao' BLOB NULL,\n" +
                "  'dn_certidao' BLOB NULL,\n" +
                "  'hora_nasc_certidao' BLOB NULL,\n" +
                "  'municipio_nasc_certidao' BLOB NULL,\n" +
                "  'federacao_nasc_certidao' BLOB NULL,\n" +
                "  'municipio_reg_certidao' BLOB NULL,\n" +
                "  'federacao_reg_certidao' BLOB NULL,\n" +
                "  'local_nasc_certidao' BLOB NULL,\n" +
                "  'sexo_certidao' BLOB NULL,\n" +
                "  'filiacao_mae_certidao' BLOB NULL,\n" +
                "  'filiacao_pai_certidao' BLOB NULL,\n" +
                "  'avoh_mat_certidao' BLOB NULL,\n" +
                "  'avom_mat_certidao' BLOB NULL,\n" +
                "  'avoh_pat_certidao' BLOB NULL,\n" +
                "  'avom_pat_certidao' BLOB NULL,\n" +
                "  'gemeo_certidao' BLOB NULL,\n" +
                "  'nome_mat_gemeos_certidao' BLOB NULL,\n" +
                "  'data_reg_extenso_certidao' BLOB NULL,\n" +
                "  'n_nasc_vivo_certidao' BLOB NULL,\n" +
                "  'anot_averb_certidao' BLOB NULL,\n" +
                "  PRIMARY KEY ('matricula_certidao'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaCNH(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'cnh' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_reg_cnh_cnh' BLOB NULL,\n" +
                "  'rg_orgao_uf_cnh' BLOB NULL,\n" +
                "  'cpf_cnh' BLOB NULL,\n" +
                "  'dn_cnh' BLOB NULL,\n" +
                "  'filiacao_mae_cnh' BLOB NULL,\n" +
                "  'filiacao_pai_cnh' BLOB NULL,\n" +
                "  'permissao_cnh' BLOB NULL,\n" +
                "  'acc_cnh' BLOB NULL,\n" +
                "  'categoria_cnh' BLOB NULL,\n" +
                "  'validade_cnh' BLOB NULL,\n" +
                "  'primeira_cnh_cnh' BLOB NULL,\n" +
                "  'local_cnh' BLOB NULL,\n" +
                "  'data_emissao_cnh' BLOB NULL,\n" +
                "  'observacao_cnh' BLOB NULL,\n" +
                "  PRIMARY KEY ('numero_reg_cnh_cnh'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaCPF(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'cpf' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_cpf' BLOB NOT NULL,\n" +
                "  'nome_cpf' BLOB NULL,\n" +
                "  'dn_cpf' BLOB NULL,\n" +
                "  PRIMARY KEY ('numero_cpf'),\n"+
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaOutros(){
        String qr;
        qr =

            "CREATE TABLE IF NOT EXISTS 'outros' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'id_outros' VARCHAR(255) NOT NULL,\n" +
                "  'nome_documento' VARCHAR(100) NOT NULL,\n" +
                "  'campo1' BLOB NULL,\n" +
                "  'campo2' BLOB NULL,\n" +
                "  'campo3' BLOB NULL,\n" +
                "  'campo4' BLOB NULL,\n" +
                "  'campo5' BLOB NULL,\n" +
                "  'campo6' BLOB NULL,\n" +
                "  'campo7' BLOB NULL,\n" +
                "  'campo8' BLOB NULL,\n" +
                "  'campo9' BLOB NULL,\n" +
                "  'campo10' BLOB NULL,\n" +
                "  PRIMARY KEY ('id_outros'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaReservista(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'reservista' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'reg_alist_reservista' BLOB NULL,\n" +
                "  'numero_reservista' BLOB NULL,\n" +
                "  'serie_reservista' BLOB NULL,\n" +
                "  'csm_reservista' BLOB NULL,\n" +
                "  'nome_reservista' BLOB NULL,\n" +
                "  'emissao_reservista' BLOB NULL,\n" +
                "  'filiacao_mae_reservista' BLOB NULL,\n" +
                "  'filiacao_pai_reservista' BLOB NULL,\n" +
                "  'dn_reservista' BLOB NULL,\n" +
                "  'naturalidade_reservista' BLOB NULL,\n" +
                "  'data_dispensa_reservista' BLOB NULL,\n" +
                "  'motivo_dispensa_reservista' BLOB NULL,\n" +
                "  'responsavel_dispensa_reservista' BLOB NULL,\n" +
                "  PRIMARY KEY ('reg_alist_reservista'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaRG(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'rg' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_rg_rg' BLOB NULL,\n" +
                "  'data_expedicao_rg' BLOB NULL,\n" +
                "  'nome_rg' BLOB NULL,\n" +
                "  'filiacao_mae_rg' BLOB NULL,\n" +
                "  'filiacao_pai_rg' BLOB NULL,\n" +
                "  'naturalidade_rg' BLOB NULL,\n" +
                "  'dn_rg' BLOB NULL,\n" +
                "  'doc_origem_rg' BLOB NOT NULL,\n" +
                "  'cpf_rg' BLOB NOT NULL,\n" +
                "  PRIMARY KEY ('numero_rg_rg'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaTitulo(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'titulo' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'num_insc_dv_titulo' BLOB NULL,\n" +
                "  'nome_titulo' BLOB NULL,\n" +
                "  'dn_titulo' BLOB NULL,\n" +
                "  'zona_titulo' BLOB NULL,\n" +
                "  'secao_titulo' BLOB NULL,\n" +
                "  'munic_uf_titulo' BLOB NULL,\n" +
                "  'data_emissao_titulo' BLOB NULL,\n" +
                "  PRIMARY KEY ('num_insc_dv_titulo'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }

    public static String criarTabelaCTPS(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'ctps' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'pis_pasep_ctps' BLOB NULL,\n" +
                "  'numero_ctps' BLOB NULL,\n" +
                "  'serie_ctps' BLOB NULL,\n" +
                "  'uf_ctps' BLOB NULL,\n" +
                "  'nome_ctps' BLOB NULL,\n" +
                "  'loc_nasc_ctps' BLOB NULL,\n" +
                "  'dn_ctps' BLOB NULL,\n" +
                "  'sexo_ctps' BLOB NULL,\n" +
                "  'filiacao_mae_ctps' BLOB NULL,\n" +
                "  'filiacao_pai_ctps' BLOB NULL,\n" +
                "  'doc_apresentado_ctps' BLOB NULL,\n" +
                "  'est_civil_ctps' BLOB NULL,\n" +
                "  'cnh_ctps' BLOB NULL,\n" +
                "  'rg_ctps' BLOB NULL,\n" +
                "  'titulo_ctps' BLOB NULL,\n" +
                "  'tit_secao_ctps' BLOB NULL,\n" +
                "  'tit_zona_ctps' BLOB NULL,\n" +
                "  'cpf_ctps' BLOB NULL,\n" +
                "  'local_emissao_ctps' BLOB NULL,\n" +
                "  'data_emissao_ctps' BLOB NULL,\n" +
                "  PRIMARY KEY ('numero_ctps'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
}
