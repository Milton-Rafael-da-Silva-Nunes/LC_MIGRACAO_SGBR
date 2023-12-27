package sistemas.LC_SISTEMAS.model.entidades;

import java.util.TreeMap;
import util.DataHoraUtil;

/**
 *
 * @author Rafael Nunes
 */
public class Pagar {

    private Integer idUsuario;
    private Integer idEmpresa;
    private Integer idPagamento;
    private Integer idPlanoContas;
    private Integer idFornecedor;
    private Integer idContaMovimento;
    private String tipo;
    private String status;
    private String documento;
    private String numeroNf;
    private String lancamento;
    private String emissao;
    private String vencimento;
    private String competencia;
    private String parcela;
    private Double valorOriginal;
    private Double valor;
    private Double valorDesc;
    private Double valorPag;
    private String dataPag;
    private Double jurosPag;
    private Double multaPag;
    private Double multa;
    private Double juros;
    private String agencia;
    private String conta;
    private String concilado;
    private String numeroCheque;
    private String numeroBoleto;
    private Double valorArec;
    // Atributos do sistema SGBR
    private String codFornecedor;
    private String fornecedorNome;
    private String documentoSgbrPagar;
    private String descricaoLancamento;
    private String especie;
    private String centroCusto;

    public Pagar() {
        idUsuario = 1;
        idEmpresa = 1;
        idPagamento = 46;
        idPlanoContas = 109;
        idContaMovimento = 1;
        tipo = "FP";
        status = "CA";
        documento = "";
        numeroNf = "";
        valorDesc = 0.0;
        valorPag = 0.0;
        jurosPag = 0.0;
        multaPag = 0.0;
        multa = 0.0;
        juros = 0.0;
        agencia = "";
        conta = "";
        numeroCheque = "";
        numeroBoleto = "";
        valorArec = 0.0;
    }

    public Pagar(Integer idUsuario, Integer idEmpresa, Integer idPagamento, Integer idPlanoContas, Integer idFornecedor, Integer idContaMovimento, String tipo, String status, String documento, String numeroNf, String lancamento, String emissao, String vencimento, String competencia, String parcela, Double valorOriginal, Double valor, Double valorDesc, Double valorPag, String dataPag, Double jurosPag, Double multaPag, Double multa, Double juros, String agencia, String conta, String concilado, String numeroCheque, String numeroBoleto, Double valorArec, String codFornecedor, String fornecedorNome, String documentoSgbrPagar, String descricaoLancamento, String especie, String centroCusto) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
        this.idPagamento = idPagamento;
        this.idPlanoContas = idPlanoContas;
        this.idFornecedor = idFornecedor;
        this.idContaMovimento = idContaMovimento;
        this.tipo = tipo;
        this.status = status;
        this.documento = documento;
        this.numeroNf = numeroNf;
        this.lancamento = lancamento;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.competencia = competencia;
        this.parcela = parcela;
        this.valorOriginal = valorOriginal;
        this.valor = valor;
        this.valorDesc = valorDesc;
        this.valorPag = valorPag;
        this.dataPag = dataPag;
        this.jurosPag = jurosPag;
        this.multaPag = multaPag;
        this.multa = multa;
        this.juros = juros;
        this.agencia = agencia;
        this.conta = conta;
        this.concilado = concilado;
        this.numeroCheque = numeroCheque;
        this.numeroBoleto = numeroBoleto;
        this.valorArec = valorArec;
        this.codFornecedor = codFornecedor;
        this.fornecedorNome = fornecedorNome;
        this.documentoSgbrPagar = documentoSgbrPagar;
        this.descricaoLancamento = descricaoLancamento;
        this.especie = especie;
        this.centroCusto = centroCusto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdPlanoContas() {
        return idPlanoContas;
    }

    public void setIdPlanoContas(Integer idPlanoContas) {
        this.idPlanoContas = idPlanoContas;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdContaMovimento() {
        return idContaMovimento;
    }

    public void setIdContaMovimento(Integer idContaMovimento) {
        this.idContaMovimento = idContaMovimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(String numeroNf) {
        this.numeroNf = numeroNf;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(Double valorDesc) {
        this.valorDesc = valorDesc;
    }

    public Double getValorPag() {
        return valorPag;
    }

    public void setValorPag(Double valorPag) {
        this.valorPag = valorPag;
    }

    public String getDataPag() {
        return dataPag;
    }

    public void setDataPag(String dataPag) {
        this.dataPag = dataPag;
    }

    public Double getJurosPag() {
        return jurosPag;
    }

    public void setJurosPag(Double jurosPag) {
        this.jurosPag = jurosPag;
    }

    public Double getMultaPag() {
        return multaPag;
    }

    public void setMultaPag(Double multaPag) {
        this.multaPag = multaPag;
    }

    public Double getMulta() {
        return multa;
    }

    public void setMulta(Double multa) {
        this.multa = multa;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getConcilado() {
        return concilado;
    }

    public void setConcilado(String concilado) {
        this.concilado = concilado;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getHistorico() {
        return "MIGRACAO: " + DataHoraUtil.getDataAtual();
    }

    public Double getValorArec() {
        return valorArec;
    }

    public void setValorArec(Double valorArec) {
        this.valorArec = valorArec;
    }

    public String getObs() {
        return "FORNEC: " + fornecedorNome + "\nDOC: " + documentoSgbrPagar + "\nESPEC: " + especie + "\nCENTRO: " + centroCusto + "\nHIST: " + descricaoLancamento;
    }

    // Metodos acessores do sistema SGBR
    public void setCodFornecedor(String codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getFornecedorNome(TreeMap<String, String> mapaNomeFornecedor) {
        String nomeFornecedor = fornecedorNome.trim();
        return mapaNomeFornecedor.getOrDefault(nomeFornecedor, mapaNomeFornecedor.get("PADRAO"));
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    public void setDocumentoSgbrPagar(String documentoSgbrPagar) {
        this.documentoSgbrPagar = documentoSgbrPagar;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
    }

    @Override
    public String toString() {
        return codFornecedor + " " + fornecedorNome + " - " + lancamento + " - " + vencimento + " R$ " + valorOriginal;
    }
}
