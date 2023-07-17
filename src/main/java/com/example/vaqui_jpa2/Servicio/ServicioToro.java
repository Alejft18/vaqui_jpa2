package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Toro;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import com.example.vaqui_jpa2.Repositorio.ToroRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioToro {
    ToroRepository repository;
    GeneralRepository genrepository;


    public ServicioToro(ToroRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Toro> listarTorosCodigo(){
        return (ArrayList<Toro>) repository.findAll();
    }

    public JSONArray listarToros(){
        JSONArray jsonArray = new JSONArray();
        List<Toro> toros = repository.findAll();

        for (Toro toro : toros) {
            int id = toro.getId_toros().getId();
            Double peso = toro.getPeso_kilos();
            LocalDate fechaExtraccion = toro.getFecha_extraccion();
            int vacasMontadas = toro.getVacas_montadas();
            LocalDate fechaRevi = toro.getFecha_revision();
            String categoria = toro.getCategoria();

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("fecha_extraccion",fechaExtraccion);
                jsonObject.put("vacas_montadas",vacasMontadas);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaRevi);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }


    public String agregarToro(Toro toro, Integer id){
        String mensaje = "";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("macho")){

            Double peso = toro.getPeso_kilos();
            LocalDate fechaExtraccion = toro.getFecha_extraccion();
            int vacasMontadas = toro.getVacas_montadas();
            LocalDate fechaRevi = toro.getFecha_revision();
            String categoria = toro.getCategoria();

            Toro tor = new Toro(general,peso,fechaExtraccion,vacasMontadas,fechaRevi,categoria);
            repository.save(tor);

            mensaje = "Toro ingresado con exito";
        }else {mensaje = "Error al ingresar al toro";}

        return mensaje;
    }

    public Toro buscarToroId(Integer id){return repository.buscarPorIdToro(id);}
    public String eliminarToro(Integer id){
        String mensaje = "";

        Toro toro = repository.buscarPorIdToro(id);
        Integer codigo= toro.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Toro borrado con exito";

        }else {mensaje = "Error al borrar el toro";}

        return mensaje;
    }

    public String actualizarToro(Toro toro, Integer id){
        String mensaje = "";

        Toro semental = repository.buscarPorIdToro(id);
        Integer codigo = semental.getCodigo();

        if (repository.existsById(codigo)){
            semental.setFecha_revision(toro.getFecha_revision());
            semental.setFecha_extraccion(toro.getFecha_extraccion());
            semental.setPeso_kilos(toro.getPeso_kilos());
            semental.setVacas_montadas(toro.getVacas_montadas());
            repository.save(semental);

            mensaje = "Informacion actualizada del toro con exito";

        }else {mensaje = "Error al actualizar informacion del toro";}

        return mensaje;
    }
}

