package sistemas.SGBR.model.dao;

import java.sql.Connection;
import sistemas.SGBR.model.dao.impl.CategoriaDaoJDBC;
import sistemas.SGBR.model.dao.impl.CestDaoJDBC;
import sistemas.SGBR.model.dao.impl.CsosnDaoJDBC;
import sistemas.SGBR.model.dao.impl.EmpresaDaoJDBC;
import sistemas.SGBR.model.dao.impl.FabricanteDaoJDBC;
import sistemas.SGBR.model.dao.impl.FornecedorDaoJDBC;
import sistemas.SGBR.model.dao.impl.NcmDaoJDBC;
import sistemas.SGBR.model.dao.impl.ProdutoDaoJDBC;
import sistemas.SGBR.model.dao.impl.SubCategoriaJDBC;
import sistemas.SGBR.model.dao.impl.UnidadeDaoJDBC;

/**
 *
 * @author supor
 */
public class FabricaDao {
    
    // conn1 > Firebird
    // conn2 > Mysql

    public static EmpresaDao criarEmpresaDao(Connection conn) {
        return new EmpresaDaoJDBC(conn);
    }

    public static CsosnDao criarCsosnDao(Connection conn1) {
        return new CsosnDaoJDBC(conn1);
    }

    public static UnidadeDao criarUnidadeDao(Connection conn1, Connection conn2) {
        return new UnidadeDaoJDBC(conn1, conn2);
    }

    public static NcmDao criarNcmDao(Connection conn1, Connection conn2) {
        return new NcmDaoJDBC(conn1, conn2);
    }

    public static CestDao criarCestDao(Connection conn1, Connection conn2) {
        return new CestDaoJDBC(conn1, conn2);
    }

    public static CategoriaDao criarCategoriaDao(Connection conn1, Connection conn2) {
        return new CategoriaDaoJDBC(conn1, conn2);
    }

    public static FabricanteDao criarFabricanteDao(Connection conn1, Connection conn2) {
        return new FabricanteDaoJDBC(conn1, conn2);
    }
    
    public static SubCategoriaDao criarSubCategoriaDao(Connection conn1, Connection conn2) {
        return new SubCategoriaJDBC(conn1, conn2);
    }
    
    public static FornecedorDao criarFornecedorDao(Connection conn1, Connection conn2) {
        return new FornecedorDaoJDBC(conn1, conn2);
    }
    
    public static ProdutoDao criarProdutoDao(Connection conn1, Connection conn2) {
        return new ProdutoDaoJDBC(conn1, conn2);
    }
}
