@param boolean logado

<header class="header">
    <div class="container">
        <div class="header-logo">
            <img src="/img/logo.png" alt="Pet shop IFBA SAJ">
            <h2 class="header-title">Petshop IFBA SAJ</h2>
        </div>
        <button class="menu-toggle" id="menu-toggle">&#9776;</button>
        <nav class="header-nav">
            <ul id="header-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/veterinario">Veterinarios</a></li>
                @if (logado)
                    <li><a href="/dono">Donos</a></li>
                    <li><a href="/logout">Logout</a></li>
                @else
                    <li><a href="/login">Login</a></li>
                    <li><a href="/cadastro">Cadastro</a></li>
                @endif
            </ul>
        </nav>
    </div>
</header>
