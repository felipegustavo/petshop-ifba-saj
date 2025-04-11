@import ifba.saj.demo.petshop.domain.dto.ConsultaDTO

@import java.util.List

@param List<ConsultaDTO> consultas
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <h2 class="title-page">Consultas Cadastrados</h2>

    <table class="tabela">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Veterinario</th>
            <th>Data</th>
            <th>Ações</th>
        </tr>
        </thead>

        <tbody>
        @for(var consulta : consultas)
            <tr>
                <td>${consulta.getId()}</td>
                <td>${consulta.getPet().getNome()}</td>
                <td>${consulta.getVeterinario().getNome()}</td>
                <td>${consulta.getAgendamentoFormatado()}</td>
                <td>
                    <a onclick="return confirm('Tem certeza que deseja apagar consulta ${consulta.getId()}?')"
                            href="/consulta/remover/${consulta.getId()}/${consulta.getPet().getId()}"
                            class="btn-excluir">Remover</a>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
`)