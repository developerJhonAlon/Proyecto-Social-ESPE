/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.Institucion;
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
public class InstitucionFacade extends AbstractFacade<Institucion> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstitucionFacade() {
        super(Institucion.class);
    }
    
    public List<Institucion> findByActivo() {
        Query query = em.createQuery("SELECT o FROM Institucion o WHERE o.estado = 'A'");
        return query.getResultList();
    }   
    
   
}
