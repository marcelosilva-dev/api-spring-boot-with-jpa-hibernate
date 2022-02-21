# api-spring-boot-with-jpa-hibernate

## Requisitos

Para fazer build e executar a aplicação você precisa:

- [Java 11](https://www.openlogic.com/openjdk-downloads)
- [Maven 4](https://maven.apache.org/download.cgi)
- [Postgres](https://www.postgresql.org/download/)

## Executando a aplicação localmente

Faça clone do repositório no seu workspace e inicie a aplicação.

Execute o jar presente em /jar

```shell
java -jar filename.jar
```

### Acessando a aplicação online

- [Clique aqui para acessar a aplicação online](https://api-amazon-clone-marcelosilva.herokuapp.com/)

#### Rotas da aplicação

- POST - Login
```shell
hostname:port/login
```

```shell
{
	"email": "email",
	"password": "password"
}
```

- POST - Users
```shell
hostname:port/users
```
```shell
{
"name": "Bob Brown 2",
"email": "bob@gmail.com",
"phone": "977557755",
"password": "fh\ihfihgishg"
}
```

- POST - Categories
```shell
hostname:port/categories
```
```shell
{
	"name": "Courses"
}
```

GET - Products
```shell
hostname:port/products
```

GET - User (Precisa do token jwt)
```shell
hostname:port/login/:id
```

GET - Categories (Precisa do token jwt)
```shell
hostname:port/categories
```

DELETE - Products (Precisa do token jwt)
```shell
hostname:port/products/:id
```

DELETE - User (Precisa do token jwt)
```shell
hostname:port/users/:id
```

- PUT - Users
```shell
hostname:port/users/:id
```
```shell
{
"id": 3,
"name": "Bob Brownie",
"email": "bob2@gmail.com",
"phone": "977557755"
}

###### Configurações do banco de dados postgres local (padrão)

- spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_course
- spring.datasource.username=postgres
- spring.datasource.password=suasenha

##### Um pouco sobre a aplicação

- Spring-Boot API
- Jwt Authentication
- Jpa / Hibernate
- Cors
- Pattern: Entity / Repository / Service / Resource

##### Em breve

- Gerenciamento de ordens de compra por usuário
- Cadastro de entradas no estoque
- Retorno do status do estoque
- Metodo de pagamento real

###### Contato

- Siga-me no Linkdin https://www.linkedin.com/in/marcelo-oliveira-pbidev/
