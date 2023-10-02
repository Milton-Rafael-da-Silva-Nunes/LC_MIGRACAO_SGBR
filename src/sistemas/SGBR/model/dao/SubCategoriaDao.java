package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.SubCategoriaDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.SubCategoria;

/**
 *
 * @author supor
 */
public interface SubCategoriaDao extends SubCategoriaDaoInsert{
    
    List<SubCategoria> findAll();
}
