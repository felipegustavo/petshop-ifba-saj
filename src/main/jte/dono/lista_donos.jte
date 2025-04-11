@import ifba.saj.demo.petshop.domain.dto.DonoDTO

@import java.util.List

@param List<DonoDTO> donos
@param boolean erroCpf = false
@param boolean logado

@template.layout.main(logado = logado, content = @`

    <h2 class="title-page">Donos Cadastrados</h2>

    <form method="get" action="/dono" class="form-busca-dono">
        <label for="nome">CPF:</label>
        <input type="text" id="cpf" name="cpf" pattern="[0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\-?[0-9]{2}">
        <button type="submit">Buscar</button>
    </form>

    <a href="/dono/cadastrar" class="btn-cadastrar">+ Cadastrar Dono</a>

    <table class="tabela">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Ações</th>
        </tr>
        </thead>

        <tbody>
        @for(var dono : donos)
            <tr>
                <td>${dono.getId()}</td>
                <td>${dono.getNome()}</td>
                <td>${dono.getEndereco()}</td>
                <td>${dono.getCpf()}</td>
                <td>${dono.getEmail()}</td>
                <td>
                    <a href="/dono/editar/${dono.getId()}" class="btn-editar">Editar</a>
                    <a href="/dono/ver/${dono.getId()}" class="btn-editar">Ver</a>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
`)