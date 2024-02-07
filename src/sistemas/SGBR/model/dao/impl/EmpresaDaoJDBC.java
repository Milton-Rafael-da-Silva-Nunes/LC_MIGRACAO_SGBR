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
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
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
        String controle = ObjetoUtil.validarString(rs.getString("controle"));
        String nomeFantasia = ObjetoUtil.validarNomeFantasia(rs.getString("razaosocial"), rs.getString("nomeFantasia"));

        if (!controle.isEmpty() && !nomeFantasia.isEmpty()) {
            Empresa empresa = new Empresa();
            empresa.setControle(controle);
            empresa.setNomeFantasia(nomeFantasia);
            empresa.setRazaoSocial(ObjetoUtil.validarString(rs.getString("razaosocial")));
            empresa.setEndereco(ObjetoUtil.validarString(rs.getString("endereco")));
            empresa.setComplemento(ObjetoUtil.validarString(rs.getString("complemento")));
            empresa.setBairro(ObjetoUtil.validarString(rs.getString("bairro")));
            empresa.setCidade(ObjetoUtil.validarString(rs.getString("cidade")));
            empresa.setUf(ObjetoUtil.validarString(rs.getString("uf")));
            empresa.setCep(ObjetoUtil.validarString(rs.getString("cep")));
            empresa.setCnpj(ObjetoUtil.validarString(rs.getString("cnpj")));
            empresa.setIe(ObjetoUtil.validarString(rs.getString("ie")));
            empresa.setTelefone(ObjetoUtil.validarString(rs.getString("telefone")));
            empresa.setEmail(ObjetoUtil.validarString(rs.getString("email")));
            empresa.setCrt(ObjetoUtil.validarString(rs.getString("crt")));
            empresa.setNumero(ObjetoUtil.validarString(rs.getString("numero")));

            return empresa;
            
        } else {
            throw new DbException("Dados de empresa inválidos ou ausentes! \n\n" + "Atenção: Codigo da empresa ou Nome não preenchidos.");
        }
    }
}
