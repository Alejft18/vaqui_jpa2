package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Lechera;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import com.example.vaqui_jpa2.Repositorio.LecherasRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosLecheras {

    LecherasRepository repository;
    GeneralRepository genrepository;



    public ServiciosLecheras(LecherasRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public JSONArray listarLecharas(){
        JSONArray jsonArray = new JSONArray();
        List<Lechera> lecheras = repository.findAll();


        for (Lechera lechera : lecheras) {
            int id = lechera.getId_lecheras().getId();
            Double litro = lechera.getLitros_producidos();
            LocalDate fechaOrdeno = lechera.getFecha_ordeno();
            Double peso = lechera.getPeso_kilos();
            LocalDate fechaRevi = lechera.getFecha_revision();
            LocalDate fechaParto = lechera.getFecha_parto();
            int partos = lechera.getCant_partos();
            String categoria = lechera.getCategoria();

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("litros_producidos", litro);
                jsonObject.put("fecha_ordeno", fechaOrdeno);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaRevi);
                jsonObject.put("fecha_parto", fechaParto);
                jsonObject.put("cant_partos", partos);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public ArrayList<Lechera> listarLecherasCodigo(){
        return (ArrayList<Lechera>) repository.findAll();
    }

    public String agregarLechera(Lechera lechera, Integer id){
        String mensaje = "Vaca lechera no ingresada";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("hembra")){

            Double litro = lechera.getLitros_producidos();
            LocalDate fechaOrdeno = lechera.getFecha_ordeno();
            Double peso = lechera.getPeso_kilos();
            LocalDate fechaRevi = lechera.getFecha_revision();
            LocalDate fechaParto = lechera.getFecha_parto();
            int partos = lechera.getCant_partos();
            String categoria = lechera.getCategoria();

            Lechera leche = new Lechera(general,litro,fechaOrdeno,peso,fechaRevi,fechaParto,partos,categoria);
            repository.save(leche);

            mensaje = "Vaca lechera ingresada con exito";

        }else {mensaje = "Error al ingresar Vaca lechera";}

        return mensaje;
    }


    public Lechera buscarLecherasId(Integer id){return repository.buscarPorIdLecheras(id);}
    public String eliminarLechera(Integer id){
        String mensaje = "No se puede borrar el bovino Gestacion";

        Lechera lechera = repository.buscarPorIdLecheras(id);
        Integer codigo= lechera.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino gestacion borrado con exito";

        }else {mensaje = "Error al borrar el bovino gestacion";}

        return mensaje;
    }

    public String actualizarLecheras(Lechera lechera, Integer id){
        String mensaje = "No se puede actualizar la vaca lechera";

        Lechera leche = repository.buscarPorIdLecheras(id);
        Integer codigo = leche.getCodigo();

        if (repository.existsById(codigo)){
            leche.setCant_partos(lechera.getCant_partos());
            leche.setFecha_ordeno(lechera.getFecha_ordeno());
            leche.setFecha_parto(lechera.getFecha_parto());
            leche.setFecha_revision(lechera.getFecha_revision());
            leche.setLitros_producidos(lechera.getLitros_producidos());
            leche.setPeso_kilos(lechera.getPeso_kilos());
            repository.save(leche);

            mensaje = "Informacion actualizada la vaca lechera con exito";

        }else {mensaje = "Error al actualizar informacion de la vaca lechera";}

        return mensaje;
    }


    public Double promedioLeche(){return repository.promedioLeche();}



}

