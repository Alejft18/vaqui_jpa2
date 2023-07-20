package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Gestacion;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioGeneral {
    GeneralRepository repository;

    public ServicioGeneral(GeneralRepository repository) {
        this.repository = repository;
    }


    public JSONArray listarGeneral(){
        JSONArray jsonArray = new JSONArray();
        List<General> generals = repository.findAll();

        for (General general: generals) {
            int id = general.getId();
            String raza = general.getRaza();
            String genero = general.getGenero();
            LocalDate fecha_nacimiento = general.getFecha_nacimiento();
            String procedencia = general.getProcedencia();
            String imagen = general.getImagen();


            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id",id);
                jsonObject.put("raza",raza);
                jsonObject.put("genero",genero);
                jsonObject.put("fecha_nacimiento",fecha_nacimiento);
                jsonObject.put("procedencia",procedencia);
                jsonObject.put("imagen",imagen);

                jsonArray.put(jsonObject);

            }catch (JSONException e){System.out.println(e);}
        }

        return jsonArray;

    }

    public General ultimoId(){
        return repository.ultimoId();
    }



    public  String agregarGeneral(General general){
        repository.save(general);
        return "Ingreso exitoso";
    }

    public String actualizarBovinoGeneral(General general){
        String mensaje="Error al actualizar el bovino";
        if (repository.existsById(general.getId())){
            repository.save(general);
            mensaje = "Actualizacion exitosa del bovino";
        }
        return mensaje;
    }


    public String eliminarBovinoGeneral(int id){
        String mensaje="Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }

    public Integer cantidadBovinos(){return repository.cantidadBovinos();}
}
