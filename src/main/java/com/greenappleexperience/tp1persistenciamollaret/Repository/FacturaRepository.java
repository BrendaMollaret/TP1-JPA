package com.greenappleexperience.tp1persistenciamollaret.Repository;

import com.greenappleexperience.tp1persistenciamollaret.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
