/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import java.math.BigDecimal;
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
public class ObjetivoBVivirFacade extends AbstractFacade<ObjetivoBVivir> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoBVivirFacade() {
        super(ObjetivoBVivir.class);
    }

    public List<ObjetivoBVivir> findObjetivosPadre() {
        List<ObjetivoBVivir> result = null;
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivir o WHERE o.svobviIdPadre IS NULL order by o.orden");
        result = query.getResultList();
        return result;
    }
      
       public List<ObjetivoBVivir> findObjXPadre(BigDecimal codIdPadre) {    
        List<ObjetivoBVivir> result = null;
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivir o WHERE o.svobviIdPadre.svobviId =:codIdPadre order by o.orden");
        query.setParameter("codIdPadre", codIdPadre);
                result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

}
