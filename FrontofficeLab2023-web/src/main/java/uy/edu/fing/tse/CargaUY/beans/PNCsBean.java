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
import uy.edu.fing.tse.CargaUY.dto.VehiculoDTO;
import uy.edu.fing.tse.CargaUY.entity.PNC;
import uy.edu.fing.tse.CargaUY.model.Vehiculos;
import uy.edu.fing.tse.CargaUY.response.RestResponse;
import uy.edu.fing.tse.CargaUY.service.IPNCService;
import uy.edu.fing.tse.CargaUY.service.IVehiculosService;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Named("pncsBean")
@ViewScoped
public class PNCsBean implements Serializable {

    @EJB
    IPNCService servicePNC;
    @EJB
    IVehiculosService service;

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

            servicePNC.agregarPNC(nuevoPNC, matriculaVehiculo);

        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error Fecha tranform", ""));
        }
    }

    public void listaVehiculos(){
        vehiculos = service.obtenerVehiculos(); ;

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
