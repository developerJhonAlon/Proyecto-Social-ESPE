/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ActaAprobacionVicerrectorado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless(mappedName = "ActaAprobacionVicerrectoradoFacade")
public class ActaAprobacionVicerrectoradoFacade extends AbstractFacade<ActaAprobacionVicerrectorado> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActaAprobacionVicerrectoradoFacade() {
        super(ActaAprobacionVicerrectorado.class);
    }
    public ActaAprobacionVicerrectorado findByMaximoSecuencial() {
        Query query = em.createQuery("SELECT o FROM ActaAprobacionVicerrectorado o order by o.secuencial desc");
        List<ActaAprobacionVicerrectorado> result = query.getResultList();
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }   
}
