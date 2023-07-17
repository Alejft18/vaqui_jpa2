package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Gestacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GestacionRepository extends JpaRepository<Gestacion, Integer> {
    @Query(value = "SELECT * FROM tbl_gestacion WHERE id LIKE :id", nativeQuery = true)
    Gestacion buscarPorIdGestacion(@Param("id") Integer id);
}

