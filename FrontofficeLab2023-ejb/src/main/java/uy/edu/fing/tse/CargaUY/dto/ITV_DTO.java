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
public class ITV_DTO implements Serializable {

    private int idITV;
    private Date fechaValidez;

}
