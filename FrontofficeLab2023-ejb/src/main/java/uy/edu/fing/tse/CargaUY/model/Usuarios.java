package uy.edu.fing.tse.CargaUY.model;

import uy.edu.fing.tse.CargaUY.dto.UsuarioDTO;
import uy.edu.fing.tse.CargaUY.entity.TipoUsuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<UsuarioDTO> listaUsuarios;
    private ArrayList<UsuarioDTO> listaCiudadanos;
    private int totalRows;

    public ArrayList<UsuarioDTO> getListaUsuarios() { return listaUsuarios; }
    public ArrayList<UsuarioDTO> getListaCiudadanos() {
        ArrayList<UsuarioDTO> listaCiudadanos = new ArrayList<>();
        for (UsuarioDTO usuario: listaUsuarios) {
            if(usuario.getTipoUsuario() == TipoUsuario.CIUDADANO){
                listaCiudadanos.add(usuario);
            }
        }
        return  listaCiudadanos;
    }
    public void setListaCiudadanos(ArrayList<UsuarioDTO> listaCiudadanos){
        this.listaCiudadanos = listaCiudadanos;
    }
    public void setListaUsuarios(ArrayList<UsuarioDTO> listaUsuarios) { this.listaUsuarios = listaUsuarios; }
    public int getTotalRows() { return totalRows; }
    public void setTotalRows(int totalRows) { this.totalRows = totalRows; }
}
