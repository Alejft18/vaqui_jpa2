package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Ternero;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import com.example.vaqui_jpa2.Repositorio.TerneroRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTernero {
    TerneroRepository repository;
    GeneralRepository genrepository;
    public ServicioTernero(TerneroRepository repository, GeneralRepository genrepository) {
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Ternero> listarTerneroCodigo(){
        return (ArrayList<Ternero>) repository.findAll();
    }

    public JSONArray listarTernero(){
        JSONArray jsonArray = new JSONArray();
        List<Ternero> terneros = repository.findAll();

        for (Ternero ternero : terneros) {
            int id = ternero.getId_terneros().getId();
            int id_madre = ternero.getId_madre().getId();
            Double peso = ternero.getPeso_kilos();
            LocalDate fechaRevi = ternero.getFecha_revision();
            String categoria = ternero.getCategoria();


            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("id_madre",id_madre);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaRevi);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public String agregarTernero(Ternero ternero,Integer id, Integer id_madre){
        String mensaje="";
        General general = genrepository.findById(id).get();
        General idMadre = genrepository.findById(id_madre).get();

        if (genrepository.existsById(id) && idMadre.getGenero().equals("hembra")){

            Double peso = ternero.getPeso_kilos();
            LocalDate fechaRevi = ternero.getFecha_revision();
            String categoria = ternero.getCategoria();

            Ternero ter= new Ternero(general,idMadre,peso,fechaRevi,categoria);
            repository.save(ter);

            mensaje = "Ternero ingresado con exito";

        }else {mensaje = "Error al ingresar el ternero";}

        return mensaje;
    }

    public Ternero buscarTerneroId(Integer id){return repository.buscarPorIdTernero(id);}

    public String eliminarTernero(Integer id){
        String mensaje = "";

        Ternero ternero = repository.buscarPorIdTernero(id);
        Integer codigo= ternero.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Ternero borrado con exito";

        }else {mensaje = "Error al borrar el ternero";}

        return mensaje;
    }

    public String actualizarTenero(Ternero ternero, Integer id){
        String mensaje = "";

        Ternero terne = repository.buscarPorIdTernero(id);
        Integer codigo = terne.getCodigo();

        if (repository.existsById(codigo)){
            terne.setFecha_revision(ternero.getFecha_revision());
            terne.setPeso_kilos(ternero.getPeso_kilos());
            repository.save(terne);

            mensaje = "Informacion actualizada del ternero";

        }else {mensaje = "Error al actualizar informacion del ternero";}

        return mensaje;
    }

    public int cantidadTerneros(){return repository.cantidadTerneros();}
}
