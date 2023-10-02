package sistemas.SGBR.model.entidades;

/**
 *
 * @author supor
 */
public class Empresa {
    
    private String controle;
    private String cnpj;
    private String nomeFantasia;

    public Empresa() {
    }

    public Empresa(String controle, String cnpj, String nomeFantasia) {
        this.controle = controle;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return controle + " - " + nomeFantasia + " - " + cnpj;
    }
    
}
