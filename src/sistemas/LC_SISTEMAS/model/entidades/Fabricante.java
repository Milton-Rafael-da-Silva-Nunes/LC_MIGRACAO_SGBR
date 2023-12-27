package sistemas.LC_SISTEMAS.model.entidades;

import util.DataHoraUtil;

/**
 *
 * @author Rafael Nunes
 */
public class Fabricante {
    
    private String nome;
    private Integer ativo;

    public Fabricante() {
        ativo = 1;
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
