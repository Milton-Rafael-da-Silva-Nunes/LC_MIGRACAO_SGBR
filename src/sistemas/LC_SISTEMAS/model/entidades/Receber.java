package sistemas.LC_SISTEMAS.model.entidades;

import java.util.TreeMap;
import util.DataHoraUtil;

/**
 *
 * @author Rafael Nunes
 */
public class Receber {

    private Integer idEmpresa;
    private Integer idCliente;
    private Integer idUsuario;
    private Integer idCobrador;
    private Integer idVendedor;
    private Integer idOperador;
    private Integer idPagamento;
    private Integer idPlanoContas;
    private Integer idContaMovimento;
    private Integer idConvenio;
    private String tipo;
    private String status;
    private String documento;
    private String nDocumento;
    private String lancamento;
    private String emissao;
    private String vencimento;
    private String parcela;
    private Double valorOriginal;
    private Double valorRec;
    private String dataRec;
    private Double jurosRec;
    private Double multaRec;
    private Double retencaoRec;
    private Double valorArec;
    private Double valorDesconto;
    private String agencia;
    private String conta;
    private String concilado;
    private String numeroCheque;
    private String numeroBoleto;
    private String historico;
    private String obs;
    // Atributos do sistema SGBR
    private String descricaoLancamento;
    private String codigoCliente;
    private String cliente;
    private String especie;
    private String centroCusto;
    private String planoConta;
    private String obsReceber;

    public Receber() {
        idEmpresa = 1;
        idUsuario = 1;
        idCobrador = 0;
        idVendedor = 0;
        idOperador = 0;
        idPagamento = 6;
        idPlanoContas = 29;
        idContaMovimento = 1;
        idConvenio = 0;
        tipo = "FD";
        status = "CA";
        documento = "";
        parcela = "1/1";
        valorRec = 0.0;
        dataRec = null;
        jurosRec = 0.0;
        multaRec = 0.0;
        retencaoRec = 0.0;
        valorArec = 0.0;
        valorDesconto = 0.0;
        agencia = "";
        conta = "";
        concilado = "";
        numeroCheque = "";
        numeroBoleto = "";
        historico = "MIGRACAO: " + DataHoraUtil.getDataAtual();
    }

    public Receber(Integer idEmpresa, Integer idCliente, Integer idUsuario, Integer idCobrador, Integer idVendedor, Integer idOperador, Integer idPagamento, Integer idPlanoContas, Integer idContaMovimento, Integer idConvenio, String tipo, String status, String documento, String nDocumento, String lancamento, String emissao, String vencimento, String parcela, Double valorOriginal, Double valorRec, String dataRec, Double jurosRec, Double multaRec, Double retencaoRec, Double valorArec, Double valorDesconto, String agencia, String conta, String concilado, String numeroCheque, String numeroBoleto, String historico, String obs) {
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idCobrador = idCobrador;
        this.idVendedor = idVendedor;
        this.idOperador = idOperador;
        this.idPagamento = idPagamento;
        this.idPlanoContas = idPlanoContas;
        this.idContaMovimento = idContaMovimento;
        this.idConvenio = idConvenio;
        this.tipo = tipo;
        this.status = status;
        this.documento = documento;
        this.nDocumento = nDocumento;
        this.lancamento = lancamento;
        this.emissao = emissao;
        this.vencimento = vencimento;
        this.parcela = parcela;
        this.valorOriginal = valorOriginal;
        this.valorRec = valorRec;
        this.dataRec = dataRec;
        this.jurosRec = jurosRec;
        this.multaRec = multaRec;
        this.retencaoRec = retencaoRec;
        this.valorArec = valorArec;
        this.valorDesconto = valorDesconto;
        this.agencia = agencia;
        this.conta = conta;
        this.concilado = concilado;
        this.numeroCheque = numeroCheque;
        this.numeroBoleto = numeroBoleto;
        this.historico = historico;
        this.obs = obs;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCobrador() {
        return idCobrador;
    }

    public void setIdCobrador(Integer idCobrador) {
        this.idCobrador = idCobrador;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
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

    public Integer getIdContaMovimento() {
        return idContaMovimento;
    }

    public void setIdContaMovimento(Integer idContaMovimento) {
        this.idContaMovimento = idContaMovimento;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
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

    public String getnDocumento() {
        if (nDocumento != null || !nDocumento.isEmpty()) {
            return nDocumento;
        } else {
            return "";
        }
    }

    public void setnDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
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

    public Double getValorRec() {
        return valorRec;
    }

    public void setValorRec(Double valorRec) {
        this.valorRec = valorRec;
    }

    public String getDataRec() {
        return dataRec;
    }

    public void setDataRec(String dataRec) {
        this.dataRec = dataRec;
    }

    public Double getJurosRec() {
        return jurosRec;
    }

    public void setJurosRec(Double jurosRec) {
        this.jurosRec = jurosRec;
    }

    public Double getMultaRec() {
        return multaRec;
    }

    public void setMultaRec(Double multaRec) {
        this.multaRec = multaRec;
    }

    public Double getRetencaoRec() {
        return retencaoRec;
    }

    public void setRetencaoRec(Double retencaoRec) {
        this.retencaoRec = retencaoRec;
    }

    public Double getValorArec() {
        return valorArec;
    }

    public void setValorArec(Double valorArec) {
        this.valorArec = valorArec;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
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
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getObs() {
        return "DESC: " + descricaoLancamento + "\nCLI: " + cliente + "\nESPEC: " + especie + "\nCENTRO CUS: " + centroCusto + "\nPLANO: " + planoConta + "\nOBS: " + obsReceber;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    // Metodos acessores do sistema SGBR
    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public String getCodigoCliente(TreeMap<String, String> mapaCodigoCliente) {
        String codigo = codigoCliente.trim();
        return mapaCodigoCliente.getOrDefault(codigo, mapaCodigoCliente.get("1"));
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
    }

    public String getPlanoConta() {
        return planoConta;
    }

    public void setPlanoConta(String planoConta) {
        this.planoConta = planoConta;
    }

    public String getObsReceber() {
        return obsReceber;
    }

    public void setObsReceber(String obsReceber) {
        this.obsReceber = obsReceber;
    }
    
    @Override
    public String toString() {
        return cliente + " " + valorOriginal + " - " + lancamento + " - " + vencimento;
    }
}
