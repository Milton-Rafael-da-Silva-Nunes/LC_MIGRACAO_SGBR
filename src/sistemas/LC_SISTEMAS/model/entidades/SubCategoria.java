package sistemas.LC_SISTEMAS.model.entidades;

import util.DataHoraUtil;

/**
 *
 * @author supor
 */
public class SubCategoria {

    private Integer idCategoria;
    private String nome;
    private Integer ativo;

    public SubCategoria() {
        idCategoria = 1;
        ativo = 1;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataHoraAlteracao() {
        return DataHoraUtil.getDataHoraAtual();
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
