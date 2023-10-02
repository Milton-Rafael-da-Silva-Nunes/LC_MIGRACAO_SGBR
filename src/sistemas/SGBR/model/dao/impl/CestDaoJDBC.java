package sistemas.SGBR.model.dao.impl;

import sistemas.SGBR.model.dao.CestDao;
import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.LC_SISTEMAS.model.entidades.Cest;

/**
 *
 * @author supor
 */
public class CestDaoJDBC implements CestDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public CestDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Cest> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT cest FROM testoque WHERE CHAR_LENGTH(cest)=7 AND cest>0 GROUP BY cest");
            rs = st.executeQuery();

            List<Cest> lista = new ArrayList<>();

            while (rs.next()) {
                Cest cest = instanciacaoCest(rs);
                lista.add(cest);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar cest em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeResultSet(rs);
            FirebirdConnector.closeStatement(st);
        }
    }

    @Override
    public void insert(Cest cest) {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO cest(cest, ncm, descricao) "
                    + "VALUES (? , ?, ?)");

            if (!cestExiste(cest.getCest())) { // // Verificar se o Cest já existe antes de inserir no LC.
                st.setString(1, cest.getCest());
                st.setString(2, "00000000");
                st.setString(3, "");
                st.executeUpdate();
                System.out.println("CEST inserido: " + cest.getCest());
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir cest em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    // Metodo para instanciar OBJ e separar responsabilidade.
    private Cest instanciacaoCest(ResultSet rs) throws SQLException {
        Cest cest = new Cest();
        cest.setCest(rs.getString("cest").trim());
        return cest;
    }

    // Metodo para verificar se a unidade já existe na tabela do LC SISTEMAS.
    private boolean cestExiste(String cest) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM cest WHERE cest = ?");
            st.setString(1, cest);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, a unidade existe
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
