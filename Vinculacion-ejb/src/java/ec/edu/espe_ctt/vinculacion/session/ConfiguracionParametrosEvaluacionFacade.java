/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
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
public class ConfiguracionParametrosEvaluacionFacade extends AbstractFacade<ConfiguracionParametrosEvaluacion> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionParametrosEvaluacionFacade() {
        super(ConfiguracionParametrosEvaluacion.class);
    }
    /*public List<ConfiguracionParametrosEvaluacion> findXProyAprobadoComisionVinculacion() {
        Query query = em.createQuery("SELECT o FROM ConfiguracionParametrosEvaluacion o WHERE o in (SELECT p.configuracionParametrosEvaluacion FROM Proyecto p WHERE p.estadoActivo = 'A' and (p.estado2.prdId = '" + SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION + "'  or p.estado2.prdId= '" + SeaParametrosDet.ESTADO_RECHAZADO_COMISION_VINCULACION + "'))");
        return query.getResultList();
    } */  
    public List<ConfiguracionParametrosEvaluacion> findXEvaluacionInicial() {
        return findXTipo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_INICIAL);
    }
    public List<ConfiguracionParametrosEvaluacion> findXEvaluacionFinal() {
        return findXTipo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_FINAL);
    }
    public ConfiguracionParametrosEvaluacion findXEvaluacionInicialAndActivo() {
        return findXTipoAndActivo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_INICIAL);
    }
    public ConfiguracionParametrosEvaluacion findXEvaluacionFinalAndActivo() {
        return findXTipoAndActivo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_FINAL);
    }
    
    private List<ConfiguracionParametrosEvaluacion> findXTipo(Integer tipo) {
        Query query = em.createQuery("SELECT o FROM ConfiguracionParametrosEvaluacion o WHERE o.tipo = :tipo ");
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }   
    private ConfiguracionParametrosEvaluacion findXTipoAndActivo(Integer tipo) {
        List<ConfiguracionParametrosEvaluacion> result= null;
        Query query = em.createQuery("SELECT o FROM ConfiguracionParametrosEvaluacion o WHERE o.tipo = :tipo AND o.estado = 'A' ");
        query.setParameter("tipo", tipo);
        result = query.getResultList();
        if (result!=null && !result.isEmpty()){
            return result.get(0);
        }
        return null;
    }   
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void edit(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion, boolean actualizarEstado){
        if (actualizarEstado){
            ConfiguracionParametrosEvaluacion conf = findXTipoAndActivo(configuracionParametrosEvaluacion.getTipo());
            if (conf!=null){
                conf.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
                this.edit(conf);
            }
        }
        this.edit(configuracionParametrosEvaluacion);
    }
    @Override
    public void create(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion){
        if (configuracionParametrosEvaluacion.getEstado().equals(ConfiguracionParametrosEvaluacion.ESTADO_ACTIVA)){
            ConfiguracionParametrosEvaluacion conf = findXTipoAndActivo(configuracionParametrosEvaluacion.getTipo());
            if (conf!=null){
                conf.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
                this.edit(conf);
            }
        }
        super.create(configuracionParametrosEvaluacion);
    }
    
}
