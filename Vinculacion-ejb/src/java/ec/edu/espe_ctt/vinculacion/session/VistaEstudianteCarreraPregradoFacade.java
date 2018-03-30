/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.VEstudianteCarreraPregrado;
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
public class VistaEstudianteCarreraPregradoFacade extends AbstractFacade<VEstudianteCarreraPregrado> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaEstudianteCarreraPregradoFacade() {
        super(VEstudianteCarreraPregrado.class);
    }
    
    public List<VEstudianteCarreraPregrado> findByPeriodoCampusCarrera(String idPeriodo, String idCampus, String idCarrera) {
        Query query = em.createQuery("SELECT o FROM VEstudianteCarreraPregrado o WHERE o.periodo.stvtermCode = :idPeriodo and o.campus.stvcampCode = :idCampus and o.carrera.stvmajrCode = :idCarrera ");
        query.setParameter("idPeriodo", idPeriodo);
        query.setParameter("idCampus", idCampus);
        query.setParameter("idCarrera", "PROG_"+ idCarrera);
        return query.getResultList();
    }   
}
