/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class LocalizacionProgramaFacade extends AbstractFacade<LocalizacionPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalizacionProgramaFacade() {
        super(LocalizacionPrograma.class);
    }
    
    public List<LocalizacionPrograma> findXPrograma(Integer codPrograma) {
        Query query = em.createQuery("SELECT o FROM LocalizacionPrograma o WHERE o.programa.id = :codPrograma ORDER BY o.id DESC");
        query.setParameter("codPrograma", codPrograma);
        return query.getResultList();
    }   
    public List<LocalizacionPrograma> findXProyecto(Integer codProyecto) {
        Query query = em.createQuery("SELECT o FROM LocalizacionPrograma o WHERE o.proyecto.id = :codProyecto ORDER BY o.id DESC");
        query.setParameter("codProyecto", codProyecto);
        return query.getResultList();
    }       
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void guardar(List<LocalizacionPrograma> listadoNuevos, List<LocalizacionPrograma> listadoEliminar)
    {
        for (LocalizacionPrograma svinZonaDetalle : listadoNuevos) {
            this.em.persist(svinZonaDetalle);
        }
        for (LocalizacionPrograma svinZonaDetalle : listadoEliminar) {
            LocalizacionPrograma d = this.em.find(LocalizacionPrograma.class, svinZonaDetalle.getId());
            this.em.remove(d);
        }

    }
}
