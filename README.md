API Rest com Java e Spring que oferece as funções de um sistema bancário básico sendo elas:
-Registro de Usuario.
-Criação de uma conta e associação desta conta ao usuario.
-Funções de saques, depositos e transferencias entre contas.
-Consulta de saldos

Tecnologias utilizadas:
-IntelliJ.
-Spring Boot.
-Spring Data JPA.
-Hibernate.
-Postgree SQL.
-CRUD.
-Heteoas.

Principais Endpoints:
GET /client: Retorna uma lista de todos os clientes cadastrados.
GET /client/{id}: Retorna os detalhes de um cliente específico pelo seu ID.
POST /client: Registra um novo cliente.
PUT /client/{id}: Atualiza os detalhes de um cliente existente.
DELETE /client/{id}: Exclui um cliente pelo seu ID.
Contas
GET /account: Retorna uma lista de todas as contas bancárias.
GET /account/{id}: Retorna os detalhes de uma conta específica pelo seu ID.
POST /account: Cria uma nova conta bancária.
DELETE /account/{id}: Exclui uma conta bancária pelo seu ID.
PUT /account/{id}/deposit: Realiza um depósito em uma conta específica.
PUT /account/{id}/withdraw: Realiza uma retirada de uma conta específica.
Transferências
GET /transfer: Retorna uma lista de todas as transferências realizadas.
POST /transfer: Realiza uma transferência entre duas contas.
