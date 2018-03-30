/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ActividadPrograma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class ActividadProgramaFacade extends AbstractFacade<ActividadPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadProgramaFacade() {
        super(ActividadPrograma.class);
    }
    
    public List<ActividadPrograma> findXPrograma(Integer codPrograma) {
        List<ActividadPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM ActividadPrograma o WHERE o.programa.id = :codPrograma");
        query.setParameter("codPrograma", codPrograma);
        result = query.getResultList();
        return result;
    }   
    
   
}
