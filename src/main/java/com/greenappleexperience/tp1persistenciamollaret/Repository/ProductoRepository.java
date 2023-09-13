package com.greenappleexperience.tp1persistenciamollaret.Repository;

import com.greenappleexperience.tp1persistenciamollaret.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
