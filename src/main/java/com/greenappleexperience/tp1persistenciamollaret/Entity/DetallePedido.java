package com.greenappleexperience.tp1persistenciamollaret.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;

    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.REFRESH)//cascade = CascadeType.PERSIST
    @JoinColumn(name = "FK_PRODUCTO")
    private Producto producto;
}
