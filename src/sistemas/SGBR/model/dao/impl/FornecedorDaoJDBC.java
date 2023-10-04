package sistemas.SGBR.model.dao.impl;

import sistemas.SGBR.model.dao.FornecedorDao;
import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

        adicionarCodigoCidadeFornecedor();
        try {

            st = conn2.prepareStatement("INSERT INTO fornecedor(codigoCidade, id_empresa, id_estado, id_cidade, id_planocontas, tipo, tipo_fornecedor, nome, razao_social, cnpj_cpf, ie, endereco, numero, bairro, cep, fone, fax, email_site, obs, ativo) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setString(1, fornecedor.getCodigoCidade());
            st.setInt(2, 1);
            st.setInt(3, 14); // Estado padrão
            st.setInt(4, 184);// Cidade padrão
            st.setInt(5, 0);
            st.setString(6, "J");
            st.setString(7, "Outros");
            st.setString(8, fornecedor.getNome());
            st.setString(9, fornecedor.getRazaoSocial());
            st.setString(10, fornecedor.getCpfCnpj());
            st.setString(11, fornecedor.getIe());
            st.setString(12, fornecedor.getEndereco());
            st.setString(13, fornecedor.getNumero());
            st.setString(14, fornecedor.getBairro());
            st.setString(15, fornecedor.getCep());
            st.setString(16, "(  )     -   ");
            st.setString(17, "(  )     -   ");
            st.setString(18, fornecedor.getEmail());
            st.setString(19, fornecedor.getObs());
            st.setInt(20, fornecedor.getAtivo());
            st.executeUpdate();
            updateCidadeEstado(); // Update id_cidade e id_estado
            System.out.println("FORNECEDOR inserido: " + fornecedor);

        } catch (SQLException e) {
            throw new DbException("Erro ao inserir fornecedor em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    @Override
    public void updateCidadeEstado() {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("UPDATE fornecedor f "
                    + "INNER JOIN cidades c "
                    + "ON c.codigocidade = f.codigoCidade "
                    + "INNER JOIN estados e "
                    + "ON e.iduf = c.iduf "
                    + "SET f.id_cidade = c.id, f.id_estado = e.id;");

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro em funcao updateCidadeEstado(): " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    @Override
    public void deletarColunasAdicionais() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            DatabaseMetaData metaData = conn2.getMetaData();
            rs = metaData.getColumns(null, null, "fornecedor", "codigoCidade");

            if (rs.next()) {
                st = conn2.prepareStatement("ALTER TABLE fornecedor DROP COLUMN codigoCidade");
                st.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DbException("Erro ao deletar coluna 'codigoCidade' em fornecedor: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }

    private void adicionarCodigoCidadeFornecedor() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            DatabaseMetaData metaData = conn2.getMetaData();
            rs = metaData.getColumns(null, null, "fornecedor", "codigoCidade");

            if (!rs.next()) {
                st = conn2.prepareStatement("ALTER TABLE fornecedor ADD COLUMN codigoCidade VARCHAR(20)AFTER id");
                st.executeUpdate();
            }

        } catch (SQLException e) {
            throw new DbException("Erro ao adicionar coluna 'codigoCidade' em fornecedor: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }

    private Fornecedor instanciacaoFornecedor(ResultSet rs) throws SQLException {
        Fornecedor obj = new Fornecedor();
        obj.setId(rs.getInt("controle"));
        obj.setRazaoSocial(rs.getString("razaosocial"));
        obj.setNome(rs.getString("nomefantasia"));
        obj.setEndereco(ObjetoUtil.validarString(rs.getString("endereco")));
        obj.setBairro(ObjetoUtil.validarString(rs.getString("bairro")));
        obj.setCodigoCidade(rs.getString("codigocidadeibge"));
        obj.setCep(ObjetoUtil.validarString(rs.getString("cep")));
        obj.setRg(ObjetoUtil.validarString(rs.getString("rg")));
        obj.setCpfCnpj(ObjetoUtil.validarCpfCnpj(rs.getString("cpf"), rs.getString("cnpj")));
        obj.setIe(ObjetoUtil.validarString(rs.getString("ie")));
        obj.setObs(ObjetoUtil.getObs(rs.getString("telefone"), rs.getString("celular"), ""));
        obj.setEmail(ObjetoUtil.validarString(rs.getString("email")));
        obj.setNumero(ObjetoUtil.validarString(rs.getString("numero")));
        obj.setAtivo(Integer.parseInt(ObjetoUtil.getAtivo(rs.getString("ativo"))));
        return obj;
    }
}
