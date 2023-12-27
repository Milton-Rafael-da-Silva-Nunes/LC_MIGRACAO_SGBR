package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.PagarDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Pagar;

/**
 *
 * @author Rafael Nunes
 */
public interface PagarDao extends PagarDaoInsert{
    
    List<Pagar> findAll();
}
