package sistemas.LC_SISTEMAS.model.enuns;

/**
 *
 * @author Rafael Nunes
 */
public enum Estoque {

    SIM("sim"),
    NAO("nao");
    
    private String estoque;

    private Estoque(String estoque) {
        this.estoque = estoque;
    }

    public String getEstoque() {
        return estoque;
    }
}
