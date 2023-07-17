package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Usuario;
import com.example.vaqui_jpa2.Servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorUsuario {
    ServicioUsuario servicio;

    public ControladorUsuario(ServicioUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarUsuario")
    public ArrayList<Usuario> listarUsario(){
        return servicio.listar();
    }

    @GetMapping("/buscarUsuario/{id}")
    public Usuario buscarUsuario(@PathVariable("id") BigInteger id){
        return servicio.buscarUsuario(id);
    }

    @GetMapping("/listarEmpleados")
    public List<Usuario> listarEmpleados(){return servicio.listarEmpleados();}

    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@RequestBody Usuario usuario){
        return servicio.agregarUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable("id") BigInteger id){
        return servicio.eliminarUsuario(id);
    }

    @PutMapping("/actualizarUsuario")
    public String actualizarUsuario(@RequestBody Usuario usuario){
        return servicio.actualizarUsuario(usuario);
    }
}

