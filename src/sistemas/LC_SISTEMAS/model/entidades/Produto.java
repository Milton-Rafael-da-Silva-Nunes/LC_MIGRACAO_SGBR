package sistemas.LC_SISTEMAS.model.entidades;

import java.sql.Date;
import java.util.TreeMap;
import util.DataHoraUtil;

/**
 *
 * @author Rafael Nunes
 */
public class Produto {

    private Integer id;
    private String codigo;
    private String referencia;
    private String codigoBarras;
    private String nome;
    private String descricao;
    private String podeDesconto;
    private String podeBalanca;
    private String podeLote;
    private String podeComissao;
    private String podeFracionado;
    private String observacoes;
    private String dataHoraCadastro;
    private String podeLerPeso;
    private String podeAtualizarNcm;
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
    private Double ipi;
    private Double precoPromocao;
    private String dataPromocaoInicial;
    private String dataPromocaoFinal;
    private Double comissao;
    private Double comissaoValor;
    private Double fidelidadePontos;
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
    private Double medApresentacaoFpop;
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
    private final Integer idGrupoTributacao;
    private final Integer idUnidadeAtacado2;
    private final Integer idUnidadeAtacado3;
    private final Integer idUnidadeAtacado4;
    private final Integer idUnidadeEmbalagem;
    private final Integer idEmpresa;
    private final Double margemFpo;
    private final Double margemIdeal;
    private final String foto;
    private final String foto2;
    private final String foto3;
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
        idGrupoTributacao = 1;
        idUnidadeAtacado2 = 0;
        idUnidadeAtacado3 = 0;
        idUnidadeAtacado4 = 0;
        idUnidadeEmbalagem = 0;
        idEmpresa = 1;
        podeDesconto = "S";
        podeLote = "N";
        podeLerPeso = "N";
        podeAtualizarNcm = "S";
        qtdMinimaPv2 = 0.0;
        descontoMax2 = 0.0;
        qtdMinimaPv3 = 0.0;
        descontoMax3 = 0.0;
        precoVenda4 = 0.0;
        qtdMinimaPv4 = 0.0;
        descontoMax4 = 0.0;
        precoAntigo = 0.0;
        precoPromocao = 0.0;
        fidelidadePontos = 0.0;
        estoqueTara = 0.0;
        qtdEmbalagem = 1.0;
        qtdDiasValidade = "0";
        pesoLiquido = 0.0;
        tipoProduto = "PRODUTO";
        origemProduto = "0";
        exTipi = "";
        refCruzada1 = "";
        refCruzada2 = "";
        refCruzada3 = "";
        refCruzada4 = "";
        refCruzada5 = "";
        refCruzada6 = "";
        portariaMed = "";
        medClasseTerapeutica = "";
        medUnidadeMedida = "";
        medUsoProlongado = "";
        medPodeAtualizar = "S";
        medPrecoVendaFpop = 0.0;
        medApresentacaoFpop = 0.0;
        tribIssAliqSaida = 0.0;
        tribIcmsObs = "";
        margemFpo = 0.0;
        margemIdeal = 0.0;
        tipoMed = "";
        tabelaMed = "";
        linhaMed = "";
        foto = "";
        foto2 = "";
        foto3 = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return !codigo.isEmpty() ? codigo.trim().replace("  ", " ") : "";
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return (referencia.equals(codigoBarras) || referencia.equals(codigo)) ? "" : referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras.length() > 15 ? codigoBarras.substring(0, 15) : codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome.length() > 250 ? nome.toUpperCase().substring(0, 250) : nome.toUpperCase().trim().replace("  ", " ");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao.length() > 250 ? descricao.toUpperCase().substring(0, 250) : descricao.toUpperCase().trim().replace("  ", " ");
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
        return (estoque % 1) > 0 ? "S" : "N";
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
        return (comissao > 0.0 || comissaoValor > 0.0) ? "S" : "N";

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
        return dataHoraCadastro != null ? dataHoraCadastro : DataHoraUtil.getDataHoraAtual();
    }

    public void setDataHoraCadastro(String dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getDataHoraAtualizacao() {
        return DataHoraUtil.getDataHoraAtual();
    }

    public Double getPrecoCompra() {
        return precoCompra == 0.0 ? precoCusto : precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getValorCompra() {
        return valorCompra == 0.0 ? precoCusto : valorCompra;
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

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
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

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public Double getComissaoValor() {
        return comissaoValor;
    }

    public void setComissaoValor(Double comissaoValor) {
        this.comissaoValor = comissaoValor;
    }

    public Double getFidelidadePontos() {
        return fidelidadePontos;
    }

    public void setFidelidadePontos(Double fidelidadePontos) {
        this.fidelidadePontos = fidelidadePontos;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double novoEstoque) {
        if (novoEstoque < 0.0) {
            this.estoque = 0.0;
        } else if (novoEstoque >= 1000000.0) {
            this.estoque = 0.0;
        } else {
            this.estoque = novoEstoque;
        }
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
        return "Migracao: " + DataHoraUtil.getDataAtual();
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLocal() {
        String localFormat = local.trim().replace("  ", " ");
        return localFormat.length() > 80 ? localFormat.substring(0, 80) : localFormat;
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
        return combCprodAnp.length() > 10 ? combCprodAnp.substring(0, 10) : combCprodAnp;
    }

    public void setCombCprodAnp(String combCprodAnp) {
        this.combCprodAnp = combCprodAnp;
    }

    public String getCombDescAnp() {
        return combDescAnp.length() > 100 ? combDescAnp.substring(0, 100) : combDescAnp;
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

    public Double getMedApresentacaoFpop() {
        return medApresentacaoFpop;
    }

    public void setMedApresentacaoFpop(Double medApresentacaoFpop) {
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
        return !codigoNcm.isEmpty() ? codigoNcm.substring(0, 2) : "00";
    }

    public Integer getIdGrupoTributacao() {
        return idGrupoTributacao;
    }

    public Integer getIdCfop() {
        if (!cstCsosn.isEmpty()) {
            if (cstCsosn.equals("500") || cstCsosn.equals("60")) {
                return 355;
            }
        }
        return 289;
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
        return margemIdeal;
    }

    public double getMargemFpop() {
        return margemFpo;
    }

    private Double calcularMargemLucro(Double preco, Double custo) {
        if (preco > 0.0 && preco > 0.0) {
            return ((preco - custo) / custo) * 100;
        }
        return 0.0;
    }

    public String getFoto() {
        return foto;
    }

    public String getFoto2() {
        return foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    // Metodos Acessores para implementar id em TREEMAP
    public String getCodigoNcm(TreeMap<String, String> mapaNcm) {
        String ncm = codigoNcm;
        return mapaNcm.getOrDefault(ncm, mapaNcm.get("00000000"));
    }

    public void setCodigoNcm(String codigoNcm) {
        this.codigoNcm = codigoNcm;
    }

    public String getCodigoCest(TreeMap<String, String> mapaCest) {
        String cest = codigoCest;
        return mapaCest.getOrDefault(cest, mapaCest.get("0000000"));
    }

    public void setCodigoCest(String codigoCest) {
        this.codigoCest = codigoCest;
    }

    public String getUnidadeMedida(TreeMap<String, String> mapaUnidade) {
        String unidade = unidadeMedida;
        return mapaUnidade.getOrDefault(unidade, mapaUnidade.get("UN"));
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
        if (cstCsosn.isEmpty()) {
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
        return codigo + " - " + codigoBarras + " > " + nome + " - R$ " + precoVenda;
    }
}
