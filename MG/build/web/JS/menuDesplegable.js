function toggleMenu() {
    const sidebar = document.getElementById('sidebar');
    const mainContent = document.getElementById('main-content');

    sidebar.classList.toggle('closed');
    mainContent.classList.toggle('collapsed');
}