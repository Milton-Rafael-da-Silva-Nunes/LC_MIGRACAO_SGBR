package sistemas.LC_SISTEMAS.model.dao;

import sistemas.LC_SISTEMAS.model.entidades.Produto;

/**
 *
 * @author supor
 */
public interface ProdutoDaoInsert {
 
    void insert(Produto produto, String regime);
    void insertEstoqueProduto(Produto produto);
}
