# 🛡️ ms-validated

Microsserviço responsável por validar dados de clientes recebidos via Apache Kafka. Parte da arquitetura distribuída com o serviço [`demo-hexagonal`](https://github.com/daienelima/demo-hexagonal).

---

## 🔍 Funcionalidades

- Consome mensagens do tópico Kafka `tp-cpf-send-validated`
- Valida os dados do cliente (ex: CPF)
- Publica o resultado no tópico `tp-cpf-validation-received`
- Utiliza Spring Kafka e arquitetura hexagonal

---

## 📦 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Kafka
- Docker
- Arquitetura Hexagonal
- MapStruct

---

## 🔁 Fluxo resumido

```text
Kafka Topic: tp-cpf-send-validated
        ↓
[ms-validated]
 ↳ valida dados do cliente (ex: CPF)
 ↳ atualiza campos da mensagem
        ↓
Kafka Topic: tp-cpf-validation-received
```
---
### Comando

```bash
./mvnw spring-boot:run
```

---

## 📂 Tópicos Kafka

| Tópico                       | Ação      | Descrição                         |
|------------------------------|-----------|------------------------------------|
| `tp-cpf-validation-received` | consumo   | Mensagens com dados brutos         |
| `tp-cpf-send-validated`      | produção  | Mensagens validadas (ex: CPF)      |

---

## 🧱 Arquitetura

O projeto segue a Arquitetura Hexagonal (Ports & Adapters), que promove o desacoplamento entre regras de negócio e tecnologias externas.

## 📁 Estrutura do Projeto
```
src/main/java/com/validated/app
├── adapters
│   ├── in
│   └── out
├── application
│   ├── core
│   └── ports
├── config
│   ├── KafkaConsumerConfig.java
│   ├── KafkaProducerConfig.java
├── Application.java
```

## 👩‍💻 Autor

- Daiene Lima — [@daienelima](https://github.com/daienelima)

