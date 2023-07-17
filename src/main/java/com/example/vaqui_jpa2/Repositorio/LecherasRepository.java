package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Lechera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LecherasRepository extends JpaRepository<Lechera, Integer> {
    @Query(value = "SELECT * FROM tbl_lechera WHERE id LIKE :id", nativeQuery = true)
    Lechera buscarPorIdLecheras(@Param("id") Integer id);

    @Query(value = "SELECT ROUND(AVG(litros_producidos),2) AS 'promedio de litros producidos' FROM tbl_lechera", nativeQuery = true)
    Double promedioLeche();
}
