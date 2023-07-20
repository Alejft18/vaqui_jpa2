document.addEventListener("DOMContentLoaded", function() {
    // Obtenemos la referencia al enlace
    const redirectLink = document.getElementById("redirect-link");

    // Esperamos 2 segundos antes de redirigir
    setTimeout(function() {
      // Obtenemos la URL del enlace
      const url = redirectLink.getAttribute("href");
      // Redireccionamos a la URL
      window.location.href = url;
    }, 1000); // 2000 milisegundos = 2 segundos
  });