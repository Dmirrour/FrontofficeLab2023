package uy.edu.fing.tse.CargaUY.beans;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.primefaces.event.SelectEvent;
import uy.edu.fing.tse.CargaUY.dto.GuiaDTO;
import uy.edu.fing.tse.CargaUY.dto.RubroDTO;
import uy.edu.fing.tse.CargaUY.dto.TipodeCargaDTO;
import uy.edu.fing.tse.CargaUY.dto.ViajeDTO;
import uy.edu.fing.tse.CargaUY.model.Guias;
import uy.edu.fing.tse.CargaUY.model.Rubros;
import uy.edu.fing.tse.CargaUY.model.TipodeCargas;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Named("guiabean")
@ViewScoped
public class GuiaBean implements Serializable {
    private String origen;
    private String destino;
    private float volumendeCarga;
    private String fechaI;
    private String fechaF;
    private Rubros rubros;
    private Guias guias;
    private TipodeCargas tipodeCargas;
    private ArrayList<RubroDTO> rubroDTOS;
    private ArrayList<TipodeCargaDTO> tipodeCargaDTOS;
    private ArrayList<GuiaDTO> guiasDTOS;

    private String idRubro;
    private String idTdP;

    private Long idGuia;
    private ViajeDTO viajeSeleccionado;

    private GuiaDTO guia;
    private Long guiaSeleccionado;




    public GuiaBean(){}


    public void initC(){
        Client client1 = ClientBuilder.newClient();
        //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/rubros/listarG");//direccion de la pagina web
        WebTarget target = client1.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/rubros/listar");
        rubros = target.request(MediaType.APPLICATION_JSON).get(Rubros.class);
        rubroDTOS=rubros.getListaRubros();
        Client client2 = ClientBuilder.newClient();
        //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/TdP/listar");//direccion de la pagina web
        WebTarget target2 = client2.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/TdP/listar");
        tipodeCargas = target2.request(MediaType.APPLICATION_JSON).get(TipodeCargas.class);
        tipodeCargaDTOS = tipodeCargas.getListaTipodeCargas();

    }

    public void initiG(){ //falta hacerlo rest
       /* guias= guiaService.obtenerGuia();
        guiasDTOS=guias.getListaGuia();*/
        Client client1 = ClientBuilder.newClient();
        //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/guia/listarG");//direccion de la pagina web
        WebTarget target = client1.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/guia/listarG");
        guias = target.request(MediaType.APPLICATION_JSON).get(Guias.class);
        guiasDTOS=guias.getListaGuia();

    }
    public void addGuia(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechai = null;
        Date fechaf = null;
        try{
            fechai = formatter.parse(fechaI);
            fechaf = formatter.parse(fechaF);
            System.out.println(idRubro + "   "+idTdP);
            GuiaDTO nuevaGuia = GuiaDTO.builder()
                    .origen(origen)
                    .destino(destino)
                    .fechaInicio(fechai)
                    .fechaFin(fechaf)
                    .volumen_carga(volumendeCarga)
                    .build();

            Client client = ClientBuilder.newClient();
            //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/guia/altaguia");//direccion de la pagina web
            WebTarget target = client.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/guia/altaguia")
                    .queryParam("rubro", idRubro)
                    .queryParam("tdp", idTdP);
            Response response =target.request(MediaType.APPLICATION_JSON).post(Entity.entity(nuevaGuia, MediaType.APPLICATION_JSON));
            RestResponse result = response.readEntity(RestResponse.class);
            if(result.getStatus() == 201)
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, result.getMsg(), ""));
            else
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, result.getMsg(), ""));

        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error Fecha pasado", ""));
        }

    }
    public void eliminarGuia(Long idGuia){
        System.out.println("Holas antes del borrar "+idGuia);
        Client client = ClientBuilder.newClient();
        //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/guia/borrar/".concat(String.valueOf(idGuia)));//direccion de la pagina web
        WebTarget target = client.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/guia/borrar/".concat(String.valueOf(idGuia)));
        boolean exito = target.request().delete(Boolean.class);
        System.out.println("Holas sali del borrar "+exito);
        if(exito){
            initC();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se ha borrado la Guia ", ""));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se pudo borrar la Guia ", ""));
        }
    }

    public void asignarViaje(SelectEvent<ViajeDTO> event){
        viajeSeleccionado = event.getObject();
        guiaService.asignarEmpresa(idGuia, viajeSeleccionado.getId());
    }

    public void leer(GuiaDTO guia2){
        System.out.println("Entre al leer");
        guia = guia2;
    }

    public void modificar(){
        /*guiaService.modificar(guia);*/
        Client client = ClientBuilder.newClient();
        //WebTarget target = client.target("https://cargauy.web.elasticloud.uy/LaboratorioCargaUYgrupo12-web/rest/guia/modificarG");//direccion de la pagina web
        WebTarget target = client.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/guia/modificarG");
        target.request().post(Entity.entity(guia, MediaType.APPLICATION_JSON));
    }
    public GuiaDTO getGuia() {
        return guia;
    }

    public void setGuia(GuiaDTO guia) {
        this.guia = guia;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getFechaI() {
        return fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public float getTipodeCarga() {
        return volumendeCarga;
    }

    public void setTipodeCarga(float tipodeCarga) {
        this.volumendeCarga = tipodeCarga;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }



    public void setRubroDTOS(ArrayList<RubroDTO> rubroDTOS) {
        this.rubroDTOS = rubroDTOS;
    }

    public ArrayList<RubroDTO> getRubroDTOS() {
        return rubroDTOS;
    }

    public ArrayList<TipodeCargaDTO> getTipodeCargaDTOS() {
        return tipodeCargaDTOS;
    }

    public void setTipodeCargaDTOS(ArrayList<TipodeCargaDTO> tipodeCargaDTOS) {
        this.tipodeCargaDTOS = tipodeCargaDTOS;
    }

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }

    public String getIdTdP() {
        return idTdP;
    }

    public void setIdTdP(String idTdP) {
        this.idTdP = idTdP;
    }

    public ArrayList<GuiaDTO> getGuiasDTOS() {
        return guiasDTOS;
    }

    public void setGuiasDTOS(ArrayList<GuiaDTO> guiasDTOS) {
        this.guiasDTOS = guiasDTOS;
    }

    public ViajeDTO getViajeSeleccionado() {
        return viajeSeleccionado;
    }

    public void setViajeSeleccionado(ViajeDTO viajeSeleccionado) {
        this.viajeSeleccionado = viajeSeleccionado;
    }

    public Long getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Long idGuia) {
        this.idGuia = idGuia;
    }

    public Long getGuiaSeleccionado() {
        return guiaSeleccionado;
    }

    public void setGuiaSeleccionado(Long guiaSeleccionado) {
        this.guiaSeleccionado = guiaSeleccionado;
    }
}
