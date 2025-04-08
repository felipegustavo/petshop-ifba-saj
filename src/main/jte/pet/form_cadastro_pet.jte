@import ifba.saj.demo.petshop.domain.dto.PetDTO
@import ifba.saj.demo.petshop.domain.dto.RacaDTO
@import ifba.saj.demo.petshop.exception.ValidationErrorDTO
@import java.util.List

@param PetDTO pet = new PetDTO()
@param List<RacaDTO> racas
@param ValidationErrorDTO errors = new ValidationErrorDTO()
@param boolean cadastro = false
@param boolean edicao = false
@param Long donoId = null

@template.layout.main(content = @`

    @if (cadastro || edicao)
        <div id="success-box" class="success-box">Pet ${cadastro ? "cadastrado" : "editado"} com sucesso!</div>
    @endif

    <a href="/dono/ver/${donoId == null ? pet.getDonoId() : donoId}" class="btn-cadastrar">Ver Dono</a>

    <div class="form-container">
        <h2 class="title-page">${cadastro ? "Cadastrado" : "Edição"} de Pet</h2>
        <form id="formVeterinario" method="post" action="/pet/cadastrar">
            <input type="hidden" id="id" name="id" value="${pet.getId()}">
            <input type="hidden" id="donoId" name="donoId" value="${donoId == null ? pet.getDonoId() : donoId}">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${pet.getNome()}">
            @for(var error : errors.getErrorsByField ("nome"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <label for="raca">Raça:</label>
            <select id="raca" name="racaId" class="styled-select">
                <option value="">Selecione</option>
                @for(var raca : racas)
                    <option value="${raca.getId()}" selected="${raca.getId().equals(pet.getRacaId())}">${raca.getNome()}</option>
                @endfor
            </select>
            @for(var error : errors.getErrorsByField ("racaId"))
                <div class="error-message">${error.message()}</div>
            @endfor

            <button type="submit">Cadastrar</button>
        </form>
    </div>
`)