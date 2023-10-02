package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.FornecedorDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Fornecedor;

/**
 *
 * @author supor
 */
public interface FornecedorDao extends FornecedorDaoInsert{
    
    List<Fornecedor> findAll();
}
