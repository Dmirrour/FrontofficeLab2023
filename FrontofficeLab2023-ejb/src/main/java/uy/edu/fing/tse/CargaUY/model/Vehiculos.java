package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.VehiculoDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<VehiculoDTO> vehiculos;

    public void setListaVehiculos(ArrayList<VehiculoDTO> vehiculos){
        this.vehiculos = vehiculos;
    }
    public ArrayList<VehiculoDTO> getListaVehiculos(){
        return vehiculos;
    }

}
