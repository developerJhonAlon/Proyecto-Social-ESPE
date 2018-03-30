/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.HitoProyecto;
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
public class HitoProyectoFacade extends AbstractFacade<HitoProyecto> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public HitoProyectoFacade() {
        super(HitoProyecto.class);
    }
    public List<HitoProyecto> findByProyecto(Integer codProyecto){
        Query query = em.createQuery("SELECT o FROM HitoProyecto o where o.proyecto.id =:codProyecto ");
        query.setParameter("codProyecto", codProyecto);
        return query.getResultList();
    }
}
