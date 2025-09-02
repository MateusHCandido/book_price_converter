# Book Price Converter - Microservices Project

## Descrição do Projeto
Este projeto é uma aplicação de microsserviços construída em **Spring Boot** que permite converter preços de livros entre diferentes moedas utilizando taxas de câmbio em tempo real. O projeto demonstra o uso de **arquitetura MVC** (Model, Controller, Service e Repository) e integra serviços de banco de dados com **MySQL**.

> **Observação:** Esta é a fase inicial do projeto. Futuramente, serão incluídos testes unitários, documentação detalhada, arquitetura limpa e comunicação assíncrona com **Apache Kafka**. O projeto será remodelado para refletir essas melhorias.

---

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Cloud**
- **Spring Actuator**
- **Spring Data JPA**
- **Flyway** (para versionamento e migração de banco de dados)
- **MySQL**
- **Lombok**
- **Docker** (para containerização de microsserviços e banco de dados)
- **Postman** (para testes das APIs)

---

## Estrutura da Aplicação
O projeto segue a arquitetura **MVC** com as camadas:
- **Model**: entidades e DTOs
- **Repository**: interface de acesso ao banco de dados
- **Service**: regras de negócio
- **Controller**: endpoints REST para comunicação com clientes

---

## Executando o Projeto
1. Clone este repositório:
```
git clone https://github.com/MateusHCandido/book_price_converter.git
```

2. Navegue até a pasta do seu projeto

3. Construa e execute os containers com Docker Compose:
```
docker-compose up -d --build
```

4. Os microsserviços estarão disponíveis nos seguintes endpoints:
- http://localhost:8100/book-service/{id_livro}/{moeda}
- http://localhost:8000/exchange-service/{preco_selecionado}/{moeda_atual}/{moeda_para_conversao}
5. Exemplos:

```
endpoint:

http://localhost:8100/book-service/1/BRL

resultado:

{
    "id": 1,
    "author": "Michael C. Feathers",
    "title": "Working Effectively with Legacy Code",
    "launchDate": "2017-11-29",
    "price": 44.9925,
    "currency": "BRL",
    "environment": "8100 FEIGN"
}
```




