import { createRoot } from 'react-dom/client';

function NavigationBar() {
  // TODO: Actually implement a navigation bar
  return <h1>Hello from React!</h1>;
}

const domNode = document.getElementById('navigation');
const root = createRoot(domNode);
root.render(<NavigationBar />);

function showRegisterForm() {
    document.getElementById('login-form').style.display = 'none';
    document.getElementById('register-form').style.display = 'block';
}


function submitForm(event) {
    event.preventDefault(); // Evitar la acción predeterminada del formulario

    // Obtener los datos del formulario
    var formData = {
        nombreUsuario: document.getElementById('nombreUsuario').value,
        contrasenia: document.getElementById('contrasenia').value
    };

    // Realizar la solicitud POST al servidor
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => {
        if (response.ok) {
            // Si la respuesta es exitosa, redirigir a otra página con el token en la URL
            window.location.href = 'misReclamos.html?token=' + response.text();
        } else {
            // Si la respuesta es un error, mostrar el mensaje de error
            alert('Error: ' + response.text());
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}


function register() {
    // Aquí puedes agregar la lógica para procesar el registro
    console.log('Intento de registro');
}





function toggleUnitSelection() {
    var userType = document.getElementById('user-type').value;
    var unitSelection = document.getElementById('unit-selection');
    unitSelection.style.display = (userType === 'dueno_inquilino') ? 'block' : 'none';
}

function filterCards() {
    var estadoSeleccionado = document.querySelector('.form-select').value;
    var tarjetas = document.querySelectorAll('.filtrable');

    tarjetas.forEach(function(tarjeta) {
        var tarjetaEstado = tarjeta.getAttribute('data-estado');
        if (estadoSeleccionado === 'todos' || estadoSeleccionado === tarjetaEstado) {
            tarjeta.style.display = 'block';
        } else {
            tarjeta.style.display = 'none';
        }
    });
}

function toggleSelection() {
    var radio1 = document.getElementById("inlineRadio1");
    var radio2 = document.getElementById("inlineRadio2");
    var aCSelection = document.getElementById("aC-selection");
    var unitSelection = document.getElementById("unit-selection");

    if (radio1.checked) {
        aCSelection.style.display = "none";
        unitSelection.style.display = "block";
    } else if (radio2.checked) {
        aCSelection.style.display = "block";
        unitSelection.style.display = "none";
    }
}

function toggleForm() {
    var form = document.getElementById("newreclamo-form");
    var cards = document.getElementById("tarjetas")
    form.style.display = form.style.display === "none" ? "block" : "none";
    cards.style.display= "none";
}

function registrarReclamo() {
    // Obtener datos del formulario
    var tipoReclamo = document.querySelector('input[name="inlineRadioOptions"]:checked').value;
    var descripcion = document.getElementById("exampleFormControlTextarea1").value;
    var seleccion = tipoReclamo === "unidad" ? document.getElementById("unit-list").value : document.getElementById("aC-list").value;

    // Crear nueva tarjeta
    var nuevaTarjeta = document.createElement("div");
    nuevaTarjeta.classList.add("card", "filtrable", "col-md-4", "mb-3");
    nuevaTarjeta.style.width = "18rem";
    nuevaTarjeta.setAttribute("data-estado", "pro"); // Estado en proceso

    var cardBody = document.createElement("div");
    cardBody.classList.add("card-body");

    var titulo = document.createElement("h5");
    titulo.classList.add("card-title");
    titulo.textContent = "ID";

    var detalle = document.createElement("h6");
    detalle.textContent = tipoReclamo === "unidad" ? "Unidad: " + seleccion : "Área Común: " + seleccion;

    var descripcionReclamo = document.createElement("h6");
    descripcionReclamo.textContent = "Descripción del Reclamo: " + descripcion;

    var estado = document.createElement("h6");
    estado.textContent = "Estado: En proceso";

    // Agregar elementos a la tarjeta
    cardBody.appendChild(titulo);
    cardBody.appendChild(detalle);
    cardBody.appendChild(descripcionReclamo);
    cardBody.appendChild(estado);

    nuevaTarjeta.appendChild(cardBody);

    // Agregar la nueva tarjeta a la sección de tarjetas
    document.getElementById("tarjetas").appendChild(nuevaTarjeta);

    // Limpiar el formulario o hacer cualquier otra tarea necesaria
    document.getElementById("newreclamo-form").reset();
}

 
function toggleDiv(divId) {
    
    document.getElementById('div1').style.display = 'none';
    document.getElementById('div2').style.display = 'none';
    document.getElementById('div3').style.display = 'none';
    document.getElementById('div4').style.display = 'none';

    
    document.getElementById(divId).style.display = 'block';
}

function ToggleMofif() {
    var form = document.getElementById("modif_reclamo-form");
    var cards = document.getElementById("tarjetas")
    form.style.display = form.style.display === "none" ? "block" : "none";
    cards.style.display= "none";
}

