/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.CarreraPrograma;
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
public class CarreraProgramaFacade extends AbstractFacade<CarreraPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraProgramaFacade() {
        super(CarreraPrograma.class);
    }
    
    public List<CarreraPrograma> findByPrograma(Integer codProg) {
        List<CarreraPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM CarreraPrograma o WHERE o.programa.id = :codProg ");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result;
    }
    
}
