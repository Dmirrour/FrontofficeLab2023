package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.PNC_DTO;

import java.util.ArrayList;

public class PNCs {

    private ArrayList<PNC_DTO> pncs;

    public void setListaPNCs(ArrayList<PNC_DTO> pncs){
        this.pncs = pncs;
    }
    public ArrayList<PNC_DTO> getListaPNCs(){
        return pncs;
    }

}
