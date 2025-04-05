# ProjetoA1 – API Spring Boot com PostgreSQL

Este é um projeto desenvolvido com **Spring Boot**, **Java 21**, **Gradle 8.13** e **PostgreSQL**, totalmente configurado para rodar com Docker. Nenhuma instalação local de banco de dados ou dependências Java é necessária para executar.

---

## 🚀 Como executar o projeto

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

### 📦 Passos para executar

1. Clone este repositório:

    ```bash
    git clone https://github.com/HitaloAguiar/ProjetoA1-TopicosEspeciais.git
    cd ProjetoA1
    ```

2. Execute o projeto com Docker Compose:

    ```bash
    docker-compose up --build
    ```

3. Acesse a aplicação no navegador:

    ```
    http://localhost:8080
    ```

---

### 📁 Estrutura dos containers

| Serviço | Porta Externa | Detalhes                    |
|---------|---------------|-----------------------------|
| app     | 8080          | API Spring Boot             |
| db      | 5432          | Banco de dados PostgreSQL   |

---
