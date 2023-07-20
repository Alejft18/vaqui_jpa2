package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Servicio.ServicioGeneral;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> listarGeneral(){
        JSONArray jsonArray= servicio.listarGeneral();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
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

