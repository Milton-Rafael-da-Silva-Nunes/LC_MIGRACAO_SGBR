package sistemas.LC_SISTEMAS.model.dao;

import sistemas.LC_SISTEMAS.model.entidades.Fornecedor;

/**
 *
 * @author supor
 */
public interface FornecedorDaoInsert {
    
    void insert(Fornecedor fornecedor);
    void updateCidadeEstado();
    void deletarColunasAdicionais();
}
