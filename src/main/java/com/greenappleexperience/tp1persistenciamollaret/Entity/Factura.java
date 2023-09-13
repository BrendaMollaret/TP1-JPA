package com.greenappleexperience.tp1persistenciamollaret.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private int numero;
    private LocalDate fecha;
    private double descuento;
    private String formaPago;
    private int total;

}
