<%@include file="menu.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Centralizar Imagem</title>
    <style>
        .centralizar {
            text-align: center; /* Centraliza o conteúdo dentro do contêiner */
        }
        .centralizar img {
            max-width: 100%; /* Ajusta a imagem ao tamanho do contêiner */
            height: auto; /* Mantém a proporção da imagem */
        }
    </style>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Counter-Strike - Página Inicial</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
    <header>
        <h1>Counter-Strike</h1>
        <nav>
            <ul>
                <li><a href="#sobre">Sobre</a></li>
                <li><a href="#mercado">Mercado</a></li>
                <li><a href="#noticias">Notícias</a></li>
                <li><a href="#contato">Contato</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="container">
        <main>
            <section id="sobre">
                <h2>Sobre o Jogo</h2>
                <p>Counter-Strike (também abreviado por CS) é um popular jogo eletrônico de tiro em primeira pessoa. Inicialmente criado como um "mod" de Half-Life para jogos online, foi desenvolvido por Minh Le e Jess Cliffe e depois adquirido pela Valve Corporation. 
                    Foi lançado em 1999, porém em 2000 ele começou a ser comercializado oficialmente, e posteriormente foram feitas versões para Xbox, Mac OS X e Linux. Atualmente o jogo é jogado na versão Counter-Strike 2.
                    O jogo é baseado em rodadas nas quais equipes de contraterroristas e terroristas combatem-se até a eliminação completa de um dos times, e tem como objetivo principal plantar e desarmar bombas, ou sequestrar e salvar reféns.</p>
                <img src="https://images.shopcdn.co.uk/51/81/5181553c3a4d05300b8b88219fb5b5bd/1918x1052/webp/resize" alt="Imagem do jogo" >
                </section>
            <section id="mercado"> 
                <h2>Mercado de Skins</h2>
                <p>Esse site é sobre o sobre compra e venda de Skins que existem dentro do jogo, mas o que são essas skins e como funciona esse mercado?</p>
                <p>O mercado de Counter-Strike é agitado, com diversas opções para comprar, vender e trocar skins. Os jogadores podem adquiri-las ao comprar chaves para abrir caixas, que contém skins de diferentes raridades e valores.
                    As skins podem ser compradas e vendidas diretamente no mercado da Comunidade na Steam, com uma tarifa fixa de 5% por transação. 
                    Para evitar desvalorizações em grandes vendas, foram criados sites de terceiros(como esse) que permite os jogadores negociarem skins entre si, criando comunidades e diversificando as microtransações.
                    Esse mercado trouxe uma nova cultura de ostentação em torno das skins, impulsionado por jogadores profissionais e influenciadores, movimentando mais de US$ 10 bilhões por ano. Em março de 2023, o jogo voltou a quebrar recordes de jogadores simultâneos com o lançamento do beta CS2.
            </section>

            <section id="noticias">
                <h2>Últimas Notícias</h2>
                <article>
                    <h3>Nova Temporada</h3>
                    <p>
                        Temporada aberta
                        16 de julho de 2024
                        No ano passado, nós anunciamos em linhas gerais as novas regras para os eventos profissionais de Counter-Strike, que entrarão em vigor a partir de 2025. Hoje, estamos compartilhando os detalhes completos — clique aqui para conferir os termos que serão adicionados aos contratos de licenciamento para organizadores de torneios daqui em diante (em inglês).

                        O Counter-Strike é melhor quando as equipes competem em igualdade de condições, e essas novas regras são parte do nosso compromisso com a saúde a longo prazo do Counter-Strike como um esporte. O nosso objetivo é garantir que o Counter-Strike profissional continue sendo um esporte aberto, onde as equipes são limitadas apenas pelas suas habilidades.

                        Sabemos que a transição para os novos requisitos não será simples, mas estamos animados para ver o que nos aguarda no futuro.</p>
                </article>
                <article>
                    <h3>Valve trabalha em 1ª operação para o CS2, diz dataminer</h3>
                    <p> CS não tem operações há mais de dois anos.
                        Lançado em setembro de 2023, o CS2 ainda não foi agraciado com as operações que ficaram famosas no CS:GO. Porém, de acordo com o dataminer Gabe Follower a Valve está trabalhando nesse tipo de conteúdo.
                        A suposição de Gabe Follower tem como base alterações no código do CS2 após a atualização que adicionou na versão do FPS o modo armamentista. Segundo o insider, a lore das operações podem ser contadas em cut scenes e não mais nos quadrinhos, como acontecia no CS:GO.</p>
                </article>
            </section>

            <section id="contato">
                <h2>Contato</h2>
                <form action="#" method="post">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="mensagem">Mensagem:</label>
                    <textarea id="mensagem" name="mensagem" rows="5" required></textarea>

                    <button type="submit">Enviar Mensagem</button>
                </form>
            </section>
        </main>
    </div>

    <footer>
        <p>&copy; 2024 Counter-Strike Valve. Todos os direitos reservados.</p>
    </footer>
</body>
</html>
