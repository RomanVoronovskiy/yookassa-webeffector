# Задание

## Нужно разработать микросервис для работы с платежной системой.
### Требования:

1) Реализовать вызов метода создания платежа
https://yookassa.ru/developers/payment-acceptance/integration-scenarios/manual-integration/basics
2) Реализовать endpoint для получения информации о изменении статусов созданных платежей
https://yookassa.ru/developers/using-api/webhooks
3) Хранение по запросам и статусам организовать в MongoDB
4) Покрыть интеграционными тестами

### Стек:
+ Spring Boot 3
+ Java 21
+ MongoDB
+ Docker Compose

## Локальный запуск:
### Docker
* Для создания docker образа: `docker build -t ykassa-backend . `
* Выполняем команду поднятия docker-compose : `docker-compose up -d`

### CURL для проверки работоспособност после запуска:
1) проверка статуса
```
curl --request GET \
  --url http://localhost:8091/yookassa/v1/status \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/8.6.1' \
  --data '
{
  "type": "notification",
  "event": "payment.waiting_for_capture",
  "object": {
    "id": "22d6d597-000f-5000-9000-145f6df21d6f",
    "status": "waiting_for_capture",
    "paid": true,
    "amount": {
      "value": "2.00",
      "currency": "RUB"
    },
    "authorization_details": {
      "rrn": "10000000000",
      "auth_code": "000000",
      "three_d_secure": {
        "applied": true
      }
    },
    "created_at": "2018-07-10T14:27:54.691Z",
    "description": "Заказ №72",
    "expires_at": "2018-07-17T14:28:32.484Z",
    "metadata": {},
    "payment_method": {
      "type": "bank_card",
      "id": "22d6d597-000f-5000-9000-145f6df21d6f",
      "saved": false,
      "card": {
        "first6": "555555",
        "last4": "4444",
        "expiry_month": "07",
        "expiry_year": "2021",
        "card_type": "MasterCard",
      "issuer_country": "RU",
      "issuer_name": "Sberbank"
      },
      "title": "Bank card *4444"
    },
    "refundable": false,
    "test": false
  }
}
'
```
2. создание платежа

```
curl --request POST \
  --url http://localhost:8091/yookassa/v1/create \
  --header 'Content-Type: application/json' \
  --header 'accept: application/json' \
  --data '{
    "amount": 2,
    "description": "Ради теста"
  }'
```