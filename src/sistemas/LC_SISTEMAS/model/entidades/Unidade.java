package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Unidade {
    
    private String unidade;

    public Unidade() {
    }

    public Unidade(String unidade) {
        this.unidade = unidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return unidade;
    }
}
