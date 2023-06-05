# Mini Curso de API REST com Java Spring - Semana Epitaciana de Computação 2023

Este é o repositório do projeto desenvolvido durante o Mini Curso de API REST com Java Spring, realizado durante a Semana Epitaciana de Computação 2023 no IFSP PEP do qual fui ministrante.

## Descrição do Projeto

O projeto é uma API REST desenvolvida em Java Spring para gerenciar uma aplicação de exemplo. A aplicação possui endpoints para realizar operações CRUD (Create, Read, Update, Delete) em uma entidade chamada `Exemplo`. A API utiliza o Spring Data JPA para interagir com o banco de dados e com uma api do governo para pegar o endereço do aluno através do CEP indicado.

## Requisitos

- Java 17
- Maven
- Banco de Dados (MySQL, PostgreSQL, etc.)

## Configuração do Banco de Dados

Antes de executar a aplicação, é necessário configurar a conexão com o banco de dados. No arquivo `application.properties`, localizado em `src/main/resources`, você deve alterar as seguintes propriedades de acordo com as configurações do seu banco de dados:

spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha


Certifique-se de substituir `nome_do_banco`, `seu_usuario` e `sua_senha` pelas informações corretas.

## Executando o Projeto

Para executar o projeto, siga os passos abaixo:

1. Clone este repositório para a sua máquina local.
2. Navegue até o diretório do projeto: `cd nome_do_projeto`.
3. Compile o projeto com o comando: `mvn clean install`.
4. Execute a aplicação: `mvn spring-boot:run`.

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

A API possui os seguintes endpoints:

- **GET /exemplos**: Retorna todos os exemplos cadastrados.
- **GET /exemplos/{id}**: Retorna o exemplo com o ID especificado.
- **POST /exemplos**: Cria um novo exemplo.
- **PUT /exemplos/{id}**: Atualiza os dados do exemplo com o ID especificado.
- **DELETE /exemplos/{id}**: Remove o exemplo com o ID especificado.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request com melhorias, correções de bugs ou novos recursos.

---

Esperamos que este projeto seja útil para o seu aprendizado. Se tiver alguma dúvida ou sugestão, fique à vontade para entrar em contato.

Divirta-se codificando! 🚀
