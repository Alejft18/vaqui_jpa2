package com.example.vaqui_jpa2.Servicio;

import com.example.vaqui_jpa2.Entidad.Usuario;
import com.example.vaqui_jpa2.Repositorio.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioUsuario {
    UsuarioRepository repository;

    public ServicioUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Usuario> listar(){
        return (ArrayList<Usuario>) repository.findAll();
    }

    public List<Usuario> listarEmpleados(){
        return repository.listarEmpleados();
    }

    public String agregarUsuario(Usuario usuario){
        repository.save(usuario);
        return "Ingreso exitoso del usuario";
    }

    public String actualizarUsuario(Usuario usuario){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(usuario.getId())){
            repository.save(usuario);
            mensaje ="Se actualizo correctamente la informacion";
        }
        return mensaje;
    }

    public String eliminarUsuario(BigInteger id){
        String mensaje = "Error al eliminar el usuario";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje= "Eliminacion exotosa del usuario";
        }
        return mensaje;
    }

    public Usuario buscarUsuario(BigInteger id) {
        Usuario usu = null;
        if (repository.existsById(id)) {
            Usuario usuario = repository.findById(id).get();
            BigInteger id_usu = usuario.getId();
            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            BigInteger telefono = usuario.getTelefono();
            String correo = usuario.getCorreo();
            String contrasena = usuario.getContrasena();
            String rol = usuario.getRol();
            String area = usuario.getArea();
            String imagen = usuario.getImagen();

            usu = new Usuario(id_usu, nombre, apellido, telefono, correo, contrasena, rol, area, imagen);

        }

        return usu;

    }
}

