package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Ternero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TerneroRepository extends JpaRepository<Ternero, Integer> {
    @Query(value = "SELECT * FROM tbl_ternero WHERE id LIKE :id", nativeQuery = true)
    Ternero buscarPorIdTernero(@Param("id") Integer id);

    @Query(value = "SELECT count(codigo) AS 'cantidad_de_terneros' FROM tbl_ternero", nativeQuery = true)
    int cantidadTerneros();
}
