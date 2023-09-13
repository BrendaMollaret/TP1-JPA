package com.greenappleexperience.tp1persistenciamollaret.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JoinColumn(name = "fk_CLIENTE")
    private List<Pedido> pedidoList = new ArrayList<Pedido>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "fk_Cliente")
    private List<Domicilio> domicilioList = new ArrayList<Domicilio>();

    public void agregarDomicilio(Domicilio dom) {
        domicilioList.add(dom);
    }

    public void agregarPedido(Pedido ped) {
        pedidoList.add(ped);
    }


    public void mostrarDomicilios(){
        System.out.println("\n Domicilios de: " + nombre + " " + apellido + " : ");
        for (Domicilio domicilio : domicilioList) {
            System.out.println("\nCalle: " + domicilio.getCalle() + "\nLocalidad: " + domicilio.getLocalidad() + "\nNumero: " + domicilio.getNumero() );
        }

    }

    public void mostrarPedidos() {
        System.out.println("\n Pedidos de: " + nombre + " " + apellido + " : ");
        for (Pedido pedido : pedidoList) {
            System.out.println("\nFecha: " + pedido.getFecha() + "\nTotal: " + pedido.getTotal());
            int counter = 0;
            for (DetallePedido detalle: pedido.getDetallePedidoList()){
                counter += 1;
                System.out.println("\nProducto "+counter+": "+detalle.getProducto().getDenominacion()+" \n cantidad: "+detalle.getCantidad()+"  \n subtotal: "+detalle.getSubtotal());
            }
        }
    }




}
