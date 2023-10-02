package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Cidades {
    
    private Integer id;
    private String codigoCidade;
    private String idUf;
    private String nome;
    
    private Estados estado;

    public Cidades() {
    }

    public Cidades(Integer id, String codigoCidade, String idUf, String nome, Estados estado) {
        this.id = id;
        this.codigoCidade = codigoCidade;
        this.idUf = idUf;
        this.nome = nome;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getIdUf() {
        return idUf;
    }

    public void setIdUf(String idUf) {
        this.idUf = idUf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + estado;
    }
}
