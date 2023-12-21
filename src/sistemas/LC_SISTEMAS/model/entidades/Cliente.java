package sistemas.LC_SISTEMAS.model.entidades;

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
    
    /*Atributos Auxiliares*/
    private String codigoCidade;
    

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
    }

    public Cliente(Integer id, String cpfCnpj, String ie, String ieIndicador, String im, String nome, String rg, String razaoSocial, String endereco, String numero, String referencia, String cep, String bairro, String telefone, String telComercial, String fax, Double limiteCredito, String obs, String endereco2, String numero2, String referencia2, String cep2, String bairro2, String ativo, String tipo, Integer idPais, Integer idEstado, Integer idCidade, Integer idEstado2, Integer idCidade2, Integer idEmpresa, Integer idClienteCanal, String paiAdi, String maeAdi, String nascimentoAdi, String sexoAdi, String estCivilAdi, String apelidoAdi, String emailAdi, Integer idCidadesAdi, Integer idEstadosAdi, String empresa, String foneEmp, String enderecoEmp, String numeroEmp, String cepEmp, String bairroEmp, String cargoEmp, Double rendaEmp, String admissaoEmp, Integer idCidadesEmp, Integer idEstadosEmp, String conjuje, String cpfConj, String rgConj, String nascimentoConj, String empresaConj, String foneConj, String enderecoConj, String numeroConj, String cepConj, String bairroConj, String cargoConj, Double rendaConj, String admissaoConj, Integer idCidadesConj, Integer idEstadosConj, String referencias, String comercial1, String comercial2, String comercial3, String bancaria1, String bancaria2, String emissao, String orgao, String dataCadastro, String dataHoraAlteracao, String foto, Double poupanca, String podeAprazo, String podeCartaCobranca, String numeroContrato, String numeroCartao, String tabelaPreco, Integer idVendedor, String filiacaoFoneMae, String filiacaoFonePai, String filiacaoEndereco, String filiacaoReferencia, String filiacaoNumero, String filiacaoCep, String filiacaoBairro, String filiacaoIdCidade, String filiacaoIdEstado, String avalistaNome, String avalistaCpf, String avalistaRg, String avalistaNascimento, String avalistaFone, String avalistaEndereco, String avalistaNumero, String avalistaCep, String avalistaBairro, String avalistaEmpresa, String avalistaCargo, Double avalistaRenda, String avalistaAdmissao, Integer avalistaIdCidade, Integer avalistaIdEstado) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.ie = ie;
        this.ieIndicador = ieIndicador;
        this.im = im;
        this.nome = nome;
        this.rg = rg;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.numero = numero;
        this.referencia = referencia;
        this.cep = cep;
        this.bairro = bairro;
        this.telefone = telefone;
        this.telComercial = telComercial;
        this.fax = fax;
        this.limiteCredito = limiteCredito;
        this.obs = obs;
        this.endereco2 = endereco2;
        this.numero2 = numero2;
        this.referencia2 = referencia2;
        this.cep2 = cep2;
        this.bairro2 = bairro2;
        this.ativo = ativo;
        this.tipo = tipo;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idCidade = idCidade;
        this.idEstado2 = idEstado2;
        this.idCidade2 = idCidade2;
        this.idEmpresa = idEmpresa;
        this.idClienteCanal = idClienteCanal;
        this.paiAdi = paiAdi;
        this.maeAdi = maeAdi;
        this.nascimentoAdi = nascimentoAdi;
        this.sexoAdi = sexoAdi;
        this.estCivilAdi = estCivilAdi;
        this.apelidoAdi = apelidoAdi;
        this.emailAdi = emailAdi;
        this.idCidadesAdi = idCidadesAdi;
        this.idEstadosAdi = idEstadosAdi;
        this.empresa = empresa;
        this.foneEmp = foneEmp;
        this.enderecoEmp = enderecoEmp;
        this.numeroEmp = numeroEmp;
        this.cepEmp = cepEmp;
        this.bairroEmp = bairroEmp;
        this.cargoEmp = cargoEmp;
        this.rendaEmp = rendaEmp;
        this.admissaoEmp = admissaoEmp;
        this.idCidadesEmp = idCidadesEmp;
        this.idEstadosEmp = idEstadosEmp;
        this.conjuje = conjuje;
        this.cpfConj = cpfConj;
        this.rgConj = rgConj;
        this.nascimentoConj = nascimentoConj;
        this.empresaConj = empresaConj;
        this.foneConj = foneConj;
        this.enderecoConj = enderecoConj;
        this.numeroConj = numeroConj;
        this.cepConj = cepConj;
        this.bairroConj = bairroConj;
        this.cargoConj = cargoConj;
        this.rendaConj = rendaConj;
        this.admissaoConj = admissaoConj;
        this.idCidadesConj = idCidadesConj;
        this.idEstadosConj = idEstadosConj;
        this.referencias = referencias;
        this.comercial1 = comercial1;
        this.comercial2 = comercial2;
        this.comercial3 = comercial3;
        this.bancaria1 = bancaria1;
        this.bancaria2 = bancaria2;
        this.emissao = emissao;
        this.orgao = orgao;
        this.dataCadastro = dataCadastro;
        this.dataHoraAlteracao = dataHoraAlteracao;
        this.foto = foto;
        this.poupanca = poupanca;
        this.podeAprazo = podeAprazo;
        this.podeCartaCobranca = podeCartaCobranca;
        this.numeroContrato = numeroContrato;
        this.numeroCartao = numeroCartao;
        this.tabelaPreco = tabelaPreco;
        this.idVendedor = idVendedor;
        this.filiacaoFoneMae = filiacaoFoneMae;
        this.filiacaoFonePai = filiacaoFonePai;
        this.filiacaoEndereco = filiacaoEndereco;
        this.filiacaoReferencia = filiacaoReferencia;
        this.filiacaoNumero = filiacaoNumero;
        this.filiacaoCep = filiacaoCep;
        this.filiacaoBairro = filiacaoBairro;
        this.filiacaoIdCidade = filiacaoIdCidade;
        this.filiacaoIdEstado = filiacaoIdEstado;
        this.avalistaNome = avalistaNome;
        this.avalistaCpf = avalistaCpf;
        this.avalistaRg = avalistaRg;
        this.avalistaNascimento = avalistaNascimento;
        this.avalistaFone = avalistaFone;
        this.avalistaEndereco = avalistaEndereco;
        this.avalistaNumero = avalistaNumero;
        this.avalistaCep = avalistaCep;
        this.avalistaBairro = avalistaBairro;
        this.avalistaEmpresa = avalistaEmpresa;
        this.avalistaCargo = avalistaCargo;
        this.avalistaRenda = avalistaRenda;
        this.avalistaAdmissao = avalistaAdmissao;
        this.avalistaIdCidade = avalistaIdCidade;
        this.avalistaIdEstado = avalistaIdEstado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIeIndicador() {
        if(ie.length()>=1) {
            return "1";
        } else {
            return "9";
        }
    }

    public void setIeIndicador(String ieIndicador) {
        this.ieIndicador = ieIndicador;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
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
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getCep2() {
        return cep2;
    }

    public void setCep2(String cep2) {
        this.cep2 = cep2;
    }

    public String getBairro2() {
        return bairro2;
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
        return paiAdi;
    }

    public void setPaiAdi(String paiAdi) {
        this.paiAdi = paiAdi;
    }

    public String getMaeAdi() {
        return maeAdi;
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
        return apelidoAdi;
    }

    public void setApelidoAdi(String apelidoAdi) {
        this.apelidoAdi = apelidoAdi;
    }

    public String getEmailAdi() {
        return emailAdi;
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
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFoneEmp() {
        return foneEmp;
    }

    public void setFoneEmp(String foneEmp) {
        this.foneEmp = foneEmp;
    }

    public String getEnderecoEmp() {
        return enderecoEmp;
    }

    public void setEnderecoEmp(String enderecoEmp) {
        this.enderecoEmp = enderecoEmp;
    }

    public String getNumeroEmp() {
        return numeroEmp;
    }

    public void setNumeroEmp(String numeroEmp) {
        this.numeroEmp = numeroEmp;
    }

    public String getCepEmp() {
        return cepEmp;
    }

    public void setCepEmp(String cepEmp) {
        this.cepEmp = cepEmp;
    }

    public String getBairroEmp() {
        return bairroEmp;
    }

    public void setBairroEmp(String bairroEmp) {
        this.bairroEmp = bairroEmp;
    }

    public String getCargoEmp() {
        return cargoEmp;
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
        return conjuje;
    }

    public void setConjuje(String conjuje) {
        this.conjuje = conjuje;
    }

    public String getCpfConj() {
        return cpfConj;
    }

    public void setCpfConj(String cpfConj) {
        this.cpfConj = cpfConj;
    }

    public String getRgConj() {
        return rgConj;
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
        return empresaConj;
    }

    public void setEmpresaConj(String empresaConj) {
        this.empresaConj = empresaConj;
    }

    public String getFoneConj() {
        return foneConj;
    }

    public void setFoneConj(String foneConj) {
        this.foneConj = foneConj;
    }

    public String getEnderecoConj() {
        return enderecoConj;
    }

    public void setEnderecoConj(String enderecoConj) {
        this.enderecoConj = enderecoConj;
    }

    public String getNumeroConj() {
        return numeroConj;
    }

    public void setNumeroConj(String numeroConj) {
        this.numeroConj = numeroConj;
    }

    public String getCepConj() {
        return cepConj;
    }

    public void setCepConj(String cepConj) {
        this.cepConj = cepConj;
    }

    public String getBairroConj() {
        return bairroConj;
    }

    public void setBairroConj(String bairroConj) {
        this.bairroConj = bairroConj;
    }

    public String getCargoConj() {
        return cargoConj;
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
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getComercial1() {
        return comercial1;
    }

    public void setComercial1(String comercial1) {
        this.comercial1 = comercial1;
    }

    public String getComercial2() {
        return comercial2;
    }

    public void setComercial2(String comercial2) {
        this.comercial2 = comercial2;
    }

    public String getComercial3() {
        return comercial3;
    }

    public void setComercial3(String comercial3) {
        this.comercial3 = comercial3;
    }

    public String getBancaria1() {
        return bancaria1;
    }

    public void setBancaria1(String bancaria1) {
        this.bancaria1 = bancaria1;
    }

    public String getBancaria2() {
        return bancaria2;
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
        return orgao;
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
        return dataHoraAlteracao;
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
        return numeroContrato;
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
        return filiacaoFoneMae;
    }

    public void setFiliacaoFoneMae(String filiacaoFoneMae) {
        this.filiacaoFoneMae = filiacaoFoneMae;
    }

    public String getFiliacaoFonePai() {
        return filiacaoFonePai;
    }

    public void setFiliacaoFonePai(String filiacaoFonePai) {
        this.filiacaoFonePai = filiacaoFonePai;
    }

    public String getFiliacaoEndereco() {
        return filiacaoEndereco;
    }

    public void setFiliacaoEndereco(String filiacaoEndereco) {
        this.filiacaoEndereco = filiacaoEndereco;
    }

    public String getFiliacaoReferencia() {
        return filiacaoReferencia;
    }

    public void setFiliacaoReferencia(String filiacaoReferencia) {
        this.filiacaoReferencia = filiacaoReferencia;
    }

    public String getFiliacaoNumero() {
        return filiacaoNumero;
    }

    public void setFiliacaoNumero(String filiacaoNumero) {
        this.filiacaoNumero = filiacaoNumero;
    }

    public String getFiliacaoCep() {
        return filiacaoCep;
    }

    public void setFiliacaoCep(String filiacaoCep) {
        this.filiacaoCep = filiacaoCep;
    }

    public String getFiliacaoBairro() {
        return filiacaoBairro;
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
        return avalistaNome;
    }

    public void setAvalistaNome(String avalistaNome) {
        this.avalistaNome = avalistaNome;
    }

    public String getAvalistaCpf() {
        return avalistaCpf;
    }

    public void setAvalistaCpf(String avalistaCpf) {
        this.avalistaCpf = avalistaCpf;
    }

    public String getAvalistaRg() {
        return avalistaRg;
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
        return avalistaFone;
    }

    public void setAvalistaFone(String avalistaFone) {
        this.avalistaFone = avalistaFone;
    }

    public String getAvalistaEndereco() {
        return avalistaEndereco;
    }

    public void setAvalistaEndereco(String avalistaEndereco) {
        this.avalistaEndereco = avalistaEndereco;
    }

    public String getAvalistaNumero() {
        return avalistaNumero;
    }

    public void setAvalistaNumero(String avalistaNumero) {
        this.avalistaNumero = avalistaNumero;
    }

    public String getAvalistaCep() {
        return avalistaCep;
    }

    public void setAvalistaCep(String avalistaCep) {
        this.avalistaCep = avalistaCep;
    }

    public String getAvalistaBairro() {
        return avalistaBairro;
    }

    public void setAvalistaBairro(String avalistaBairro) {
        this.avalistaBairro = avalistaBairro;
    }

    public String getAvalistaEmpresa() {
        return avalistaEmpresa;
    }

    public void setAvalistaEmpresa(String avalistaEmpresa) {
        this.avalistaEmpresa = avalistaEmpresa;
    }

    public String getAvalistaCargo() {
        return avalistaCargo;
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
    
    /*Metodos auxiliares*/
    public String getCodigoCidade() {
        if(codigoCidade == null || codigoCidade.equals("")) {
            return "1501402"; // CIDADE Belem-PA
        }
        return codigoCidade;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }
    
    @Override
    public String toString() {
        return numeroCartao + " - " + cpfCnpj + " > " + nome;
    }
}
