@import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO

@import java.util.List

@param List<VeterinarioDTO> veterinarios

@template.layout.main(content = @`

    <h2 class="title-page">Veterinários Cadastrados</h2>

    <a href="/veterinario/cadastrar" class="btn-cadastrar">+ Cadastrar Veterinário</a>

    <table class="tabela">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CRMV</th>
            <th>Especialidades</th>
            <th>Ações</th>
        </tr>
        </thead>

        <tbody>
        @for(var veterinario : veterinarios)
            <tr>
                <td>${veterinario.getId()}</td>
                <td>${veterinario.getNome()}</td>
                <td>${veterinario.getCrmv()}</td>
                <td>${veterinario.getNomesEspecialidades()}</td>
                <td>
                    <a href="/veterinario/editar/${veterinario.getId()}" class="btn-editar">Editar</a>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
`)