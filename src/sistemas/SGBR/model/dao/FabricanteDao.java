package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.FabricanteDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Fabricante;

/**
 *
 * @author supor
 */
public interface FabricanteDao extends FabricanteDaoInsert{
    
    List<Fabricante> findAll();
}
