package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.LC_SISTEMAS.model.entidades.Pagar;
import sistemas.SGBR.model.dao.PagarDao;

/**
 *
 * @author Rafael Nunes
 */
public class PagarDaoJDBC implements PagarDao{
    
    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public PagarDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Pagar> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            List<Pagar> lista = new ArrayList<>();
            
            st = conn1.prepareStatement("");
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
