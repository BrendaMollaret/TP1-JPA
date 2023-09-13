package com.greenappleexperience.tp1persistenciamollaret;

import com.greenappleexperience.tp1persistenciamollaret.Entity.*;
import com.greenappleexperience.tp1persistenciamollaret.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class Tp1PersistenciaMollaretApplication {

    @Autowired //Inyección de dependencia mediante SpringBoot
    ClienteRepository clienteRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    DomicilioRepository domicilioRepository;

    @Autowired
    RubroRepository rubroRepository;

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1PersistenciaMollaretApplication.class, args);

    }

    @Bean
    CommandLineRunner init(ClienteRepository clienteRepository,
                           FacturaRepository facturaRepository,
                           PedidoRepository pedidoRepository,
                           ProductoRepository productoRepository,
                           DomicilioRepository domicilioRepository,
                           DetallePedidoRepository detallePedidoRepository,
                           RubroRepository rubroRepository) {

        return args -> {
            System.out.println(" ");

            System.out.println("----------------------------FUNCIONA!---------------------------------");

            //Creación de domicilio1
            Domicilio domicilio1 = Domicilio.builder()
                    .calle("CalleFalsa")
                    .localidad("Ciudad")
                    .numero("123")
                    .build();

            //Creación de domicilio2
            Domicilio domicilio2 = Domicilio.builder()
                    .calle("CalleVerdadera")
                    .localidad("Guaymallen")
                    .numero("789")
                    .build();

            //Creación de domicilio3
            Domicilio domicilio3 = Domicilio.builder()
                    .calle("CalleIntermedia")
                    .numero("567")
                    .localidad("Godoy cruz")
                    .build();

            //Creación de un cliente
            Cliente cliente = Cliente.builder()
                    .nombre("Brenda")
                    .apellido("Mollaret")
                    .email("brendaemail@gmai.com")
                    .telefono("2615123587")
                    .build();

            //Creación de otro cliente1
            Cliente cliente1 = Cliente.builder()
                    .nombre("Sabrina")
                    .apellido("Espacio")
                    .telefono("2612789563")
                    .email("sabrina.espacio@gmail.com")
                    .build();

            //Unidireccionalidad de Uno a Muchos de Cliente a domicilios
            //agrego con los metodos del objeto cliente los domicilios correspondientes
            cliente.agregarDomicilio(domicilio1);
            cliente.agregarDomicilio(domicilio2);

            cliente1.agregarDomicilio(domicilio3);


            //Creación de un Rubro
            Rubro rubro = Rubro.builder()
                    .denominacion("Vegetales")
                    .build();


            //Creación de un producto
            Producto producto1 = Producto.builder()
                    .denominacion("Ensalada")
                    .precioVenta(250)
                    .receta("3 zanahorias")
                    .stockActual(23)
                    .stockMinimo(2)
                    .precioCompra(200)
                    .tiempoEstimadoCocina(45)
                    .unidadMedida("cm")
                    .tipo("Acompañamiento")

                    .build();

            //Creación de otro producto
            Producto producto2 = Producto.builder()
                    .denominacion("Pizza")
                    .precioVenta(250)
                    .receta("Harina")
                    .stockActual(23)
                    .stockMinimo(2)
                    .precioCompra(200)
                    .tiempoEstimadoCocina(45)
                    .unidadMedida("cm")
                    .tipo("Comida")

                    .build();

            //Asociación productos con rubro
            rubro.agregarProducto(producto1);
            rubro.agregarProducto(producto2);

            //Guardar un Rubro
            rubroRepository.save(rubro);


            //Creación de DetallePedido
            DetallePedido detallePedido1 = DetallePedido.builder()
                    .cantidad(20)
                    .subtotal(5)
                    .build();

            DetallePedido detallePedido2 = DetallePedido.builder()
                    .cantidad(20)
                    .subtotal(5)
                    .build();

            DetallePedido detallePedido3 = DetallePedido.builder()
                    .cantidad(2)
                    .subtotal(5)
                    .build();

            //Creación de un Pedido
            //Con fecha actual creada por LocalDate
            LocalDate fechaActual = LocalDate.now();

            Pedido pedido1 = Pedido.builder()
                    .total(2500)
                    .fecha(fechaActual)
                    .tipoEnvio("RETIRA")
                    .estado("INICIADO")
                    .build();

            Pedido pedido2 = Pedido.builder()
                    .total(4000)
                    .fecha(fechaActual)
                    .tipoEnvio("DELIVERY")
                    .estado("ENTREGADO")
                    .build();


            //Creación factura
            Factura factura1 = Factura.builder()
                    .fecha(fechaActual)
                    .descuento(300)
                    .total(2200)
                    .numero(2)
                    .formaPago("MERCADO_PAGO")
                    .build();
            Factura factura2 = Factura.builder()
                    .fecha(fechaActual)
                    .descuento(500)
                    .total(3500)
                    .numero(2)
                    .formaPago("EFECTIVO")
                    .build();


            //setear detalle pedido a Pedido
            pedido1.agregarDetallePedido(detallePedido1);
            pedido2.agregarDetallePedido(detallePedido2);
            pedido1.agregarDetallePedido(detallePedido3);


            //Agregar un pedido a un cliente--Relación unidireccional uno a muchos Cliente a Pedidos
            cliente.agregarPedido(pedido1);
            cliente1.agregarPedido(pedido2);

            //Agregar producto a detallePedido
            detallePedido1.setProducto(producto1);
            detallePedido2.setProducto(producto2);
            detallePedido3.setProducto(producto1);

            //Setear factura a pedido
            pedido1.setFactura(factura1);
            pedido2.setFactura(factura2);


            //Guardar un cliente en la base de datos
            //Ya que extiende de JpaRepository me da estos métodos.
            //Graba el ORM gracias a esto
            clienteRepository.save(cliente);
            clienteRepository.save(cliente1);


            //-----------------------------------------------------------------


            //Recuperar el cliente de la base de datos
            Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);

            //prueba pedido
            Pedido pedidoRecuperado = pedidoRepository.findById(pedido1.getId()).orElse(null);
            if (clienteRecuperado != null ){
                System.out.println("\n------------------ DATOS CLIENTE ------------------");
                System.out.println("Nombre: "+clienteRecuperado.getNombre());
                System.out.println("Apellido: "+clienteRecuperado.getApellido());
                System.out.println("Email: "+clienteRecuperado.getEmail());
                System.out.println("Telefono: "+clienteRecuperado.getTelefono());

                clienteRecuperado.mostrarDomicilios();
                clienteRecuperado.mostrarPedidos();




            }






        };

    }


}