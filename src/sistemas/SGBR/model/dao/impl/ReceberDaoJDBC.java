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
import sistemas.LC_SISTEMAS.model.entidades.Receber;
import sistemas.SGBR.model.dao.ReceberDao;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class ReceberDaoJDBC implements ReceberDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public ReceberDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    private TreeMap<String, String> mapaIdCliente;

    @Override
    public List<Receber> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT * FROM treceber WHERE quitada = 'NÂO' AND cancelada = 'NÂO';");
            rs = st.executeQuery();

            List<Receber> lista = new ArrayList<>();

            while (rs.next()) {
                Receber receber = instaciacaoReceber(rs);
                lista.add(receber);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar contas receber em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Receber receber) {
        PreparedStatement st = null;

        mapaIdCliente = getMapaIdCliente();

        try {
            st = conn2.prepareStatement("INSERT INTO receber(id_empresa, id_cliente, id_usuario, id_cobrador, id_vendedor, id_operador, id_pagamento, id_planocontas, id_contamovimento, id_convenio, tipo, status, documento, n_documento, lancamento, emissao, vencimento, parcela, valor_original, valor_rec, data_rec, juros_rec, multa_rec, retencao_rec, valor_arec, valor_desconto, agencia, conta, conciliado, numero_cheque, numero_boleto, historico, obs) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, receber.getIdEmpresa());
            st.setString(2, receber.getCodigoCliente(mapaIdCliente));
            st.setInt(3, receber.getIdUsuario());
            st.setInt(4, receber.getIdCobrador());
            st.setInt(5, receber.getIdVendedor());
            st.setInt(6, receber.getIdOperador());
            st.setInt(7, receber.getIdPagamento());
            st.setInt(8, receber.getIdPlanoContas());
            st.setInt(9, receber.getIdContaMovimento());
            st.setInt(10, receber.getIdConvenio());
            st.setString(11, receber.getTipo());
            st.setString(12, receber.getStatus());
            st.setString(13, receber.getDocumento());
            st.setString(14, receber.getnDocumento());
            st.setString(15, receber.getLancamento());
            st.setString(16, receber.getEmissao());
            st.setString(17, receber.getVencimento());
            st.setString(18, receber.getParcela());
            st.setDouble(19, receber.getValorOriginal());
            st.setDouble(20, receber.getValorRec());
            st.setString(21, receber.getDataRec());
            st.setDouble(22, receber.getJurosRec());
            st.setDouble(23, receber.getMultaRec());
            st.setDouble(24, receber.getRetencaoRec());
            st.setDouble(25, receber.getValorArec());
            st.setDouble(26, receber.getValorDesconto());
            st.setString(27, receber.getAgencia());
            st.setString(28, receber.getConta());
            st.setString(29, receber.getConcilado());
            st.setString(30, receber.getNumeroCheque());
            st.setString(31, receber.getNumeroBoleto());
            st.setString(32, receber.getHistorico());
            st.setString(33, receber.getObs());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir receber em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    private Receber instaciacaoReceber(ResultSet rs) throws SQLException {
        Receber rec = new Receber();
        rec.setParcela(ObjetoUtil.validarString(rs.getString("nparcela") + "/" + rs.getString("qtdeparcela")));
        rec.setDescricaoLancamento(ObjetoUtil.validarString(rs.getString("descricaolancamento")));
        rec.setCodigoCliente(rs.getString("codcliente"));
        rec.setCliente(ObjetoUtil.validarString(rs.getString("cliente")));
        rec.setEspecie(ObjetoUtil.validarString(rs.getString("especie")));
        rec.setCentroCusto(ObjetoUtil.validarString(rs.getString("centrocusto")));
        rec.setPlanoConta(ObjetoUtil.validarString(rs.getString("planoconta")));
        rec.setLancamento(rs.getString("datahoracadastro"));
        rec.setEmissao(rs.getString("datahoracadastro"));
        rec.setVencimento(rs.getString("datavencimento"));
        rec.setnDocumento(ObjetoUtil.validarString(rs.getString("documento")));
        double valororiginal = rs.getDouble("valororiginal") - rs.getDouble("valorpago");
        rec.setValorOriginal(valororiginal);
        rec.setObsReceber(ObjetoUtil.validarString(rs.getString("obs")));
        return rec;
    }

    private TreeMap<String, String> getMapaIdCliente() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap();

        try {
            st = conn2.prepareStatement("SELECT id, numero_cartao FROM cliente WHERE numero_cartao <> '';");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("numero_cartao"), rs.getString("id"));
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
