package sistemas.LC_SISTEMAS.model.entidades;

import java.sql.Date;
import java.util.TreeMap;
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
    private String dataHoraAtualizacao; // SOMENTE get
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
    // IDS
    private Integer idGrupoTributacao = 1;
    private Integer idFornecedor = 1;
    private Integer idUnidadeAtacado2 = 0;
    private Integer idUnidadeAtacado3 = 0;
    private Integer idUnidadeAtacado4 = 0;
    private Integer idUnidadeEmbalagem = 0;
    private Integer idEmpresa = 1;
    private Integer idCfop = 289;
    private Integer idCategoria = 0;
    private Integer idCst = 14;
    private Integer idNcm = 1;
    private Integer idCest = 1;
    private Integer idFabricante = 1;
    private Integer idSubcategoria = 0;
    private Integer idUnidade = 1;
    //private Double margemLucro;
    //private Double margemLucro2;
    //private Double margemLucro3;
    //private Double margemLucro4;
    private Double margemFpo;
    private Double margemIdeal;
    // Campos de terceiros para associacao em MAP
    private String codigoNcm;
    private String codigoCest;
    private String unidadeMedida;
    private String categoriaNome;
    private String subcategoriaNome;
    private String fabricanteNome;
    private String cstCsosn;
    private String fornecedorNome;

    public Produto() {
    }

    public Produto(Integer id, String codigo, String referencia, String codigoBarras, String nome, String descricao, String podeDesconto, String podeFracionado, String podeBalanca, String podeLote, String podeComissao, String podeLerPeso, String podeAtualizarNcm, String dataHoraCadastro, Double precoCompra, Double valorCompra, Double precoCusto, Double custoMedio, Double precoVenda, Double descontoMax, Double precoVenda2, Double qtdMinimaPv2, Double descontoMax2, Double precoVenda3, Double qtdMinimaPv3, Double descontoMax3, Double precoVenda4, Double qtdMinimaPv4, Double descontoMax4, Double precoAntigo, Double valorFrete, String ipi, Double precoPromocao, String dataPromocaoInicial, String dataPromocaoFinal, Integer comissao, Double comissaoValor, String fidelidadePontos, Double estoque, Double estoqueMinimo, Double estoqueMax, Double estoqueTara, Double qtdEmbalagem, String qtdDiasValidade, Double pesoBruto, Double pesoLiquido, String tipoProduto, String origemProduto, String exTipi, Integer ativo, String observacoes, String local, String refCruzada1, String refCruzada2, String refCruzada3, String refCruzada4, String refCruzada5, String refCruzada6, String codEan, String codigoMed, String tipoMed, String tabelaMed, String linhaMed, String refAnvisaMed, String portariaMed, String rmsMed, Date datVigenciaMed, String edicaoPharmacos, String combCprodAnp, String combDescAnp, Double combPercentualGasPetroleo, Double combPercentualGasNatuaralNacional, Double combPercentualGasNaturalImportado, Double combValorPartilha, String medClasseTerapeutica, String medUnidadeMedida, String medUsoProlongado, String medPodeAtualizar, Double medPrecoVendaFpop, String medApresentacaoFpop, Double tribIssAliqSaida, Double tribIcmsAliqsaida, Double tribIcmsAliqRedBaseCalcSaida, String tribIcmsObs, Double tribIcmsfcpAliq, String tribIpiSaida, Double tribIpiAliqSaida, String tribPisSaida, Double tribPisAliqSaida, String tribCofinsSaida, Double tribCofinsAliqSaida) {
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
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo == null ? "" : codigo.trim().replace("  ", "");
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        if (referencia == null || (codigoBarras != null && referencia.equals(codigoBarras))) {
            return "";
        }
        return referencia.trim().replace("  ", "");
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras == null ? "" : codigoBarras.trim().replace("  ", "");
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome.toUpperCase().trim().replace("  ", "");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao == null ? "" : descricao.toUpperCase().trim().replace("  ", "");
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPodeDesconto() {
        return podeDesconto == null ? "S" : podeDesconto;
    }

    public void setPodeDesconto(String podeDesconto) {
        this.podeDesconto = podeDesconto;
    }

    public String getPodeFracionado() {
        return podeFracionado == null ? "N" : podeFracionado;
    }

    public void setPodeFracionado(String podeFracionado) {
        this.podeFracionado = podeFracionado;
    }

    public String getPodeBalanca() {
        return podeBalanca == null ? "N" : podeBalanca;
    }

    public void setPodeBalanca(String podeBalanca) {
        this.podeBalanca = podeBalanca;
    }

    public String getPodeLote() {
        return podeLote == null ? "N" : podeLote;
    }

    public void setPodeLote(String podeLote) {
        this.podeLote = podeLote;
    }

    public String getPodeComissao() {
        return podeComissao == null ? "S" : podeComissao;
    }

    public void setPodeComissao(String podeComissao) {
        this.podeComissao = podeComissao;
    }

    public String getPodeLerPeso() {
        return podeLerPeso == null ? "N" : podeLerPeso;
    }

    public void setPodeLerPeso(String podeLerPeso) {
        this.podeLerPeso = podeLerPeso;
    }

    public String getPodeAtualizarNcm() {
        return podeAtualizarNcm == null ? "S" : podeAtualizarNcm;
    }

    public void setPodeAtualizarNcm(String podeAtualizarNcm) {
        this.podeAtualizarNcm = podeAtualizarNcm;
    }

    public String getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public String getDataHoraAtualizacao() {
        return DataHoraUtil.getDataHoraAtual();
    }

    public Double getPrecoCompra() {
        return precoCompra == null ? 0.0 : precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getValorCompra() {
        return valorCompra == null ? 0.0 : valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getPrecoCusto() {
        return precoCusto == null ? 0.0 : precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getCustoMedio() {
        return custoMedio == null ? precoCusto : custoMedio;
    }

    public void setCustoMedio(Double custoMedio) {
        this.custoMedio = custoMedio;
    }

    public Double getPrecoVenda() {
        return precoVenda == null ? 0.0 : precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getDescontoMax() {
        return descontoMax == null ? 0.0 : descontoMax;
    }

    public void setDescontoMax(Double descontoMax) {
        this.descontoMax = descontoMax;
    }

    public Double getPrecoVenda2() {
        return precoVenda2 == null ? 0.0 : precoVenda2;
    }

    public void setPrecoVenda2(Double precoVenda2) {
        this.precoVenda2 = precoVenda2;
    }

    public Double getQtdMinimaPv2() {
        return qtdMinimaPv2 == null ? 0.0 : qtdMinimaPv2;
    }

    public void setQtdMinimaPv2(Double qtdMinimaPv2) {
        this.qtdMinimaPv2 = qtdMinimaPv2;
    }

    public Double getDescontoMax2() {
        return descontoMax2 == null ? 0.0 : descontoMax2;
    }

    public void setDescontoMax2(Double descontoMax2) {
        this.descontoMax2 = descontoMax2;
    }

    public Double getPrecoVenda3() {
        return precoVenda3 == null ? 0.0 : precoVenda3;
    }

    public void setPrecoVenda3(Double precoVenda3) {
        this.precoVenda3 = precoVenda3;
    }

    public Double getQtdMinimaPv3() {
        return qtdMinimaPv3 == null ? 0.0 : qtdMinimaPv3;
    }

    public void setQtdMinimaPv3(Double qtdMinimaPv3) {
        this.qtdMinimaPv3 = qtdMinimaPv3;
    }

    public Double getDescontoMax3() {
        return descontoMax3 == null ? 0.0 : descontoMax3;
    }

    public void setDescontoMax3(Double descontoMax3) {
        this.descontoMax3 = descontoMax3;
    }

    public Double getPrecoVenda4() {
        return precoVenda4 == null ? 0.0 : precoVenda4;
    }

    public void setPrecoVenda4(Double precoVenda4) {
        this.precoVenda4 = precoVenda4;
    }

    public Double getQtdMinimaPv4() {
        return qtdMinimaPv4 == null ? 0.0 : qtdMinimaPv4;
    }

    public void setQtdMinimaPv4(Double qtdMinimaPv4) {
        this.qtdMinimaPv4 = qtdMinimaPv4;
    }

    public Double getDescontoMax4() {
        return descontoMax4 == null ? 0.0 : descontoMax4;
    }

    public void setDescontoMax4(Double descontoMax4) {
        this.descontoMax4 = descontoMax4;
    }

    public Double getPrecoAntigo() {
        return precoAntigo == null ? 0.0 : precoAntigo;
    }

    public void setPrecoAntigo(Double precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public Double getValorFrete() {
        return valorFrete == null ? 0.0 : valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getIpi() {
        return ipi == null ? "0.0" : ipi;
    }

    public void setIpi(String ipi) {
        this.ipi = ipi;
    }

    public Double getPrecoPromocao() {
        return precoPromocao == null ? 0.0 : precoPromocao;
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
        return comissao == null ? 0 : comissao;
    }

    public void setComissao(Integer comissao) {
        this.comissao = comissao;
    }

    public Double getComissaoValor() {
        return comissaoValor == null ? 0.0 : comissaoValor;
    }

    public void setComissaoValor(Double comissaoValor) {
        this.comissaoValor = comissaoValor;
    }

    public String getFidelidadePontos() {
        return fidelidadePontos == null ? "0.0" : fidelidadePontos;
    }

    public void setFidelidadePontos(String fidelidadePontos) {
        this.fidelidadePontos = fidelidadePontos;
    }

    public Double getEstoque() {
        if (estoque == null || estoque.equals("") || estoque < 0) {
            return 0.0;
        }
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
        return estoqueTara == null ? 0.0 : estoqueTara;
    }

    public void setEstoqueTara(Double estoqueTara) {
        this.estoqueTara = estoqueTara;
    }

    public Double getQtdEmbalagem() {
        return qtdEmbalagem == null ? 1.0 : qtdEmbalagem;
    }

    public void setQtdEmbalagem(Double qtdEmbalagem) {
        this.qtdEmbalagem = qtdEmbalagem;
    }

    public String getQtdDiasValidade() {
        return qtdDiasValidade == null ? "0" : qtdDiasValidade;
    }

    public void setQtdDiasValidade(String qtdDiasValidade) {
        this.qtdDiasValidade = qtdDiasValidade;
    }

    public Double getPesoBruto() {
        return pesoBruto == null ? 0.0 : pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Double getPesoLiquido() {
        return pesoLiquido == null ? 0.0 : pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public String getTipoProduto() {
        return tipoProduto == null ? "PRODUTO" : tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getOrigemProduto() {
        return origemProduto == null ? "0" : origemProduto;
    }

    public void setOrigemProduto(String origemProduto) {
        this.origemProduto = origemProduto;
    }

    public String getExTipi() {
        return exTipi == null ? "" : exTipi;
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
        return observacoes == null ? "Migracao: " + DataHoraUtil.getDataAtual() : observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLocal() {
        return local == null ? "" : local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getRefCruzada1() {
        return refCruzada1 == null ? "" : refCruzada1;
    }

    public void setRefCruzada1(String refCruzada1) {
        this.refCruzada1 = refCruzada1;
    }

    public String getRefCruzada2() {
        return refCruzada2 == null ? "" : refCruzada2;
    }

    public void setRefCruzada2(String refCruzada2) {
        this.refCruzada2 = refCruzada2;
    }

    public String getRefCruzada3() {
        return refCruzada3 == null ? "" : refCruzada3;
    }

    public void setRefCruzada3(String refCruzada3) {
        this.refCruzada3 = refCruzada3;
    }

    public String getRefCruzada4() {
        return refCruzada4 == null ? "" : refCruzada4;
    }

    public void setRefCruzada4(String refCruzada4) {
        this.refCruzada4 = refCruzada4;
    }

    public String getRefCruzada5() {
        return refCruzada5 == null ? "" : refCruzada5;
    }

    public void setRefCruzada5(String refCruzada5) {
        this.refCruzada5 = refCruzada5;
    }

    public String getRefCruzada6() {
        return refCruzada6 == null ? "" : refCruzada6;
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
        return tipoMed == null ? "" : tipoMed;
    }

    public void setTipoMed(String tipoMed) {
        this.tipoMed = tipoMed;
    }

    public String getTabelaMed() {
        return tabelaMed == null ? "" : tabelaMed;
    }

    public void setTabelaMed(String tabelaMed) {
        this.tabelaMed = tabelaMed;
    }

    public String getLinhaMed() {
        return linhaMed == null ? "" : linhaMed;
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
        return portariaMed == null ? "" : portariaMed;
    }

    public void setPortariaMed(String portariaMed) {
        this.portariaMed = portariaMed;
    }

    public String getRmsMed() {
        return formatarRmsMed(rmsMed);
    }

    private String formatarRmsMed(String rms) {
        if (rms != null) {
            return rms.replace(".", "").replace("-", "").replace("/", "").replace(",", "");
        } else {
            return "";
        }
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
        return combCprodAnp == null ? "" : combCprodAnp;
    }

    public void setCombCprodAnp(String combCprodAnp) {
        this.combCprodAnp = combCprodAnp;
    }

    public String getCombDescAnp() {
        return combDescAnp == null ? "" : combDescAnp;
    }

    public void setCombDescAnp(String combDescAnp) {
        this.combDescAnp = combDescAnp;
    }

    public Double getCombPercentualGasPetroleo() {
        return combPercentualGasPetroleo == null ? 0.0 : combPercentualGasPetroleo;
    }

    public void setCombPercentualGasPetroleo(Double combPercentualGasPetroleo) {
        this.combPercentualGasPetroleo = combPercentualGasPetroleo;
    }

    public Double getCombPercentualGasNatuaralNacional() {
        return combPercentualGasNatuaralNacional == null ? 0.0 : combPercentualGasNatuaralNacional;
    }

    public void setCombPercentualGasNatuaralNacional(Double combPercentualGasNatuaralNacional) {
        this.combPercentualGasNatuaralNacional = combPercentualGasNatuaralNacional;
    }

    public Double getCombPercentualGasNaturalImportado() {
        return combPercentualGasNaturalImportado == null ? 0.0 : combPercentualGasNaturalImportado;
    }

    public void setCombPercentualGasNaturalImportado(Double combPercentualGasNaturalImportado) {
        this.combPercentualGasNaturalImportado = combPercentualGasNaturalImportado;
    }

    public Double getCombValorPartilha() {
        return combValorPartilha == null ? 0.0 : combValorPartilha;
    }

    public void setCombValorPartilha(Double combValorPartilha) {
        this.combValorPartilha = combValorPartilha;
    }

    public String getMedClasseTerapeutica() {
        return medClasseTerapeutica == null ? "" : medClasseTerapeutica;
    }

    public void setMedClasseTerapeutica(String medClasseTerapeutica) {
        this.medClasseTerapeutica = medClasseTerapeutica;
    }

    public String getMedUnidadeMedida() {
        return medUnidadeMedida == null ? "" : medUnidadeMedida;
    }

    public void setMedUnidadeMedida(String medUnidadeMedida) {
        this.medUnidadeMedida = medUnidadeMedida;
    }

    public String getMedUsoProlongado() {
        return medUsoProlongado == null ? "" : medUsoProlongado;
    }

    public void setMedUsoProlongado(String medUsoProlongado) {
        this.medUsoProlongado = medUsoProlongado;
    }

    public String getMedPodeAtualizar() {
        return medPodeAtualizar == null ? "S" : medPodeAtualizar;
    }

    public void setMedPodeAtualizar(String medPodeAtualizar) {
        this.medPodeAtualizar = medPodeAtualizar;
    }

    public Double getMedPrecoVendaFpop() {
        return medPrecoVendaFpop == null ? 0.0 : medPrecoVendaFpop;
    }

    public void setMedPrecoVendaFpop(Double medPrecoVendaFpop) {
        this.medPrecoVendaFpop = medPrecoVendaFpop;
    }

    public String getMedApresentacaoFpop() {
        return medApresentacaoFpop == null ? "0.0" : medApresentacaoFpop;
    }

    public void setMedApresentacaoFpop(String medApresentacaoFpop) {
        this.medApresentacaoFpop = medApresentacaoFpop;
    }

    public Double getTribIssAliqSaida() {
        return tribIssAliqSaida == null ? 0.0 : tribIssAliqSaida;
    }

    public void setTribIssAliqSaida(Double tribIssAliqSaida) {
        this.tribIssAliqSaida = tribIssAliqSaida;
    }

    public Double getTribIcmsAliqsaida() {
        return tribIcmsAliqsaida == null ? 0.0 : tribIcmsAliqsaida;
    }

    public void setTribIcmsAliqsaida(Double tribIcmsAliqsaida) {
        this.tribIcmsAliqsaida = tribIcmsAliqsaida;
    }

    public Double getTribIcmsAliqRedBaseCalcSaida() {
        return tribIcmsAliqRedBaseCalcSaida == null ? 0.0 : tribIcmsAliqRedBaseCalcSaida;
    }

    public void setTribIcmsAliqRedBaseCalcSaida(Double tribIcmsAliqRedBaseCalcSaida) {
        this.tribIcmsAliqRedBaseCalcSaida = tribIcmsAliqRedBaseCalcSaida;
    }

    public String getTribIcmsObs() {
        return tribIcmsObs == null ? "" : tribIcmsObs;
    }

    public void setTribIcmsObs(String tribIcmsObs) {
        this.tribIcmsObs = tribIcmsObs;
    }

    public Double getTribIcmsfcpAliq() {
        return tribIcmsfcpAliq == null ? 0.0 : tribIcmsfcpAliq;
    }

    public void setTribIcmsfcpAliq(Double tribIcmsfcpAliq) {
        this.tribIcmsfcpAliq = tribIcmsfcpAliq;
    }

    public String getTribIpiSaida() {
        return tribIpiSaida == null ? "" : tribIpiSaida;
    }

    public void setTribIpiSaida(String tribIpiSaida) {
        this.tribIpiSaida = tribIpiSaida;
    }

    public Double getTribIpiAliqSaida() {
        return tribIpiAliqSaida == null ? 0.0 : tribIpiAliqSaida;
    }

    public void setTribIpiAliqSaida(Double tribIpiAliqSaida) {
        this.tribIpiAliqSaida = tribIpiAliqSaida;
    }

    public String getTribPisSaida() {
        return tribPisSaida == null ? "07" : tribPisSaida;
    }

    public void setTribPisSaida(String tribPisSaida) {
        this.tribPisSaida = tribPisSaida;
    }

    public Double getTribPisAliqSaida() {
        return tribPisAliqSaida == null ? 0.0 : tribPisAliqSaida;
    }

    public void setTribPisAliqSaida(Double tribPisAliqSaida) {
        this.tribPisAliqSaida = tribPisAliqSaida;
    }

    public String getTribCofinsSaida() {
        return tribCofinsSaida == null ? "07" : tribCofinsSaida;
    }

    public void setTribCofinsSaida(String tribCofinsSaida) {
        this.tribCofinsSaida = tribCofinsSaida;
    }

    public Double getTribCofinsAliqSaida() {
        return tribCofinsAliqSaida == null ? 0.0 : tribCofinsAliqSaida;
    }

    public void setTribCofinsAliqSaida(Double tribCofinsAliqSaida) {
        this.tribCofinsAliqSaida = tribCofinsAliqSaida;
    }

    public String getTriGenero() {
        return codigoNcm == null ? "" : codigoNcm.substring(0, 2);
    }

    public Integer getIdGrupoTributacao() {
        return idGrupoTributacao;
    }

    public Integer getIdCfop() {
        if (cstCsosn != null) {
            if (cstCsosn.equals("500") || cstCsosn.equals("60")) {
                return 355;
            }
        }
        return 289;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public Integer getIdUnidadeAtacado2() {
        return idUnidadeAtacado2;
    }

    public Integer getIdUnidadeAtacado3() {
        return idUnidadeAtacado3;
    }

    public Integer getIdUnidadeAtacado4() {
        return idUnidadeAtacado4;
    }

    public Integer getIdUnidadeEmbalagem() {
        return idUnidadeEmbalagem;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public Double getMargemLucro() {
        return calcularMargemLucro(precoVenda, precoCusto);
    }

    public Double getMargemLucro2() {
        return calcularMargemLucro(precoVenda2, precoCusto);
    }

    public Double getMargemLucro3() {
        return calcularMargemLucro(precoVenda3, precoCusto);
    }

    public Double getMargemLucro4() {
        return calcularMargemLucro(precoVenda4, precoCusto);
    }

    public Double getMargemIdeal() {
        return margemIdeal == null ? 0.0 : margemIdeal;
    }

    public double getMargemFpop() {
        return margemFpo == null ? 0.0 : margemFpo;
    }

    private Double calcularMargemLucro(Double precoVenda, Double precoCusto) {
        if (precoVenda != null && precoVenda > 0) {
            return ((precoVenda - precoCusto) / precoCusto) * 100;
        }
        return 0.0;
    }

    // Metodos Acessores para implementar id em TREEMAP
    public String getCodigoNcm(TreeMap<String, String> mapaNcm) {
        String ncm = (codigoNcm != null && !codigoNcm.equals("")) ? codigoNcm : "00000000";
        return mapaNcm.containsKey(ncm) ? mapaNcm.get(ncm) : mapaNcm.get("00000000");
    }

    public void setCodigoNcm(String codigoNcm) {
        this.codigoNcm = codigoNcm;
    }

    public String getCodigoCest(TreeMap<String, String> mapaCest) {
        String cest = (codigoCest != null && !codigoCest.equals("")) ? codigoCest : "0000000";
        return mapaCest.containsKey(cest) ? mapaCest.get(cest) : mapaCest.get("0000000");
    }

    public void setCodigoCest(String codigoCest) {
        this.codigoCest = codigoCest;
    }
    
    public String getUnidadeMedida(TreeMap<String, String> mapaUnidade) {
        String unidade = (unidadeMedida != null && !unidadeMedida.equals("")) ? unidadeMedida : "UN";
        return mapaUnidade.containsKey(unidade) ? mapaUnidade.get(unidade.replace("Ç", "C").replace("ç", "c")) : mapaUnidade.get("UN");
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getCategoriaNome(TreeMap<String, String> mapaCategoria) {
        String categoria = categoriaNome;
        return mapaCategoria.getOrDefault(categoria, mapaCategoria.get("PADRAO"));
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getSubCategoriaNome(TreeMap<String, String> mapaSubcategoria) {
        String subcategoria = subcategoriaNome;
        return mapaSubcategoria.getOrDefault(subcategoria, mapaSubcategoria.get("PADRAO"));
    }

    public void setSubcategoriaNome(String subcategoriaNome) {
        this.subcategoriaNome = subcategoriaNome;
    }

    public String getFabricanteNome(TreeMap<String, String> mapaFabricante) {
        String fabricante = fabricanteNome;
        return mapaFabricante.getOrDefault(fabricante, mapaFabricante.get("PADRAO"));
    }

    public void setFabricanteNome(String fabricanteNome) {
        this.fabricanteNome = fabricanteNome;
    }

    public String getCstCsosn(String regime) {
        return formatarCstCsosnRegime(cstCsosn, regime);
    }

    public void setCstCsosn(String cstCsosn) {
        this.cstCsosn = cstCsosn;
    }
    
    public String getFornecedorNome(TreeMap<String, String> mapaFornecedor) {
        String fornecedor = fornecedorNome;
        return mapaFornecedor.getOrDefault(fornecedor, mapaFornecedor.get("PADRAO"));
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    private String formatarCstCsosnRegime(String cstCsosn, String regime) {
        if (cstCsosn == null || cstCsosn.isEmpty()) {
            cstCsosn = (regime.equalsIgnoreCase("simples")) ? "102" : "00";
        }

        if (regime.equalsIgnoreCase("simples")) {
            switch (cstCsosn) {
                case "00":
                case "10":
                case "20":
                case "70":
                    return "102";
                case "30":
                case "40":
                case "50":
                case "51":
                    return "300";
                case "41":
                    return "400";
                case "60":
                    return "500";
                case "90":
                    return "900";
                default:
                    return cstCsosn;
            }
        } else {
            switch (cstCsosn) {
                case "101":
                case "102":
                case "103":
                case "201":
                case "202":
                case "203":
                    return "00";
                case "300":
                    return "40";
                case "400":
                    return "41";
                case "500":
                    return "60";
                case "900":
                    return "90";
                default:
                    return cstCsosn;
            }
        }
    }

    @Override
    public String toString() {
        return codigo + " - " + codigoBarras + " > " + nome + " > " + fornecedorNome;
    }
}
