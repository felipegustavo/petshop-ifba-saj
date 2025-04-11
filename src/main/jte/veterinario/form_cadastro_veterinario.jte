@import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO
@import ifba.saj.demo.petshop.domain.dto.EspecialidadeDTO
@import ifba.saj.demo.petshop.exception.ValidationErrorDTO
@import java.util.List

@param VeterinarioDTO veterinario = new VeterinarioDTO()
@param List<EspecialidadeDTO> especialidades
@param ValidationErrorDTO errors = new ValidationErrorDTO()
@param boolean cadastro = false
@param boolean edicao = false
@param boolean logado

@template.layout.main(logado = logado, content = @`

    @if (cadastro || edicao)
        <div id="success-box" class="success-box">Veterinário ${cadastro ? "cadastrado" : "editado"} com sucesso!</div>
    @endif

    <div class="form-container">
        <h2 class="title-page">${cadastro ? "Cadastrado" : "Edição"} de Veterinário</h2>
        <form id="formVeterinario" method="post" action="/veterinario/cadastrar">
            <input type="hidden" id="id" name="id" value="${veterinario.getId()}">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${veterinario.getNome()}">
            @for(var error : errors.getErrorsByField ("nome"))
                <div class="error-message">${error.message()}</div>
            @endfor


            <label for="crmv">CRMV:</label>
            <input type="number" id="crmv" name="crmv" value="${veterinario.getCrmv()}">
            @for(var error : errors.getErrorsByField ("crmv"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <fieldset>
                <legend>Especialidades:</legend>
                @for(var espec : especialidades)
                    <label><input type="checkbox" name="especialidadeIds"
                                  checked="${veterinario.getEspecialidadeIds().contains(espec.getId())}"
                                  value="${espec.getId()}"> ${espec.getNome()}</label><br>
                @endfor
            </fieldset>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
`)