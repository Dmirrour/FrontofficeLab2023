package uy.edu.fing.tse.CargaUY.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.entity.EstadoViaje;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViajeDTO implements Serializable {
    private Long id;

    private EstadoViaje estadoViaje;
    private VehiculoDTO vehiculo;
    private UsuarioDTO chofer;

    private GuiaDTO guia;

    private String nombre;

    private EmpresaDTO empresa;


    //private ArrayList<Ubicacion> recorrido;
    //private ArrayList<String> pesajesBalanza;

    private ViajeDTO(long id,String nombre,EstadoViaje estadoViaje){
        this.estadoViaje=estadoViaje;
        this.id=id;
        this.nombre=nombre;
    }
}
