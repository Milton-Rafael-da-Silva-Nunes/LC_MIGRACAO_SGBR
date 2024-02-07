package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.SGBR.model.dao.CsosnDao;
import sistemas.LC_SISTEMAS.model.entidades.Csosn;

/**
 *
 * @author Rafael Nunes
 */
public class CsosnDaoJDBC implements CsosnDao {

    private Connection conn;

    public CsosnDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Csosn> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT csosn FROM testoque GROUP BY csosn");
            rs = st.executeQuery();

            List<Csosn> lista = new ArrayList<>();

            while (rs.next()) {
                Csosn csosn = instaciacaoCsosn(rs);
                lista.add(csosn);
            }

            return lista;
        } catch (SQLException e) {
            throw new DbException("Error ao buscar csosn em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeResultSet(rs);
            FirebirdConnector.closeStatement(st);
        }
    }

    private Csosn instaciacaoCsosn(ResultSet rs) throws SQLException {
        String csosn = rs.getString("csosn");
        
        if(csosn != null && !csosn.equals("")) {
            Csosn obj = new Csosn();
            obj.setCsosn(csosn.trim());
            return obj;
        }else {
            return new Csosn("102");
        }
    }
}
