package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Csosn {

    private String csosn;

    public Csosn() {
    }

    public Csosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    @Override
    public String toString() {
        return csosn;
    }
}
