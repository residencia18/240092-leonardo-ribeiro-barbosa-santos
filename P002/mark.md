### P002 ###

###### HTML #####


~~~html
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>Universidade Estadual de Santa Cruz</title>
    <link rel="stylesheet" href="siteUesc.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Josefin+Sans:ital@1&family=Smooch&display=swap" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="card" id="logo">
            UESC - Universidade Estadual de Santa Cruz
        </div>
        <div id="menu">
            <div class="header">
                Menu
                <hr>
            </div>
            <ul>
                <li><a>A UESC</a></li>
                <li><a>Graduação</a></li>
                <li><a>Pos Graduação</a></li>
                <li><a>Extensão</a></li>
                <li><a>Estrutura Organizacional</a></li>
                <li><a>Servidores</a></li>
                <li><a>Fale Conosco</a></li>
            </ul>
        </div>
        <div class="card" id="noticias">
            <div class="header">
                Notícias
                <hr>
            </div>
            <div id="listaNoticias">
                <b>Aula Pública</b>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptate obcaecati nulla cupiditate
                    asperiores quo? Quo ex repellat iure magni atque, veniam architecto facilis voluptatibus repellendus
                    rem, nam dolorum, corrupti laborum.</p>
                <br>
            </div>
        </div>
        <div class="card" id="destaques">
            Destaques
            <img src="c:\Users\user\Pictures\uescacontece.jpg">
            
        </div>
        <div  class="card" id="servicos">
            <div class="header">
                Serviços
                <hr>
            </div>
            <div id="listaServicos">
                <a>Protocolo Digital</a><br>
                <a>Biblioteca</a><br>
                <a>Licitações</a><br>
                <a>Auditorios</a><br>
                <a>Portal Academico</a>
                <br>
                <br>
            </div>
        </div>
        <div class="card" id="resultados">
           
            <div id="listaResultados">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt, culpa molestias. Dolores, molestiae tempore doloremque officiis pariatur facilis alias nam fuga aliquid quam natus a consequatur, omnis eaque soluta similique.</p>
            </div>
        </div>
    </div>
</body>

</html>
~~~



##### CSS #####

~~~ css
/* Estilos para telas maiores que 500px (estilo original) */
body {
    font-family: 'Roboto', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f8f9fa;
}

.container {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
    max-width: 1200px;
    margin: 0 auto;
}

.card {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
}

#logo {
   
    text-align: center;
    font-size: 36px;
    font-weight: bold;
    color: #005493;
    padding: 40px 0;
    font-family:'Bebas Neue', sans-serif;
    grid-column: span 3;
}

#menu, #noticias, #destaques {
    flex: 1;
}

#menu {
    background-color: #005493;
    color: #fff;
}

#menu .header {
    font-size: 24px;
    font-weight: bold;
    padding: 10px;
}

#menu ul {
    list-style: none;
    padding: 0;
}

#menu li {
    padding: 10px;
}

#menu a {
    text-decoration: none;
    color: #fff;
    font-weight: bold;
}

#noticias, #servicos, #resultados {
    background-color: #f8f9fa;
}

#noticias .header, #servicos .header {
    font-size: 24px;
    font-weight: bold;
    color: #005493;
    padding: 10px;
    font-family: 'Smooch', cursive;
}

#listaNoticias, #listaServicos, #listaResultados {
    padding: 20px;
    font-family:'Josefin Sans', sans-serif;
}

#destaques {
    text-align: center;
    background-color: #005493;
    color: #fff;
    font-size: 24px;
    font-weight: bold;
    padding: 20px;
}

#destaques img {
    width: 100%;
    border-radius: 10px;
}

#rodape {
    text-align: center;
    padding: 10px;
    background-color: #005493;
    color: #fff;
}


/* Estilos para telas menores que 500px (estilo para celular) */
@media (max-width: 500px) {
    .container {
        grid-template-columns: 1fr;
    }
    #logo {
        grid-column: span 1;
    }

    #menu, #noticias, #destaques {
        width: 100%;
    }

    #destaques img {
        border-radius: 0; /* Remover borda arredondada em imagens */
    }
}
~~~