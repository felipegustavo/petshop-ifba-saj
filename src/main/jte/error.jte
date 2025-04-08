@param boolean serverError = false

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop IFBA SAJ</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
    <style>
        .error-container {
          max-width: 600px;
          padding: 2rem;
        }
        .error-code {
          font-size: 6rem;
          color: #4CAF50;
          margin-bottom: 0.5rem;
        }
        .error-title {
          margin-bottom: 1rem;
        }
        .error-description {
          font-size: 1.2rem;
          margin-bottom: 2rem;
        }
        .error-link {
          text-decoration: none;
          color: white;
          background-color: #4CAF50;
          padding: 0.75rem 1.5rem;
          border-radius: 6px;
          font-weight: bold;
          transition: background-color 0.3s ease;
        }
        .error-link:hover {
          background-color: #388E3C;
        }
        .error-icon {
          width: 200px;
          margin-top: 2rem;
        }
    </style>
</head>
<body>

    <div class="wrapper">
        <main class="main container">
            <div class="error-container">

                @if (serverError)
                    <h1 class="error-code">500</h1>
                    <h2 class="error-title">Ops! Houve um erro inesperado.</h2>
                    <p class="error-description">Desculpe, mas a aplicação apresentou um erro que não consegue tratar</p>
                @else
                    <h1 class="error-code">404</h1>
                    <h2 class="error-title">Ops! Página não encontrada.</h2>
                    <p class="error-description">Desculpe, mas a página que você está procurando não existe ou foi movida.</p>
                @endif

                <a href="/" class="error-link">Voltar para a página inicial</a>
                <img src="https://cdn-icons-png.flaticon.com/512/616/616408.png" alt="Cachorrinho perdido" class="error-icon">
            </div>
        </main>

        @template.layout.footer()
    </div>

</body>
</html>