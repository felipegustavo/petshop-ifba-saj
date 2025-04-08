@param gg.jte.Content content

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop Administrativo</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
</head>
<body>

    <div class="wrapper">
        @template.layout.header()

        <main class="main container">
            ${content}
        </main>

        @template.layout.footer()
    </div>

    <script src="/js/script.js"></script>
</body>
</html>