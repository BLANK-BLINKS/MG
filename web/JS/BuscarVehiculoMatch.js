document.getElementById('buscar').addEventListener('keyup', function() {
    const filtro = this.value.toUpperCase(); // Convierte a mayúsculas para comparación insensible a mayúsculas
    const tabla = document.getElementById('tablaVehiculos');
    const filas = tabla.getElementsByTagName('tr');

    for (let i = 1; i < filas.length; i++) { // Comienza en 1 para saltar el encabezado
        const celdas = filas[i].getElementsByTagName('td');
        let encontrado = false;

        for (let j = 0; j < celdas.length; j++) {
            const contenidoCelda = celdas[j].textContent || celdas[j].innerText;
            if (contenidoCelda.toUpperCase().indexOf(filtro) > -1) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            filas[i].style.display = '';
        } else {
            filas[i].style.display = 'none';
        }
    }
});
