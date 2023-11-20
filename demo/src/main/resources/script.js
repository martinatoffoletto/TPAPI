function showRegisterForm() {
    document.getElementById('login-form').style.display = 'none';
    document.getElementById('register-form').style.display = 'block';
}

document.getElementById('login-form').addEventListener('submit', async function (event) {
    event.preventDefault();

    const nombreUsuario = document.getElementById('nombreUsuario').value;
    const contrasenia = document.getElementById('contrasenia').value;

    const response = await fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            nombreUsuario: nombreUsuario,
            contrasenia: contrasenia,
        }),
    });

    if (response.ok) {
        const token = await response.text();
        alert("Usuario existente");
        // Redirect to another page or perform other actions with the token
    } else {
        const errorMessage = await response.text();
        alert("Usuario inexistente"); // Display a user-friendly error message
    }
});



function register() {
    // Aquí puedes agregar la lógica para procesar el registro
    console.log('Intento de registro');
}

function toggleUnitSelection() {
    var userType = document.getElementById('user-type').value;
    var edifSelection= document.getElementById('edif-selection');
    var unitSelection = document.getElementById('unit-selection');
    unitSelection.style.display = (userType === 'dueno_inquilino') ? 'block' : 'none';
    edifSelection.style.display = (userType === 'dueno_inquilino') ? 'block' : 'none';
}

function filterCards() {
    var selectedState = document.getElementById('filter-state').value;
    var cards = document.querySelectorAll('.card');
    cards.forEach(function(card) {
        var cardState = card.getAttribute('data-estado');
        if (selectedState === 'todos' || cardState === selectedState) {
            card.style.display = 'block';
        } else {
            card.style.display = 'none';
        }
    });
}

function toggleSelection() {
    var radioValue = document.querySelector('input[name="inlineRadioOptions"]:checked').value;
    var aCSelection = document.getElementById('aC-selection');

    if (radioValue === 'aC') {
        aCSelection.style.display = 'block';
        fillACSelect();
    } else {
        aCSelection.style.display = 'none';
    }
}



 
 