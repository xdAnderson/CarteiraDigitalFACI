package com.example.lpa.carteiradigitalfaci_pt.datamodel;

public class DocumentoDataModel {

    public static String criarTabelaCertidao() {
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'certidao' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
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
        qr = "CREATE TABLE IF NOT EXISTS 'outros' (" +
                "'id_usuario' INTEGER(255) NOT NULL, " +
                "'id_outros' INTEGER(255), " +
                "'nome_documento' BLOB NOT NULL, " +
                "'campo1' BLOB NULL, " +
                "'campo2' BLOB NULL, " +
                "'campo3' BLOB NULL, " +
                "'campo4' BLOB NULL, " +
                "'campo5' BLOB NULL, " +
                "'campo6' BLOB NULL, " +
                "'campo7' BLOB NULL, " +
                "'campo8' BLOB NULL, " +
                "'campo9' BLOB NULL, " +
                "'campo10' BLOB NULL, " +
                "PRIMARY KEY ('id_outros'), " +
                "FOREIGN KEY ('id_usuario') " +
                    "REFERENCES 'usuario' ('id_usuario'));";
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
        qr = "CREATE TABLE 'ctps' (" +
                "'id_usuario' INTEGER(255) NOT NULL, " +
                "'pis_pasep_ctps' BLOB NULL, " +
                "'numero_ctps' BLOB NULL, " +
                "'serie_ctps' BLOB NULL, " +
                "'uf_ctps' BLOB NULL, " +
                "'nome_ctps' BLOB NULL, " +
                "'loc_nasc_ctps' BLOB NULL, " +
                "'dn_ctps' BLOB NULL, " +
                "'sexo_ctps' BLOB NULL, " +
                "'filiacao_mae_ctps' BLOB NULL, " +
                "'filiacao_pai_ctps' BLOB NULL, " +
                "'doc_apresentado_ctps' BLOB NULL, " +
                "'est_civil_ctps' BLOB NULL, " +
                "'cnh_ctps' BLOB NULL, " +
                "'rg_ctps' BLOB NULL, " +
                "'titulo_ctps' BLOB NULL, " +
                "'tit_secao_ctps' BLOB NULL, " +
                "'tit_zona_ctps' BLOB NULL, " +
                "'cpf_ctps' BLOB NULL, " +
                "'local_emissao_ctps' BLOB NULL, " +
                "'data_emissao_ctps' BLOB NULL, " +
                "PRIMARY KEY ('numero_ctps'), " +
                "FOREIGN KEY ('id_usuario') " +
                    "REFERENCES 'usuario' ('id_usuario'));";
        return qr;
    }
}
