@import ifba.saj.demo.petshop.domain.dto.ConsultaDTO
@import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO
@import ifba.saj.demo.petshop.exception.ValidationErrorDTO
@import java.util.List

@param ConsultaDTO consulta = new ConsultaDTO()
@param List<VeterinarioDTO> veterinarios
@param ValidationErrorDTO errors = new ValidationErrorDTO()
@param Long petId = null
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <button class="btn-cadastrar" onclick="history.back()">Voltar</button>

    <div class="form-container">
        <h2 class="title-page">Cadastro de Consulta</h2>

        <form id="formVeterinario" method="post" action="/consulta/cadastrar">
            <input type="hidden" id="petId" name="petId" value="${petId}">

            <label for="veterinario">Veterinario:</label>
            <select id="veterinario" name="veterinarioId" class="styled-select">
                <option value="">Selecione</option>
                @for(var veterinario : veterinarios)
                    <option value="${veterinario.getId()}"
                            selected="${veterinario.getId().equals(consulta.getVeterinarioId())}">${veterinario.getNome()}</option>
                @endfor
            </select>
            @for(var error : errors.getErrorsByField ("veterinarioId"))
                <div class="error-message">${error.message()}</div>
            @endfor

           <input type="date" name="agendamento" id="agendamento">
            @for(var error : errors.getErrorsByField ("agendamento"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <button type="submit">Cadastrar</button>
        </form>
    </div>
`)