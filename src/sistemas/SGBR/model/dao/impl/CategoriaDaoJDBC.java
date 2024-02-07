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
import sistemas.LC_SISTEMAS.model.entidades.Categoria;
import sistemas.SGBR.model.dao.CategoriaDao;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class CategoriaDaoJDBC implements CategoriaDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public CategoriaDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Categoria> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT grupo FROM testoque WHERE grupo IS NOT NULL AND grupo <> '' GROUP BY grupo");
            rs = st.executeQuery();

            List<Categoria> lista = new ArrayList<>();

            while (rs.next()) {
                Categoria cat = instanciacaoCategoria(rs);
                lista.add(cat);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar grupos em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Categoria categoria){
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO categoria(nome, comissao, pode_gourmet, datahora_alteracao, ativo) "
                    + "VALUES (?, ?, ?, ?, ?)");

            if (!categoriaExiste(categoria.getNome())) { // Verificar se a categoria já existe antes de inserir no LC.
                st.setString(1, categoria.getNome());
                st.setDouble(2, categoria.getComissao());
                st.setString(3, categoria.getPodeGourmet());
                st.setString(4, categoria.getDatahoraAlteracao());
                st.setInt(5, categoria.getAtivo());
                st.executeUpdate();
                System.out.println("CATEGORIA inserida: " + categoria.getNome());
            }
            
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir categoria em metodo insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
       }
    }

    // Metodo para instanciar OBJ e separar responsabilidade.
    private Categoria instanciacaoCategoria(ResultSet rs) throws SQLException {
        Categoria obj = new Categoria();
        obj.setNome(ObjetoUtil.removerCaracteresEspeciais(rs.getString("grupo")));
        return obj;
    }

    // Metodo para verificar se a categoria já existe na tabela do LC SISTEMAS.
    private boolean categoriaExiste(String nome) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM categoria WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, a unidade existe 
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
