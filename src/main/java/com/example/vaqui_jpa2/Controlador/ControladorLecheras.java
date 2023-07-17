package com.example.vaqui_jpa2.Controlador;

import com.example.vaqui_jpa2.Entidad.Lechera;
import com.example.vaqui_jpa2.Servicio.ServiciosLecheras;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class    ControladorLecheras {

    ServiciosLecheras servicios;

    public ControladorLecheras(ServiciosLecheras servicios){this.servicios = servicios;}


    @GetMapping("/listarLecheras")
    public ResponseEntity<String> listarLecheras(){
        JSONArray jsonArray=servicios.listarLecharas();
        String json= jsonArray.toString();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }

    @PostMapping("/agregarLecheras/{id}")
    public String agregarLechera(@RequestBody Lechera lechera, @PathVariable("id") Integer id){return servicios.agregarLechera(lechera,id);}

    @GetMapping("/buscarLecheraId/{id}")
    public Lechera buscarLecheraId(@PathVariable("id")Integer id){
        return servicios.buscarLecherasId(id);
    }

    @PutMapping("/actualizarLechera/{id}")
    public String actualizarLechera(@RequestBody Lechera lechera, @PathVariable("id") Integer id){
        return servicios.actualizarLecheras(lechera,id);
    }

    @DeleteMapping("/eliminarLechera/{id}")
    public String eliminarLechera(@PathVariable("id") Integer id){
        return servicios.eliminarLechera(id);
    }

    @GetMapping("/promedioLeche")
    public Double promedioLeche(){return servicios.promedioLeche();}
}
