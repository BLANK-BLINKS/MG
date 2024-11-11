function toggleMenu() {
    const sidebar = document.getElementById('sidebar');
    const mainContent = document.getElementById('main-content');
    sidebar.classList.toggle('closed');
    mainContent.classList.toggle('collapsed');
}

async function cargarContenido(url) {
    try {
        const respuesta = await fetch(url);
        console.log('Respuesta del servidor:', respuesta);
        if (!respuesta.ok) throw new Error(`Error ${respuesta.status}`);
        const contenido = await respuesta.text();
        console.log('Contenido cargado:', contenido); // Para depuración
        // Actualiza solo el contenido principal
        document.getElementById('main-content').innerHTML = contenido;
    } catch (error) {
        console.error("Error al cargar el contenido:", error);
    }
}

function redirigir(url) {
    cargarContenido(url);
}
