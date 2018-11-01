package com.example.lpa.carteiradigitalfaci_pt.datamodel;

public class DocumentoDataModel {

    public static String criarTabela1() {
        String qr = "";
        qr = "CREATE TABLE IF NOT EXISTS 'TIPODOCOBRIGATORIO' (\n" +
                "  'IDOBRIGATORIO' INT(11) NOT NULL,\n" +
                "  'NUMCSMRES' VARCHAR(4) NULL,\n" +
                "  'SERIERES' VARCHAR(2) NULL,\n" +
                "  'RARES' VARCHAR(16) NULL,\n" +
                "  'NOMECOMPRES' VARCHAR(50) NULL,\n" +
                "  'DATADISRES' DATE NULL,\n" +
                "  'MOTIVODISRES' VARCHAR(70) NULL,\n" +
                "  'NOMECOMTIT' VARCHAR(50) NULL,\n" +
                "  'DATANASCTIT' DATE NULL,\n" +
                "  'NUMINSCTIT' VARCHAR(15) NULL,\n" +
                "  'DVTIT' VARCHAR(15) NULL,\n" +
                "  'ZONATIT' VARCHAR(5) NULL,\n" +
                "  'SECAOTIT' VARCHAR(6) NULL,\n" +
                "  'MUNICPIOTIT' VARCHAR(30) NULL,\n" +
                "  PRIMARY KEY ('IDOBRIGATORIO'));\n";
        return qr;
    }
    public static String criarTabela2(){
        String qr = "";
        qr =
                    "CREATE TABLE IF NOT EXISTS 'TIPODOCPRINCIPAL' (\n" +
                "  'IDPRINCIPAL' INT(11) NOT NULL,\n" +
                "  'NOMECERT' VARCHAR(50) NULL,\n" +
                "  'DATANASCCERT' DATE NULL,\n" +
                "  'HORANASCCERT' VARCHAR(10) NULL,\n" +
                "  'MUNICNASCCERT' VARCHAR(30) NULL,\n" +
                "  'UFNASCCERT' VARCHAR(2) NULL,\n" +
                "  'NOMECOMPMAE' VARCHAR(50) NULL,\n" +
                "  'NOMECOMPPAI' VARCHAR(50) NULL,\n" +
                "  'NOMECOMPAVOY' VARCHAR(50) NULL,\n" +
                "  'NOMECOMPAVOX' VARCHAR(50) NULL,\n" +
                "  'NUMNASCVIVO' INT(11) NULL,\n" +
                "  'NUMRG' VARCHAR(7) NULL,\n" +
                "  'NOMECOMPRG' VARCHAR(50) NULL,\n" +
                "  'DATANASCRG' DATE NULL,\n" +
                "  'NOMECOMPCPF' VARCHAR(50) NULL,\n" +
                "  'NUMCPF' VARCHAR(16) NULL,\n" +
                "  'DATANASCCPF' DATE NULL,\n" +
                "  'TIPODOCOBRIGATORIO_IDOBRIGATORIO' INT(11) NOT NULL,\n" +
                "  PRIMARY KEY ('IDPRINCIPAL'),\n" +
                "    FOREIGN KEY ('TIPODOCOBRIGATORIO_IDOBRIGATORIO')\n" +
                "    REFERENCES 'TIPODOCOBRIGATORIO' ('IDOBRIGATORIO'));\n";
        return qr;
    }
    public static String criarTabela3(){
        String qr = "";
        qr =
            "CREATE TABLE IF NOT EXISTS 'CADASTRO' (\n" +
                "  'IDUSER' INT(11) NOT NULL,\n" +
                "  'EMAIL' VARCHAR(50) NOT NULL,\n" +
                "  'SENHA' VARCHAR(20) NULL,\n" +
                "  'STATUS' VARCHAR(20) NULL,\n" +
                "  'TIPODOCPRINCIPAL_IDPRINCIPAL' INT(11) NOT NULL,\n" +
                "  PRIMARY KEY ('IDUSER'),\n" +
                "  FOREIGN KEY ('TIPODOCPRINCIPAL_IDPRINCIPAL')\n" +
                "    REFERENCES 'TIPODOCPRINCIPAL' ('IDPRINCIPAL'));\n";
        return qr;
    }
    public static String criarTabela4(){
        String qr = "";
        qr =

            "CREATE TABLE IF NOT EXISTS 'PESSOAFISICA' (\n" +
                "  'IDPES' INT(11) NOT NULL,\n" +
                "  'NOMECOMP' VARCHAR(60) NOT NULL,\n" +
                "  'SEXO' VARCHAR(9) NULL,\n" +
                "  'CADASTRO_IDUSER' INT(11) NOT NULL,\n" +
                "  PRIMARY KEY ('IDPES'),\n" +
                "    FOREIGN KEY ('CADASTRO_IDUSER')\n" +
                "    REFERENCES 'CADASTRO' ('IDUSER'));\n";
        return qr;
    }
    public static String criarTabela5(){
        String qr = "";
        qr =

            "CREATE TABLE IF NOT EXISTS 'LOCAISEMISSAO' (\n" +
                "  'IDLOCAISEMISSAO' INT(11) NOT NULL,\n" +
                "  'UFREGISCERT' VARCHAR(20) NULL,\n" +
                "  'DOCLOCALRG' VARCHAR(50) NULL,\n" +
                "  'MUNICIPIOEMIRES' VARCHAR(20) NULL,\n" +
                "  'UFEMIRES' VARCHAR(20) NULL,\n" +
                "  'UFTIT' VARCHAR(20) NULL,\n" +
                "  'CIDADEEMICNH' VARCHAR(20) NULL,\n" +
                "  'UFCNH' VARCHAR(20) NULL,\n" +
                "  'UFCTPS' VARCHAR(20) NULL,\n" +
                "  'UFRG' VARCHAR(20) NULL,\n" +
                "  PRIMARY KEY ('IDLOCAISEMISSAO'));\n";
        return qr;
    }
    public static String criarTabela6(){
        String qr = "";
        qr =

            "CREATE TABLE IF NOT EXISTS 'DADOREGISTRO' (\n" +
                "  'IDDADOREGISTRO' INT(11) NOT NULL,\n" +
                "  'DATAREGISNASC' DATE NULL,\n" +
                "  'OBSCERT' VARCHAR(60) NULL,\n" +
                "  'OBSCNH' VARCHAR(60) NULL,\n" +
                "  'DATAEXPRG' DATE NULL,\n" +
                "  'DATAEMIRES' DATE NULL,\n" +
                "  'DATAEMITIT' DATE NULL,\n" +
                "  'DATAEMICNH' DATE NULL,\n" +
                "  'CADASTRO_IDUSER' INT(11) NOT NULL,\n" +
                "  'LOCAISEMISSAO_IDLOCAISEMISSAO' INT(11) NOT NULL,\n" +
                "  PRIMARY KEY ('IDDADOREGISTRO'),\n" +
                "    FOREIGN KEY ('CADASTRO_IDUSER')\n" +
                "    REFERENCES 'CADASTRO' ('IDUSER'),\n" +
                "    FOREIGN KEY ('LOCAISEMISSAO_IDLOCAISEMISSAO')\n" +
                "    REFERENCES 'LOCAISEMISSAO' ('IDLOCAISEMISSAO'));\n";
        return qr;
    }
    public static String criarTabela7(){
        String qr = "";
        qr =

            "CREATE TABLE IF NOT EXISTS 'TIPODOCNAOOBRIGATORIO' (\n" +
                "  'IDDOCNAOOBRIGATORIO' INT(11) NOT NULL,\n" +
                "  'NOMECOMPCNH' VARCHAR(50) NULL,\n" +
                "  'PERMISSAOCNH' VARCHAR(12) NULL,\n" +
                "  'ACCCNH' VARCHAR(10) NULL,\n" +
                "  'CATHABCNH' VARCHAR(2) NULL,\n" +
                "  'NUMCNH' VARCHAR(16) NULL,\n" +
                "  'VALIDADECNH' DATE NULL,\n" +
                "  'HABANTCNH' DATE NULL,\n" +
                "  'PISCTPS' VARCHAR(15) NULL,\n" +
                "  'NUMCTPS' VARCHAR(8) NULL,\n" +
                "  'SERIECTPS' VARCHAR(5) NULL,\n" +
                "  'NOMECTPS' VARCHAR(50) NULL,\n" +
                "  PRIMARY KEY ('IDDOCNAOOBRIGATORIO'));";
        return qr;
    }
}
