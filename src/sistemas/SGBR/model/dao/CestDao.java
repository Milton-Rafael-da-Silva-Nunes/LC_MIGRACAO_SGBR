package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.CestDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Cest;

/**
 *
 * @author supor
 */
public interface CestDao extends CestDaoInsert{
    
    List<Cest> findAll();
}
