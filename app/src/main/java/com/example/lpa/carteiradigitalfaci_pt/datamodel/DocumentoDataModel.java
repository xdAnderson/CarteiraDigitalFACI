package com.example.lpa.carteiradigitalfaci_pt.datamodel;

public class DocumentoDataModel {

    public static String criarTabelaCertidao() {
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'certidao' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'cpf_certidao' VARCHAR(12) NULL,\n" +
                "  'nome_certidao' VARCHAR(50) NULL,\n" +
                "  'matricula_certidao' VARCHAR(33) NULL,\n" +
                "  'dn_extenso_certidao' VARCHAR(50) NULL,\n" +
                "  'dn_certidao' DATE NULL,\n" +
                "  'hora_nasc_certidao' VARCHAR(50) NULL,\n" +
                "  'municipio_nasc_certidao' VARCHAR(30) NULL,\n" +
                "  'federacao_nasc_certidao' VARCHAR(2) NULL,\n" +
                "  'municipio_reg_certidao' VARCHAR(30) NULL,\n" +
                "  'federacao_reg_certidao' VARCHAR(2) NULL,\n" +
                "  'local_nasc_certidao' VARCHAR(30) NULL,\n" +
                "  'sexo_certidao' VARCHAR(10) NULL,\n" +
                "  'filiacao_mae_certidao' VARCHAR(50) NULL,\n" +
                "  'filiacao_pai_certidao' VARCHAR(50) NULL,\n" +
                "  'avoh_mat_certidao' VARCHAR(50) NULL,\n" +
                "  'avom_mat_certidao' VARCHAR(50) NULL,\n" +
                "  'avoh_pat_certidao' VARCHAR(50) NULL,\n" +
                "  'avom_pat_certidao' VARCHAR(50) NULL,\n" +
                "  'gemeo_certidao' INT (1) NULL,\n" +
                "  'nome_mat_gemeos_certidao' VARCHAR(255) NULL,\n" +
                "  'data_reg_extenso_certidao' VARCHAR(50) NULL,\n" +
                "  'n_nasc_vivo_certidao' VARCHAR(40) NULL,\n" +
                "  'anot_averb_certidao' VARCHAR(200) NULL,\n" +
                "  'nome_oficio_certidao' VARCHAR(50) NULL,\n" +
                "  'oficial_certidao' VARCHAR(50) NULL,\n" +
                "  'end_ofic_certidao' VARCHAR(100) NULL,\n" +
                "  'telefone_ofic_certidao' VARCHAR(20) NULL,\n" +
                "  'email_ofic_certidao' VARCHAR(30) NULL,\n" +
                "  PRIMARY KEY ('matricula_certidao'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
    public static String criarTabelaCNH(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'cnh' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_reg_cnh_cnh' VARCHAR(20) NULL,\n" +
                "  'rg_orgao_uf_cnh' VARCHAR(10) NULL,\n" +
                "  'cpf_cnh' VARCHAR(13) NULL,\n" +
                "  'dn_cnh' DATE NULL,\n" +
                "  'filiacao_mae_rg' VARCHAR(50) NULL,\n" +
                "  'filiacao_pai_rg' VARCHAR(50) NULL,\n" +
                "  'permissao_cnh' VARCHAR(30) NULL,\n" +
                "  'acc_cnh' VARCHAR(10) NULL,\n" +
                "  'categoria_cnh' VARCHAR(10) NULL,\n" +
                "  'validade_cnh' DATE NULL,\n" +
                "  'primeira_cnh_cnh' DATE NULL,\n" +
                "  'local_cnh' VARCHAR(30) NULL,\n" +
                "  'data_emissao_cnh' DATE NULL,\n" +
                "  PRIMARY KEY ('numero_reg_cnh_cnh'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
    public static String criarTabelaCPF(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'cpf' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_cpf' VARCHAR(12) NOT NULL,\n" +
                "  'nome_cpf' VARCHAR(50) NULL,\n" +
                "  'nome_social_cpf' VARCHAR(50) NULL,\n" +
                "  'dn_cpf' DATE NULL,\n" +
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
                "  'campo1' VARCHAR(100) NULL,\n" +
                "  'campo2' VARCHAR(100) NULL,\n" +
                "  'campo3' VARCHAR(100) NULL,\n" +
                "  'campo4' VARCHAR(100) NULL,\n" +
                "  'campo5' VARCHAR(100) NULL,\n" +
                "  'campo6' VARCHAR(100) NULL,\n" +
                "  'campo7' VARCHAR(100) NULL,\n" +
                "  'campo8' VARCHAR(100) NULL,\n" +
                "  'campo9' VARCHAR(100) NULL,\n" +
                "  'campo10' VARCHAR(100) NULL,\n" +
                "  PRIMARY KEY ('id_outros'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
    public static String criarTabelaReservista(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'reservista' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'reg_alist_reservista' VARCHAR(15) NULL,\n" +
                "  'numero_reservista' VARCHAR(10) NULL,\n" +
                "  'serie_reservista' VARCHAR(5) NULL,\n" +
                "  'csm_reservista' VARCHAR(5) NULL,\n" +
                "  'nome_reservista' VARCHAR(50) NULL,\n" +
                "  'emissao_reservista' VARCHAR(100) NULL,\n" +
                "  PRIMARY KEY ('reg_alist_reservista'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
    public static String criarTabelaRG(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'rg' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'numero_rg_rg' INT(11) NULL,\n" +
                "  'data_expedicao_rg' DATE NULL,\n" +
                "  'nome_rg' VARCHAR(50) NULL,\n" +
                "  'filiacao_mae_rg' VARCHAR(50) NULL,\n" +
                "  'filiacao_pai_rg' VARCHAR(50) NULL,\n" +
                "  'naturalidade_rg' VARCHAR(30) NULL,\n" +
                "  'dn_rg' DATE NULL,\n" +
                "  'doc_origem_rg' VARCHAR(100) NOT NULL,\n" +
                "  'cpf_rg' VARCHAR(12) NOT NULL,\n" +
                "  'foto_rg' BLOB NOT NULL,\n" +
                "  PRIMARY KEY ('numero_rg_rg'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
    public static String criarTabelaTitulo(){
        String qr;
        qr = "CREATE TABLE IF NOT EXISTS 'titulo' (\n" +
                "  'id_usuario' INTEGER(255) NOT NULL,\n" +
                "  'num_insc_dv_titulo' VARCHAR(15) NULL,\n" +
                "  'nome_titulo' VARCHAR(50) NULL,\n" +
                "  'dn_titulo' DATE NULL,\n" +
                "  'zona_titulo' VARCHAR(5) NULL,\n" +
                "  'secao_titulo' VARCHAR(5) NULL,\n" +
                "  'munic_uf_titulo' VARCHAR(30) NULL,\n" +
                "  'data_emissao_titulo' DATE NULL,\n" +
                "  PRIMARY KEY ('num_insc_dv_titulo'),\n" +
                "    FOREIGN KEY ('id_usuario')\n" +
                "    REFERENCES 'usuario' ('id_usuario'));\n";
        return qr;
    }
}
