/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.CoordinadorVinculacion;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import java.math.BigDecimal;
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
public class CoordinadorVinculacionFacade extends AbstractFacade<CoordinadorVinculacion> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoordinadorVinculacionFacade() {
        super(CoordinadorVinculacion.class);
    }
    public CoordinadorVinculacion getCoordinacionVincluacionById(BigDecimal codUsu){
         List<CoordinadorVinculacion> result = null;
        Query query = em.createQuery("SELECT o FROM CoordinadorVinculacion o WHERE o.usuario.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
}
