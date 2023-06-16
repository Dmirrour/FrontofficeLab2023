package uy.edu.fing.tse.CargaUY.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.dto.EmpresaDTO;
import uy.edu.fing.tse.CargaUY.dto.RubroDTO;
import uy.edu.fing.tse.CargaUY.dto.TipodeCargaDTO;
import uy.edu.fing.tse.CargaUY.dto.ViajeDTO;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guia implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGuia;
    private float volumen_carga;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaInicio;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaFin;
    private String origen;
    private String destino;
   // @Builder.Default
    @OneToOne(cascade = CascadeType.REMOVE)
    private Viaje viaje;

    @ManyToOne
    private Rubro rubro;// aca ira almacenado el rubro

    @ManyToOne
    private TipodeCarga tipocarga; // esto no se porque se guarda aca si solo segun la letra se guarda el volumne peor se puede usar

    @ManyToOne
    private Empresa empresa;

    public Guia (float volumen_carga, Date fechaInicio, Date fechaFin, String origen, String destino,Empresa empresa){
        //this.idGuia=idGuia;
        this.volumen_carga=volumen_carga;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.origen=origen;
        this.destino=destino;
        this.empresa=empresa;
    }

    public RubroDTO getRubro() {
        return RubroDTO.builder()
                .nombre(rubro.getNombre())
                .descripcion(rubro.getDescripcion())
                .build();
    }

    public TipodeCargaDTO getTipocarga() {
        return TipodeCargaDTO.builder()
                .nombre(tipocarga.getNombre())
                .descripcion(tipocarga.getDescripcion())
                .build();
    }

    public ViajeDTO getViaje(){
        if(viaje==null){
            return ViajeDTO.builder().nombre("No Asignado").build();
        }else{
            return ViajeDTO.builder()
                    .nombre(viaje.getNombre())
                    .estadoViaje(viaje.getEstadoViaje())
                    .id(viaje.getId())
                    .chofer(viaje.getUsuarioDTO())
                    .vehiculo(viaje.getVehiculoDTO())
                    .build();
        }

    }
    public EmpresaDTO getEmpresaDTO(){
        if(empresa==null){
            return EmpresaDTO.builder().nombrePublico("No Asigando").build();
        }else{
            return EmpresaDTO.builder()
                    .nroEmpresa(empresa.getNroEmpresa())
                    .nombrePublico(empresa.getNombrePublico())
                    .direccion(empresa.getDireccion())
                    .build();
        }

    }
}
