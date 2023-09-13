package com.greenappleexperience.tp1persistenciamollaret.Entity;

import com.greenappleexperience.tp1persistenciamollaret.Enum.EstadoPedido;
import com.greenappleexperience.tp1persistenciamollaret.Enum.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate fecha;
    private TipoEnvio tipoEnvio; //enum
    private double total;
    private EstadoPedido estado; //enum

    //Relación con factura
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_FACTURA")
    private Factura factura;


    //Relación con detallePedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "fk_PEDIDO")
    private List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();

    public void agregarDetallePedido(DetallePedido detallePed){
        detallePedidoList.add(detallePed);

    }

}
