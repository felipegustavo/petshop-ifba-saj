@param String error
@param String logout
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <div class="form-container">
        <h2 class="title-page">Login</h2>
        <form action="/login" method="post">
            <label for="username">Email:</label>
            <input type="text" name="username" required>

            <label for="password">Senha:</label>
            <input type="password" name="password" required>

            <button type="submit">Login</button>
        </form>
        @if(error != null)
            <div class="error-message">Email ou senha incorretos</div>
        @endif
        @if(logout != null)
            <p style="margin-top: 10px;">Você foi deslogado</p>
        @endif
    </div>
`)
