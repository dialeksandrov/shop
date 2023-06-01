После пула проекта запустить как обычный Spring проект в IDE
Так же можно запустить композник лежащий в корне проекта
Сваггер доступен по ссылке localhost:8080/swagger-ui.html
UI базы доступен по ссылке localhost:9006/h2-console
креды бд admin admin

Тело запроса на сохранение
{
"series":"AR12345",
"manufacturer":"Intel",
"type":"PC",
"amount":150,
"stockCount":13,
"params":[{
"name":"type",
"param":"mono"
}]
}

Тело запроса на редактирование
{
"id": 1,
"series": "AR12345",
"manufacturer": "Intel",
"amount": 150,
"type": "PC",
"params": [
{
"id": 1,
"name": "type",
"param": "mono",
"productId": 1
}
],
"stockCount": 13
}