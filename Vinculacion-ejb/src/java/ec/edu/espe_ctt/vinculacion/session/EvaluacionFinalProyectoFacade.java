/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ActividadPrograma;
import ec.edu.espe_ctt.vinculacion.entity.EvaluacionFinalProyecto;
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
public class EvaluacionFinalProyectoFacade extends AbstractFacade<EvaluacionFinalProyecto> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionFinalProyectoFacade() {
        super(EvaluacionFinalProyecto.class);
    }
    
    public EvaluacionFinalProyecto findByProyecto(Integer codProyecto) {
        List<EvaluacionFinalProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM EvaluacionFinalProyecto o WHERE o.proyecto.id = :codProyecto order by o.id desc");
        query.setParameter("codProyecto", codProyecto);
        result = query.getResultList();
        if (result!=null && !result.isEmpty()){
            return result.get(0);
        }
        return null;
    }   
    
   
}
