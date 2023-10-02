package sistemas.SGBR.model.dao;

import java.util.List;
import sistemas.SGBR.model.entidades.Empresa;

/**
 *
 * @author supor
 */
public interface EmpresaDao {
    
    List<Empresa> findAll();
    Empresa findById(String id);
}
