package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Fabricante {
    
    private String nome;

    public Fabricante() {
    }

    public Fabricante(String nome) {
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
