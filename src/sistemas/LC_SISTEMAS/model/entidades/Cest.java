package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Cest {
    
    private String cest;

    public Cest() {
    }

    public Cest(String cest) {
        this.cest = cest;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }
    
    @Override
    public String toString() {
        return cest;
    }
}
