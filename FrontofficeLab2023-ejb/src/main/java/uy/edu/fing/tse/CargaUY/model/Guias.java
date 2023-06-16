package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.GuiaDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Guias implements Serializable {
    private static final Long serialVersionUID = 1L;
    private ArrayList<GuiaDTO> guia;
    public void setListaGuia(ArrayList<GuiaDTO> guia){
        this.guia=guia;
    }
    public ArrayList<GuiaDTO> getListaGuia(){
        return guia;
    }
}
