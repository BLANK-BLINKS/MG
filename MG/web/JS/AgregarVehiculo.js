function agregarVehiculo() {
    let ruta = "http://localhost:8080/MG/api/vehiculo/insert";
    
    let v_numeroSerie = document.getElementById("agregarNumeroSerie").value;
    let v_modelo = document.getElementById("agregarModelo").value;
    let v_color = document.getElementById("agregarColor").value;
    let v_tapiceria = document.getElementById("agregarTapiceria").value;
    let v_anio = document.getElementById("agregarAnio").value;
    let v_IDV = document.getElementById("agregarIDV").value;
    let v_fraCompra = document.getElementById("agregarFraCompra").value;
    let v_diasStock = document.getElementById("agregarDiasStock").value;
    let v_ubicacion = document.getElementById("agregarUbicacion").value;
    let v_categoria = document.getElementById("agregarCategoria").value;
    let v_estatus = document.getElementById("agregarEstatus").value;
    
    // Validar campos requeridos antes de enviar la solicitud
    if (!v_numeroSerie || !v_modelo || !v_color || !v_tapiceria || !v_anio || !v_IDV || !v_diasStock || !v_ubicacion || !v_categoria || !v_estatus) {
        alert("Por favor complete todos los campos obligatorios antes de agregar el vehículo.");
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
                alert("Vehículo agregado correctamente");
                window.location.href = "Vehiculo.html"; // Redirige al usuario al HTML de Vehículos
            } else {
                throw new Error('El servidor no confirmó la inserción del vehículo.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("No fue posible insertar el vehículo. Verifique los datos e intente nuevamente.");
        });
}