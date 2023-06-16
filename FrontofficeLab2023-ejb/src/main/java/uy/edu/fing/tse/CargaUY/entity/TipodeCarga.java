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
public class TipodeCarga implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    private String nombre;
    private String descripcion;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long indice;

    /*@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Guia> guiasT = new ArrayList<>();*/


}
