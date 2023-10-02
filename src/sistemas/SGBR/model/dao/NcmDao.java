package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.NcmDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Ncm;

/**
 *
 * @author supor
 */
public interface NcmDao extends NcmDaoInsert{
    
    List<Ncm> findAll();
}
