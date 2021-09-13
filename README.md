# back-teste-ciss
Repositório voltado ao desafio para a vaga de dev da CISS.com.br

## Informações
Dos atributos do Funcionário
- Nome (Entre 2 e 30 caracteres)
- Sobrenome (Entre 2 e 50 caracteres)
- e-mail (Validar e-mail)
- Número do NIS (PIS) (Somente números)

Das funcionalidades (Utilizando APIs):
- Inserção de um Funcionário
- Exclusão de um Funcionário
- Atualização de um Funcionário

## Setup
1. Troque as informações do arquivo **main/java/com/example/demo/resources/application.properties** para essas, descomentando as outras e trocando **create** por  **update** em **spring.jpa.hibernate.ddl-auto**
```dotenv
# Seu arquivo deve ficar parecido com esse

# spring.datasource.hikari.connectionTimeout=20000 # comente essa linha
# spring.datasource.hikari.maximumPoolSize=5 # comente essa linha também

...
spring.datasource.username=seu-usuario # descomentar e atribuir
spring.datasource.password=-sua-senha # descomentar e atribuir
spring.jpa.hibernate.ddl-auto=create # troque para create a primeira vez que rodar o app
 ```
2. Crie um banco de dados com o nome "**funcionarios**" no **postgres** com docker ou **PgAdmin**
3. Importe o projeto com alguma IDE (**IntelliJ**) com o arquivo **pom.xml** e aguarde a atualização das dependências
4. Rode o arquivo **main/java/com/example/demo/Application.java**

Prontinho, app de backend rodando.

## Referências da API

#### Listar todos os funcionários

```http
  GET /api/funcionarios
```

#### Listar funcionário buscando pelo id

```http
  GET /api/funcionarios/${id}
```

#### Cadastrar funcionário

```http
  POST /api/funcionarios
```

| Parametro | Tipo     | Descrição                       |
| :-------- | :------- | :-------------------------------- |
| `nome`      | `string` | **Requerido**. Nome do funcionário |
| `sobrenome`      | `string` | **Requerido**. Sobrenome do funcionário |
| `email`      | `string` | **Requerido**. E-mail do funcionário |
| `pis`      | `string` | **Requerido**. Número do PIS/NIS do funcionário |

#### Alterar informações do funcionário

```http
  PUT /api/funcionarios/${id}
```

| Parametro | Tipo     | Descrição                       |
| :-------- | :------- | :-------------------------------- |
| `nome`      | `string` | **Requerido**. Nome do funcionário |
| `sobrenome`      | `string` | **Requerido**. Sobrenome do funcionário |
| `email`      | `string` | **Requerido**. E-mail do funcionário |
| `pis`      | `string` | **Requerido**. Número do PIS/NIS do funcionário |

#### Deletar funcionário pelo id

```http
  DELETE /api/funcionarios/${id}
```

Obrigado por ler até aqui