$(document).ready(function(){

let categoria = "";

    // Agregar BOVINO GENERAL
$("#agregar").on('click', function() {
    let datos = {
        raza: $('#raza').val(),
        genero: $('#genero').val(),
        fecha_nacimiento: $('#fechaNacimiento').val(),
        procedencia: $('#procedencia').val(),
        imagen: $('#imagen').val()
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarGeneral",
        type: "POST",
        data: datosEnvio,
        contentType: "application/JSON",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./Seleccionar categoria.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});

    // Agregar LECHERA
$("#agregarLechera").on('click', function() {
    categoria = "lechera";
    let datos = {
        id: $('#id').val(),
        litros_producidos: $('#litrosLeche').val(),
        fecha_ordeno: $('#fecha_ordeño').val(),
        peso_kilos: $('#peso_lechera').val(),
        fecha_revision: $('#revision_lechera').val(),
        fecha_parto: $('#fecha_parto').val(),
        cant_partos: $('#partos_cantidad').val(),
        categoria: categoria
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarLecheras/" + $('#id').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});


    // Agregar ENGORDE
$("#agregarEngorde").on('click', function() {
    categoria = "engorde";
    let datos = {
        id: $('#id').val(),
        peso_kilos: $('#peso').val(),
        fecha_revision: $('#fecha_reivision').val(),
        alimento: $('#alimento').val(),
        categoria: categoria
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/ingresarEngorde/" + $('#id').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});


    // Agregar TERNERO
$("#agregarTernero").on('click', function() {
    let categoria = "ternero";
    let datos = {
        id: $('#id').val(),
        id_madre: $('#id_madre').val(),
        peso_kilos: $('#peso').val(),
        fecha_revision: $('#revision').val(),
        categoria: categoria
    };

    let datosEnvio = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:8080/agregarTernero/" + $('#id').val() + "/" + $('#id_madre').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});


    // Agregar GESTACION
$("#agregarGestacion").on('click', function() {
    categoria = "gestacion";
    let datos = {
        id: $('#id').val(),
        peso_kilos: $('#peso').val(),
        fecha_inseminacion: $('#inseminacion').val(),
        fecha_aproxParto: $('#aproxParto').val(),
        fecha_ultimoParto: $('#fecha_ult_parto').val(),
        fecha_revision: $('#fecha_reivision').val(),
        categoria: categoria
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarGestacion/" + $('#id').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});


    // Agregar SECADO
$("#agregarSecado").on('click', function() {
    categoria = "secado";
    let datos = {
        id: $('#id').val(),
        fecha_ultimo_parto: $('#ult_parto').val(),
        peso_kilos: $('#peso').val(),
        fecha_revision: $('#revision').val(),
        fecha_ordeno: $('#fecha_ordeño').val(),
        categoria: categoria
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarSecado/" + $('#id').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});


    // Agregar TORO
$("#agregarToro").on('click', function() {
    categoria = "toro";
    let datos = {
        id: $('#id').val(),
        peso_kilos: $('#peso').val(),
        fecha_extraccion: $('#extraccion').val(),
        vacas_montadas: $('#vacas_montadas').val(),
        fecha_revision: $('#fecha_reivision').val(),
        categoria: categoria
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarToro/" + $('#id').val(),
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./LandingPage.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});

    // Agregar USUARIO
        $("#registrar").on('click',function(){
            let datos = {
                id: parseInt($('#id_empleado').val()),
                nombre: $('#nombre').val(),
                apellido: $('#apellido').val(),
                telefono: parseInt($('#telefono').val()),
                correo: $('#correo').val(),
                contrasena: $('#contraseña').val(),
                rol: $('#rol').val(),
                area: $('#area').val()
//                imagen: $('#seleccionar__imagen').val(),
            }

            console.log(datos);
            let datosEnvio = JSON.stringify(datos);
            console.log(datosEnvio);

            $.ajax({
                url: "http://localhost:8080/agregarUsuario",
                type: "POST",
                data: datosEnvio,
                contentType: "application/JSON",
                dataType: "JSON",
                success: function(response) {
                    console.log(response); // Muestra la respuesta del servidor en la consola para inspeccionarla
                    try {
                        let jsonResponse = JSON.parse(response); // Intenta parsear la respuesta como JSON
                        alert("El usuario se agregó exitosamente."); // Muestra un mensaje de éxito
                        window.location.href = "./LandingPage.html";
                    } catch (error) {
                        alert("Error al agregar el usuario: La respuesta del servidor no es un JSON válido."); // Muestra un mensaje de error si no se puede parsear como JSON
                    }
                },
           });
        });


        //CARGAR EL ULTIMO ID
        $.ajax({
            url: 'http://localhost:8080/ultimoIdGeneral',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                $('#id').val(data.id);
            },
            error: function(error) {
                console.error(error);
            }
        });

});
