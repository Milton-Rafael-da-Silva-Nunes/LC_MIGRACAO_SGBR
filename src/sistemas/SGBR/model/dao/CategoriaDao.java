package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.LC_SISTEMAS.model.dao.CategoriaDaoInsert;
import sistemas.LC_SISTEMAS.model.entidades.Categoria;

/**
 *
 * @author supor
 */
public interface CategoriaDao extends CategoriaDaoInsert{
    
    List<Categoria> findAll();
}
