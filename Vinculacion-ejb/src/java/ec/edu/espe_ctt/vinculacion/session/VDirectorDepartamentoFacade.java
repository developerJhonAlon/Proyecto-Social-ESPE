/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorDepartamento;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
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
public class VDirectorDepartamentoFacade extends AbstractFacade<VDirectorDepartamento> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDirectorDepartamentoFacade() {
        super(VDirectorDepartamento.class);
    }
    public List<VDirectorDepartamento> findByDepartamento(String idCampus, String idDepartamento) {
        Query query = em.createQuery("SELECT o FROM VDirectorDepartamento o WHERE o.campus.stvcampCode = :idCampus and o.departamento.stvsubjCode = :idDepartamento");
        query.setParameter("idCampus", idCampus);
        query.setParameter("idDepartamento", idDepartamento);
        return (query.getResultList());
    }


}
