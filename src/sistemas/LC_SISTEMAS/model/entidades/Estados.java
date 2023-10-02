package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Estados {
    
    private Integer id;
    private String idUf;
    private String uf;
    private String nome;

    public Estados() {
    }

    public Estados(Integer id, String idUf, String uf, String nome) {
        this.id = id;
        this.idUf = idUf;
        this.uf = uf;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdUf() {
        return idUf;
    }

    public void setIdUf(String idUf) {
        this.idUf = idUf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return id + " - " + uf;
    }
}
