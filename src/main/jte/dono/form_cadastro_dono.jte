@import ifba.saj.demo.petshop.domain.dto.DonoDTO
@import ifba.saj.demo.petshop.domain.dto.PetDTO
@import ifba.saj.demo.petshop.exception.ValidationErrorDTO
@import java.util.List

@param DonoDTO dono = new DonoDTO()
@param List<PetDTO> pets
@param ValidationErrorDTO errors = new ValidationErrorDTO()
@param boolean cadastro = false
@param boolean edicao = false
@param boolean visualizacao = false
@param boolean logado

@template.layout.main(logado = logado, content = @`

    @if (cadastro || edicao)
        <div id="success-box" class="success-box">Dono ${cadastro ? "cadastrado" : "editado"} com sucesso!</div>
    @endif

    <div class="form-container">

        @if(!visualizacao)
            <h2 class="title-page">${cadastro ? "Cadastrado" : "Edição"} de Dono</h2>
        @endif

        <form id="formdono" method="post" action="/dono/cadastrar" disabled="${visualizacao}">
            <input type="hidden" id="id" name="id" value="${dono.getId()}" disabled="${visualizacao}">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required value="${dono.getNome()}" disabled="${visualizacao}">
            @for(var error : errors.getErrorsByField ("nome"))
                <div class="error-message">${error.message()}</div>
            @endfor


            <label for="endereco">Endereço:</label>
            <input type="text" id="endereco" name="endereco" value="${dono.getEndereco()}" disabled="${visualizacao}">
            @for(var error : errors.getErrorsByField ("endereco"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <label for="cpf">CPF:</label>
            <input type="number" id="cpf" name="cpf" value="${dono.getCpf()}" disabled="${visualizacao}">
            @for(var error : errors.getErrorsByField ("cpf"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${dono.getEmail()}" disabled="${visualizacao}">
            @for(var error : errors.getErrorsByField ("email"))
                <div class="error-message">${error.message()}</div>
            @endfor

            @if(!visualizacao)
                <button type="submit">Enviar</button>
            @endif
        </form>
    </div>

    @if (visualizacao)
        <div class="dono-container">
            <h3>Pets do(a) ${dono.getNome()}</h3>

            <a href="/pet/cadastrar/${dono.getId()}" class="btn-cadastrar">+ Cadastrar Pet</a>

            <div class="pets-lista">

                @for (var pet : pets)
                    <div class="pet-card">
                        <div>
                            <p><strong>Nome:</strong> ${pet.getNome()}</p>
                            <p><strong>Raça:</strong> ${pet.getRaca().getNome()}</p>
                        </div>
                        <div class="pet-botoes">
                            <a href="/pet/editar/${pet.getId()}" class="btn-editar">Editar</a>
                            <a href="/consulta/${pet.getId()}" class="btn-editar">Ver Visitas</a>
                            <a href="/consulta/cadastrar/${pet.getId()}" class="btn-editar">Cadastrar Visita</a>
                        </div>
                    </div>
                @endfor
            </div>
        </div>
    @endif

`)