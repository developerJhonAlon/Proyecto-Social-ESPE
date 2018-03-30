/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.util.Date;
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
public class ProgramaFacade extends AbstractFacade<Programa> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }

    public Programa findPrograma() {
        List<Programa> result = null;
        Query query = em.createQuery("SELECT o FROM Programa o ");
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<Programa> findXEstado(String estado) {
        String where = "";
        if (estado != null && !estado.isEmpty()) {
            where = "and o.estado = '" + estado + "'";
        }
        Query query = em.createQuery("SELECT o FROM Programa o WHERE o.estadoActivo = 'A' " + where + " order by o.id");
        List<Programa> result = query.getResultList();
        return result;
    }

    public List<Programa> findXCampos(Date fechaInicio, Date fechaFin, Integer id, String estado, String codCarrera, String codDepartamento, SeaProvincia provincia, SeaCanton canton, SeaParroquia parroquia, String codSede) {
        StringBuilder where = new StringBuilder();
        if (fechaInicio != null) {
            where.append(" and o.fechaInicio >= :fechaInicio");
        }
        if (fechaFin != null) {
            where.append(" and o.fechaFin <= :fechaFin");
        }
        if (id!=null){
            where.append(" and o.id = ").append(id);
        }
        if (estado!=null && !estado.isEmpty()){
            where.append(" and o.estado = '").append(estado).append("'");
        }
        if (codCarrera!=null && !codCarrera.isEmpty()){
            where.append(" and o in (select car.programa from CarreraPrograma car where car.carrera.stvmajrCode = '").append(codCarrera).append("')");
        }
        if (codDepartamento!=null && !codDepartamento.isEmpty()){
            where.append(" and o in (select dep.programa from DepartamentoPrograma dep where dep.departamento.stvsubjCode = '").append(codDepartamento).append("')");
        }
        if (provincia!=null){
            where.append(" and o in (select prov.programa from LocalizacionPrograma prov where prov.provincia.proId = '").append(provincia.getProId()).append("')");
        }
        if (canton!=null){
            where.append(" and o in (select can.programa from LocalizacionPrograma can where can.canton.canId = '").append(canton.getCanId()).append("')");
        }
        if (parroquia!=null){
            where.append(" and o in (select parr.programa from LocalizacionPrograma parr where parr.parroquia.prqId = '").append(parroquia.getPrqId()).append("')");
        }
        if (codSede!=null && !codSede.isEmpty()){
            where.append(" and o in (select s.programa from DepartamentoPrograma s where s.campus.stvcampCode = '").append(codSede).append("')");
        }
        
        Query query = em.createQuery("SELECT o FROM Programa o WHERE o.estadoActivo = 'A' " + where.toString());
        if (fechaInicio!=null){
            query.setParameter("fechaInicio", fechaInicio);
        }
        if (fechaFin!=null){
            query.setParameter("fechaFin", fechaFin);
        }
        
        List<Programa> result = query.getResultList();
        return result;
    }
    /*@Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Programa programaV)
    {
        ResponsableProyecto responsableProg = svinResponsableProgFacade.findDocentePrograma(programaV.getSprvId());
        if (responsableProg!=null)
        {
            svinResponsableProgFacade.remove(responsableProg);
        }
        
        List<SvinOpcionInstitucion>  svinOpcionInstitucionList =  svinOpcionInstitucionFacade.findOpcionInstitucion(programaV.getSprvId());
        for (SvinOpcionInstitucion svinOpcionInstitucion : svinOpcionInstitucionList) {
            this.em.remove(svinOpcionInstitucion);
        }
        
        List<SvinZonaDetalle> svinZonaDetalleList = vinZonaDetalleFacade.findXPrograma(programaV.getSprvId());
        for (SvinZonaDetalle svinZonaDetalle : svinZonaDetalleList) {
            this.em.remove(svinZonaDetalle);
        }

        List<SvinProgObj> proObjListTemp = svinProgObjFacade.findByPrograma(programaV.getSprvId());
        for (SvinProgObj svinProgObj : proObjListTemp) {
            this.em.remove(svinProgObj);
        }
        
        this.em.remove(this.em.find(Programa.class, programaV.getSprvId()));
    }
     */
}
