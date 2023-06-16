package uy.edu.fing.tse.CargaUY.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RubroDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String nombre;
    private long indice;
    private String descripcion;
}
