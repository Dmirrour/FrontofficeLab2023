package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.dto.UsuarioDTO;
import uy.edu.fing.tse.CargaUY.dto.VehiculoDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empresa implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nroEmpresa;
    private String razonSocial;
    private String nombrePublico;
    private String direccion;
    @Builder.Default
    @OneToMany(orphanRemoval = true)
    List<Vehiculo> vehiculos = new ArrayList<>();
    @Builder.Default
    @OneToMany
    List<Usuario> ciudadanos = new ArrayList<>();

    public ArrayList<VehiculoDTO> getVehiculosDTO(){
        ArrayList<VehiculoDTO> result = new ArrayList<>();
        vehiculos.forEach(vehiculo -> {
            result.add(VehiculoDTO.builder()
                    .peso(vehiculo.getPeso())
                    .pnc(vehiculo.getPnc())
                    .capacidadCarga(vehiculo.getCapacidadCarga())
                    .itv(vehiculo.getItv())
                    .marca(vehiculo.getMarca())
                    .matricula(vehiculo.getMatricula())
                    .modelo(vehiculo.getModelo())
                    .build());
        });
        return result;
    }

    public ArrayList<UsuarioDTO> getCiudadanosDTO(){
        ArrayList<UsuarioDTO> result = new ArrayList<>();
        ciudadanos.forEach(ciudadano -> {
            if(ciudadano.getTipoUsuario() == TipoUsuario.CIUDADANO) {
                result.add(UsuarioDTO.builder()
                        .id(ciudadano.getId())
                        .ci(ciudadano.getCi())
                        .apellido(ciudadano.getApellido())
                        .nombre(ciudadano.getNombre())
                        .email(ciudadano.getEmail())
                        .pass(ciudadano.getPass())
                        .tipoUsuario(ciudadano.getTipoUsuario())
                        .build());
            }
        });
        return result;
    }

}
