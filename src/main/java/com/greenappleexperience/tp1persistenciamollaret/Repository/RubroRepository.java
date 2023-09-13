package com.greenappleexperience.tp1persistenciamollaret.Repository;

import com.greenappleexperience.tp1persistenciamollaret.Entity.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
}
