package sistemas.LC_SISTEMAS.model.entidades;

import util.DataHoraUtil;

/**
 *
 * @author supor
 */
public class Categoria {
    
    private String nome;
    private Double comissao;
    private String podeGourmet;
    private String datahoraAlteracao;
    private Integer ativo;

    public Categoria() {
        comissao = 0.0;
        podeGourmet = "S";
        ativo = 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getPodeGourmet() {
        return podeGourmet;
    }

    public String getDatahoraAlteracao() {
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
