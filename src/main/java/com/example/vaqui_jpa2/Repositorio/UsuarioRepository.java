package com.example.vaqui_jpa2.Repositorio;

import com.example.vaqui_jpa2.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
    @Query(value = "SELECT * FROM tbl_usuarios WHERE rol like 'empleado'",nativeQuery = true)
    List<Usuario> listarEmpleados();
}

