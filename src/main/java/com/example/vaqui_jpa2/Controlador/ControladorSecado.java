package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Secado;
import com.example.vaqui_jpa2.Servicio.ServiciosSecado;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorSecado {

    ServiciosSecado servicios;

    public ControladorSecado(ServiciosSecado servicios){this.servicios = servicios;}

    @GetMapping("/listarSecadoCodigo")
    public ArrayList<Secado> listarSecadoCodigo(){
        return servicios.listarSecadoCodigo();
    }

    @GetMapping("/listarSecado")
    public ResponseEntity<String> listarSecado(){
        JSONArray jsonArray = servicios.listarSecado();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }

    @PostMapping("/agregarSecado/{id}")
    public String agregarSecado(@RequestBody Secado secado, @PathVariable("id") Integer id){return servicios.agregarSecado(secado,id);}

    @GetMapping("/buscarSecadoId/{id}")
    public Secado buscarSecadoId(@PathVariable("id")Integer id){
        return servicios.buscarSecadoId(id);
    }

    @PutMapping("/actualizarSecado/{id}")
    public String actualizarSecado(@RequestBody Secado secado, @PathVariable("id") Integer id){
        return servicios.actualizarSecado(secado,id);
    }

    @DeleteMapping("/eliminarSecado/{id}")
    public String eliminarSecado(@PathVariable("id") Integer id){
        return servicios.eliminarSecado(id);
    }


}
