# Documentação do Projeto
## Visão Geral
O projeto é um sistema de gerenciamento de usuários e tarefas desenvolvido com o framework Java Spring. Ele permite o registro de usuários, autenticação segura, criação e manipulação de tarefas, e interação com o front-end através de páginas HTML, estilizadas com CSS e interativas com JavaScript.

## Tecnologias Utilizadas
Java Spring: Framework utilizado para desenvolver a aplicação backend.
HTML: Linguagem de marcação utilizada para estruturar as páginas do front-end.
CSS: Linguagem de estilo utilizada para definir a aparência visual das páginas.
JavaScript: Linguagem de programação utilizada para adicionar interatividade às páginas.
DTO (Data Transfer Object): Padrão utilizado para transferir dados entre a camada de apresentação (front-end) e a camada de negócio (backend).
Spring Security: Framework utilizado para implementar a autenticação e autorização de usuários.
JWT (JSON Web Token): Mecanismo utilizado para autenticar solicitações entre o front-end e o backend de forma segura.
MVC (Model-View-Controller): Padrão de arquitetura utilizado para separar a lógica de negócio (Model), a apresentação (View) e o controle (Controller) da aplicação.
JPA (Java Persistence API): API utilizada para mapear objetos Java para entidades de banco de dados e realizar operações de persistência.

## Funcionalidades Principais
Registro de Usuários: Permite que os usuários se registrem no sistema fornecendo informações básicas, como nome de usuário, senha e informações de contato.
Autenticação e Autorização: Implementa um sistema seguro de autenticação e autorização usando o Spring Security e JWT. Os usuários podem fazer login e receber um token JWT válido para realizar solicitações autenticadas posteriormente.
Gerenciamento de Tarefas: Permite que os usuários criem, visualizem, atualizem e excluam tarefas. As tarefas são associadas a usuários específicos e podem ter propriedades como título, descrição, data de vencimento, etc.
Integração com o Front-end: A aplicação interage com o front-end por meio de endpoints RESTful, onde as requisições são feitas usando JSON para transmitir os dados entre as camadas front-end e back-end.
