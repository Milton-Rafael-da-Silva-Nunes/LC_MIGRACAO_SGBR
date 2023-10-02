package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.ProdutoDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Produto;

/**
 *
 * @author supor
 */
public interface ProdutoDao extends ProdutoDaoInsert{
    
    List<Produto> findAll();
}
