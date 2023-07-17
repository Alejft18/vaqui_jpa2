package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Toro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToroRepository extends JpaRepository<Toro, Integer> {
    @Query(value = "SELECT * FROM tbl_toro WHERE id LIKE :id", nativeQuery = true)
    Toro buscarPorIdToro(@Param("id") Integer id);
}

