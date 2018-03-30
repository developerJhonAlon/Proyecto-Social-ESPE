/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ActaDesignacionResponsable;
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
public class ActaDesignacionResponsableFacade extends AbstractFacade<ActaDesignacionResponsable> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActaDesignacionResponsableFacade() {
        super(ActaDesignacionResponsable.class);
    }
    
    public List<ActaDesignacionResponsable> findByTipo(Integer idProyecto, Integer tipo){
        Query query = em.createQuery("SELECT distinct o.actaDesignacionResponsable FROM ResponsableProyecto o where o.proyecto.id = :idProyecto and o.tipoResponsable.id = :tipo and o.actaDesignacionResponsable!=null order by o.actaDesignacionResponsable.secuencial");
        query.setParameter("idProyecto", idProyecto);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
   public ActaDesignacionResponsable findByMaximoSecuencial(Integer idProyecto, Integer tipo) {
        Query query = em.createQuery("SELECT o.actaDesignacionResponsable FROM ResponsableProyecto o where o.proyecto.id = :idProyecto and o.tipoResponsable.id = :tipo and o.actaDesignacionResponsable!=null order by o.actaDesignacionResponsable.secuencial desc");
        query.setParameter("idProyecto", idProyecto);
        query.setParameter("tipo", tipo);
        List<ActaDesignacionResponsable> result = query.getResultList();
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }   
}
