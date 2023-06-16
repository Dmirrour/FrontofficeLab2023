package uy.edu.fing.tse.CargaUY.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuiaDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long idGuia;
    private float volumen_carga;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaInicio;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaFin;
    private String origen;
    private String destino;


    private ViajeDTO viaje;
    private RubroDTO rubro;
    private TipodeCargaDTO tipoCarga;
    private EmpresaDTO empresa;

    public GuiaDTO (long idGuia, float volumen_carga, Date fechaInicio, Date fechaFin, String origen, String destino){
        this.idGuia=idGuia;
        this.volumen_carga=volumen_carga;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.origen=origen;
        this.destino=destino;
    }
}
