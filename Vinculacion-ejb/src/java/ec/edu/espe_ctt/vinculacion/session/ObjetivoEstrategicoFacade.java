/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico;
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
public class ObjetivoEstrategicoFacade extends AbstractFacade<ObjetivoEstrategico> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoEstrategicoFacade() {
        super(ObjetivoEstrategico.class);
    }
    public List<ObjetivoEstrategico> findPrespectivas(){
        Query query = em.createQuery("SELECT o FROM ObjetivoEstrategico o WHERE o.objetivoEstrategicoPadre is null AND o.configuraObjetivo.id = 5");
        return query.getResultList();
    }
    public List<ObjetivoEstrategico> findObjetivoEstraInst(Integer codObj) {
        Query query = em.createQuery("SELECT o FROM ObjetivoEstrategico o WHERE o.objetivoEstrategicoPadre.id =:codObj");
        query.setParameter("codObj", codObj);
        return query.getResultList();
    }
    public List<ObjetivoEstrategico> findObjetivosMilenio(){
        Query query = em.createQuery("SELECT o FROM ObjetivoEstrategico o WHERE o.objetivoEstrategicoPadre is null AND o.configuraObjetivo.id = 4");
        return query.getResultList();
    }
    
    public List<ObjetivoEstrategico> findCampoUnesco(){
        Query query = em.createQuery("SELECT u FROM ObjetivoEstrategico u WHERE u.objetivoEstrategicoPadre is null AND u.configuraObjetivo.id = 3");
        return query.getResultList();
    }
}
