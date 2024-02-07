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
import sistemas.LC_SISTEMAS.model.entidades.Fabricante;
import sistemas.SGBR.model.dao.FabricanteDao;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class FabricanteDaoJDBC implements FabricanteDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public FabricanteDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Fabricante> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT marca FROM testoque WHERE marca IS NOT NULL AND marca <> '' GROUP BY marca");
            rs = st.executeQuery();

            List<Fabricante> lista = new ArrayList<>();

            while (rs.next()) {
                Fabricante fab = instanciacaoFabricante(rs);
                lista.add(fab);
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
    public void insert(Fabricante fabricante) {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO fabricante(nome, datahora_alteracao, ativo) "
                    + "VALUES (?, ?, ?)");

            if (!fabricanteExiste(fabricante.getNome())) {
                st.setString(1, fabricante.getNome());
                st.setString(2, fabricante.getDataHoraAlteracao());
                st.setInt(3, fabricante.getAtivo());
                st.executeUpdate();
                System.out.println("FABRICANTE inserido: " + fabricante.getNome());
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir ncm em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    private Fabricante instanciacaoFabricante(ResultSet rs) throws SQLException {
        Fabricante obj = new Fabricante();
        obj.setNome(ObjetoUtil.removerCaracteresEspeciais(rs.getString("marca")));
        return obj;
    }

    private boolean fabricanteExiste(String nome) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            st = conn2.prepareStatement("SELECT 1 FROM fabricante WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            
            return rs.next();
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
