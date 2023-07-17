package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Engorde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EngordeRepository extends JpaRepository<Engorde, Integer> {
    @Query(value = "SELECT * FROM tbl_engorde WHERE id LIKE :id", nativeQuery = true)
    Engorde buscarPorIdEngorde(@Param("id") Integer id);
}
