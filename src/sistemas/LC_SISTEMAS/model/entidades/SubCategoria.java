package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class SubCategoria {

    private String nome;

    public SubCategoria() {
    }

    public SubCategoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
