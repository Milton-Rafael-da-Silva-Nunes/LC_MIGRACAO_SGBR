package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Ncm {
    
    private String ncm;

    public Ncm() {
    }

    public Ncm(String ncm) {
        this.ncm = ncm;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    @Override
    public String toString() {
        return ncm;
    }
}
