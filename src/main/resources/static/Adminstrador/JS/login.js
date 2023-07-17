function validarFormulario(event) {
    event.preventDefault(); // Evitar que el formulario se envíe automáticamente

    // Obtener los valores del formulario
    var numeroDocumento = document.getElementById('number').value;
    var contraseña = document.getElementById('contraseña').value;

    // Verificar las credenciales
    var adminCredenciales = ['1031802727', 'admin123'];
    var empleadoCredenciales = ['1031802727', 'empleado123'];

    if (numeroDocumento === adminCredenciales[0] && contraseña === adminCredenciales[1]) {
        // Redireccionar al administrador
        window.location.href = '/Adminstrador/LandingPage.html';
    } else if (numeroDocumento === empleadoCredenciales[0] && contraseña === empleadoCredenciales[1]) {
        // Redireccionar al empleado
        window.location.href = '/Empleado/LandingPage.html';
    } else {
        // Mostrar mensaje de error o realizar otra acción en caso de credenciales incorrectas
        alert('Debes ingresar tu usuario para poder ingresar');
    }
}