package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Servicio.ServicioGeneral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorGeneral {

    ServicioGeneral servicio;

    public ControladorGeneral(ServicioGeneral servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarGeneral")
    public ResponseEntity<List<General>> listarGeneral(){
        List<General> listaGeneral = servicio.listar();
        return ResponseEntity.ok(listaGeneral);
    }
    @GetMapping("/ultimoIdGeneral")
    public General ultimoId(){return servicio.ultimoId();}


    @GetMapping("/cantidadBovinos")
    public Integer cantidadBovinos(){return servicio.cantidadBovinos();}

    @PostMapping("/agregarGeneral")
    public String agregarGeneral(@RequestBody General general){
        return servicio.agregarGeneral(general);
    }

    @PutMapping("/actualizarBovinoGeneral")
    public String actualizarBovinoGeneral(@RequestBody General general){
        return servicio.actualizarBovinoGeneral(general);
    }

    @DeleteMapping("/eliminarBovinoGeneral/{id}")
    public String eliminarBovinoGeneral(@PathVariable("id") int id){
        return servicio.eliminarBovinoGeneral(id);
    }


}

