package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.RubroDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Rubros implements Serializable {
    private static final Long serialVersionUID = 1L;
    private ArrayList<RubroDTO> rubros;
    public void setListaRubros(ArrayList<RubroDTO> rubro){
        this.rubros=rubro;
    }
    public ArrayList<RubroDTO> getListaRubros(){
        return rubros;
    }
}
