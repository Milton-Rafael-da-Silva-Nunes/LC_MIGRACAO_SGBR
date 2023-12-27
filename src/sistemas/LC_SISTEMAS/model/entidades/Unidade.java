package sistemas.LC_SISTEMAS.model.entidades;

import util.DataHoraUtil;

/**
 *
 * @author supor
 */
public class Unidade {
    
    private String descricao;
    private Double fatorConversao;
    private Integer ativo;
    

    public Unidade() {
        fatorConversao = 1.0;
        ativo = 1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return descricao + " - " + fatorConversao;
    }

    public Double getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(Double fatorConversao) {
        this.fatorConversao = fatorConversao;
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
        return descricao;
    }
}
