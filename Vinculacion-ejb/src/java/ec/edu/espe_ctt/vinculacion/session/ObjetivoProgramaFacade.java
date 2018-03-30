/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
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
public class ObjetivoProgramaFacade extends AbstractFacade<ObjetivoPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoProgramaFacade() {
        super(ObjetivoPrograma.class);
    }
    public List<ObjetivoPrograma> findObjetivosPrograma(Integer codProg){
        Query query = em.createQuery("SELECT o FROM ObjetivoPrograma o WHERE o.programa.id = :codProg");
        query.setParameter("codProg", codProg);
        return query.getResultList();
    }
    public List<ObjetivoPrograma> findObjetivosProyecto(Integer codProy){
        Query query = em.createQuery("SELECT o FROM ObjetivoPrograma o WHERE o.proyecto.id = :codProy");
        query.setParameter("codProy", codProy);
        return  query.getResultList();
    }
}
