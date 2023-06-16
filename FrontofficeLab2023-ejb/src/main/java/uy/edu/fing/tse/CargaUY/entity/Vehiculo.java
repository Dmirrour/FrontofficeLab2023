package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String matricula;
    private String marca;
    private String modelo;
    private Long peso;
    private Long capacidadCarga;

    @OneToOne(orphanRemoval=true)
    private PNC pnc; //poner como relacion luego

    @OneToOne(orphanRemoval = true)
    private ITV itv; //poner como relacion luego

}
