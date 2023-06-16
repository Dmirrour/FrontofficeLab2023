package uy.edu.fing.tse.CargaUY.beans;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import uy.edu.fing.tse.CargaUY.dto.VehiculoDTO;
import uy.edu.fing.tse.CargaUY.entity.PNC;
import uy.edu.fing.tse.CargaUY.model.Vehiculos;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uy.edu.fing.tse.CargaUY.response.RestResponse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Named("pncsBean")
@ViewScoped
public class PNCsBean implements Serializable {
    private String matriculaVehiculo;
    private int idPNC;
    private String fechaValidez;

    private ArrayList<VehiculoDTO> listaVehiculos;

    private Vehiculos vehiculos;

    public PNCsBean(){}

    public void addPNC(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaV = null;
        try {
            fechaV = formatter.parse(fechaValidez);

            PNC nuevoPNC = PNC.builder()
                    .idPNC(idPNC)
                    .fechaValidez(fechaV)
                    .build();

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/pncs/agregar")
                    .queryParam("matriculaVehiculo", matriculaVehiculo);
            Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(nuevoPNC, MediaType.APPLICATION_JSON));

            RestResponse result = response.readEntity(RestResponse.class);
            if(result.getStatus() == 201)
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, result.getMsg(), ""));
            else
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, result.getMsg(), ""));


        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error Fecha tranform", ""));
        }
    }

    public void listaVehiculos(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/LaboratorioCargaUYgrupo12-web/rest/vehiculos/listar");
        vehiculos = target.request(MediaType.APPLICATION_JSON).get(Vehiculos.class);
        listaVehiculos = vehiculos.getListaVehiculos();
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public int getIdPNC() {
        return idPNC;
    }

    public void setIdPNC(int idPNC) {
        this.idPNC = idPNC;
    }

    public String getFechaValidez() {
        return fechaValidez;
    }

    public void setFechaValidez(String fechaValidez) {
        this.fechaValidez = fechaValidez;
    }

    public ArrayList<VehiculoDTO> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<VehiculoDTO> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }
}
