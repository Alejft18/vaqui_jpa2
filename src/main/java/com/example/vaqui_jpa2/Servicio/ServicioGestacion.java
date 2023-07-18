package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Gestacion;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import com.example.vaqui_jpa2.Repositorio.GestacionRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioGestacion {
    GestacionRepository repository;
    GeneralRepository genrepository;

    public ServicioGestacion(GestacionRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Gestacion> listarGestacionCodigo(){
        return (ArrayList<Gestacion>) repository.findAll();
    }

    public JSONArray listarGestacion(){
        JSONArray jsonArray = new JSONArray();
        List<Gestacion> gestaciones = repository.findAll();


        for (Gestacion gestacion: gestaciones) {
            int id = gestacion.getId_gestacion().getId();
            Double peso = gestacion.getPeso_kilos();
            LocalDate fechaInsemi = gestacion.getFecha_inseminacion();
            LocalDate fechaAproxParto = gestacion.getFecha_aprox_parto();
            LocalDate fechaUltiParto = gestacion.getFecha_ultimo_parto();
            LocalDate fechaRevi = gestacion.getFecha_revision();
            String categoria = gestacion.getCategoria();



            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id",id);
                jsonObject.put("peso_kilos",peso);
                jsonObject.put("fecha_inseminacion", fechaInsemi);
                jsonObject.put("fecha_aproxParto",fechaAproxParto);
                jsonObject.put("fecha_ultimoParto",fechaUltiParto);
                jsonObject.put("fecha_revision",fechaRevi);
                jsonObject.put("categoria",categoria);

                jsonArray.put(jsonObject);

            }catch (JSONException e){System.out.println(e);}
        }

        return jsonArray;
    }

    public String agregarGestacion(Gestacion gestacion, Integer id){
        String mensaje = "Bovino en gestacion no ingresado";

        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("hembra")){
            Double peso = gestacion.getPeso_kilos();
            LocalDate fechaInsemi = gestacion.getFecha_inseminacion();
            LocalDate fechaAproxParto = gestacion.getFecha_aprox_parto();
            LocalDate fechaUltiParto = gestacion.getFecha_ultimo_parto();
            LocalDate fechaRevi = gestacion.getFecha_revision();
            String categoria = gestacion.getCategoria();

            Gestacion ges= new Gestacion(general,peso,fechaInsemi,fechaAproxParto,fechaUltiParto,fechaRevi,categoria);
            repository.save(ges);

            mensaje = "Bovino en gestacion ingresado con exito";

        }else {mensaje = "Error al ingresar Bovino en gestacion";}

        return mensaje;
    }

    public Gestacion buscarGestacionId(Integer id){return repository.buscarPorIdGestacion(id);}
    public String eliminargestacion(Integer id){
        String mensaje = "No se puede borrar el bovino Gestacion";

        Gestacion gestacion = repository.buscarPorIdGestacion(id);
        Integer codigo= gestacion.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino gestacion borrado con exito";

        }else {mensaje = "Error al borrar el bovino gestacion";}

        return mensaje;
    }

    public String actualizarGestacion(Gestacion gestacion, Integer id){
        String mensaje = "No se puede actualizar el bovino gestacion";

        Gestacion gesta = repository.buscarPorIdGestacion(id);
        Integer codigo = gesta.getCodigo();

        if (repository.existsById(codigo)){
            gesta.setFecha_revision(gestacion.getFecha_revision());
            gesta.setFecha_aprox_parto(gestacion.getFecha_aprox_parto());
            gesta.setFecha_inseminacion(gestacion.getFecha_inseminacion());
            gesta.setFecha_ultimo_parto(gestacion.getFecha_ultimo_parto());
            gesta.setPeso_kilos(gestacion.getPeso_kilos());
            repository.save(gesta);

            mensaje = "Informacion actualizada del bovino en gestacion con exito";

        }else {mensaje = "Error al actualizar informacion del bovino en gestacion";}

        return mensaje;
    }

}

