/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
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
public class ResponsableProyectoFacade extends AbstractFacade<ResponsableProyecto> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableProyectoFacade() {
        super(ResponsableProyecto.class);
    }

    /*public ResponsableProyecto findDocentePrograma(Integer codProg) {
        List<ResponsableProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM ResponsableProyecto o WHERE o.programa.id =:codProg");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }*/

    public List<SegUsuario> findParticipante(Integer tipoResponsable) {
        Query query = em.createQuery("SELECT DISTINCT(o.usuario) FROM ResponsableProyecto o WHERE o.proyecto != null and o.tipoResponsable.id = " + tipoResponsable);
        return query.getResultList();
    }
    
    public List<SegUsuario> findDocenteParticipante() {
        Query query = em.createQuery("SELECT DISTINCT(o.usuario) FROM ResponsableProyecto o WHERE o.proyecto != null and ( o.tipoResponsable.id = 1 OR o.tipoResponsable.id = 2) ");
        return query.getResultList();
    }
}
