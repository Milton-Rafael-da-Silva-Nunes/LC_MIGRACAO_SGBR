package conexaoDB.firebird;

import conexaoDB.exception.DbException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rafael Nunes
 */
public class FirebirdConnector {

    private static Connection conn = null;
    private static String porta;
    private static String caminho;
    private static String usuario;
    private static String senha;
    private static String charset = "UTF8"; // Codificação padrão
    
    public FirebirdConnector() {
        
    }

    public FirebirdConnector(String porta, String caminho, String usuario, String senha) {
        FirebirdConnector.porta = porta;
        FirebirdConnector.caminho = caminho;
        FirebirdConnector.usuario = usuario;
        FirebirdConnector.senha = senha;
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                abrirConexao();
            } catch (Exception ex) {
                throw new DbException(ex.getMessage());
            }
        }
        return conn;
    }

    private void abrirConexao() throws Exception {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String url = "jdbc:firebirdsql:localhost/" + porta + ":" + caminho + "?encoding=" + charset;
            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao Firebird efetuada com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new DbException("Classe de conexao Firebird: " + e.getMessage());
        }
    }

    public boolean testarConexao(String porta, String usuario, String senha, String caminho) {
        Connection testConn = null;
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String url = "jdbc:firebirdsql:localhost/" + porta + ":" + caminho + "?encoding=" + charset;
            testConn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao Firebird testada com sucesso!");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao testar a conexão Firebird: " + e.getMessage());
            return false;
        } finally {
            closeConnection(testConn);
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexao Firebird fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Error! closeConnection " + e.getMessage());
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Error! closeStatement " + e.getMessage());
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error! closeResultSet " + e.getMessage());
                throw new DbException(e.getMessage());
            }
        }
    }
}
