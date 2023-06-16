package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.EmpresaDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresas implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<EmpresaDTO> empresas;

    public void setListaEmpresas(ArrayList<EmpresaDTO> empresas){
        this.empresas = empresas;
    }
    public ArrayList<EmpresaDTO> getListaEmpresas(){
        return empresas;
    }
}
