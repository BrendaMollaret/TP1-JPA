package com.greenappleexperience.tp1persistenciamollaret.Repository;

import com.greenappleexperience.tp1persistenciamollaret.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
