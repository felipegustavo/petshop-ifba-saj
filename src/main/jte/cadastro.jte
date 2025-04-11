@import ifba.saj.demo.petshop.exception.ValidationErrorDTO
@import ifba.saj.demo.petshop.domain.dto.UsuarioDTO

@param ValidationErrorDTO errors = new ValidationErrorDTO()
@param UsuarioDTO usuario
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <div class="form-container">
        <h2 class="title-page">Cadastro</h2>
        <form action="/cadastro" method="post">

            <label for="nome">Nome:</label>
            <input type="text" name="nome" required>
            @for(var error : errors.getErrorsByField ("nome"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <label for="email">Email:</label>
            <input type="email" name="email" required>
            @for(var error : errors.getErrorsByField ("email"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <label for="senha">Senha:</label>
            <input type="password" name="senha" required>
            @for(var error : errors.getErrorsByField ("senha"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <button type="submit">Cadastrar</button>
        </form>
    </div>

`)
