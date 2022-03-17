# kafka-sales

Integração entre aplicações utilizando Kafka.

Acessar modulo kafka-sales-service e rodar docker-compose up -d para subir kafka e banco.

- Iniciar os projetos
- Import curl no postman para envio

``` curl --location --request POST 'http://localhost:9090/sale' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 10,
    "saleDate":"2022-03-17",
    "clientName": "Ederson Caldatto",
    "ammount": 100.30
}'
```
