package uy.edu.fing.tse.CargaUY.dto;

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
public class PNC_DTO implements Serializable {

    private int idPNC;
    private Date fechaValidez;

}
