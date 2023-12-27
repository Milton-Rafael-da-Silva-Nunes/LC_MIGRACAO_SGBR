package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.ReceberDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Receber;

/**
 *
 * @author Rafael Nunes
 */
public interface ReceberDao extends ReceberDaoInsert{
    
    List<Receber> findAll();
}
