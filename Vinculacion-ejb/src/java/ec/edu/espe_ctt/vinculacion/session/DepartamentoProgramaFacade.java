/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.DepartamentoPrograma;
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
public class DepartamentoProgramaFacade extends AbstractFacade<DepartamentoPrograma> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoProgramaFacade() {
        super(DepartamentoPrograma.class);
    }
    
    public List<DepartamentoPrograma> findCampus(Integer codProg) {
        List<DepartamentoPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM DepartamentoPrograma o WHERE o.departamento IS NULL and o.campus IS NOT NULL and o.programa.id = :codProg ");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result;
    }

    public List<DepartamentoPrograma> findDepartamentos(Integer codProg) {
        List<DepartamentoPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM DepartamentoPrograma o WHERE o.departamento IS NOT NULL and o.programa.id = :codProg ");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result;
    }
    public List<DepartamentoPrograma> findCarreras(Integer codProg) {
        List<DepartamentoPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM DepartamentoPrograma o WHERE o.carrera IS NOT NULL and o.programa.id = :codProg ");
        query.setParameter("codProg", codProg);
        result = query.getResultList();
        return result;
    }
    
}
