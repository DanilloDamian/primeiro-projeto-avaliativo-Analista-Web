# LabBeach

## Sobre
O projeto consiste no CRUD de bairros e praias. <br>
Os **Bairros** devem conter as operações de **Inserir, Deletar e Listar** sendo que não se permite Deletar bairros que já possuem praias cadastradas e evitar cadastro duplicado ou com o campo *nome* em branco.<br>
As **Praias** deve conter o CRUD completo: **Consultar, Inserir, Atualizar e Remover** e como regra não permitir o cadastro duplicado ou com campos inválidos.<br>

## Features

- [x] Cadastro de bairro
- [x] Listagem de bairro
- [x] Exclusão de bairro
- [x] Cadastro de praia
- [x] Listagem de todas as praias
- [x] Edição de praias por identificador
- [x] Exclusão de uma praia por identificador
- [x] Listagem de praias conforme o status
- [x] Listagem de praias com acessibilidade
- [x] Listagens de praias por população no bairro

## Tecnologias

- Java
- PostegreSQL
- Spring

## Como testar

### Abrindo projeto

1. Clone este repositório na sua máquina com o comando `git clone https://github.com/DanilloDamian/primeiro-projeto-avaliativo-Analista-Web.git`.
2. Importe o projeto para a IDE de sua preferência (Eclipse, Intellij,...).
3. Execute o comando Maven Install.
4. Execute o Script localizado na raiz do projeto no sistema de Gestão de Banco de Dados de sua preferência (Dbeaver,Microsoft SQL Server,...).
5. Altere o arquivo *application.properties* localizado no caminho `src\main\resources` para setar as configurações do seu banco de dados.
6. Acesse o arquivo *LabBeachApplication* localizado na pasta `src\main\java\projetoavaliativo\com\br\LabBeach`.
7. Clique com o botão direito do mouse no arquivo e selecione a opção **Run 'LabBeach'**.
8. Com o servidor funcionando, abra o API Client de sua preferência (Postman,Hoppscotch,...).
9. Insira o caminho que o servidor está rodando em sua máquina, por padrão é `http://localhost:8080` (pode ser verificado na mensagem de sua IDE após realizar o passo 6).

### Testando funcionalidades da Classe Bairro

No caminho do servidor, adicione  "*/bairros*", exemplo: `http://localhost:8080/bairros`.
- Para **Cadastro**, selecionar método **POST** e no corpo da requisição inserir os atributos: nome, descrição e população (sendo que apenas o nome é obrigatório). Exemplo: <br>
`{
  "nome": "Canasvieiras",
  "descricao" : "Bairro localizado no norte de Florianópolis",
  "populacao" : 15000
  }`.
- Para **Listagem**, selecionar método **GET**.
- Para **Exclusão**, selecionar o método **DELETE** e passar o **ID** do bairro no caminho da requisição. Exemplo: `http://localhost:8080/bairros/1`.

### Testando funcionalidades da Classe Praia

No caminho do servidor, adicione  "*/praias*", exemplo: `http://localhost:8080/praias`.
- Para **Cadastro**, selecionar método **POST** e no corpo da requisição inserir os atributos: bairro (apenas o ID), nome, acessibilidade e status. Todos os campos são **obrigatórios**. Para acessibilidade considerar valores: "Nao Possui" ou "Possui". Para status considerar valores: "Propria" ou "Impropria". Exemplo: <br>
`{
  "bairro":1,
  "nome": "Praia de Canasvieiras",
    "acessibilidade": "Possui",
    "status": "Propria"
  }`.
- Para **Listagem** de todas as praias, selecionar método **GET**.
- Para **Edição**,  selecionar o método **PUT** ,  passar o **ID** da praia no caminho da requisição e a praia com os novos atributos alterados no corpo da requisição. Exemplo:<br>
`http://localhost:8080/praias/1` <br>
`{
  "bairro":1,
  "nome": "Praia de Canasvieiras",
    "acessibilidade": "Nao possui",
    "status": "Impropria"
  }`.
- Para **Exclusão**, selecionar o método **DELETE** e passar o **ID** da praia no caminho da requisição. Exemplo: `http://localhost:8080/praias/1`.
 - Para **Listagem conforme Status** mostrando apenas praias que estão próprias para banho, selecionar método **GET** e adicionar */status* no caminho da requisição. Exemplo: `http://localhost:8080/praias/status`.
 - Para **Listagem conforme Acessibilidade** mostrando apenas praias que possuem acessibilidade, selecionar método **GET** e adicionar */acessibilidade* no caminho da requisição. Exemplo: `http://localhost:8080/praias/acessibilidade`.
 - Para **Listagem conforme População no Bairro** mostrando apenas praias localizadas em bairros com população até um certo número definido pelo usuário, selecionar método **GET** e adicionar o número da popualçao desejada no caminho da requisição. Exemplo: `http://localhost:8080/praias/15000`.
