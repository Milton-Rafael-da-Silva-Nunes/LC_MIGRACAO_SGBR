package application;

import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemas.LC_SISTEMAS.model.entidades.Categoria;
import sistemas.SGBR.model.dao.CestDao;
import sistemas.SGBR.model.dao.EmpresaDao;
import sistemas.SGBR.model.dao.FabricaDao;
import sistemas.SGBR.model.dao.NcmDao;
import sistemas.SGBR.model.dao.UnidadeDao;
import sistemas.SGBR.model.entidades.Empresa;
import sistemas.LC_SISTEMAS.model.entidades.Cest;
import sistemas.LC_SISTEMAS.model.entidades.Cliente;
import sistemas.LC_SISTEMAS.model.entidades.Fabricante;
import sistemas.LC_SISTEMAS.model.entidades.Fornecedor;
import sistemas.LC_SISTEMAS.model.entidades.Ncm;
import sistemas.LC_SISTEMAS.model.entidades.Pagar;
import sistemas.LC_SISTEMAS.model.entidades.Produto;
import sistemas.LC_SISTEMAS.model.entidades.Receber;
import sistemas.LC_SISTEMAS.model.entidades.SubCategoria;
import sistemas.LC_SISTEMAS.model.entidades.Unidade;
import sistemas.LC_SISTEMAS.model.enuns.Estoque;
import sistemas.LC_SISTEMAS.model.enuns.Regime;
import sistemas.SGBR.model.dao.CategoriaDao;
import sistemas.SGBR.model.dao.ClienteDao;
import sistemas.SGBR.model.dao.FabricanteDao;
import sistemas.SGBR.model.dao.SubCategoriaDao;
import sistemas.SGBR.model.dao.FornecedorDao;
import sistemas.SGBR.model.dao.PagarDao;
import sistemas.SGBR.model.dao.ProdutoDao;
import sistemas.SGBR.model.dao.ReceberDao;

/**
 *
 * @author supor
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        Connection conn1 = null;
        Connection conn2 = null;
        String porta = "3050";
        String caminho = "C:\\Users\\supor\\Documents\\BASESGMASTER.FDB";
        String usuario = "SYSDBA";
        String senha = "masterkey";

        FirebirdConnector conecatorFdb = new FirebirdConnector(porta, caminho, usuario, senha);

        try {
            conn1 = conecatorFdb.getConnection(); // Conector FDB
            conn2 = new MysqlConnector().getConnection(); // Conector LC SISTEMAS
            conn2.setAutoCommit(false);

            EmpresaDao empresadao = FabricaDao.criarEmpresaDao(conn1);
            UnidadeDao unidadedao = FabricaDao.criarUnidadeDao(conn1, conn2);
            NcmDao ncmdao = FabricaDao.criarNcmDao(conn1, conn2);
            CestDao cestdao = FabricaDao.criarCestDao(conn1, conn2);
            CategoriaDao categoriadao = FabricaDao.criarCategoriaDao(conn1, conn2);
            FabricanteDao fabricantedao = FabricaDao.criarFabricanteDao(conn1, conn2);
            SubCategoriaDao subcategoriadao = FabricaDao.criarSubCategoriaDao(conn1, conn2);
            FornecedorDao fornecedordao = FabricaDao.criarFornecedorDao(conn1, conn2);
            ProdutoDao produtodao = FabricaDao.criarProdutoDao(conn1, conn2);
            ClienteDao clientedao = FabricaDao.criarClienteDao(conn1, conn2);
            ReceberDao receberdao = FabricaDao.criarReceberDao(conn1, conn2);
            PagarDao pagardao = FabricaDao.criarPagarDao(conn1, conn2);

            List<Empresa> listEmp = empresadao.findAll();
            List<Unidade> listUnd = unidadedao.findAll();
            List<Ncm> listNcm = ncmdao.findAll();
            List<Cest> listaCest = cestdao.findAll();
            List<Categoria> listaCategoria = categoriadao.findAll();
            List<Fabricante> listaFabricante = fabricantedao.findAll();
            List<SubCategoria> listaSubCategoria = subcategoriadao.findAll();
            List<Fornecedor> listaFornecedor = fornecedordao.findAll();
            List<Produto> listaProduto = produtodao.findAll();
            List<Cliente> listaCliente = clientedao.findAll();
            List<Receber> listaReceber = receberdao.findAll();
            List<Pagar> listaPagar = pagardao.findAll();

           /* System.out.println("\n**** TESTE - findAll EMPRESA ****");
            for (Empresa obj : listEmp) {
                System.out.println(obj);
            }

            System.out.println("\n**** TESTE - findAll UNIDADE ****");
            for (Unidade obj : listUnd) {
                unidadedao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll NCM ****");
            for (Ncm obj : listNcm) {
                ncmdao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll CEST ****");
            for (Cest obj : listaCest) {
                cestdao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll CATEGORIA ****");
            for (Categoria obj : listaCategoria) {
                categoriadao.insert(obj);
            }*/

            System.out.println("\n**** TESTE - findAll FABRICANTE ****");
            for (Fabricante obj : listaFabricante) {
                fabricantedao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll SUBCATEGORIA ****");
            for (SubCategoria obj : listaSubCategoria) {
                subcategoriadao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll FORNECEDOR ****");
            for (Fornecedor obj : listaFornecedor) {
                fornecedordao.insert(obj);
            }

            System.out.println("\n**** TESTE - findAll PRODUTO ****");
            Regime regime = Regime.SIMPLES;
            Estoque estoque = Estoque.SIM;

            for (Produto obj : listaProduto) {
                produtodao.insert(obj, regime.getRegime());
                // Inserir estoque  
                if (estoque.getEstoque().equalsIgnoreCase("sim")) {
                    produtodao.insertEstoqueProduto(obj);
                }
            }

            /*System.out.println("\n**** TESTE - findAll CLIENTE ****");
            for (Cliente obj : listaCliente) {
                clientedao.insert(obj);
            }*/

            /*System.out.println("\n**** TESTE - findAll RECEBER ****");
            for (Receber obj : listaReceber) {
                receberdao.insert(obj);
            }
            
            System.out.println("\n**** TESTE - findAll PAGAR ****");
            for(Pagar obj : listaPagar) {
                pagardao.insert(obj);
            }*/

            System.out.println("");
            System.out.println("Total de produtos Migrados: " + listaProduto.size());
            System.out.println("Total de clientes Migrados: " + listaCliente.size());
            System.out.println("Total de forneced Migrados: " + listaFornecedor.size());
            System.out.println("Total de Receber  Migrados: " + listaReceber.size());
            System.out.println("Total de Pagar    Migrados: " + listaPagar.size());
            System.out.println("");
            
            conn2.commit();

        } catch (Exception ex) {
            conn2.rollback();
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FirebirdConnector.closeConnection(conn1);
            MysqlConnector.closeConnection(conn2);
        }
    }
}
