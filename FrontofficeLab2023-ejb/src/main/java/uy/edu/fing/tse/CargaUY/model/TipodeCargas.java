package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.TipodeCargaDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class TipodeCargas implements Serializable {
    private static final Long serialVersionUID = 1L;
    private ArrayList<TipodeCargaDTO> tipodeCargaDTOS;
    public void setListaTipodeCargas(ArrayList<TipodeCargaDTO> tipodeCargaDTOS){
        this.tipodeCargaDTOS=tipodeCargaDTOS;
    }
    public ArrayList<TipodeCargaDTO> getListaTipodeCargas(){
        return tipodeCargaDTOS;
    }
}
