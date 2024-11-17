
document.addEventListener('DOMContentLoaded', function() {
    CargarTabla();
});

function CargarTabla() {
    let ruta2 = "http://localhost:8080/MG/api/vehiculo/getall";
    fetch(ruta2)
        .then(function(data) {
            return data.json();
        })
        .then(function(data) {
            // Obtener la tabla y su cuerpo
            const tablaVehiculos = document.getElementById("tablaVehiculos").getElementsByTagName('tbody')[0];

            // Limpiar la tabla
            tablaVehiculos.innerHTML = "";

            // Recorrer los datos y agregar filas a la tabla
            data.forEach(function(fila) {
                const nuevaFila = tablaVehiculos.insertRow(-1);

                const numeroSerieCell = nuevaFila.insertCell(0);
                numeroSerieCell.innerHTML = fila.numeroSerie;

                const modeloCell = nuevaFila.insertCell(1);
                modeloCell.innerHTML = fila.modelo;

                const colorCell = nuevaFila.insertCell(2);
                colorCell.innerHTML = fila.color;

                const tapiceriaCell = nuevaFila.insertCell(3);
                tapiceriaCell.innerHTML = fila.tapiceria;

                const anioCell = nuevaFila.insertCell(4);
                anioCell.innerHTML = fila.anio;

                const IDVCell = nuevaFila.insertCell(5);
                IDVCell.innerHTML = fila.IDV;

                const fraCompraCell = nuevaFila.insertCell(6);
                fraCompraCell.innerHTML = fila.fraCompra;

                const diasStockCell = nuevaFila.insertCell(7);
                diasStockCell.innerHTML = fila.diasStock;

                const ubicacionCell = nuevaFila.insertCell(8);
                ubicacionCell.innerHTML = fila.ubicacion;

                const categoriaCell = nuevaFila.insertCell(9);
                categoriaCell.innerHTML = fila.categoria;

                const estatusCell = nuevaFila.insertCell(10);
                estatusCell.innerHTML = fila.estatus;

                // Agregar el evento de clic para seleccionar el vehículo
                nuevaFila.onclick = function() {
                    seleccionarVehiculo(fila);
                };
            });
        })
        .catch(function(error) {
            console.error("Error al cargar la tabla: " + error);
        });
}

function seleccionarVehiculo(vehiculo) {
    // Almacenar datos del vehículo en localStorage
    localStorage.setItem('vehiculoSeleccionado', JSON.stringify(vehiculo));
    // Redirigir a la página de actualización
    window.location.href = 'ActualizarVehiculo.html';
}
