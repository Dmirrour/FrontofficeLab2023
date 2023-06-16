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
import uy.edu.fing.tse.CargaUY.dto.EmpresaDTO;
import uy.edu.fing.tse.CargaUY.dto.VehiculoDTO;
import uy.edu.fing.tse.CargaUY.entity.Empresa;
import uy.edu.fing.tse.CargaUY.entity.ITV;
import uy.edu.fing.tse.CargaUY.entity.PNC;
import uy.edu.fing.tse.CargaUY.entity.Vehiculo;
import uy.edu.fing.tse.CargaUY.model.Empresas;
import uy.edu.fing.tse.CargaUY.model.Rubros;
import uy.edu.fing.tse.CargaUY.model.Vehiculos;
import uy.edu.fing.tse.CargaUY.response.RestResponse;
import uy.edu.fing.tse.CargaUY.service.IVehiculosService;
import uy.edu.fing.tse.CargaUY.service.IEmpresasService;

import java.io.Serializable;
import java.util.ArrayList;

@Named("vehiculosBean")
@ViewScoped
public class VehiculosBean implements Serializable {

    @EJB
    IVehiculosService service;

    @EJB
    IEmpresasService serviceEmpresa;


    private Vehiculos vehiculos;
    private ArrayList<VehiculoDTO> list;
    private ArrayList<EmpresaDTO> listaEmpresas;
    private Empresas empresas; //private Empresa empresa;

    private Empresa empresa;

    private Long nroEmpresa;
    private String matricula;
    private String marca;
    private String modelo;
    private Long peso;
    private Long capacidadCarga;
    private PNC pnc;
    private ITV itv;
    private String filtro;

    public VehiculosBean(){}

    public void listaEmpresas(){

        listaEmpresas = serviceEmpresa.obtenerEmpresas().getListaEmpresas();
    }

    public void initLista(){
        list = service.obtenerVehiculos().getListaVehiculos();
    }

    public void addVehiculo(){
        Vehiculo nuevoVehiculo = Vehiculo.builder()
                .matricula(matricula)
                .marca(marca)
                .modelo(modelo)
                .peso(peso)
                .capacidadCarga(capacidadCarga)
                .build();

        service.agregarVehiculo(nuevoVehiculo, nroEmpresa);
    }

    public void filtrarVehiculos(){
        list = service.filtrarVehiculos(filtro).getListaVehiculos();
    }

    public void eliminarVehiculo(String matricula){

        if(service.borrarVehiculo(matricula)){
            initLista();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se ha borrado el Vehiculo", ""));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se pudo borrar el Vehiculo", ""));
        }
    }

    public void modificarVehiculo(){
        Vehiculo vehiculoModificado = Vehiculo.builder()
                .matricula(matricula)
                .marca(marca)
                .modelo(modelo)
                .peso(peso)
                .capacidadCarga(capacidadCarga)
                .build();

        service.modificarVehiculo(vehiculoModificado);
    }

    public IVehiculosService getService() {
        return service;
    }

    public void setService(IVehiculosService service) {
        this.service = service;
    }

    public IEmpresasService getServiceEmpresa() {
        return serviceEmpresa;
    }

    public void setServiceEmpresa(IEmpresasService serviceEmpresa) {
        this.serviceEmpresa = serviceEmpresa;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<VehiculoDTO> getList() {
        return list;
    }

    public void setList(ArrayList<VehiculoDTO> list) {
        this.list = list;
    }

    public ArrayList<EmpresaDTO> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<EmpresaDTO> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getNroEmpresa() {
        return nroEmpresa;
    }

    public void setNroEmpresa(Long nroEmpresa) {
        this.nroEmpresa = nroEmpresa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Long capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public PNC getPnc() {
        return pnc;
    }

    public void setPnc(PNC pnc) {
        this.pnc = pnc;
    }

    public ITV getItv() {
        return itv;
    }

    public void setItv(ITV itv) {
        this.itv = itv;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
