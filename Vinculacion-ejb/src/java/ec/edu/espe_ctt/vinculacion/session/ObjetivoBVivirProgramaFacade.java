/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivirPrograma;
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
public class ObjetivoBVivirProgramaFacade extends AbstractFacade<ObjetivoBVivirPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoBVivirProgramaFacade() {
        super(ObjetivoBVivirPrograma.class);
    }
    
      /*public List<SvinProgObj> findSubObjByObjetivo(BigDecimal codId) {    
        List<SvinProgObj> result = null;
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivirPrograma o WHERE o.svobviId.svobviIdPadre.svobviId =:codId");
        query.setParameter("codId", codId);
                result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }*/
      
       /*public List<SvinProgObj> findSubObjByObjetivo1(BigDecimal codId) {    
        List<SvinProgObj> result = null;
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivirPrograma o WHERE o.svobviId.svobviIdPadre.svobviId =:codId");
        query.setParameter("codId", codId);
                result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }*/
    public List<ObjetivoBVivirPrograma> findByPrograma(Integer codProg){
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivirPrograma o WHERE o.programa.id = :codProg order by o.objetivoBVivir.svobviDescripcion");
        query.setParameter("codProg", codProg);
        return query.getResultList();
    }
    public List<ObjetivoBVivirPrograma> findByProyecto(Integer codProy){
        Query query = em.createQuery("SELECT o FROM ObjetivoBVivirPrograma o WHERE o.proyecto.id = :codProy order by o.objetivoBVivir.svobviDescripcion");
        query.setParameter("codProy", codProy);
        return query.getResultList();
    }
   
}
