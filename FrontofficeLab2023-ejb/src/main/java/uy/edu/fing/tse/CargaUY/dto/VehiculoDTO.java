package uy.edu.fing.tse.CargaUY.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.entity.ITV;
import uy.edu.fing.tse.CargaUY.entity.PNC;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private Long peso;
    private Long capacidadCarga;
    private PNC pnc;
    private ITV itv;

}

