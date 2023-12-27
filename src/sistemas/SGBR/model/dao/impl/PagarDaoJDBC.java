package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import sistemas.LC_SISTEMAS.model.entidades.Pagar;
import sistemas.SGBR.model.dao.PagarDao;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class PagarDaoJDBC implements PagarDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public PagarDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    private TreeMap<String, String> mapaIdFornecedor;

    @Override
    public List<Pagar> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            List<Pagar> lista = new ArrayList<>();

            st = conn1.prepareStatement("SELECT * FROM tpagar WHERE cancelada = 'NÂO' AND quitada = 'NÂO';");
            rs = st.executeQuery();

            while (rs.next()) {
                Pagar pagar = instaciacaoPagar(rs);
                lista.add(pagar);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar marca em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Pagar pagar) {
        PreparedStatement st = null;

        mapaIdFornecedor = getMapaIdFornecedor();

        try {
            st = conn2.prepareStatement("INSERT INTO pagar(id_usuario, id_empresa, id_pagamento, id_planocontas, id_fornecedor, id_contamovimento, tipo, status, documento, numero_nf, lancamento, emissao, vencimento, competencia, parcela, valor_original, valor, valor_desc, valor_pag, data_pag, juros_pag, multa_pag, multa, juros, agencia, conta, conciliado, numero_cheque, numero_boleto, historico, valor_arec, obs) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, pagar.getIdUsuario());
            st.setInt(2, pagar.getIdEmpresa());
            st.setInt(3, pagar.getIdPagamento());
            st.setInt(4, pagar.getIdPlanoContas());
            st.setString(5, pagar.getFornecedorNome(mapaIdFornecedor));
            st.setInt(6, pagar.getIdContaMovimento());
            st.setString(7, pagar.getTipo());
            st.setString(8, pagar.getStatus());
            st.setString(9, pagar.getDocumento());
            st.setString(10, pagar.getNumeroNf());
            st.setString(11, pagar.getLancamento());
            st.setString(12, pagar.getEmissao());
            st.setString(13, pagar.getVencimento());
            st.setString(14, pagar.getCompetencia());
            st.setString(15, pagar.getParcela());
            st.setDouble(16, pagar.getValorOriginal());
            st.setDouble(17, pagar.getValor());
            st.setDouble(18, pagar.getValorDesc());
            st.setDouble(19, pagar.getValorPag());
            st.setString(20, pagar.getDataPag());
            st.setDouble(21, pagar.getJurosPag());
            st.setDouble(22, pagar.getMultaPag());
            st.setDouble(23, pagar.getMulta());
            st.setDouble(24, pagar.getJuros());
            st.setString(25, pagar.getAgencia());
            st.setString(26, pagar.getConta());
            st.setString(27, pagar.getConcilado());
            st.setString(28, pagar.getNumeroCheque());
            st.setString(29, pagar.getNumeroBoleto());
            st.setString(30, pagar.getHistorico());
            st.setDouble(31, pagar.getValorArec());
            st.setString(32, pagar.getObs());
            st.executeUpdate();
            System.out.println("PAGAR inserido: " + pagar);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException("Erro ao inserir pagar em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    private Pagar instaciacaoPagar(ResultSet rs) throws SQLException {
        Pagar obj = new Pagar();
        obj.setLancamento(rs.getString("datahoracadastro"));
        obj.setEmissao(rs.getString("datahoracadastro"));
        obj.setVencimento(rs.getString("datavencimento"));
        obj.setDocumentoSgbrPagar(ObjetoUtil.removerCaracteresEspeciais(rs.getString("documento")));
        obj.setDescricaoLancamento(ObjetoUtil.removerCaracteresEspeciais(rs.getString("descricaolancamento")));
        obj.setCodFornecedor(ObjetoUtil.validarString(rs.getString("codfornecedor")));
        obj.setFornecedorNome(ObjetoUtil.removerCaracteresEspeciais(rs.getString("fornecedor")));
        obj.setEspecie(ObjetoUtil.removerCaracteresEspeciais(rs.getString("especie")));
        obj.setCentroCusto(ObjetoUtil.removerCaracteresEspeciais(rs.getString("centrocusto")));
        double valor = rs.getDouble("valororiginal") - rs.getDouble("valorpago");
        obj.setValorOriginal(valor);
        obj.setValor(valor);
        obj.setParcela(rs.getString("nparcela") + "/" + rs.getString("qtdeparcela"));
        return obj;
    }

    private TreeMap<String, String> getMapaIdFornecedor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap<>();

        try {
            st = conn2.prepareStatement("SELECT id, razao_social FROM fornecedor;");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("razao_social"), rs.getString("id"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            MysqlConnector.closeResultSet(rs);
            MysqlConnector.closeStatement(st);
        }
        return map;
    }
}
