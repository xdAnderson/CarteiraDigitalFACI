package com.example.lpa.carteiradigitalfaci_pt.model;

public class Documento {

    //Tipo Documento Obrigatório
    private int idobrigatorio;
    private String RESERVISTO_numcsmres;
    private String RESERVISTO_serieres;
    private String RESERVISTO_rares;
    private String RESERVISTO_nomecompres;
    private String RESERVISTO_datadisres;
    private String RESERVISTO_motivodisres;
    private String TITULO_nomecomtit;
    private String TITULO_datanasctit;
    private String TITULO_numinsctit;
    private String TITULO_dvtit;
    private String TITULO_zonatit;
    private String TITULO_secaotit;
    private String TITULO_municipiotit;

    //Tipo Documento Principal
    private int idprincipal;
    private String CERTIDAO_nomecert;
    private String CERTIDAO_datanasccert;
    private String CERTIDAO_horanasccert;
    private String CERTIDAO_municnasccert;
    private String CERTIDAO_ufnasccert;
    private String CERTIDAO_nomecompmae;
    private String CERTIDAO_nomecomppai;
    private String CERTIDAO_nomecompavomy;
    private String CERTIDAO_nomecompavomx;
    private String CERTIDAO_nomecompavopy;
    private String CERTIDAO_nomecompavopx;
    private String CERTIDAO_numnascvivo;
    private String RG_numrg;
    private String RG_nomecomprg;
    private String RG_datanascrg;
    private String CPF_nomecompcpf;
    private String CPF_numcpf;
    private String CPF_datanasccpf;

    //Locais de Emissão
    private int idlocaisemissao;
    private String CERTIDAO_ufregscert;
    private String RG_doclocalrg;
    private String RESERVISTO_ufemires;
    private String TITULO_uftit;
    private String CNH_cidadeemicnh;
    private String CTPS_ufctps;
    private String RG_ufrg;

    //Dado Registro
    private int iddadoregistro;
    private String CERTIDAO_dataregnasc;
    private String CERTIDAO_obscert;
    private String CNH_obscnh;
    private String RG_dataexprg;
    private String RESERVISTO_dataemires;
    private String TITULO_dataemitit;
    private String CNH_dataemicnh;

    //Tipo de documento não obrigatório
    private int iddocnaoobrigatorio;
    private String CNH_nomecompcnh;
    private String CNH_permissaocnh;
    private String CNH_acccnh;
    private String CNH_cathabcnh;
    private String CNH_numcnh;
    private String CNH_validadecnh;
    private String CNH_habantcnh;
    private String CTPS_pisctps;
    private String CTPS_numctps;
    private String CTPS_seriectps;
    private String CTPS_nomectps;


    public int getIdobrigatorio() {
        return idobrigatorio;
    }

    public void setIdobrigatorio(int idobrigatorio) {
        this.idobrigatorio = idobrigatorio;
    }

    public String getRESERVISTO_numcsmres() {
        return RESERVISTO_numcsmres;
    }

    public void setRESERVISTO_numcsmres(String RESERVISTO_numcsmres) {
        this.RESERVISTO_numcsmres = RESERVISTO_numcsmres;
    }

    public String getRESERVISTO_serieres() {
        return RESERVISTO_serieres;
    }

    public void setRESERVISTO_serieres(String RESERVISTO_serieres) {
        this.RESERVISTO_serieres = RESERVISTO_serieres;
    }

    public String getRESERVISTO_rares() {
        return RESERVISTO_rares;
    }

    public void setRESERVISTO_rares(String RESERVISTO_rares) {
        this.RESERVISTO_rares = RESERVISTO_rares;
    }

    public String getRESERVISTO_nomecompres() {
        return RESERVISTO_nomecompres;
    }

    public void setRESERVISTO_nomecompres(String RESERVISTO_nomecompres) {
        this.RESERVISTO_nomecompres = RESERVISTO_nomecompres;
    }

    public String getRESERVISTO_datadisres() {
        return RESERVISTO_datadisres;
    }

    public void setRESERVISTO_datadisres(String RESERVISTO_datadisres) {
        this.RESERVISTO_datadisres = RESERVISTO_datadisres;
    }

    public String getRESERVISTO_motivodisres() {
        return RESERVISTO_motivodisres;
    }

    public void setRESERVISTO_motivodisres(String RESERVISTO_motivodisres) {
        this.RESERVISTO_motivodisres = RESERVISTO_motivodisres;
    }

    public String getTITULO_nomecomtit() {
        return TITULO_nomecomtit;
    }

    public void setTITULO_nomecomtit(String TITULO_nomecomtit) {
        this.TITULO_nomecomtit = TITULO_nomecomtit;
    }

    public String getTITULO_datanasctit() {
        return TITULO_datanasctit;
    }

    public void setTITULO_datanasctit(String TITULO_datanasctit) {
        this.TITULO_datanasctit = TITULO_datanasctit;
    }

    public String getTITULO_numinsctit() {
        return TITULO_numinsctit;
    }

    public void setTITULO_numinsctit(String TITULO_numinsctit) {
        this.TITULO_numinsctit = TITULO_numinsctit;
    }

    public String getTITULO_dvtit() {
        return TITULO_dvtit;
    }

    public void setTITULO_dvtit(String TITULO_dvtit) {
        this.TITULO_dvtit = TITULO_dvtit;
    }

    public String getTITULO_zonatit() {
        return TITULO_zonatit;
    }

    public void setTITULO_zonatit(String TITULO_zonatit) {
        this.TITULO_zonatit = TITULO_zonatit;
    }

    public String getTITULO_secaotit() {
        return TITULO_secaotit;
    }

    public void setTITULO_secaotit(String TITULO_secaotit) {
        this.TITULO_secaotit = TITULO_secaotit;
    }

    public String getTITULO_municipiotit() {
        return TITULO_municipiotit;
    }

    public void setTITULO_municipiotit(String TITULO_municipiotit) {
        this.TITULO_municipiotit = TITULO_municipiotit;
    }

    public int getIdprincipal() {
        return idprincipal;
    }

    public void setIdprincipal(int idprincipal) {
        this.idprincipal = idprincipal;
    }

    public String getCERTIDAO_nomecert() {
        return CERTIDAO_nomecert;
    }

    public void setCERTIDAO_nomecert(String CERTIDAO_nomecert) {
        this.CERTIDAO_nomecert = CERTIDAO_nomecert;
    }

    public String getCERTIDAO_datanasccert() {
        return CERTIDAO_datanasccert;
    }

    public void setCERTIDAO_datanasccert(String CERTIDAO_datanasccert) {
        this.CERTIDAO_datanasccert = CERTIDAO_datanasccert;
    }

    public String getCERTIDAO_horanasccert() {
        return CERTIDAO_horanasccert;
    }

    public void setCERTIDAO_horanasccert(String CERTIDAO_horanasccert) {
        this.CERTIDAO_horanasccert = CERTIDAO_horanasccert;
    }

    public String getCERTIDAO_municnasccert() {
        return CERTIDAO_municnasccert;
    }

    public void setCERTIDAO_municnasccert(String CERTIDAO_municnasccert) {
        this.CERTIDAO_municnasccert = CERTIDAO_municnasccert;
    }

    public String getCERTIDAO_ufnasccert() {
        return CERTIDAO_ufnasccert;
    }

    public void setCERTIDAO_ufnasccert(String CERTIDAO_ufnasccert) {
        this.CERTIDAO_ufnasccert = CERTIDAO_ufnasccert;
    }

    public String getCERTIDAO_nomecompmae() {
        return CERTIDAO_nomecompmae;
    }

    public void setCERTIDAO_nomecompmae(String CERTIDAO_nomecompmae) {
        this.CERTIDAO_nomecompmae = CERTIDAO_nomecompmae;
    }

    public String getCERTIDAO_nomecomppai() {
        return CERTIDAO_nomecomppai;
    }

    public void setCERTIDAO_nomecomppai(String CERTIDAO_nomecomppai) {
        this.CERTIDAO_nomecomppai = CERTIDAO_nomecomppai;
    }

    public String getCERTIDAO_nomecompavomy() {
        return CERTIDAO_nomecompavomy;
    }

    public void setCERTIDAO_nomecompavomy(String CERTIDAO_nomecompavomy) {
        this.CERTIDAO_nomecompavomy = CERTIDAO_nomecompavomy;
    }

    public String getCERTIDAO_nomecompavomx() {
        return CERTIDAO_nomecompavomx;
    }

    public void setCERTIDAO_nomecompavomx(String CERTIDAO_nomecompavomx) {
        this.CERTIDAO_nomecompavomx = CERTIDAO_nomecompavomx;
    }

    public String getCERTIDAO_nomecompavopy() {
        return CERTIDAO_nomecompavopy;
    }

    public void setCERTIDAO_nomecompavopy(String CERTIDAO_nomecompavopy) {
        this.CERTIDAO_nomecompavopy = CERTIDAO_nomecompavopy;
    }

    public String getCERTIDAO_nomecompavopx() {
        return CERTIDAO_nomecompavopx;
    }

    public void setCERTIDAO_nomecompavopx(String CERTIDAO_nomecompavopx) {
        this.CERTIDAO_nomecompavopx = CERTIDAO_nomecompavopx;
    }

    public String getCERTIDAO_numnascvivo() {
        return CERTIDAO_numnascvivo;
    }

    public void setCERTIDAO_numnascvivo(String CERTIDAO_numnascvivo) {
        this.CERTIDAO_numnascvivo = CERTIDAO_numnascvivo;
    }

    public String getRG_numrg() {
        return RG_numrg;
    }

    public void setRG_numrg(String RG_numrg) {
        this.RG_numrg = RG_numrg;
    }

    public String getRG_nomecomprg() {
        return RG_nomecomprg;
    }

    public void setRG_nomecomprg(String RG_nomecomprg) {
        this.RG_nomecomprg = RG_nomecomprg;
    }

    public String getRG_datanascrg() {
        return RG_datanascrg;
    }

    public void setRG_datanascrg(String RG_datanascrg) {
        this.RG_datanascrg = RG_datanascrg;
    }

    public String getCPF_nomecompcpf() {
        return CPF_nomecompcpf;
    }

    public void setCPF_nomecompcpf(String CPF_nomecompcpf) {
        this.CPF_nomecompcpf = CPF_nomecompcpf;
    }

    public String getCPF_numcpf() {
        return CPF_numcpf;
    }

    public void setCPF_numcpf(String CPF_numcpf) {
        this.CPF_numcpf = CPF_numcpf;
    }

    public String getCPF_datanasccpf() {
        return CPF_datanasccpf;
    }

    public void setCPF_datanasccpf(String CPF_datanasccpf) {
        this.CPF_datanasccpf = CPF_datanasccpf;
    }

    public int getIdlocaisemissao() {
        return idlocaisemissao;
    }

    public void setIdlocaisemissao(int idlocaisemissao) {
        this.idlocaisemissao = idlocaisemissao;
    }

    public String getCERTIDAO_ufregscert() {
        return CERTIDAO_ufregscert;
    }

    public void setCERTIDAO_ufregscert(String CERTIDAO_ufregscert) {
        this.CERTIDAO_ufregscert = CERTIDAO_ufregscert;
    }

    public String getRG_doclocalrg() {
        return RG_doclocalrg;
    }

    public void setRG_doclocalrg(String RG_doclocalrg) {
        this.RG_doclocalrg = RG_doclocalrg;
    }

    public String getRESERVISTO_ufemires() {
        return RESERVISTO_ufemires;
    }

    public void setRESERVISTO_ufemires(String RESERVISTO_ufemires) {
        this.RESERVISTO_ufemires = RESERVISTO_ufemires;
    }

    public String getTITULO_uftit() {
        return TITULO_uftit;
    }

    public void setTITULO_uftit(String TITULO_uftit) {
        this.TITULO_uftit = TITULO_uftit;
    }

    public String getCNH_cidadeemicnh() {
        return CNH_cidadeemicnh;
    }

    public void setCNH_cidadeemicnh(String CNH_cidadeemicnh) {
        this.CNH_cidadeemicnh = CNH_cidadeemicnh;
    }

    public String getCTPS_ufctps() {
        return CTPS_ufctps;
    }

    public void setCTPS_ufctps(String CTPS_ufctps) {
        this.CTPS_ufctps = CTPS_ufctps;
    }

    public String getRG_ufrg() {
        return RG_ufrg;
    }

    public void setRG_ufrg(String RG_ufrg) {
        this.RG_ufrg = RG_ufrg;
    }

    public int getIddadoregistro() {
        return iddadoregistro;
    }

    public void setIddadoregistro(int iddadoregistro) {
        this.iddadoregistro = iddadoregistro;
    }

    public String getCERTIDAO_dataregnasc() {
        return CERTIDAO_dataregnasc;
    }

    public void setCERTIDAO_dataregnasc(String CERTIDAO_dataregnasc) {
        this.CERTIDAO_dataregnasc = CERTIDAO_dataregnasc;
    }

    public String getCERTIDAO_obscert() {
        return CERTIDAO_obscert;
    }

    public void setCERTIDAO_obscert(String CERTIDAO_obscert) {
        this.CERTIDAO_obscert = CERTIDAO_obscert;
    }

    public String getCNH_obscnh() {
        return CNH_obscnh;
    }

    public void setCNH_obscnh(String CNH_obscnh) {
        this.CNH_obscnh = CNH_obscnh;
    }

    public String getRG_dataexprg() {
        return RG_dataexprg;
    }

    public void setRG_dataexprg(String RG_dataexprg) {
        this.RG_dataexprg = RG_dataexprg;
    }

    public String getRESERVISTO_dataemires() {
        return RESERVISTO_dataemires;
    }

    public void setRESERVISTO_dataemires(String RESERVISTO_dataemires) {
        this.RESERVISTO_dataemires = RESERVISTO_dataemires;
    }

    public String getTITULO_dataemitit() {
        return TITULO_dataemitit;
    }

    public void setTITULO_dataemitit(String TITULO_dataemitit) {
        this.TITULO_dataemitit = TITULO_dataemitit;
    }

    public String getCNH_dataemicnh() {
        return CNH_dataemicnh;
    }

    public void setCNH_dataemicnh(String CNH_dataemicnh) {
        this.CNH_dataemicnh = CNH_dataemicnh;
    }

    public int getIddocnaoobrigatorio() {
        return iddocnaoobrigatorio;
    }

    public void setIddocnaoobrigatorio(int iddocnaoobrigatorio) {
        this.iddocnaoobrigatorio = iddocnaoobrigatorio;
    }

    public String getCNH_nomecompcnh() {
        return CNH_nomecompcnh;
    }

    public void setCNH_nomecompcnh(String CNH_nomecompcnh) {
        this.CNH_nomecompcnh = CNH_nomecompcnh;
    }

    public String getCNH_permissaocnh() {
        return CNH_permissaocnh;
    }

    public void setCNH_permissaocnh(String CNH_permissaocnh) {
        this.CNH_permissaocnh = CNH_permissaocnh;
    }

    public String getCNH_acccnh() {
        return CNH_acccnh;
    }

    public void setCNH_acccnh(String CNH_acccnh) {
        this.CNH_acccnh = CNH_acccnh;
    }

    public String getCNH_cathabcnh() {
        return CNH_cathabcnh;
    }

    public void setCNH_cathabcnh(String CNH_cathabcnh) {
        this.CNH_cathabcnh = CNH_cathabcnh;
    }

    public String getCNH_numcnh() {
        return CNH_numcnh;
    }

    public void setCNH_numcnh(String CNH_numcnh) {
        this.CNH_numcnh = CNH_numcnh;
    }

    public String getCNH_validadecnh() {
        return CNH_validadecnh;
    }

    public void setCNH_validadecnh(String CNH_validadecnh) {
        this.CNH_validadecnh = CNH_validadecnh;
    }

    public String getCNH_habantcnh() {
        return CNH_habantcnh;
    }

    public void setCNH_habantcnh(String CNH_habantcnh) {
        this.CNH_habantcnh = CNH_habantcnh;
    }

    public String getCTPS_pisctps() {
        return CTPS_pisctps;
    }

    public void setCTPS_pisctps(String CTPS_pisctps) {
        this.CTPS_pisctps = CTPS_pisctps;
    }

    public String getCTPS_numctps() {
        return CTPS_numctps;
    }

    public void setCTPS_numctps(String CTPS_numctps) {
        this.CTPS_numctps = CTPS_numctps;
    }

    public String getCTPS_seriectps() {
        return CTPS_seriectps;
    }

    public void setCTPS_seriectps(String CTPS_seriectps) {
        this.CTPS_seriectps = CTPS_seriectps;
    }

    public String getCTPS_nomectps() {
        return CTPS_nomectps;
    }

    public void setCTPS_nomectps(String CTPS_nomectps) {
        this.CTPS_nomectps = CTPS_nomectps;
    }
}
