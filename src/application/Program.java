package application;

import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
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
import sistemas.LC_SISTEMAS.model.entidades.Fabricante;
import sistemas.LC_SISTEMAS.model.entidades.Fornecedor;
import sistemas.LC_SISTEMAS.model.entidades.Ncm;
import sistemas.LC_SISTEMAS.model.entidades.Produto;
import sistemas.LC_SISTEMAS.model.entidades.SubCategoria;
import sistemas.LC_SISTEMAS.model.entidades.Unidade;
import sistemas.SGBR.model.dao.CategoriaDao;
import sistemas.SGBR.model.dao.FabricanteDao;
import sistemas.SGBR.model.dao.SubCategoriaDao;
import sistemas.SGBR.model.dao.FornecedorDao;
import sistemas.SGBR.model.dao.ProdutoDao;

/**
 *
 * @author supor
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conn1 = null;
        Connection conn2 = null;
        String porta = "3050";
        String caminho = "C:\\Users\\supor\\Documents\\TESTE-PROGRAMA-JAVA-MIGRACAO\\BASESGMASTER.FDB";
        String usuario = "SYSDBA";
        String senha = "masterkey";

        FirebirdConnector conecatorFdb = new FirebirdConnector(porta, caminho, usuario, senha);

        try {
            conn1 = conecatorFdb.getConnection(); // Conector FDB
            conn2 = new MysqlConnector().getConnection(); // Conector LC SISTEMAS

            EmpresaDao empresadao = FabricaDao.criarEmpresaDao(conn1);
            UnidadeDao unidadedao = FabricaDao.criarUnidadeDao(conn1, conn2);
            NcmDao ncmdao = FabricaDao.criarNcmDao(conn1, conn2);
            CestDao cestdao = FabricaDao.criarCestDao(conn1, conn2);
            CategoriaDao categoriadao = FabricaDao.criarCategoriaDao(conn1, conn2);
            FabricanteDao fabricantedao = FabricaDao.criarFabricanteDao(conn1, conn2);
            SubCategoriaDao subcategoriadao = FabricaDao.criarSubCategoriaDao(conn1, conn2);
            FornecedorDao fornecedordao = FabricaDao.criarFornecedorDao(conn1, conn2);
            ProdutoDao produtodao = FabricaDao.criarProdutoDao(conn1, conn2);

            List<Empresa> listEmp = empresadao.findAll();
            List<Unidade> listUnd = unidadedao.findAll();
            List<Ncm> listNcm = ncmdao.findAll();
            List<Cest> listaCest = cestdao.findAll();
            List<Categoria> listaCategoria = categoriadao.findAll();
            List<Fabricante> listaFabricante = fabricantedao.findAll();
            List<SubCategoria> listaSubCategoria = subcategoriadao.findAll();
            List<Fornecedor> listaFornecedor = fornecedordao.findAll();
            List<Produto> listaProduto = produtodao.findAll();

            /*System.out.println("\n**** TESTE - findById EMPRESA ****");
            System.out.println(empresadao.findById("1"));
            
            System.out.println("\n**** TESTE - findAll CSOSN ****");
            for(Csosn obj : listaCsosn) {
                System.out.println(obj);
            }*/
            
            System.out.println("\n**** TESTE - findAll EMPRESA ****");
            for (Empresa obj : listEmp) {
                System.out.println(obj);
            }
            
            System.out.println("\n**** TESTE - findAll UNIDADE ****");
            for (Unidade obj : listUnd) {
                unidadedao.insert(obj);
            }
            
            System.out.println("\n**** TESTE - findAll NCM ****");
            for(Ncm obj : listNcm) {
                ncmdao.insert(obj);
            }
            
            System.out.println("\n**** TESTE - findAll CEST ****");
            for (Cest obj : listaCest) {
                cestdao.insert(obj);
            }
            
            System.out.println("\n**** TESTE - findAll CATEGORIA ****");
            for (Categoria obj : listaCategoria) {
                categoriadao.insert(obj);
            }
            
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
            // DELETAR Colunas em fornecedores
            fornecedordao.deletarColunasAdicionais();
            
            System.out.println("\n**** TESTE - findAll PRODUTO ****");
            String regime = "SIMPLES";
            for (Produto obj : listaProduto) {
                produtodao.insert(obj, regime);
            }
            System.out.println("Total de produtos Migrados: " + listaProduto.size());
            
            System.out.println("");
        } catch (Exception ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FirebirdConnector.closeConnection(conn1);
            MysqlConnector.closeConnection(conn2);
        }
    }
}
