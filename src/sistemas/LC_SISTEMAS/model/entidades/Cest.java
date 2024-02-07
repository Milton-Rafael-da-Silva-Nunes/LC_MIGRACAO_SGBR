package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Cest {
    
    private String cest;
    private String ncm;
    private String descricao;

    public Cest() {
    }
    
    public Cest(String cest, String ncm, String descricao) {
        this.cest = cest;
        this.ncm = ncm;
        this.descricao = descricao;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return cest;
    }
}
