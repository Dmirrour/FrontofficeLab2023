package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.ITV_DTO;

import java.util.ArrayList;

public class ITVs {

    private ArrayList<ITV_DTO> itvs;

    public void setListaITVs(ArrayList<ITV_DTO> itvs){
        this.itvs = itvs;
    }
    public ArrayList<ITV_DTO> getListaITVs(){
        return itvs;
    }

}
