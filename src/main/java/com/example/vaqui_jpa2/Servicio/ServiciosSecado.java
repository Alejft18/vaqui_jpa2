package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.General;
import com.example.vaqui_jpa2.Entidad.Secado;
import com.example.vaqui_jpa2.Repositorio.GeneralRepository;
import com.example.vaqui_jpa2.Repositorio.SecadoRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosSecado {
    SecadoRepository repository;
    GeneralRepository genrepository;


    public ServiciosSecado(SecadoRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Secado> listarSecadoCodigo(){
        return (ArrayList<Secado>) repository.findAll();
    }


    public JSONArray listarSecado(){
        JSONArray jsonArray = new JSONArray();
        List<Secado> secados = repository.findAll();


        for (Secado secado : secados) {
            int id = secado.getId_secado().getId();
            LocalDate fechaUltiParto = secado.getFecha_ultimo_parto();
            Double peso = secado.getPeso_kilos();
            LocalDate fechaRevi = secado.getFecha_revision();
            LocalDate fechaUltiOrdeno = secado.getFecha_ordeno();
            String categoria = secado.getCategoria();



            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("fecha_ultimo_parto", fechaUltiParto);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaRevi);
                jsonObject.put("fecha_ordeno", fechaUltiOrdeno);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public String agregarSecado(Secado secado, Integer id){

        String mensaje = "";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("hembra")){

            LocalDate fechaUltiParto = secado.getFecha_ultimo_parto();
            Double peso = secado.getPeso_kilos();
            LocalDate fechaRevi = secado.getFecha_revision();
            LocalDate fechaUltiOrdeno = secado.getFecha_ordeno();
            String categoria = secado.getCategoria();

            Secado seca = new Secado(general,fechaUltiParto,peso,fechaRevi,fechaUltiOrdeno,categoria);
            System.out.println(seca);
            repository.save(seca);

            mensaje = "Bovino en secado agregado con exito";

        }else {mensaje = "Error al ingresar bovino en secado";}

        return mensaje;
    }

    public Secado buscarSecadoId(Integer id){return repository.buscarPorIdSecado(id);}

    public String eliminarSecado(Integer id){
        String mensaje = "";

        Secado secado = repository.buscarPorIdSecado(id);
        Integer codigo= secado.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino en secado borrado con exito";

        }else {mensaje = "Error al borrar el bovino en secado";}

        return mensaje;
    }

    public String actualizarSecado(Secado secado, Integer id){
        String mensaje = "";

        Secado seca = repository.buscarPorIdSecado(id);
        Integer codigo = seca.getCodigo();

        if (repository.existsById(codigo)){
            seca.setFecha_revision(secado.getFecha_revision());
            seca.setFecha_ultimo_parto(secado.getFecha_ultimo_parto());
            seca.setFecha_ordeno(secado.getFecha_ordeno());
            seca.setPeso_kilos(secado.getPeso_kilos());
            repository.save(seca);

            mensaje = "Informacion actualizada del bovino en secado con exito";

        }else {mensaje = "Error al actualizar informacion del bovino en secado";}

        return mensaje;
    }

}

