/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.IndicadorEstrategiaProyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class IndicadorEstrategiaProyectoFacade extends AbstractFacade<IndicadorEstrategiaProyecto> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadorEstrategiaProyectoFacade() {
        super(IndicadorEstrategiaProyecto.class);
    }
    public List<IndicadorEstrategiaProyecto> findByPrograma(Integer codProg){
        List<IndicadorEstrategiaProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM SvinProgObjEstrategicos o WHERE o.programa.id = :codProg ");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result;
    }
    
}
