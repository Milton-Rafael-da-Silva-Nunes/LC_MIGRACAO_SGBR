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
import sistemas.SGBR.model.dao.UnidadeDao;
import sistemas.LC_SISTEMAS.model.entidades.Unidade;
import util.DataHoraUtil;

/**
 *
 * @author supor
 */
public class UnidadeDaoJDBC implements UnidadeDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public UnidadeDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Unidade> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT unidade FROM testoque GROUP BY unidade");
            rs = st.executeQuery();

            List<Unidade> lista = new ArrayList<>();

            while (rs.next()) {
                Unidade un = instanciacaoUnidade(rs);
                lista.add(un);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar unidades em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Unidade unidade) {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO unidade(descricao, nome, fator_conversao, datahora_alteracao, ativo) "
                    + "VALUES (?, ?, ?, ?, ?)");

            if (!unidadeExiste(unidade.getUnidade())) { // Verificar se a unidade já existe antes de inserir no LC.
                st.setString(1, unidade.getUnidade());
                st.setString(2, unidade.getUnidade() + " - 1");
                st.setDouble(3, 1.0);
                st.setString(4, DataHoraUtil.getDataHoraAtual());
                st.setInt(5, 1);
                st.executeUpdate();
                System.out.println("UNIDADE inserida: " + unidade.getUnidade());
            }
        } catch (SQLException ex) {
            throw new DbException("Erro ao inserir unidades em metodo insert: " + ex.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    // Metodo para instanciar OBJ e separar responsabilidade.
    private Unidade instanciacaoUnidade(ResultSet rs) throws SQLException {
        String unidade = rs.getString("unidade");

        if (unidade != null && !unidade.equals("")) {
            Unidade obj = new Unidade();
            obj.setUnidade(unidade);
            return obj;
        } else {
            return new Unidade("UN");
        }
    }

    // Metodo para verificar se a unidade já existe na tabela do LC SISTEMAS.
    private boolean unidadeExiste(String descricao) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM unidade WHERE descricao = ?");
            st.setString(1, descricao);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, a unidade existe
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
