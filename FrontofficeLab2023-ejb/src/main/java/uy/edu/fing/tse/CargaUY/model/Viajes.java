package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.ViajeDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Viajes implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ViajeDTO> viajes;

    public void setListaViajes(ArrayList<ViajeDTO> viajes){
        this.viajes = viajes;
    }
    public ArrayList<ViajeDTO> getListaViajes(){
        return viajes;
    }
}
