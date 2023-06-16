package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Rubro implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    private String nombre;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long indice;

    private String descripcion;

    /*@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Guia> guiasR = new ArrayList<>(); no va segun el proge*/

}
