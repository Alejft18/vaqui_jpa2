//CODIGO PARA OBTENER LOS DATOS ESTADISTICOS
$(document).ready(function() {
  function obtenerDatosPromedio() {
    $.ajax({
      url: 'https://vaquijpa2-production.up.railway.app/promedioLeche',
      type: "GET",
      success: function(respuesta) {
        $("#promedioLeche").text(respuesta + " Lt"); // Actualiza el valor del elemento <h4>
      }
    });
  }

    function obtenerDatosBovinos() {
      $.ajax({
        url: 'https://vaquijpa2-production.up.railway.app/cantidadBovinos',
        type: "GET",
        success: function(respuesta) {
          $("#cantidadBovinos").text(respuesta + " Bovinos"); // Actualiza el valor del elemento <h4>
        }
      });
    }

    function obtenerDatosTerneros() {
      $.ajax({
        url: 'https://vaquijpa2-production.up.railway.app/cantidadTerneros',
        type: "GET",
        success: function(respuesta) {
          $("#cantidadTerneros").text(respuesta + " Terneros"); // Actualiza el valor del elemento <h4>
        }
      });
    }

  obtenerDatosPromedio(); // Llama a la función para obtener y mostrar los datos inicialmente
  obtenerDatosBovinos(); // Llama a la función para obtener y mostrar los datos inicialmente
  obtenerDatosTerneros(); // Llama a la función para obtener y mostrar los datos inicialmente

});

//CODIGO PARA EL SLIDER "COLABORADORES"
(function(){
    const sliders = [...document.querySelectorAll('.slider__body')];
    const arrowNext = document.querySelector('#next');
    const arrowBefore = document.querySelector('#before');
    let value;

    arrowNext.addEventListener('click', ()=>changePosition(1));

    arrowBefore.addEventListener('click', ()=>changePosition(-1));

    function changePosition(change){
        const currentElement = Number(document.querySelector('.slider__body--show').
        dataset.id);

        value = currentElement;
        value+= change;

        if(value === 0 || value == sliders.length+1){
            value = value === 0 ? sliders.length : 1; 
        }

        sliders[currentElement-1].classList.toggle('slider__body--show'); 
        sliders[value-1].classList.toggle('slider__body--show'); 

    }
})() 

//CODIGO PARA EL NAV RESPONSIVE
function toggleMenu() {
    var menu = document.getElementById("menu");
    menu.classList.toggle("active");
}

//CODIGO PARA EL PERFIL "BARRA LATERAL"
function toggleSidebar() {
  const sidebar = document.getElementById('sidebar');
  sidebar.classList.toggle('active');
}

document.addEventListener('click', function(event) {
  const sidebar = document.getElementById('sidebar');
  const targetElement = event.target;

  // Si el clic ocurre fuera de la barra lateral y del botón "perfil", y tampoco es la "X", se cierra la barra lateral
  if (!sidebar.contains(targetElement) && targetElement !== document.querySelector('.perfil')) {
      sidebar.classList.remove('active');
  }
});