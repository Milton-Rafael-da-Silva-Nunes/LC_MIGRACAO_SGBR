package sistemas.LC_SISTEMAS.model.entidades;

import java.sql.Date;
import util.DataHoraUtil;

/**
 *
 * @author supor
 */
public class Produto {
    
    private Integer id;
    private String codigo;
    private String referencia;
    private String codigoBarras;
    private String nome;
    private String descricao;
    private String podeDesconto;
    private String podeFracionado;
    private String podeBalanca;
    private String podeLote;
    private String podeComissao;
    private String podeLerPeso;
    private String podeAtualizarNcm;
    private String dataHoraCadastro; // SOMENTE get
    private Date dataHoraAtualizacao;
    private Double precoCompra;
    private Double valorCompra;
    private Double precoCusto;
    private Double custoMedio;
    private Double precoVenda;
    private Double descontoMax;
    private Double precoVenda2;
    private Double qtdMinimaPv2;
    private Double descontoMax2;
    private Double precoVenda3;
    private Double qtdMinimaPv3;
    private Double descontoMax3;
    private Double precoVenda4;
    private Double qtdMinimaPv4;
    private Double descontoMax4;
    private Double precoAntigo;
    private Double valorFrete;
    private String ipi;
    private Double precoPromocao;
    private String dataPromocaoInicial;
    private String dataPromocaoFinal;
    private Integer comissao;
    private Double comissaoValor;
    private String fidelidadePontos;
    private Double estoque;
    private Double estoqueMinimo;
    private Double estoqueMax;
    private Double estoqueTara;
    private Double qtdEmbalagem;
    private String qtdDiasValidade;
    private Double pesoBruto;
    private Double pesoLiquido;
    private String tipoProduto;
    private String origemProduto;
    private String exTipi;
    private Integer ativo;
    private String observacoes;
    private String local;
    private String refCruzada1;
    private String refCruzada2;
    private String refCruzada3;
    private String refCruzada4;
    private String refCruzada5;
    private String refCruzada6;
    private String codEan;
    private String codigoMed;
    private String tipoMed;
    private String tabelaMed;
    private String linhaMed;
    private String refAnvisaMed;
    private String portariaMed;
    private String rmsMed;
    private Date datVigenciaMed;
    private String edicaoPharmacos;
    private String combCprodAnp;
    private String combDescAnp;
    private Double combPercentualGasPetroleo;
    private Double combPercentualGasNatuaralNacional;
    private Double combPercentualGasNaturalImportado;
    private Double combValorPartilha;
    private String medClasseTerapeutica;
    private String medUnidadeMedida;
    private String medUsoProlongado;
    private String medPodeAtualizar;
    private Double medPrecoVendaFpop;
    private String medApresentacaoFpop;
    private Double tribIssAliqSaida;
    private Double tribIcmsAliqsaida;
    private Double tribIcmsAliqRedBaseCalcSaida;
    private String tribIcmsObs;
    private Double tribIcmsfcpAliq;
    private String tribIpiSaida;
    private Double tribIpiAliqSaida;
    private String tribPisSaida;
    private Double tribPisAliqSaida;
    private String tribCofinsSaida;
    private Double tribCofinsAliqSaida;
    private String tribGenero;
    // IDS
    private Integer idGrupoTributacao = 1;
    private Integer idCategoria = 1;
    private Integer idCfop = 289;
    private Integer idCst = 14;
    private Integer idNcm = 1;
    private Integer idCest = 1;
    private Integer idFabricante = 1;
    private Integer idFornecedor = 1;
    private Integer idUnidade = 1;
    private Integer idUnidadeAtacado2 = 0;
    private Integer idUnidadeAtacado3 = 0;
    private Integer idUnidadeAtacado4 = 0;
    private Integer idUnidadeEmbalagem = 1;
    private Integer idSubcategoria = 1;
    private Integer idEmpresa = 1;

    public Produto() {
    }

    public Produto(Integer id, String codigo, String referencia, String codigoBarras, String nome, String descricao, String podeDesconto, String podeFracionado, String podeBalanca, String podeLote, String podeComissao, String podeLerPeso, String podeAtualizarNcm, String dataHoraCadastro, Date dataHoraAtualizacao, Double precoCompra, Double valorCompra, Double precoCusto, Double custoMedio, Double precoVenda, Double descontoMax, Double precoVenda2, Double qtdMinimaPv2, Double descontoMax2, Double precoVenda3, Double qtdMinimaPv3, Double descontoMax3, Double precoVenda4, Double qtdMinimaPv4, Double descontoMax4, Double precoAntigo, Double valorFrete, String ipi, Double precoPromocao, String dataPromocaoInicial, String dataPromocaoFinal, Integer comissao, Double comissaoValor, String fidelidadePontos, Double estoque, Double estoqueMinimo, Double estoqueMax, Double estoqueTara, Double qtdEmbalagem, String qtdDiasValidade, Double pesoBruto, Double pesoLiquido, String tipoProduto, String origemProduto, String exTipi, Integer ativo, String observacoes, String local, String refCruzada1, String refCruzada2, String refCruzada3, String refCruzada4, String refCruzada5, String refCruzada6, String codEan, String codigoMed, String tipoMed, String tabelaMed, String linhaMed, String refAnvisaMed, String portariaMed, String rmsMed, Date datVigenciaMed, String edicaoPharmacos, String combCprodAnp, String combDescAnp, Double combPercentualGasPetroleo, Double combPercentualGasNatuaralNacional, Double combPercentualGasNaturalImportado, Double combValorPartilha, String medClasseTerapeutica, String medUnidadeMedida, String medUsoProlongado, String medPodeAtualizar, Double medPrecoVendaFpop, String medApresentacaoFpop, Double tribIssAliqSaida, Double tribIcmsAliqsaida, Double tribIcmsAliqRedBaseCalcSaida, String tribIcmsObs, Double tribIcmsfcpAliq, String tribIpiSaida, Double tribIpiAliqSaida, String tribPisSaida, Double tribPisAliqSaida, String tribCofinsSaida, Double tribCofinsAliqSaida, String tribGenero, Integer idGrupoTributacao, Integer idCategoria, Integer idCfop, Integer idCst, Integer idNcm, Integer idCest, Integer idFabricante, Integer idFornecedor, Integer idUnidade, Integer idUnidadeAtacado2, Integer idUnidadeAtacado3, Integer idUnidadeAtacado4, Integer idUnidadeEmbalagem, Integer idSubcategoria, Integer idEmpresa) {
        this.id = id;
        this.codigo = codigo;
        this.referencia = referencia;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.podeDesconto = podeDesconto;
        this.podeFracionado = podeFracionado;
        this.podeBalanca = podeBalanca;
        this.podeLote = podeLote;
        this.podeComissao = podeComissao;
        this.podeLerPeso = podeLerPeso;
        this.podeAtualizarNcm = podeAtualizarNcm;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraAtualizacao = dataHoraAtualizacao;
        this.precoCompra = precoCompra;
        this.valorCompra = valorCompra;
        this.precoCusto = precoCusto;
        this.custoMedio = custoMedio;
        this.precoVenda = precoVenda;
        this.descontoMax = descontoMax;
        this.precoVenda2 = precoVenda2;
        this.qtdMinimaPv2 = qtdMinimaPv2;
        this.descontoMax2 = descontoMax2;
        this.precoVenda3 = precoVenda3;
        this.qtdMinimaPv3 = qtdMinimaPv3;
        this.descontoMax3 = descontoMax3;
        this.precoVenda4 = precoVenda4;
        this.qtdMinimaPv4 = qtdMinimaPv4;
        this.descontoMax4 = descontoMax4;
        this.precoAntigo = precoAntigo;
        this.valorFrete = valorFrete;
        this.ipi = ipi;
        this.precoPromocao = precoPromocao;
        this.dataPromocaoInicial = dataPromocaoInicial;
        this.dataPromocaoFinal = dataPromocaoFinal;
        this.comissao = comissao;
        this.comissaoValor = comissaoValor;
        this.fidelidadePontos = fidelidadePontos;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMax = estoqueMax;
        this.estoqueTara = estoqueTara;
        this.qtdEmbalagem = qtdEmbalagem;
        this.qtdDiasValidade = qtdDiasValidade;
        this.pesoBruto = pesoBruto;
        this.pesoLiquido = pesoLiquido;
        this.tipoProduto = tipoProduto;
        this.origemProduto = origemProduto;
        this.exTipi = exTipi;
        this.ativo = ativo;
        this.observacoes = observacoes;
        this.local = local;
        this.refCruzada1 = refCruzada1;
        this.refCruzada2 = refCruzada2;
        this.refCruzada3 = refCruzada3;
        this.refCruzada4 = refCruzada4;
        this.refCruzada5 = refCruzada5;
        this.refCruzada6 = refCruzada6;
        this.codEan = codEan;
        this.codigoMed = codigoMed;
        this.tipoMed = tipoMed;
        this.tabelaMed = tabelaMed;
        this.linhaMed = linhaMed;
        this.refAnvisaMed = refAnvisaMed;
        this.portariaMed = portariaMed;
        this.rmsMed = rmsMed;
        this.datVigenciaMed = datVigenciaMed;
        this.edicaoPharmacos = edicaoPharmacos;
        this.combCprodAnp = combCprodAnp;
        this.combDescAnp = combDescAnp;
        this.combPercentualGasPetroleo = combPercentualGasPetroleo;
        this.combPercentualGasNatuaralNacional = combPercentualGasNatuaralNacional;
        this.combPercentualGasNaturalImportado = combPercentualGasNaturalImportado;
        this.combValorPartilha = combValorPartilha;
        this.medClasseTerapeutica = medClasseTerapeutica;
        this.medUnidadeMedida = medUnidadeMedida;
        this.medUsoProlongado = medUsoProlongado;
        this.medPodeAtualizar = medPodeAtualizar;
        this.medPrecoVendaFpop = medPrecoVendaFpop;
        this.medApresentacaoFpop = medApresentacaoFpop;
        this.tribIssAliqSaida = tribIssAliqSaida;
        this.tribIcmsAliqsaida = tribIcmsAliqsaida;
        this.tribIcmsAliqRedBaseCalcSaida = tribIcmsAliqRedBaseCalcSaida;
        this.tribIcmsObs = tribIcmsObs;
        this.tribIcmsfcpAliq = tribIcmsfcpAliq;
        this.tribIpiSaida = tribIpiSaida;
        this.tribIpiAliqSaida = tribIpiAliqSaida;
        this.tribPisSaida = tribPisSaida;
        this.tribPisAliqSaida = tribPisAliqSaida;
        this.tribCofinsSaida = tribCofinsSaida;
        this.tribCofinsAliqSaida = tribCofinsAliqSaida;
        this.tribGenero = tribGenero;
        this.idGrupoTributacao = idGrupoTributacao;
        this.idCategoria = idCategoria;
        this.idCfop = idCfop;
        this.idCst = idCst;
        this.idNcm = idNcm;
        this.idCest = idCest;
        this.idFabricante = idFabricante;
        this.idFornecedor = idFornecedor;
        this.idUnidade = idUnidade;
        this.idUnidadeAtacado2 = idUnidadeAtacado2;
        this.idUnidadeAtacado3 = idUnidadeAtacado3;
        this.idUnidadeAtacado4 = idUnidadeAtacado4;
        this.idUnidadeEmbalagem = idUnidadeEmbalagem;
        this.idSubcategoria = idSubcategoria;
        this.idEmpresa = idEmpresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPodeDesconto() {
        return podeDesconto;
    }

    public void setPodeDesconto(String podeDesconto) {
        this.podeDesconto = podeDesconto;
    }

    public String getPodeFracionado() {
        return podeFracionado;
    }

    public void setPodeFracionado(String podeFracionado) {
        this.podeFracionado = podeFracionado;
    }    

    public String getPodeBalanca() {
        return podeBalanca;
    }

    public void setPodeBalanca(String podeBalanca) {
        this.podeBalanca = podeBalanca;
    }

    public String getPodeLote() {
        return podeLote;
    }

    public void setPodeLote(String podeLote) {
        this.podeLote = podeLote;
    }

    public String getPodeComissao() {
        return podeComissao;
    }

    public void setPodeComissao(String podeComissao) {
        this.podeComissao = podeComissao;
    }

    public String getPodeLerPeso() {
        return podeLerPeso;
    }

    public void setPodeLerPeso(String podeLerPeso) {
        this.podeLerPeso = podeLerPeso;
    }

    public String getPodeAtualizarNcm() {
        return podeAtualizarNcm;
    }

    public void setPodeAtualizarNcm(String podeAtualizarNcm) {
        this.podeAtualizarNcm = podeAtualizarNcm;
    }

    public String getDataHoraCadastro() {
        return DataHoraUtil.getDataHoraAtual();
    }

    public Date getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(Double custoMedio) {
        this.custoMedio = custoMedio;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getDescontoMax() {
        return descontoMax;
    }

    public void setDescontoMax(Double descontoMax) {
        this.descontoMax = descontoMax;
    }

    public Double getPrecoVenda2() {
        return precoVenda2;
    }

    public void setPrecoVenda2(Double precoVenda2) {
        this.precoVenda2 = precoVenda2;
    }

    public Double getQtdMinimaPv2() {
        return qtdMinimaPv2;
    }

    public void setQtdMinimaPv2(Double qtdMinimaPv2) {
        this.qtdMinimaPv2 = qtdMinimaPv2;
    }

    public Double getDescontoMax2() {
        return descontoMax2;
    }

    public void setDescontoMax2(Double descontoMax2) {
        this.descontoMax2 = descontoMax2;
    }

    public Double getPrecoVenda3() {
        return precoVenda3;
    }

    public void setPrecoVenda3(Double precoVenda3) {
        this.precoVenda3 = precoVenda3;
    }

    public Double getQtdMinimaPv3() {
        return qtdMinimaPv3;
    }

    public void setQtdMinimaPv3(Double qtdMinimaPv3) {
        this.qtdMinimaPv3 = qtdMinimaPv3;
    }

    public Double getDescontoMax3() {
        return descontoMax3;
    }

    public void setDescontoMax3(Double descontoMax3) {
        this.descontoMax3 = descontoMax3;
    }

    public Double getPrecoVenda4() {
        return precoVenda4;
    }

    public void setPrecoVenda4(Double precoVenda4) {
        this.precoVenda4 = precoVenda4;
    }

    public Double getQtdMinimaPv4() {
        return qtdMinimaPv4;
    }

    public void setQtdMinimaPv4(Double qtdMinimaPv4) {
        this.qtdMinimaPv4 = qtdMinimaPv4;
    }

    public Double getDescontoMax4() {
        return descontoMax4;
    }

    public void setDescontoMax4(Double descontoMax4) {
        this.descontoMax4 = descontoMax4;
    }

    public Double getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(Double precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getIpi() {
        return ipi;
    }

    public void setIpi(String ipi) {
        this.ipi = ipi;
    }

    public Double getPrecoPromocao() {
        return precoPromocao;
    }

    public void setPrecoPromocao(Double precoPromocao) {
        this.precoPromocao = precoPromocao;
    }

    public String getDataPromocaoInicial() {
        return dataPromocaoInicial;
    }

    public void setDataPromocaoInicial(String dataPromocaoInicial) {
        this.dataPromocaoInicial = dataPromocaoInicial;
    }

    public String getDataPromocaoFinal() {
        return dataPromocaoFinal;
    }

    public void setDataPromocaoFinal(String dataPromocaoFinal) {
        this.dataPromocaoFinal = dataPromocaoFinal;
    }

    public Integer getComissao() {
        return comissao;
    }

    public void setComissao(Integer comissao) {
        this.comissao = comissao;
    }

    public Double getComissaoValor() {
        return comissaoValor;
    }

    public void setComissaoValor(Double comissaoValor) {
        this.comissaoValor = comissaoValor;
    }

    public String getFidelidadePontos() {
        return fidelidadePontos;
    }

    public void setFidelidadePontos(String fidelidadePontos) {
        this.fidelidadePontos = fidelidadePontos;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Double getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(Double estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public Double getEstoqueTara() {
        return estoqueTara;
    }

    public void setEstoqueTara(Double estoqueTara) {
        this.estoqueTara = estoqueTara;
    }

    public Double getQtdEmbalagem() {
        return qtdEmbalagem;
    }

    public void setQtdEmbalagem(Double qtdEmbalagem) {
        this.qtdEmbalagem = qtdEmbalagem;
    }

    public String getQtdDiasValidade() {
        return qtdDiasValidade;
    }

    public void setQtdDiasValidade(String qtdDiasValidade) {
        this.qtdDiasValidade = qtdDiasValidade;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getOrigemProduto() {
        return origemProduto;
    }

    public void setOrigemProduto(String origemProduto) {
        this.origemProduto = origemProduto;
    }

    public String getExTipi() {
        return exTipi;
    }

    public void setExTipi(String exTipi) {
        this.exTipi = exTipi;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getRefCruzada1() {
        return refCruzada1;
    }

    public void setRefCruzada1(String refCruzada1) {
        this.refCruzada1 = refCruzada1;
    }

    public String getRefCruzada2() {
        return refCruzada2;
    }

    public void setRefCruzada2(String refCruzada2) {
        this.refCruzada2 = refCruzada2;
    }

    public String getRefCruzada3() {
        return refCruzada3;
    }

    public void setRefCruzada3(String refCruzada3) {
        this.refCruzada3 = refCruzada3;
    }

    public String getRefCruzada4() {
        return refCruzada4;
    }

    public void setRefCruzada4(String refCruzada4) {
        this.refCruzada4 = refCruzada4;
    }

    public String getRefCruzada5() {
        return refCruzada5;
    }

    public void setRefCruzada5(String refCruzada5) {
        this.refCruzada5 = refCruzada5;
    }

    public String getRefCruzada6() {
        return refCruzada6;
    }

    public void setRefCruzada6(String refCruzada6) {
        this.refCruzada6 = refCruzada6;
    }

    public String getCodEan() {
        return codEan;
    }

    public void setCodEan(String codEan) {
        this.codEan = codEan;
    }

    public String getCodigoMed() {
        return codigoMed;
    }

    public void setCodigoMed(String codigoMed) {
        this.codigoMed = codigoMed;
    }

    public String getTipoMed() {
        return tipoMed;
    }

    public void setTipoMed(String tipoMed) {
        this.tipoMed = tipoMed;
    }

    public String getTabelaMed() {
        return tabelaMed;
    }

    public void setTabelaMed(String tabelaMed) {
        this.tabelaMed = tabelaMed;
    }

    public String getLinhaMed() {
        return linhaMed;
    }

    public void setLinhaMed(String linhaMed) {
        this.linhaMed = linhaMed;
    }

    public String getRefAnvisaMed() {
        return refAnvisaMed;
    }

    public void setRefAnvisaMed(String refAnvisaMed) {
        this.refAnvisaMed = refAnvisaMed;
    }

    public String getPortariaMed() {
        return portariaMed;
    }

    public void setPortariaMed(String portariaMed) {
        this.portariaMed = portariaMed;
    }

    public String getRmsMed() {
        return rmsMed;
    }

    public void setRmsMed(String rmsMed) {
        this.rmsMed = rmsMed;
    }

    public Date getDatVigenciaMed() {
        return datVigenciaMed;
    }

    public void setDatVigenciaMed(Date datVigenciaMed) {
        this.datVigenciaMed = datVigenciaMed;
    }

    public String getEdicaoPharmacos() {
        return edicaoPharmacos;
    }

    public void setEdicaoPharmacos(String edicaoPharmacos) {
        this.edicaoPharmacos = edicaoPharmacos;
    }

    public String getCombCprodAnp() {
        return combCprodAnp;
    }

    public void setCombCprodAnp(String combCprodAnp) {
        this.combCprodAnp = combCprodAnp;
    }

    public String getCombDescAnp() {
        return combDescAnp;
    }

    public void setCombDescAnp(String combDescAnp) {
        this.combDescAnp = combDescAnp;
    }

    public Double getCombPercentualGasPetroleo() {
        return combPercentualGasPetroleo;
    }

    public void setCombPercentualGasPetroleo(Double combPercentualGasPetroleo) {
        this.combPercentualGasPetroleo = combPercentualGasPetroleo;
    }

    public Double getCombPercentualGasNatuaralNacional() {
        return combPercentualGasNatuaralNacional;
    }

    public void setCombPercentualGasNatuaralNacional(Double combPercentualGasNatuaralNacional) {
        this.combPercentualGasNatuaralNacional = combPercentualGasNatuaralNacional;
    }

    public Double getCombPercentualGasNaturalImportado() {
        return combPercentualGasNaturalImportado;
    }

    public void setCombPercentualGasNaturalImportado(Double combPercentualGasNaturalImportado) {
        this.combPercentualGasNaturalImportado = combPercentualGasNaturalImportado;
    }

    public Double getCombValorPartilha() {
        return combValorPartilha;
    }

    public void setCombValorPartilha(Double combValorPartilha) {
        this.combValorPartilha = combValorPartilha;
    }

    public String getMedClasseTerapeutica() {
        return medClasseTerapeutica;
    }

    public void setMedClasseTerapeutica(String medClasseTerapeutica) {
        this.medClasseTerapeutica = medClasseTerapeutica;
    }

    public String getMedUnidadeMedida() {
        return medUnidadeMedida;
    }

    public void setMedUnidadeMedida(String medUnidadeMedida) {
        this.medUnidadeMedida = medUnidadeMedida;
    }

    public String getMedUsoProlongado() {
        return medUsoProlongado;
    }

    public void setMedUsoProlongado(String medUsoProlongado) {
        this.medUsoProlongado = medUsoProlongado;
    }

    public String getMedPodeAtualizar() {
        return medPodeAtualizar;
    }

    public void setMedPodeAtualizar(String medPodeAtualizar) {
        this.medPodeAtualizar = medPodeAtualizar;
    }

    public Double getMedPrecoVendaFpop() {
        return medPrecoVendaFpop;
    }

    public void setMedPrecoVendaFpop(Double medPrecoVendaFpop) {
        this.medPrecoVendaFpop = medPrecoVendaFpop;
    }

    public String getMedApresentacaoFpop() {
        return medApresentacaoFpop;
    }

    public void setMedApresentacaoFpop(String medApresentacaoFpop) {
        this.medApresentacaoFpop = medApresentacaoFpop;
    }

    public Double getTribIssAliqSaida() {
        return tribIssAliqSaida;
    }

    public void setTribIssAliqSaida(Double tribIssAliqSaida) {
        this.tribIssAliqSaida = tribIssAliqSaida;
    }

    public Double getTribIcmsAliqsaida() {
        return tribIcmsAliqsaida;
    }

    public void setTribIcmsAliqsaida(Double tribIcmsAliqsaida) {
        this.tribIcmsAliqsaida = tribIcmsAliqsaida;
    }

    public Double getTribIcmsAliqRedBaseCalcSaida() {
        return tribIcmsAliqRedBaseCalcSaida;
    }

    public void setTribIcmsAliqRedBaseCalcSaida(Double tribIcmsAliqRedBaseCalcSaida) {
        this.tribIcmsAliqRedBaseCalcSaida = tribIcmsAliqRedBaseCalcSaida;
    }

    public String getTribIcmsObs() {
        return tribIcmsObs;
    }

    public void setTribIcmsObs(String tribIcmsObs) {
        this.tribIcmsObs = tribIcmsObs;
    }

    public Double getTribIcmsfcpAliq() {
        return tribIcmsfcpAliq;
    }

    public void setTribIcmsfcpAliq(Double tribIcmsfcpAliq) {
        this.tribIcmsfcpAliq = tribIcmsfcpAliq;
    }

    public String getTribIpiSaida() {
        return tribIpiSaida;
    }

    public void setTribIpiSaida(String tribIpiSaida) {
        this.tribIpiSaida = tribIpiSaida;
    }

    public Double getTribIpiAliqSaida() {
        return tribIpiAliqSaida;
    }

    public void setTribIpiAliqSaida(Double tribIpiAliqSaida) {
        this.tribIpiAliqSaida = tribIpiAliqSaida;
    }

    public String getTribPisSaida() {
        return tribPisSaida;
    }

    public void setTribPisSaida(String tribPisSaida) {
        this.tribPisSaida = tribPisSaida;
    }

    public Double getTribPisAliqSaida() {
        return tribPisAliqSaida;
    }

    public void setTribPisAliqSaida(Double tribPisAliqSaida) {
        this.tribPisAliqSaida = tribPisAliqSaida;
    }

    public String getTribCofinsSaida() {
        return tribCofinsSaida;
    }

    public void setTribCofinsSaida(String tribCofinsSaida) {
        this.tribCofinsSaida = tribCofinsSaida;
    }

    public Double getTribCofinsAliqSaida() {
        return tribCofinsAliqSaida;
    }

    public void setTribCofinsAliqSaida(Double tribCofinsAliqSaida) {
        this.tribCofinsAliqSaida = tribCofinsAliqSaida;
    }

    public String getTriGenero() {
        return tribGenero;
    }

    public void setTribGenero(String tribGenero) {
        this.tribGenero = tribGenero;
    }

    public Integer getIdGrupoTributacao() {
        return idGrupoTributacao;
    }

    public void setIdGrupoTributacao(Integer idGrupoTributacao) {
        this.idGrupoTributacao = idGrupoTributacao;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCfop() {
        return idCfop;
    }

    public void setIdCfop(Integer idCfop) {
        this.idCfop = idCfop;
    }

    public Integer getIdCst() {
        return idCst;
    }

    public void setIdCst(Integer idCst) {
        this.idCst = idCst;
    }

    public Integer getIdNcm() {
        return idNcm;
    }

    public void setIdNcm(Integer idNcm) {
        this.idNcm = idNcm;
    }

    public Integer getIdCest() {
        return idCest;
    }

    public void setIdCest(Integer idCest) {
        this.idCest = idCest;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Integer getIdUnidadeAtacado2() {
        return idUnidadeAtacado2;
    }

    public void setIdUnidadeAtacado2(Integer idUnidadeAtacado2) {
        this.idUnidadeAtacado2 = idUnidadeAtacado2;
    }

    public Integer getIdUnidadeAtacado3() {
        return idUnidadeAtacado3;
    }

    public void setIdUnidadeAtacado3(Integer idUnidadeAtacado3) {
        this.idUnidadeAtacado3 = idUnidadeAtacado3;
    }

    public Integer getIdUnidadeAtacado4() {
        return idUnidadeAtacado4;
    }

    public void setIdUnidadeAtacado4(Integer idUnidadeAtacado4) {
        this.idUnidadeAtacado4 = idUnidadeAtacado4;
    }

    public Integer getIdUnidadeEmbalagem() {
        return idUnidadeEmbalagem;
    }

    public void setIdUnidadeEmbalagem(Integer idUnidadeEmbalagem) {
        this.idUnidadeEmbalagem = idUnidadeEmbalagem;
    }

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return codigo + " - " +  codigoBarras + " > " + nome;
    }
}
