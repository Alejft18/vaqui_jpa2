package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Ternero;
import com.example.vaqui_jpa2.Servicio.ServicioTernero;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorTernero {

    ServicioTernero servicio;

    public ControladorTernero(ServicioTernero servicio){
        this.servicio = servicio;
    }

    @GetMapping("/listarTerneroCodigo")
    public ArrayList<Ternero> listarTerneroCodigo(){
        return servicio.listarTerneroCodigo();
    }

    @GetMapping("/listarTerneros")
    public ResponseEntity<String> listarTernero(){
        JSONArray jsonArray = servicio.listarTernero();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);

    }

    @PostMapping("/agregarTernero/{id}/{id_madre}")
    public String agregarTernero(@RequestBody Ternero ternero, @PathVariable("id") Integer id, @PathVariable("id_madre") Integer id_madre){
        return servicio.agregarTernero(ternero,id,id_madre);
    }

    @GetMapping("/buscarTerneroId/{id}")
    public Ternero buscarTerneroId(@PathVariable("id")Integer id){
        return servicio.buscarTerneroId(id);
    }

    @GetMapping("/cantidadTerneros")
    public int cantidadTerneros(){return servicio.cantidadTerneros();}

    @PutMapping("/actualizarTernero/{id}")
    public String actualizarTernero(@RequestBody Ternero ternero, @PathVariable("id") Integer id){
        return servicio.actualizarTenero(ternero,id);
    }

    @DeleteMapping("/eliminarTernero/{id}")
    public String eliminarTernero(@PathVariable("id") Integer id){
        return servicio.eliminarTernero(id);
    }


}
