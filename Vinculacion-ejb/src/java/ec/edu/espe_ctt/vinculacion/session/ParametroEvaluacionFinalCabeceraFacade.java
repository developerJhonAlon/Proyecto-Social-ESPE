/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class ParametroEvaluacionFinalCabeceraFacade extends AbstractFacade<ParametroEvaluacionFinalCabecera> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametroEvaluacionFinalCabeceraFacade() {
        super(ParametroEvaluacionFinalCabecera.class);
    }

}
