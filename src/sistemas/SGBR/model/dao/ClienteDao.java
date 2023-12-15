
package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.ClienteDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Cliente;

/**
 *
 * @author Rafael Nunes
 */
public interface ClienteDao extends ClienteDaoInsert{
    
    List<Cliente> findAll();
}
