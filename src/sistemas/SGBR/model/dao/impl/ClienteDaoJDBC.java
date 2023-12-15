package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.LC_SISTEMAS.model.entidades.Cliente;
import sistemas.SGBR.model.dao.ClienteDao;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public ClienteDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Cliente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT * FROM tcliente WHERE cliente IS NOT NULL;");
            rs = st.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            
            while (rs.next()) {
                Cliente cliente = instanciacaoCliente(rs);
                lista.add(cliente);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar clientes em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Cliente instanciacaoCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNumeroCartao(rs.getString("controle"));
        cliente.setRazaoSocial(rs.getString("cliente"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setReferencia(rs.getString("complemento"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setCep(rs.getString("cep"));
        cliente.setTipo(ObjetoUtil.validarTipo(rs.getString("tipocliente")));
        cliente.setRg(rs.getString("rg"));
        cliente.setCpfCnpj(ObjetoUtil.validarCpfCnpj(rs.getString("cpf"), rs.getString("cnpj")));
        cliente.setIe(rs.getString("ie"));
        cliente.setIm(rs.getString("im"));
        cliente.setNascimentoAdi(rs.getString("datanascimento"));
        cliente.setDataCadastro(rs.getString("datahoracadastro"));
        cliente.setPaiAdi(rs.getString("pai"));
        cliente.setMaeAdi(rs.getString("mae"));
        cliente.setObs(ObjetoUtil.getObs(rs.getString("telefone"), rs.getString("celular"), "", rs.getString("obs")));
        cliente.setEmailAdi(rs.getString("email"));
        cliente.setAtivo(ObjetoUtil.getAtivo(rs.getString("ativo")));
        cliente.setNome(ObjetoUtil.validarNomeFantasia(rs.getString("cliente"), rs.getString("fantasia")));
        cliente.setLimiteCredito(rs.getDouble("limitecredito"));
        cliente.setConjuje(rs.getString("nomeconjuge"));
        cliente.setNumero(rs.getString("numero"));
        cliente.setSexoAdi(ObjetoUtil.validarSexo(rs.getString("sexo")));
        cliente.setCodigoCidade(rs.getString("codigocidadeibge"));
        return cliente;
    }

}
