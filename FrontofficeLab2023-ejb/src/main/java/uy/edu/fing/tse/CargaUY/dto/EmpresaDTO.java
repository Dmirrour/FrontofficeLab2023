package uy.edu.fing.tse.CargaUY.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long nroEmpresa;
    private String razonSocial;
    private String nombrePublico;
    private String direccion;

    @Builder.Default
    ArrayList<VehiculoDTO> vehiculos = new ArrayList<>();
    @Builder.Default
    ArrayList<UsuarioDTO> ciudadanos = new ArrayList<>();
}
