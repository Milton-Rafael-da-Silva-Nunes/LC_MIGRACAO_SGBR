package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.SGBR.model.dao.EmpresaDao;
import sistemas.SGBR.model.entidades.Empresa;

/**
 *
 * @author supor
 */
public class EmpresaDaoJDBC implements EmpresaDao {

    private Connection conn;

    public EmpresaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Empresa> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM TEMITENTE");
            rs = st.executeQuery();

            List<Empresa> lista = new ArrayList<>();

            while (rs.next()) {
                Empresa emp = instanciacaoEmpresa(rs);
                lista.add(emp);
            }
            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar empresas em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeResultSet(rs);
            FirebirdConnector.closeStatement(st);
        }
    }

    @Override
    public Empresa findById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM TEMITENTE WHERE controle = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Empresa emp = instanciacaoEmpresa(rs);
                return emp;
            }
            return null; // Retorno obrigadoria devito o retorno do metodo

        } catch (SQLException e) {
            throw new DbException("Error ao buscar empresa em fingByid: " + e.getMessage());
        } finally {
            FirebirdConnector.closeResultSet(rs);
            FirebirdConnector.closeStatement(st);
        }
    }

    private Empresa instanciacaoEmpresa(ResultSet rs) throws SQLException {
        String controle = rs.getString("controle");
        String cnpj = rs.getString("cnpj");
        String nomeFantasia = rs.getString("nomeFantasia");

        if (controle != null && !controle.isEmpty() && nomeFantasia != null && !nomeFantasia.isEmpty()) {
            Empresa empresa = new Empresa();
            empresa.setControle(controle);
            empresa.setCnpj(cnpj);
            empresa.setNomeFantasia(nomeFantasia);
            return empresa;
        } else {
            throw new DbException("Dados de empresa inválidos ou ausentes! \n\n" + "Atenção: Codigo da empresa ou Nome não preenchidos.");
        }
    }
}
