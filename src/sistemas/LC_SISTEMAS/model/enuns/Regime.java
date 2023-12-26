package sistemas.LC_SISTEMAS.model.enuns;

/**
 *
 * @author Rafael Nunes
 */
public enum Regime {
    
    SIMPLES("simples"),
    NORMAL("normal");
    
    private String regime;

    private Regime(String regime) {
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }
}
