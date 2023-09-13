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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;

    private String calle;
    private String numero;
    private String localidad;
}
