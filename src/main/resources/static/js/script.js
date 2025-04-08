const toggleBtn = document.getElementById('menu-toggle');
const navLinks = document.getElementById('header-nav');

toggleBtn.addEventListener('click', () => {
  navLinks.classList.toggle('show');
});
