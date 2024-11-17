function ActualizarVehiculo() {
    let ruta = "http://localhost:8080/MG/api/vehiculo/update";
    
    let v_numeroSerie = document.getElementById("ActualizarNumeroSerie").value;
    let v_modelo = document.getElementById("ActualizarModelo").value;
    let v_color = document.getElementById("ActualizarColor").value;
    let v_tapiceria = document.getElementById("ActualizarTapiceria").value;
    let v_anio = document.getElementById("ActualizarAnio").value;
    let v_IDV = document.getElementById("ActualizarIDV").value;
    let v_fraCompra = document.getElementById("ActualizarFraCompra").value;
    let v_diasStock = document.getElementById("ActualizarDiasStock").value;
    let v_ubicacion = document.getElementById("ActualizarUbicacion").value;
    let v_categoria = document.getElementById("ActualizarCategoria").value;
    let v_estatus = document.getElementById("ActualizarEstatus").value;
    
    // Validar campos requeridos antes de enviar la solicitud
    if (!v_numeroSerie || !v_modelo || !v_color || !v_tapiceria || !v_anio || !v_IDV || !v_diasStock || !v_ubicacion || !v_categoria || !v_estatus) {
        alert("Por favor complete todos los campos obligatorios antes de Actualizar el vehículo.");
        return;
    }
    
    let _datos = {
        numeroSerie: v_numeroSerie,
        modelo: v_modelo,
        color: v_color,
        tapiceria: v_tapiceria,
        anio: v_anio,
        IDV: v_IDV,
        fraCompra: v_fraCompra,
        diasStock: v_diasStock,
        ubicacion: v_ubicacion,
        categoria: v_categoria,
        estatus: v_estatus
    };
    
    const queryString = new URLSearchParams(_datos).toString();
    
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: queryString
    };
    
    fetch(ruta, requestOptions)
        .then(response => {
            if (!response.ok) {
                // Si la respuesta no es exitosa, mostramos un mensaje de error
                throw new Error(`Error en la solicitud: ${response.statusText}`);
            }
            return response.json();
        })
        .then(json => {
            if (json && json['Numero de serie']) {
                alert("Vehículo Actualizado correctamente");
                window.location.href = "Vehiculo.html"; // Redirige al usuario al HTML de Vehículos
            } else {
                throw new Error('El servidor no confirmó la actualización del vehículo.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("No fue posible actualizar el vehículo. Verifique los datos e intente nuevamente.");
        });
}

document.addEventListener('DOMContentLoaded', () => {
    // Recuperar los datos del vehículo desde localStorage
    const vehiculo = JSON.parse(localStorage.getItem('vehiculoSeleccionado'));

    if (vehiculo) {
        // Llenar los campos del formulario con los datos del vehículo
        document.getElementById('ActualizarNumeroSerie').value = vehiculo.numeroSerie || '';
        document.getElementById('ActualizarModelo').value = vehiculo.modelo || '';
        document.getElementById('ActualizarColor').value = vehiculo.color || '';
        document.getElementById('ActualizarTapiceria').value = vehiculo.tapiceria || '';
        document.getElementById('ActualizarAnio').value = vehiculo.anio || '';
        document.getElementById('ActualizarIDV').value = vehiculo.IDV || '';
        document.getElementById('ActualizarFraCompra').value = vehiculo.fraCompra || '';
        document.getElementById('ActualizarDiasStock').value = vehiculo.diasStock || '';

        // Mapeo de valores de texto a sus correspondientes valores en el select
        const ubicacionMap = {
            "Patio": "1",
            "Exhibición": "2",
            "Almacen": "5",
            "Lavado": "6",
            "San Luis": "7",
            "En tránsito": "8",
            "Entrega": "9",
            "Taller": "3",
            "Servicio": "4"
        };

        const categoriaMap = {
            "Nuevo": "1",
            "Seminuevo": "2",
            "Servicio": "3"
        };

        const estatusMap = {
            "Disponible": "1",
            "En trato": "2",
            "Vendido": "3",
            "Facturado": "4",
            "Entregado": "5",
            "Servicio": "6"
        };

        // Ajustar los selects según el valor mapeado
        setSelectValue('ActualizarUbicacion', ubicacionMap[vehiculo.ubicacion.trim()]);
        setSelectValue('ActualizarCategoria', categoriaMap[vehiculo.categoria.trim()]);
        setSelectValue('ActualizarEstatus', estatusMap[vehiculo.estatus.trim()]);
    }
});

// Función para seleccionar el valor correcto en un select
function setSelectValue(selectId, value) {
    const select = document.getElementById(selectId);
    if (select) {
        // Verificar si el valor existe como opción
        for (let i = 0; i < select.options.length; i++) {
            if (select.options[i].value == value) {
                select.selectedIndex = i;
                break;
            }
        }
    }
}

