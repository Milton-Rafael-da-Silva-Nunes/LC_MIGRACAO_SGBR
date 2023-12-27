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
import static util.ObjetoUtil.removerCaracteresEspeciais;

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
            st = conn1.prepareStatement("SELECT unidade FROM testoque WHERE unidade IS NOT NULL AND unidade <> '' GROUP BY unidade");
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

            if (!unidadeExiste(unidade.getDescricao())) { // Verificar se a unidade já existe antes de inserir no LC.
                st.setString(1, unidade.getDescricao());
                st.setString(2, unidade.getNome());
                st.setDouble(3, unidade.getFatorConversao());
                st.setString(4, unidade.getDataHoraAlteracao());
                st.setInt(5, unidade.getAtivo());
                st.executeUpdate();
                System.out.println("UNIDADE inserida: " + unidade.getDescricao());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException("Erro ao inserir unidade em metodo insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    // Metodo para instanciar OBJ e separar responsabilidade.
    private Unidade instanciacaoUnidade(ResultSet rs) throws SQLException {
        Unidade obj = new Unidade();
        obj.setDescricao(removerCaracteresEspeciais(rs.getString("unidade")));
        return obj;
    }

    // Metodo para verificar se a unidade já existe na tabela do LC SISTEMAS.
    private boolean unidadeExiste(String descricao) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM unidade WHERE descricao = ? COLLATE utf8_general_ci");
            st.setString(1, descricao);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, a unidade existe
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
