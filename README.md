Projeto Avaliativo do Módulo 1 do curso de Analista de Desenvolvimento Web.

Conforme documentação enviada:
"A aplicação realizada individualmente deverá seguir os requisitos apresentados à seguir.

Requisito geral da aplicação:
Utilização de Spring: Boot, MVC, Data
Criação de API Rest
Utilização de Git com GitHub
Uso do banco de dados PostgreSQL"


Para implementação do projeto segue instruções de como realizei o exercicio proposto:


Primeiramente, criei um diretório para armazenar toda minha aplicação.

Depois elaborei um Banco de Dados em PostegresSQL utilizando o programa DBeaver na sua versão 22.3.4.202302060909. 
Nos arquivos deste projeto irá conter o script que fiz.

Após o Banco de Dados estar pronto para uso, entrei no site "https://start.spring.io/" e gerei um Spring com as seguintes caracteristicas:
SCREENSHOT1

Descompactei o projeto no diretório e com os primeiros arquivos já na pasta, criei o repositório no GitHub, fazendo o primeiro commit e o primeiro push.

Utilizando a IDEA IntelliJ, na sua versão 17.0.5+1-b653.25 amd64, abri meu repositório para editar o código.

Com o projeto aberto, minha primeira ação foi configurar o banco de dados. 
Para isso entrei na pasta src/main/resources e editei o arquivo "application.properties", inserindo nele o caminho com a porta para meu banco de dados e a senha para acessar o mesmo.

Em seguida, para aplicar o modelo MVC,  criei as seguintes Packages : 
-Controller,
-Service,
-Repository,
-Entity. 

Dentro de cada uma criei os arquivos de Classe Java, e no Repository criei a Interface Java.

Realizei o segundo commit "Packages criadas e banco de dados configurado".

Contrui as entidades Bairro e Praia na package entity, com os atributos passados na documentação, e acrescentei a extensão JpaRepository dentro de cada repositório.

Realizei o terceiro commit 
