package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Gestacion;
import com.example.vaqui_jpa2.Servicio.ServicioGestacion;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorGestacion {

    private ServicioGestacion servicio;

    public ControladorGestacion(ServicioGestacion servicio){this.servicio =  servicio;}

    @GetMapping("/listarGestacion")
    public ResponseEntity<String> listarEngorde(){
        JSONArray jsonArray= servicio.listarGestacion();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }


    @PostMapping("/agregarGestacion/{id}")
    public String agregarGestacion(@RequestBody Gestacion gestacion, @PathVariable("id") Integer id){
        return servicio.agregarGestacion(gestacion,id);
    }

    @GetMapping("/buscarGestacionId/{id}")
    public Gestacion buscarGestacionId(@PathVariable("id")Integer id){
        return servicio.buscarGestacionId(id);
    }

    @PutMapping("/actualizarGestacion/{id}")
    public String actualizarGestacion(@RequestBody Gestacion gestacion, @PathVariable("id") Integer id){
        return servicio.actualizarGestacion(gestacion,id);
    }

    @DeleteMapping("/eliminarGestacion/{id}")
    public String eliminarGestacion(@PathVariable("id") Integer id){
        return servicio.eliminargestacion(id);
    }
}
