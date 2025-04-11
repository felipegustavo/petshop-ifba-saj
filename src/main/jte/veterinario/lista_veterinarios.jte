@import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO

@import java.util.List

@param List<VeterinarioDTO> veterinarios
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <h2 class="title-page">Veterinários Cadastrados</h2>

    @if (logado)
        <a href="/veterinario/cadastrar" class="btn-cadastrar">+ Cadastrar Veterinário</a>
    @endif

    <table class="tabela">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CRMV</th>
            <th>Especialidades</th>
            @if (logado)
                <th>Ações</th>
            @endif
        </tr>
        </thead>

        <tbody>
        @for(var veterinario : veterinarios)
            <tr>
                <td>${veterinario.getId()}</td>
                <td>${veterinario.getNome()}</td>
                <td>${veterinario.getCrmv()}</td>
                <td>${veterinario.getNomesEspecialidades()}</td>
                @if (logado)
                    <td>
                        <a href="/veterinario/editar/${veterinario.getId()}" class="btn-editar">Editar</a>
                    </td>
                @endif
            </tr>
        @endfor
        </tbody>
    </table>
`)