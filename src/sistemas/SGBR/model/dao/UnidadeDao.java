package sistemas.SGBR.model.dao;

import sistemas.LC_SISTEMAS.model.dao.UnidadeDaoInsert;
import java.util.List;
import sistemas.LC_SISTEMAS.model.entidades.Unidade;

/**
 *
 * @author supor
 */
public interface UnidadeDao extends UnidadeDaoInsert{
    
    List<Unidade> findAll();
}
