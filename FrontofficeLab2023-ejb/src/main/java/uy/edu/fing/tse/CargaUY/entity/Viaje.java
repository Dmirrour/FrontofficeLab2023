package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.dto.EmpresaDTO;
import uy.edu.fing.tse.CargaUY.dto.GuiaDTO;
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
public class Viaje implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    private List<String> pesajesBalanza = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private EstadoViaje estadoViaje;
    @OneToOne
    private Vehiculo vehiculo;
    @OneToOne
    private Usuario chofer;

    @Column(unique = true)
    private String nombre;
    @OneToOne
    private Guia guia;

    @Builder.Default
    @OneToMany(orphanRemoval = true)
    List<Ubicacion> recorrido=new ArrayList<>();

    @ManyToOne
    private Empresa empresa;

    public Viaje (Long id,String nombre,EstadoViaje estadoViaje,Empresa empresa,Usuario chofer,Vehiculo vehiculo){
        this.id=id;
        this.nombre=nombre;
        this.estadoViaje=estadoViaje;
        this.empresa=empresa;
        this.chofer=chofer;
        this.vehiculo=vehiculo;
    }

    public GuiaDTO getGuiaDTO(){
        if(guia==null){
            return null;
        }else{
            return GuiaDTO.builder()
                    .idGuia(guia.getIdGuia())
                    .fechaFin(guia.getFechaFin())
                    .fechaInicio(guia.getFechaInicio())
                    //.viaje(guia.getViaje())
                    .rubro(guia.getRubro())
                    .origen(guia.getOrigen())
                    .destino(guia.getDestino())
                    .volumen_carga(guia.getVolumen_carga())
                    .build();
        }

    }
    public VehiculoDTO getVehiculoDTO(){

        return VehiculoDTO.builder()
                .peso(vehiculo.getPeso())
                .pnc(vehiculo.getPnc())
                .capacidadCarga(vehiculo.getCapacidadCarga())
                .itv(vehiculo.getItv())
                .marca(vehiculo.getMarca())
                .matricula(vehiculo.getMatricula())
                .modelo(vehiculo.getModelo())
                .build();
    }
    public UsuarioDTO getUsuarioDTO(){

      return UsuarioDTO.builder()
                .id(chofer.getId())
                .ci(chofer.getCi())
                .apellido(chofer.getApellido())
                .nombre(chofer.getNombre())
                .email(chofer.getEmail())
                .tipoUsuario(chofer.getTipoUsuario())
                //.pass(chofer.getPass())??????
                .build();

    }
    public EmpresaDTO getEmpresaDTO(){
        return EmpresaDTO.builder()
                .nroEmpresa(empresa.getNroEmpresa())
                .nombrePublico(empresa.getNombrePublico())
                .direccion(empresa.getDireccion())
                .build();
    }




}
