package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralRepository extends JpaRepository<General, Integer> {

    @Query(value = "SELECT * FROM tbl_general ORDER BY id DESC LIMIT 1", nativeQuery = true)
    General ultimoId();

    @Query(value = "SELECT count(id) AS 'cantidad de bovinos' FROM tbl_general",nativeQuery = true)
    Integer cantidadBovinos();

}
