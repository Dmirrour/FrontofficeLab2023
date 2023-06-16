package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double latitud;
    private double longitud;
    private String fecha;
    private double altitud;
    private double precision;
    private double velocidad;
    private double direccion;
}
