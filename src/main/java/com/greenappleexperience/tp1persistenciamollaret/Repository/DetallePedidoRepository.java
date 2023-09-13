package com.greenappleexperience.tp1persistenciamollaret.Repository;

import com.greenappleexperience.tp1persistenciamollaret.Entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}
