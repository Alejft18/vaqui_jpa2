package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Toro;
import com.example.vaqui_jpa2.Servicio.ServicioToro;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorToro {
    ServicioToro servicio;

    public ControladorToro(ServicioToro servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarToroCodigo")
    public ArrayList<Toro> listarTorosCodigo(){
        return servicio.listarTorosCodigo();
    }

    @GetMapping("/listarToros")
    public ResponseEntity<String> listarToros(){
        JSONArray jsonArray = servicio.listarToros();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);

    }

    @PostMapping("/agregarToro/{id}")
    public String agregarToro(@RequestBody Toro toro, @PathVariable("id") Integer id){
        return servicio.agregarToro(toro, id);
    }

    @GetMapping("/buscarToroId/{id}")
    public Toro buscarToroId(@PathVariable("id")Integer id){
        return servicio.buscarToroId(id);
    }

    @PutMapping("/actualizarToro/{id}")
    public String actualizarToro(@RequestBody Toro toro, @PathVariable("id") Integer id){
        return servicio.actualizarToro(toro,id);
    }

    @DeleteMapping("/eliminarToro/{id}")
    public String eliminarToro(@PathVariable("id") Integer id){
        return servicio.eliminarToro(id);
    }

}

