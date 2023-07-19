//function validarFormulario(event) {
//    event.preventDefault(); // Evitar que el formulario se envíe automáticamente
//
//    // Obtener los valores del formulario
//    var numeroDocumento = document.getElementById('id').value;
//    var contraseña = document.getElementById('contraseña').value;
//
//    // Verificar las credenciales
//    var adminCredenciales = ['1031802727', 'admin123'];
//    var empleadoCredenciales = ['1031802727', 'empleado123'];
//
//    if (numeroDocumento === adminCredenciales[0] && contraseña === adminCredenciales[1]) {
//        // Redireccionar al administrador
//        window.location.href = '/Adminstrador/LandingPage.html';
//    } else if (numeroDocumento === empleadoCredenciales[0] && contraseña === empleadoCredenciales[1]) {
//        // Redireccionar al empleado
//        window.location.href = '/Empleado/LandingPage.html';
//    } else {
//        // Mostrar mensaje de error o realizar otra acción en caso de credenciales incorrectas
//        alert('Debes ingresar tu usuario para poder ingresar');
//    }
//}

function validarFormulario(event) {
    event.preventDefault();

    // Obtener los valores del formulario
    const id = document.getElementById('id').value;
    const contraseña = document.getElementById('contraseña').value;

    // Validar que los campos no estén vacíos
    if (id.trim() === '' || contraseña.trim() === '') {
        alert('Por favor, ingrese el número de documento y la contraseña.');
        return;
    }

    const url = `https://vaquijpa2-production.up.railway.app/buscarUsuario/${id}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Usuario no encontrado');
        }
        return response.json();
    })
    .then(usuario => {
        // Verificar si la contraseña coincide
        if (usuario.contrasena === contraseña) {
            // Verificar el rol del usuario
            if (usuario.rol === 'Empleada' || usuario.rol === 'empleada' || usuario.rol === 'Empleado' || usuario.rol === 'empleado') {
                alert('Inicio de sesión exitoso como empleado');
                // Redireccionar a la página de empleado después del inicio de sesión
                window.location.href = '/Empleado/LandingPage.html';
            } else if (usuario.rol === 'Administrador' || usuario.rol ==="administrador" || usuario.rol ==="Administradora" || usuario.rol ==="administradora") {
                alert('Inicio de sesión exitoso como administrador');
                // Redireccionar a la página de administrador después del inicio de sesión
                window.location.href = '/Adminstrador/LandingPage.html';
            } else {
                alert('Rol no reconocido');
            }

            // Cargar los datos del usuario en el perfil
            cargarPerfilUsuario(usuario.id); // Llama a la función para cargar los datos del usuario
        } else {
            alert('Documento y/o contraseña incorrectos');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Función para cargar los datos del perfil del usuario
function cargarPerfilUsuario(id) {
    const url = `https://vaquijpa2-production.up.railway.app/buscarUsuario/${id}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al obtener los datos del perfil');
        }
        return response.json();
    })
    .then(usuario => {
        // Mostrar los datos del usuario en la consola
        console.log('Datos del usuario:', usuario);

        // Mostrar los datos del usuario en el perfil
        document.getElementById('nombre').textContent = usuario.nombre;
        document.getElementById('apellido').textContent = usuario.apellido;
        document.getElementById('telefono').textContent = usuario.telefono;
        document.getElementById('correo').textContent = usuario.correo;
        document.getElementById('rol').textContent = usuario.rol;
        document.getElementById('area').textContent = usuario.area;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}





