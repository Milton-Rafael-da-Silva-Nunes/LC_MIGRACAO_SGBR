package sistemas.SGBR.model.dao.impl;

import sistemas.SGBR.model.dao.FornecedorDao;
import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import sistemas.LC_SISTEMAS.model.entidades.Fornecedor;
import util.ObjetoUtil;

/**
 *
 * @author supor
 */
public class FornecedorDaoJDBC implements FornecedorDao {

    private Connection conn1;
    private Connection conn2;

    public FornecedorDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }
    
    private TreeMap<String, String> mapaCidade;
    private TreeMap<String, String> mapaEstado;

    @Override
    public List<Fornecedor> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT * FROM tfornecedor WHERE nomefantasia IS NOT NULL");
            rs = st.executeQuery();

            List<Fornecedor> lista = new ArrayList<>();

            while (rs.next()) {
                Fornecedor fornecedor = instanciacaoFornecedor(rs);
                lista.add(fornecedor);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar fornecedores em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Fornecedor fornecedor) {
        PreparedStatement st = null;

        mapaCidade = getMapaCidade();
        mapaEstado = getMapaEstado();
        
        try {
            st = conn2.prepareStatement("INSERT INTO fornecedor(id_empresa, id_estado, id_cidade, id_planocontas, tipo, tipo_fornecedor, nome, razao_social, cnpj_cpf, ie, endereco, numero, bairro, cep, fone, fax, email_site, obs, ativo) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, fornecedor.getIdEmpresa());
            st.setString(2, mapaEstado.get(fornecedor.getCodigoCidade())); // Estado pelo codigo da cidade fornecico
            st.setString(3, mapaCidade.get(fornecedor.getCodigoCidade()));// Cidade 
            st.setInt(4, fornecedor.getIdPlanoContas());
            st.setString(5, fornecedor.getTipo());
            st.setString(6, fornecedor.getTipoFornecedor());
            st.setString(7, fornecedor.getNome());
            st.setString(8, fornecedor.getRazaoSocial());
            st.setString(9, fornecedor.getCnpjCpf());
            st.setString(10, fornecedor.getIe());
            st.setString(11, fornecedor.getEndereco());
            st.setString(12, fornecedor.getNumero());
            st.setString(13, fornecedor.getBairro());
            st.setString(14, fornecedor.getCep());
            st.setString(15, fornecedor.getFone());
            st.setString(16, fornecedor.getFax());
            st.setString(17, fornecedor.getEmail());
            st.setString(18, fornecedor.getObs());
            st.setInt(19, fornecedor.getAtivo());
            st.executeUpdate();
            System.out.println("FORNECEDOR inserido: " + fornecedor);

        } catch (SQLException e) {
            throw new DbException("Erro ao inserir fornecedor em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }
    
    private Fornecedor instanciacaoFornecedor(ResultSet rs) throws SQLException {
        Fornecedor obj = new Fornecedor();
        obj.setId(rs.getInt("controle"));
        obj.setRazaoSocial(ObjetoUtil.removerCaracteresEspeciais(rs.getString("razaosocial")));
        obj.setNome(ObjetoUtil.removerCaracteresEspeciais(rs.getString("nomefantasia")));
        obj.setEndereco(ObjetoUtil.removerCaracteresEspeciais(rs.getString("endereco")));
        obj.setBairro(ObjetoUtil.removerCaracteresEspeciais(rs.getString("bairro")));
        obj.setCodigoCidade(ObjetoUtil.validarString(rs.getString("codigocidadeibge")));
        obj.setCep(ObjetoUtil.validarString(rs.getString("cep")));
        obj.setRg(ObjetoUtil.validarString(rs.getString("rg")));
        obj.setCpf(ObjetoUtil.validarString(rs.getString("cpf")));
        obj.setCnpj(ObjetoUtil.validarString(rs.getString("cnpj")));
        obj.setIe(ObjetoUtil.validarString(rs.getString("ie")));
        obj.setObs(ObjetoUtil.getObs(ObjetoUtil.validarString(rs.getString("telefone")), ObjetoUtil.validarString(rs.getString("celular")), "", ""));
        obj.setEmail(ObjetoUtil.validarString(rs.getString("email")));
        obj.setNumero(ObjetoUtil.validarString(rs.getString("numero")));
        obj.setAtivo(Integer.parseInt(ObjetoUtil.getAtivo(rs.getString("ativo"))));
        return obj;
    }

    private TreeMap<String, String> getMapaCidade() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap();

        try {
            st = conn2.prepareStatement("select id, codigocidade from cidades");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("codigocidade"), rs.getString("id"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            MysqlConnector.closeResultSet(rs);
            MysqlConnector.closeStatement(st);
        }
        return map;
    }
    
    private TreeMap<String, String> getMapaEstado() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap();

        try {
            st = conn2.prepareStatement("select (select e.id from estados e where e.iduf = c.iduf)as id_estado, c.codigocidade from cidades c");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("codigocidade"), rs.getString("id_estado"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            MysqlConnector.closeResultSet(rs);
            MysqlConnector.closeStatement(st);
        }
        return map;
    }
}
