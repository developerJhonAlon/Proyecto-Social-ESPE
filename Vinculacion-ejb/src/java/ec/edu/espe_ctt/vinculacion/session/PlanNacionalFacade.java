/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.PlanNacional;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhonny
 */
@Stateless
public class PlanNacionalFacade extends AbstractFacade<PlanNacional> {
    
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanNacionalFacade() {
        super(PlanNacional.class);
    }
    
    public boolean verificarPermitiriEdicionPlanNacional(Integer idPlanNacional){
        Query query = em.createQuery("SELECT COUNT(o) FROM ObjetivoBVivirPrograma o WHERE o.objetivoBVivir = (SELECT TOP 1 p.svobviId FROM ObjetivoBVivir p WHERE p.sztvplanCode = :idPlanNacional)");
        query.setParameter("idPlanNacional", idPlanNacional);
        return (Integer.valueOf(query.getSingleResult().toString()) == 0);
    }
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void edit(PlanNacional configuracionPlanNacional, boolean actualizarEstado){
        if (actualizarEstado){
            PlanNacional conf = findXActivo();
            if (conf!=null){
                conf.setEstado(PlanNacional.ESTADO_INACTIVA);
                this.edit(conf);
            }
        }
        this.edit(configuracionPlanNacional);
    }
    
    private PlanNacional findXActivo() {
        List<PlanNacional> result= null;
        Query query = em.createQuery("SELECT o FROM PlanNacional o WHERE o.estado = 'A' ");
        result = query.getResultList();
        if (result!=null && !result.isEmpty()){
            return result.get(0);
        }
        return null;
    }   
    
}
