/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion;
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
public class VDocenteVinculacionFacade extends AbstractFacade<VDocenteVinculacion> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDocenteVinculacionFacade() {
        super(VDocenteVinculacion.class);
    }

  



    /*public List<VDocenteVinculacion> findCargoDepart() {
        List<VDocenteVinculacion> result = null;
        Query query = em.createQuery("SELECT o FROM VDocenteVinculacion o ");
        result = query.getResultList();
        return result;
    }*/

    
}
