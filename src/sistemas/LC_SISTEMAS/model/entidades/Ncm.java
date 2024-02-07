package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author Rafael Nunes
 */
public class Ncm {
    
    private String ncm;
    private String ex;
    private String descricao;
    private Double aliquotaNacional;
    private Double aliquotaInternacional;
    private Double aliquotaEstadual;
    private Double aliquotaMunicipal;
    private String vigencialInicio = null;
    private String vigenciaFim = null;
    private String chave;
    private String versao;
    private Integer ativo;

    public Ncm() {
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAliquotaNacional() {
        return aliquotaNacional;
    }

    public void setAliquotaNacional(Double aliquotaNacional) {
        this.aliquotaNacional = aliquotaNacional;
    }

    public Double getAliquotaInternacional() {
        return aliquotaInternacional;
    }

    public void setAliquotaInternacional(Double aliquotaInternacional) {
        this.aliquotaInternacional = aliquotaInternacional;
    }

    public Double getAliquotaEstadual() {
        return aliquotaEstadual;
    }

    public void setAliquotaEstadual(Double aliquotaEstadual) {
        this.aliquotaEstadual = aliquotaEstadual;
    }

    public Double getAliquotaMunicipal() {
        return aliquotaMunicipal;
    }

    public void setAliquotaMunicipal(Double aliquotaMunicipal) {
        this.aliquotaMunicipal = aliquotaMunicipal;
    }

    public String getVigencialInicio() {
        return vigencialInicio;
    }

    public String getVigenciaFim() {
        return vigenciaFim;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return ncm;
    }
}
