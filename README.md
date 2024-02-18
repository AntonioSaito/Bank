# API Rest com Java e Spring para Sistema Bancário Básico

## Descrição
API Rest desenvolvida com Java e Spring que oferece as funcionalidades básicas de um sistema bancário. Inclui registro de usuários, criação de contas, operações de saque, depósito, transferências, consulta de saldos entre outras.

## Tecnologias Utilizadas
- IntelliJ IDEA
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- CRUD
- HATEOAS

## Principais Endpoints

### Clientes
- **GET /client**: Retorna uma lista de todos os clientes cadastrados.
- **GET /client/{id}**: Retorna os detalhes de um cliente específico pelo seu ID.
- **POST /client**: Cadastre um novo cliente.
- **PUT /client/{id}**: Atualiza os detalhes de um cliente existente.
- **DELETE /client/{id}**: Exclui um cliente pelo seu ID.

### Contas
- **GET /account**: Retorna uma lista de todas as contas bancárias.
- **GET /account/{id}**: Retorna os detalhes de uma conta específica pelo seu ID.
- **POST /account**: Crie uma nova conta bancária.
- **DELETE /account/{id}**: Exclui uma conta bancária pelo seu ID.
- **PUT /account/{id}/deposit**: Realiza um depósito em uma conta específica.
- **PUT /account/{id}/withdraw**: Realiza a retirada de uma conta específica.

### Transferências
- **GET /transfer**: Retorna uma lista de todas as transferências realizadas.
- **POST /transfer**: Realiza uma transferência entre duas contas.
