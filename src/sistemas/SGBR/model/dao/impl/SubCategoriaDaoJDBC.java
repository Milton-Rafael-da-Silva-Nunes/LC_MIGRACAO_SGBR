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
import sistemas.LC_SISTEMAS.model.entidades.SubCategoria;
import sistemas.SGBR.model.dao.SubCategoriaDao;
import util.ObjetoUtil;

/**
 *
 * @author supor
 */
public class SubCategoriaDaoJDBC implements SubCategoriaDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public SubCategoriaDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<SubCategoria> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT subgrupo FROM testoque WHERE subgrupo IS NOT NULL AND subgrupo <> '' GROUP BY subgrupo");
            rs = st.executeQuery();

            List<SubCategoria> lista = new ArrayList<>();

            while (rs.next()) {
                SubCategoria subcategoria = instanciacaoSubCategoria(rs);
                lista.add(subcategoria);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar subcategoria em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(SubCategoria subcategoria) {
        PreparedStatement st = null;

        try {
            st = conn2.prepareStatement("INSERT INTO subcategoria(id_categoria, nome, datahora_alteracao, ativo) "
                    + "VALUES(?, ?, ?, ?)");

            if (!subcategoriaExiste(subcategoria.getNome())) {
                st.setInt(1, subcategoria.getIdCategoria());
                st.setString(2, subcategoria.getNome());
                st.setString(3, subcategoria.getDataHoraAlteracao());
                st.setInt(4, subcategoria.getAtivo());
                st.executeUpdate();
                System.out.println("SUBCATEGORIA inserida: " + subcategoria.getNome());
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao inserir subcategoria em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    // Metodo para instancia obj e separar responsabilidades.
    private SubCategoria instanciacaoSubCategoria(ResultSet rs) throws SQLException {
        SubCategoria obj = new SubCategoria();
        obj.setNome(ObjetoUtil.removerCaracteresEspeciais(rs.getString("subgrupo")));
        return obj;
    }

    // Metodo para verificar se a SUBCATEGORIA já existe na tabela do LC SISTEMAS.
    private boolean subcategoriaExiste(String nome) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn2.prepareStatement("SELECT 1 FROM subcategoria WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            return rs.next(); // Se o resultado tiver uma linha, a SUBCATEGORIA existe
        } finally {
            MysqlConnector.closeStatement(st);
            MysqlConnector.closeResultSet(rs);
        }
    }
}
