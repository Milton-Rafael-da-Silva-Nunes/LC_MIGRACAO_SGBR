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
import sistemas.SGBR.model.dao.NcmDao;
import sistemas.LC_SISTEMAS.model.entidades.Ncm;

/**
 *
 * @author Rafael Nunes
 */
public class NcmDaoJDBC implements NcmDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public NcmDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Ncm> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT ncm FROM testoque WHERE CHAR_LENGTH(ncm)=8 AND ncm>0 GROUP BY ncm");
            rs = st.executeQuery();

            List<Ncm> lista = new ArrayList<>();

            while (rs.next()) {
                Ncm ncm = instaciacaoNcm(rs);
                lista.add(ncm);
            }

            return lista;
        } catch (SQLException e) {
            throw new DbException("Error ao buscar ncm em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeResultSet(rs);
            FirebirdConnector.closeStatement(st);
        }
    }

    @Override
    public void insert(Ncm ncm) {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO ncm (codigo, ex, descricao, aliquota_nacional, aliquota_internacional, aliquota_estadual, aliquota_municipal, vigenciainicio, vigenciafim, chave, versao, ativo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            if (!ncmExiste(ncm.getNcm())) {
                st.setString(1, ncm.getNcm());
                st.setString(2, ncm.getEx());
                st.setString(3, ncm.getDescricao());
                st.setDouble(4, ncm.getAliquotaNacional());
                st.setDouble(5, ncm.getAliquotaInternacional());
                st.setDouble(6, ncm.getAliquotaEstadual());
                st.setDouble(7, ncm.getAliquotaNacional());
                st.setString(8, ncm.getVigencialInicio());
                st.setString(9, ncm.getVigenciaFim());
                st.setString(10, ncm.getChave());
                st.setString(11, ncm.getVersao());
                st.setInt(12, ncm.getAtivo());
                st.executeUpdate();
                System.out.println("NCM inserido: " + ncm.getNcm());
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir ncm em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    // Metodo para instancia obj e separar responsabilidades.
    private Ncm instaciacaoNcm(ResultSet rs) throws SQLException {
        Ncm ncm = new Ncm();
        ncm.setNcm(rs.getString("ncm").trim());
        ncm.setEx("");
        ncm.setDescricao("");
        ncm.setAliquotaNacional(0.0);
        ncm.setAliquotaEstadual(0.0);
        ncm.setAliquotaMunicipal(0.0);
        ncm.setAliquotaInternacional(0.0);
        ncm.setVersao("");
        ncm.setChave("");
        ncm.setAtivo(1);
        return ncm;
    }

    // Metodo para verificar se o NCM já existe na tabela do LC SISTEMAS.
    private boolean ncmExiste(String ncm) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM ncm WHERE codigo = ?");
            st.setString(1, ncm);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, o NCM existe
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
