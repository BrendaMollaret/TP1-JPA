package com.greenappleexperience.tp1persistenciamollaret.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String denominacion;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Builder.Default
    @JoinColumn(name = "fk_Rubro")
    private List<Producto> productoList = new ArrayList<Producto>();

    public void agregarProducto(Producto prod) {
        productoList.add(prod);
    }

}
