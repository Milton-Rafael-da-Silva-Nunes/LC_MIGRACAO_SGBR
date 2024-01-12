package sistemas.LC_SISTEMAS.model.entidades;

import util.DataHoraUtil;

/**
 *
 * @author Rafael Nunes
 */
public class Cliente {

    private Integer id;
    private String cpfCnpj;
    private String ie;
    private String ieIndicador;
    private String im;
    private String nome;
    private String rg;
    private String isUf;
    private String razaoSocial;
    private String endereco;
    private String numero;
    private String referencia;
    private String cep;
    private String bairro;
    private String telefone;
    private String telComercial;
    private String fax;
    private Double limiteCredito;
    private String obs;
    private String endereco2;
    private String numero2;
    private String referencia2;
    private String cep2;
    private String bairro2;
    private String ativo;
    private String tipo;
    private Integer idPais;
    private Integer idEstado;
    private Integer idCidade;
    private Integer idEstado2;
    private Integer idCidade2;
    private Integer idEmpresa;
    private Integer idClienteCanal;
    private String paiAdi;
    private String maeAdi;
    private String nascimentoAdi;
    private String sexoAdi;
    private String estCivilAdi;
    private String apelidoAdi;
    private String emailAdi;
    private Integer idCidadesAdi;
    private Integer idEstadosAdi;
    private String empresa;
    private String foneEmp;
    private String enderecoEmp;
    private String numeroEmp;
    private String cepEmp;
    private String bairroEmp;
    private String cargoEmp;
    private Double rendaEmp;
    private String admissaoEmp;
    private Integer idCidadesEmp;
    private Integer idEstadosEmp;
    private String conjuje;
    private String cpfConj;
    private String rgConj;
    private String nascimentoConj;
    private String empresaConj;
    private String foneConj;
    private String enderecoConj;
    private String numeroConj;
    private String cepConj;
    private String bairroConj;
    private String cargoConj;
    private Double rendaConj;
    private String admissaoConj;
    private Integer idCidadesConj;
    private Integer idEstadosConj;
    private String referencias;
    private String comercial1;
    private String comercial2;
    private String comercial3;
    private String bancaria1;
    private String bancaria2;
    private String emissao;
    private String orgao;
    private String dataCadastro;
    private String dataHoraAlteracao;
    private String foto;
    private Double poupanca;
    private String podeAprazo;
    private String podeCartaCobranca;
    private String numeroContrato;
    private String numeroCartao;
    private String tabelaPreco;
    private Integer idVendedor;
    private String filiacaoFoneMae;
    private String filiacaoFonePai;
    private String filiacaoEndereco;
    private String filiacaoReferencia;
    private String filiacaoNumero;
    private String filiacaoCep;
    private String filiacaoBairro;
    private String filiacaoIdCidade;
    private String filiacaoIdEstado;
    private String avalistaNome;
    private String avalistaCpf;
    private String avalistaRg;
    private String avalistaNascimento;
    private String avalistaFone;
    private String avalistaEndereco;
    private String avalistaNumero;
    private String avalistaCep;
    private String avalistaBairro;
    private String avalistaEmpresa;
    private String avalistaCargo;
    private Double avalistaRenda;
    private String avalistaAdmissao;
    private Integer avalistaIdCidade;
    private Integer avalistaIdEstado;
    // Atributos do sistema SGBR
    private String codigoCidade;
    private String cpf;
    private String cnpj;

    public Cliente() {
        idPais = 34;
        idEmpresa = 1;
        idClienteCanal = 0;
        idCidadesAdi = 0;
        idEstadosAdi = 0;
        rendaEmp = 0.0;
        idCidadesEmp = 0;
        idEstadosEmp = 0;
        idCidadesConj = 0;
        idEstadosConj = 0;
        rendaConj = 0.0;
        poupanca = 0.0;
        idVendedor = 0;
        telefone = "";
        telComercial = "";
        fax = "";
        estCivilAdi = "";
        apelidoAdi = "";
        empresa = "";
        foneEmp = "";
        enderecoEmp = "";
        numeroEmp = "";
        cepEmp = "";
        bairroEmp = "";
        cargoEmp = "";
        cpfConj = "";
        rgConj = "";
        empresaConj = "";
        foneConj = "";
        enderecoConj = "";
        numeroConj = "";
        cepConj = "";
        bairroConj = "";
        cargoConj = "";
        referencias = "";
        comercial1 = "";
        comercial2 = "";
        comercial3 = "";
        bancaria1 = "";
        bancaria2 = "";
        orgao = "";
        foto = "";
        podeAprazo = "S";
        podeCartaCobranca = "S";
        tabelaPreco = "NORMAL";
        filiacaoFoneMae = "(  )    -    ";
        filiacaoFonePai = "(  )    -    ";
        filiacaoEndereco = "";
        filiacaoReferencia = "";
        filiacaoNumero = "";
        filiacaoCep = "";
        filiacaoBairro = "";
        filiacaoIdCidade = "0";
        filiacaoIdEstado = "0";
        avalistaNome = "";
        avalistaCpf = "   .   .   -  ";
        avalistaRg = "";
        avalistaFone = "(  )    -    ";
        avalistaEndereco = "";
        avalistaNumero = "";
        avalistaCep = "";
        avalistaBairro = "";
        avalistaEmpresa = "";
        avalistaCargo = "";
        avalistaRenda = 0.0;
        avalistaIdCidade = 0;
        avalistaIdEstado = 0;
        numeroContrato = "";
        isUf = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return !cpf.isEmpty() ? cpf : cnpj;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie.length() > 20 ? ie.substring(0, 20) : ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIeIndicador() {
        return getCpfCnpj().length() >= 14 && !ie.isEmpty() ? "1" : "9";
    }

    public String getIm() {
        return im.length() > 20 ? im.substring(0, 20) : im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getNome() {
        return nome.length() > 80 ? nome.substring(0, 80) : nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg.length() > 17 ? rg.substring(0, 17) : rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getIsUf() {
        return isUf;
    }

    public void setIsUf(String isUf) {
        this.isUf = isUf;
    }

    public String getRazaoSocial() {
        String razao = escolherRazao();
        return limitarComprimento(razao, 80);
    }

    private String escolherRazao() {
        return (getCpfCnpj().length() == 14 && !razaoSocial.isEmpty()) ? razaoSocial : nome;
    }

    private String limitarComprimento(String razao, int maxLength) {
        return razao.length() > maxLength ? razao.substring(0, maxLength) : razao;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco.length() > 80 ? endereco.substring(0, 80) : endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero.length() > 10 ? numero.substring(0, 10) : numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia.length() > 80 ? referencia.substring(0, 80) : referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCep() {
        return cep.length() > 15 ? cep.substring(0, 15) : cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro.length() > 45 ? bairro.substring(0, 45) : bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getObs() {
        return obs.length() > 100 ? obs.substring(0, 100) : obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEndereco2() {
        return endereco2.length() > 80 ? endereco2.substring(0, 80) : endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getNumero2() {
        return numero2.length() > 10 ? numero2.substring(0, 10) : numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getReferencia2() {
        return referencia2.length() > 80 ? referencia2.substring(0, 80) : referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getCep2() {
        return cep2.length() > 15 ? cep2.substring(0, 15) : cep2;
    }

    public void setCep2(String cep2) {
        this.cep2 = cep2;
    }

    public String getBairro2() {
        return bairro2.length() > 45 ? bairro2.substring(0, 45) : bairro2;
    }

    public void setBairro2(String bairro2) {
        this.bairro2 = bairro2;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdEstado2() {
        return idEstado2;
    }

    public void setIdEstado2(Integer idEstado2) {
        this.idEstado2 = idEstado2;
    }

    public Integer getIdCidade2() {
        return idCidade2;
    }

    public void setIdCidade2(Integer idCidade2) {
        this.idCidade2 = idCidade2;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdClienteCanal() {
        return idClienteCanal;
    }

    public void setIdClienteCanal(Integer idClienteCanal) {
        this.idClienteCanal = idClienteCanal;
    }

    public String getPaiAdi() {
        return paiAdi.length() > 100 ? paiAdi.substring(0, 100) : paiAdi;
    }

    public void setPaiAdi(String paiAdi) {
        this.paiAdi = paiAdi;
    }

    public String getMaeAdi() {
        return maeAdi.length() > 100 ? maeAdi.substring(0, 100) : maeAdi;
    }

    public void setMaeAdi(String maeAdi) {
        this.maeAdi = maeAdi;
    }

    public String getNascimentoAdi() {
        return nascimentoAdi;
    }

    public void setNascimentoAdi(String nascimentoAdi) {
        this.nascimentoAdi = nascimentoAdi;
    }

    public String getSexoAdi() {
        return sexoAdi;
    }

    public void setSexoAdi(String sexoAdi) {
        this.sexoAdi = sexoAdi;
    }

    public String getEstCivilAdi() {
        return estCivilAdi;
    }

    public void setEstCivilAdi(String estCivilAdi) {
        this.estCivilAdi = estCivilAdi;
    }

    public String getApelidoAdi() {
        return apelidoAdi.length() > 20 ? apelidoAdi.substring(0, 20) : apelidoAdi;
    }

    public void setApelidoAdi(String apelidoAdi) {
        this.apelidoAdi = apelidoAdi;
    }

    public String getEmailAdi() {
        return emailAdi.length() > 100 ? emailAdi.substring(0, 100) : emailAdi;
    }

    public void setEmailAdi(String emailAdi) {
        this.emailAdi = emailAdi;
    }

    public Integer getIdCidadesAdi() {
        return idCidadesAdi;
    }

    public void setIdCidadesAdi(Integer idCidadesAdi) {
        this.idCidadesAdi = idCidadesAdi;
    }

    public Integer getIdEstadosAdi() {
        return idEstadosAdi;
    }

    public void setIdEstadosAdi(Integer idEstadosAdi) {
        this.idEstadosAdi = idEstadosAdi;
    }

    public String getEmpresa() {
        return empresa.length() > 100 ? empresa.substring(0, 100) : empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFoneEmp() {
        return foneEmp.length() > 15 ? foneEmp.substring(0, 15) : foneEmp;
    }

    public void setFoneEmp(String foneEmp) {
        this.foneEmp = foneEmp;
    }

    public String getEnderecoEmp() {
        return enderecoEmp.length() > 100 ? enderecoEmp.substring(0, 100) : enderecoEmp;
    }

    public void setEnderecoEmp(String enderecoEmp) {
        this.enderecoEmp = enderecoEmp;
    }

    public String getNumeroEmp() {
        return numeroEmp.length() > 15 ? numeroEmp.substring(0, 15) : numeroEmp;
    }

    public void setNumeroEmp(String numeroEmp) {
        this.numeroEmp = numeroEmp;
    }

    public String getCepEmp() {
        return cepEmp.length() > 15 ? cepEmp.substring(0, 15) : cepEmp;
    }

    public void setCepEmp(String cepEmp) {
        this.cepEmp = cepEmp;
    }

    public String getBairroEmp() {
        return bairroEmp.length() > 50 ? bairroEmp.substring(0, 50) : bairroEmp;
    }

    public void setBairroEmp(String bairroEmp) {
        this.bairroEmp = bairroEmp;
    }

    public String getCargoEmp() {
        return cargoEmp.length() > 50 ? cargoEmp.substring(0, 50) : cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    public Double getRendaEmp() {
        return rendaEmp;
    }

    public void setRendaEmp(Double rendaEmp) {
        this.rendaEmp = rendaEmp;
    }

    public String getAdmissaoEmp() {
        return admissaoEmp;
    }

    public void setAdmissaoEmp(String admissaoEmp) {
        this.admissaoEmp = admissaoEmp;
    }

    public Integer getIdCidadesEmp() {
        return idCidadesEmp;
    }

    public void setIdCidadesEmp(Integer idCidadesEmp) {
        this.idCidadesEmp = idCidadesEmp;
    }

    public Integer getIdEstadosEmp() {
        return idEstadosEmp;
    }

    public void setIdEstadosEmp(Integer idEstadosEmp) {
        this.idEstadosEmp = idEstadosEmp;
    }

    public String getConjuje() {
        return conjuje.length() > 100 ? conjuje.substring(0, 100) : conjuje;
    }

    public void setConjuje(String conjuje) {
        this.conjuje = conjuje;
    }

    public String getCpfConj() {
        return cpfConj.length() > 19 ? cpfConj.substring(0, 19) : cpfConj;
    }

    public void setCpfConj(String cpfConj) {
        this.cpfConj = cpfConj;
    }

    public String getRgConj() {
        return rgConj.length() > 14 ? rgConj.substring(0, 14) : rgConj;
    }

    public void setRgConj(String rgConj) {
        this.rgConj = rgConj;
    }

    public String getNascimentoConj() {
        return nascimentoConj;
    }

    public void setNascimentoConj(String nascimentoConj) {
        this.nascimentoConj = nascimentoConj;
    }

    public String getEmpresaConj() {
        return empresaConj.length() > 80 ? empresaConj.substring(0, 80) : empresaConj;
    }

    public void setEmpresaConj(String empresaConj) {
        this.empresaConj = empresaConj;
    }

    public String getFoneConj() {
        return foneConj.length() > 12 ? foneConj.substring(0, 12) : foneConj;
    }

    public void setFoneConj(String foneConj) {
        this.foneConj = foneConj;
    }

    public String getEnderecoConj() {
        return enderecoConj.length() > 100 ? enderecoConj.substring(0, 100) : enderecoConj;
    }

    public void setEnderecoConj(String enderecoConj) {
        this.enderecoConj = enderecoConj;
    }

    public String getNumeroConj() {
        return numeroConj.length() > 15 ? numeroConj.substring(0, 15) : numeroConj;
    }

    public void setNumeroConj(String numeroConj) {
        this.numeroConj = numeroConj;
    }

    public String getCepConj() {
        return cepConj.length() > 15 ? cepConj.substring(0, 15) : cepConj;
    }

    public void setCepConj(String cepConj) {
        this.cepConj = cepConj;
    }

    public String getBairroConj() {
        return bairroConj.length() > 50 ? bairroConj.substring(0, 50) : bairroConj;
    }

    public void setBairroConj(String bairroConj) {
        this.bairroConj = bairroConj;
    }

    public String getCargoConj() {
        return cargoConj.length() > 50 ? cargoConj.substring(0, 50) : cargoConj;
    }

    public void setCargoConj(String cargoConj) {
        this.cargoConj = cargoConj;
    }

    public Double getRendaConj() {
        return rendaConj;
    }

    public void setRendaConj(Double rendaConj) {
        this.rendaConj = rendaConj;
    }

    public String getAdmissaoConj() {
        return admissaoConj;
    }

    public void setAdmissaoConj(String admissaoConj) {
        this.admissaoConj = admissaoConj;
    }

    public Integer getIdCidadesConj() {
        return idCidadesConj;
    }

    public void setIdCidadesConj(Integer idCidadesConj) {
        this.idCidadesConj = idCidadesConj;
    }

    public Integer getIdEstadosConj() {
        return idEstadosConj;
    }

    public void setIdEstadosConj(Integer idEstadosConj) {
        this.idEstadosConj = idEstadosConj;
    }

    public String getReferencias() {
        return referencias.length() > 200 ? referencias.substring(0, 200) : referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getComercial1() {
        return comercial1.length() > 200 ? comercial1.substring(0, 200) : comercial1;
    }

    public void setComercial1(String comercial1) {
        this.comercial1 = comercial1;
    }

    public String getComercial2() {
        return comercial2.length() > 200 ? comercial2.substring(0, 200) : comercial2;
    }

    public void setComercial2(String comercial2) {
        this.comercial2 = comercial2;
    }

    public String getComercial3() {
        return comercial3.length() > 200 ? comercial3.substring(0, 200) : comercial3;
    }

    public void setComercial3(String comercial3) {
        this.comercial3 = comercial3;
    }

    public String getBancaria1() {
        return bancaria1.length() > 200 ? bancaria1.substring(0, 200) : bancaria1;
    }

    public void setBancaria1(String bancaria1) {
        this.bancaria1 = bancaria1;
    }

    public String getBancaria2() {
        return bancaria2.length() > 45 ? bancaria2.substring(0, 45) : bancaria2;
    }

    public void setBancaria2(String bancaria2) {
        this.bancaria2 = bancaria2;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getOrgao() {
        return orgao.length() > 20 ? orgao.substring(0, 20) : orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataHoraAlteracao() {
        return DataHoraUtil.getDataHoraAtual();
    }

    public void setDataHoraAlteracao(String dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Double poupanca) {
        this.poupanca = poupanca;
    }

    public String getPodeAprazo() {
        return podeAprazo;
    }

    public void setPodeAprazo(String podeAprazo) {
        this.podeAprazo = podeAprazo;
    }

    public String getPodeCartaCobranca() {
        return podeCartaCobranca;
    }

    public void setPodeCartaCobranca(String podeCartaCobranca) {
        this.podeCartaCobranca = podeCartaCobranca;
    }

    public String getNumeroContrato() {
        return numeroContrato.length() > 20 ? numeroContrato.substring(0, 20) : numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(String tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getFiliacaoFoneMae() {
        return filiacaoFoneMae.length() > 14 ? filiacaoFoneMae.substring(0, 14) : filiacaoFoneMae;
    }

    public void setFiliacaoFoneMae(String filiacaoFoneMae) {
        this.filiacaoFoneMae = filiacaoFoneMae;
    }

    public String getFiliacaoFonePai() {
        return filiacaoFonePai.length() > 14 ? filiacaoFonePai.substring(0, 14) : filiacaoFonePai;
    }

    public void setFiliacaoFonePai(String filiacaoFonePai) {
        this.filiacaoFonePai = filiacaoFonePai;
    }

    public String getFiliacaoEndereco() {
        return filiacaoEndereco.length() > 150 ? filiacaoEndereco.substring(0, 150) : filiacaoEndereco;
    }

    public void setFiliacaoEndereco(String filiacaoEndereco) {
        this.filiacaoEndereco = filiacaoEndereco;
    }

    public String getFiliacaoReferencia() {
        return filiacaoReferencia.length() > 150 ? filiacaoReferencia.substring(0, 150) : filiacaoReferencia;
    }

    public void setFiliacaoReferencia(String filiacaoReferencia) {
        this.filiacaoReferencia = filiacaoReferencia;
    }

    public String getFiliacaoNumero() {
        return filiacaoNumero.length() > 20 ? filiacaoNumero.substring(0, 20) : filiacaoNumero;
    }

    public void setFiliacaoNumero(String filiacaoNumero) {
        this.filiacaoNumero = filiacaoNumero;
    }

    public String getFiliacaoCep() {
        return filiacaoCep.length() > 20 ? filiacaoCep.substring(0, 20) : filiacaoCep;
    }

    public void setFiliacaoCep(String filiacaoCep) {
        this.filiacaoCep = filiacaoCep;
    }

    public String getFiliacaoBairro() {
        return filiacaoBairro.length() > 50 ? filiacaoBairro.substring(0, 50) : filiacaoBairro;
    }

    public void setFiliacaoBairro(String filiacaoBairro) {
        this.filiacaoBairro = filiacaoBairro;
    }

    public String getFiliacaoIdCidade() {
        return filiacaoIdCidade;
    }

    public void setFiliacaoIdCidade(String filiacaoIdCidade) {
        this.filiacaoIdCidade = filiacaoIdCidade;
    }

    public String getFiliacaoIdEstado() {
        return filiacaoIdEstado;
    }

    public void setFiliacaoIdEstado(String filiacaoIdEstado) {
        this.filiacaoIdEstado = filiacaoIdEstado;
    }

    public String getAvalistaNome() {
        return avalistaNome.length() > 150 ? avalistaNome.substring(0, 150) : avalistaNome;
    }

    public void setAvalistaNome(String avalistaNome) {
        this.avalistaNome = avalistaNome;
    }

    public String getAvalistaCpf() {
        return avalistaCpf.length() > 15 ? avalistaCpf.substring(0, 15) : avalistaCpf;
    }

    public void setAvalistaCpf(String avalistaCpf) {
        this.avalistaCpf = avalistaCpf;
    }

    public String getAvalistaRg() {
        return avalistaRg.length() > 20 ? avalistaRg.substring(0, 20) : avalistaRg;
    }

    public void setAvalistaRg(String avalistaRg) {
        this.avalistaRg = avalistaRg;
    }

    public String getAvalistaNascimento() {
        return avalistaNascimento;
    }

    public void setAvalistaNascimento(String avalistaNascimento) {
        this.avalistaNascimento = avalistaNascimento;
    }

    public String getAvalistaFone() {
        return avalistaFone.length() > 14 ? avalistaFone.substring(0, 14) : avalistaFone;
    }

    public void setAvalistaFone(String avalistaFone) {
        this.avalistaFone = avalistaFone;
    }

    public String getAvalistaEndereco() {
        return avalistaEndereco.length() > 150 ? avalistaEndereco.substring(0, 150) : avalistaEndereco;
    }

    public void setAvalistaEndereco(String avalistaEndereco) {
        this.avalistaEndereco = avalistaEndereco;
    }

    public String getAvalistaNumero() {
        return avalistaNumero.length() > 15 ? avalistaNumero.substring(0, 15) : avalistaNumero;
    }

    public void setAvalistaNumero(String avalistaNumero) {
        this.avalistaNumero = avalistaNumero;
    }

    public String getAvalistaCep() {
        return avalistaCep.length() > 20 ? avalistaCep.substring(0, 20) : avalistaCep;
    }

    public void setAvalistaCep(String avalistaCep) {
        this.avalistaCep = avalistaCep;
    }

    public String getAvalistaBairro() {
        return avalistaBairro.length() > 50 ? avalistaBairro.substring(0, 50) : avalistaBairro;
    }

    public void setAvalistaBairro(String avalistaBairro) {
        this.avalistaBairro = avalistaBairro;
    }

    public String getAvalistaEmpresa() {
        return avalistaEmpresa.length() > 100 ? avalistaEmpresa.substring(0, 100) : avalistaEmpresa;
    }

    public void setAvalistaEmpresa(String avalistaEmpresa) {
        this.avalistaEmpresa = avalistaEmpresa;
    }

    public String getAvalistaCargo() {
        return avalistaCargo.length() > 100 ? avalistaCargo.substring(0, 100) : avalistaCargo;
    }

    public void setAvalistaCargo(String avalistaCargo) {
        this.avalistaCargo = avalistaCargo;
    }

    public Double getAvalistaRenda() {
        return avalistaRenda;
    }

    public void setAvalistaRenda(Double avalistaRenda) {
        this.avalistaRenda = avalistaRenda;
    }

    public String getAvalistaAdmissao() {
        return avalistaAdmissao;
    }

    public void setAvalistaAdmissao(String avalistaAdmissao) {
        this.avalistaAdmissao = avalistaAdmissao;
    }

    public Integer getAvalistaIdCidade() {
        return avalistaIdCidade;
    }

    public void setAvalistaIdCidade(Integer avalistaIdCidade) {
        this.avalistaIdCidade = avalistaIdCidade;
    }

    public Integer getAvalistaIdEstado() {
        return avalistaIdEstado;
    }

    public void setAvalistaIdEstado(Integer avalistaIdEstado) {
        this.avalistaIdEstado = avalistaIdEstado;
    }

    // Metodos acessores do sistema SGBR
    public String getCodigoCidade() {
        if (codigoCidade.equals("")) {
            return "1501402"; // CIDADE Belem-PA
        }
        return codigoCidade;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Override
    public String toString() {
        return numeroCartao + " - " + getCpfCnpj() + " > " + nome;
    }
}
