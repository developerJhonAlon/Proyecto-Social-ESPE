/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ImpactoEsperado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ImpactoEsperadoFacade extends AbstractFacade<ImpactoEsperado> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpactoEsperadoFacade() {
        super(ImpactoEsperado.class);
    }
    
    public List<ImpactoEsperado> findByProyecto(Integer codProyecto){
        Query query = em.createQuery("SELECT i FROM ImpactoEsperado i WHERE i.proyecto.id = :codProyecto");
        query.setParameter("codProyecto", codProyecto);
        return query.getResultList();
    }
}
