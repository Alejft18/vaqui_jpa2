package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Servicio.ServicioGeneral;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorGeneral {

    ServicioGeneral servicio;

    public ControladorGeneral(ServicioGeneral servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarGeneral")
    public ArrayList<General> listarGeneral(){
        return servicio.listar();
    }

    @GetMapping("/ultimoIdGeneral")
    public General ultimoId(){return servicio.ultimoId();}

//    @GetMapping("/ulti_id")
//    public General ulti_id(){return servicio.ulti_id();}

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

