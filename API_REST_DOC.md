# API Rest documentation
## Introduction
These are the status codes that are returned by the application in this cases:
* Everything is correct: 200 OK
* Something is created properly: 201 Created
* User not logged: 401 Unauthorized
* User does not have permission to access: 403 Forbidden
* Something is not found: 404 Not Found
## Content
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Contents list | https://localhost:8443/api/contents | GET 
| Specific content | https://localhost:8443/api/units/{id}/contents | GET 
| New content | https://localhost:8443/api/units/{id}/newContent | POST 
| Delete content | https://localhost:8443/api/units/{id}/contents/{content_id}/deleteContent | DELETE 
| Upload image | https://localhost:8443/api/units/{id}/contents/{content_id}/uploadImage | POST 
| Edit content | https://localhost:8443/api/units/{id}/contents/{content_id}/update | PUT

### Request examples (JSON)
#### URL
`https://localhost:8443/api/contents`
#### Request
~~~~
[
    {
        "id": 2,
        "title": "¿Para qué?",
        "desc": "lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 25,
        "title": "¿Para qué?",
        "desc": "lus semper vitae. Sed auctor placerat viverra. Ut a tellus vitae sapien pellentesque elementu",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 26,
        "title": "¿Qué?",
        "desc": "JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ? basado en prototipos, imperativo, débilmente tipado y dinámico.",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 27,
        "title": "Historia",
        "desc": "JavaScript fue desarrollado originalmente por Brendan Eich de Netscape con el nombre de Mocha, el cual fue renombrado posteriormente a LiveScript, para finalmente quedar como JavaScript.",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 28,
        "title": "¿Qué?",
        "desc": "La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1? comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 29,
        "title": "¿Cómo?",
        "desc": "El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 30,
        "title": "Historia",
        "desc": "Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 31,
        "title": "Premios",
        "desc": "El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 32,
        "title": "¿Qué?",
        "desc": "Timothy \"Tim\" John Berners-Lee, KBE es un científico de la computación británica, conocido por ser el padre de la World Wide Web",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 33,
        "title": "¿Qué?",
        "desc": "Este año marca un giro en la historia del mundo por las revoluciones que derrocaron a los estados comunistas de Bloque del Este, son conocidos como las Revoluciones de 1989",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 34,
        "title": "Historia",
        "desc": "Las matemáticas o la matemática1? (del latín mathemat?ca, y este del griego ??????????, derivado de ??????, ‘conocimiento’) es una ciencia formal que, partiendo de axiomas y siguiendo el razonamiento lógico",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 35,
        "title": "Aspectos formales",
        "desc": "Es muy posible que el arte del cálculo haya sido desarrollado antes incluso que la escritura,14? relacionado fundamentalmente con la contabilidad y la administración de bienes, el comercio, en la agrimensura y, posteriormente, en la astronomía.",
        "hasImage": false,
        "imageRaw": null
    },
    
    [...]
    
    {
        "id": 47,
        "title": "Title 11",
        "desc": "Pichulo",
        "hasImage": false,
        "imageRaw": null
    },
    {
        "id": 48,
        "title": "Title 12",
        "desc": "Pichulo",
        "hasImage": false,
        "imageRaw": null
    }
]
~~~~

#### URL
`https://localhost:8443/api/units/{id}/contents`
##### Note
- {id} is where unit id is written. (In this example is 3)

#### Request
~~~~
{
    "content": [
        {
            "id": 28,
            "title": "¿Qué?",
            "desc": "La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1? comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 29,
            "title": "¿Cómo?",
            "desc": "El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 30,
            "title": "Historia",
            "desc": "Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 31,
            "title": "Premios",
            "desc": "El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.",
            "hasImage": false,
            "imageRaw": null
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "pageSize": 10,
        "pageNumber": 0,
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "totalElements": 4,
    "last": true,
    "totalPages": 1,
    "first": true,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 4,
    "size": 10,
    "number": 0,
    "empty": false
}
~~~~

#### URL
`https://localhost:8443/api/units/{id}/newContent`
##### Note
- {id} is where unit id is written. (In this example is 3)
#### Body
~~~~
{
	"title": "¿Por qué?"
	"desc": "Nunca sabremos el porqué."
}
~~~~
#### Request
~~~~
{
    "id": 52,
    "title": "¿Por qué?",
    "desc": "Nunca sabremos el porqué.",
    "hasImage": false,
    "imageRaw": null
}
~~~~

#### URL
`https://localhost:8443/api/units/{id}/contents/{content_id}/deleteContent`
##### Notes
- {id} is where unit id is written. (In this example is 3)
- {content_id} is where the content id which is going to be delete is written. (In this example is 28)

#### Request
~~~~
{
    "id": 28,
    "title": "¿Qué?",
    "desc": "La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1? comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire",
    "hasImage": false,
    "imageRaw": null
}
~~~~
#### URL
`https://localhost:8443/api/units/{id}/contents/{content_id}/uploadImage`
##### Notes
- {id} is where unit id is written. (In this example is 3)
- {content_id} is where the content id which is going to be delete is written. (In this example is 28)
#### How to set an image
On Postman, go to "Headers" tab and set "Content-Type" on the field "KEY" and "multipart/form-data" on the field "VALUE". Now, we go to the tab "Body" and select "form-data".
#### Body
Once on "Body" tab, set "file" on the field "KEY" and in "VALUE" field chose an image. Then, we send the request.
#### Request
~~~~
{
    "id": 26,
    "title": "¿Qué?",
    "desc": "JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ? basado en prototipos, imperativo, débilmente tipado y dinámico.",
    "hasImage": true,
    "imageRaw": "/9j/4AAQSkZJRgABAQAAAQABAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2NjIpLCBxdWFsaXR5ID0gNzUK/9sAQwAIBgYHBgUIBwcHCQkICgwUDQwLCwwZEhMPFB0aHx4dGhwcICQuJyAiLCMcHCg3KSwwMTQ0NB8nOT04MjwuMzQy/9sAQwEJCQkMCwwYDQ0YMiEcITIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIy/8AAEQgCuQS+AwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A7GiiivozwwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiikMKQ8GjNIa4q9Z3tE+ly3L4KPtKiv2A0mKliheY4Qc+tWV0885fnvXK2z2Vyx0sUsUdKuPYuB8pzVR1aM4cEfWkpMGoz6CZpaSlrqpV0tGePjcrjOLlS3ClopK7k01dHzck7tPSwtFFFMgKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoopKQC0hpaQ1M3aJvQhz1Yx8xBTkQvIFHJNNHSrViubjPoK8tu7PuElCKiaMMYjQKAOO9P70dKBUGYhpksKzLhgPrUtIaAvYx57doH/ANk9KhrZljWVCD+FZDqY2KN1oNYu+4lLTaXtXfh6t/dZ87m+EUH7WO3UWiiius8LfUKKKKBBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRRcaYUUUfjSHaTCikFLQTqFFFFML3CiiigYgoNLSGs6ivE6MJK1eL8wq3Yf6xvpVOrVgcT49RXlPc+3k7q5qCgUUCkZC0UUUAIRWfqEXAcD61omoLhd8DD2zQNMx+1KKQdOaK2pStJGWOpqpQkh1FIe1LXp3PimunYKKKKZIUUUUAFFFFABRRRQAUUUUAFLSUtABSUtJQAUUUUAFFFHagBaKBRQAUlLSUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRTTnNK9ldlQhKUlGPUXNBNJRj2rhq4h7I+mweURjHmqIM0UuM9KTBrD2kz044ailZQFozxSZFGKuNeUdzlrZbRq6WsxQaWm5pRXZSq86PnsZgJ4d90LRRRW9meeFJS0lS+xdOXLJMSpYH8uZD74qI8UZxzXlzjaTR9xQmqlKLRur0pait23Qqe9SiosNi0UUUhBTH5U/Sn00/dNAupiMMMfrTafJ/rG+tMqo/EjSavEdRSdqWvWXwo+EkvefqwoooqiQooooDUKKKKQW7hRRRRddwSbemoUUGkzSc4rqaqhVltEWikzRU+1h3NI4KvLaItLTc0mTUe2gjdZZiH9kdRSUUe3gWspxL6C0UlITU/WIFrJ8R1HZozTQaWpeKiaxySp9pi5ozTeaOaX1tdjX+w7/bHUUhpM1ccTFmFTJKy+DUdRTQadW8ZqXU8yrh6tJ8slYKKKKZj1sFFFFMQUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAU09aU0nWubEysrHsZPR56jk+gVPb2zTEEnAqFRuYKOprYhTYgUV57Pp5MRLeNOiinmJD1UU/vRilczKktmj52jB9qoS27xNyOPWtrFMdAwwRkUDUrGJiirFzbGFtwHymq/NUny7FShGouV9RRS03pS5zXp0qilGx8hj8G8NU02FooorQ4baiGkxS9aSuHEQalc+oyaup03B7ov6fJnKE9OlXx1rFhfy5Q1bCNkA1y7nqSVmPooopEhTW4U0vaorh9sLn0FAGQ5y7H3ptLmkq4rUuq3GDaFHSlpM0V6PtIxS1Pjo4OtWk3BC0ZpCaQVnLEpbHbSyWs/jHUmaTmisniZdDup5LSj8WouaTNANLgk8A/lWbrzZ1wy7DQ1sJk0ZxUgglbohNSLZTH+ECs3OT3Z0KjSjsiv1oq4NPc/ecCnjTvWSlctcq6FDFGK0hYRjqSaeLKEfw0rjckZXAorXFrF/cFO+zxD+EUIOcx/zowfQ/lWwIUH8IpQidMD8qBc5jY46Gird5KAdiY96qUilsIKcFJHQ/lVu2s84d/yq6I16ADFO4nIxipHakraMS/3R+VNNvG3VBTDmRj0YrTawiPQEGq72DLnac/Wk2Ckip0op7RuhwykUzrTUmtgnCFRWkgyaXNJS12UsR0Z8/jMpSTnSFopBS11pp6o8Jq2nUKKKKYgooooEFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFACGkxSmkzXDi07XPo8jaUZoltgDOmfWtgVj27YnQ+9bA6fjXIz2pi96XtSUVJIUUtFADGQOpB6VkTwmKQg9D0rZqvdw+bEf7w6U7lRdmZVIKOQSD1pa1pS5ZGONw8a9FxClpBzS16ad1c+JmuX3ewlJinUHpUVY80TrwVf2NVS7jcGtOxl3xYP3lrMBNS20vlzg8815jjbQ+zbU480TYzS5qu91Gv8QPsKqyX7nhMAVNiLNmiXAHzECqN5OjR7Ack1Ud3kOWYmo+e9BSiFGaXtT0ieT7q8etBQykq4lgx5dsewqwllGnPWm1cOdGYAT0Uk/SpEtpH/hxWssaqOFApwpE85nJp7nlmwKmXT4x94k1c7U0kAc0E3bIVtYkP3KlCIOiioJbyOPIByarm/c9EFFgSkaPTtSgVmfb5c9BUqagM/Mn4iizBxZd70tRxypIMqwzUmc0rCCiiigAoxRS0IBopsrbI2b2p5qrfsVgIB607jW5mkln3HvzU1pF5kuT0FQVp2KAQBu5oNG7FkKAOKWjpRSMgooxRimAZzSEUtFIBrIrDkZqlNZcFo+Par9GKBptbGGyMrbSMGm1rzW6zA8fN61lyxNE2HqkaxlcYDS5pKBXVRr2tFni5nl6knVgOopKWu4+Za6BRRRTAKKKKBBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFACEc0hp1JXPiY3ietk9Xkr8r6gvBB7jmtmF/MiVh6Vi960dPkypQnp0rzT6ieuqLtLSUtIgMUYoopgJSHpTqSkBk3kflzZHQ1XrTvo98W4DlazOvFUnY1jqrAKdTaWvQoTvDU+UzXDuNd8q3FzSUlGacq8YoMNldStZvRCmko60ZBNcMpczbPpqNL2MOQM0fjTguXC469604raNADjJqGzVySRnpDK/3VOPWllt3hAJGQfStfGBwOKQgMMEZpEc5jKhdgoBrXijCRqtKsaqchQDT8GgUncNtGKWigQlBpaaTjPpQJDHkEa7mrNnuWlPBwlF1OZZCv8ACKgUFm2quSegoehol3EHX0+vejjmuk07w2ZEEt0SM8ha2F0OyC4MKmpc0jmnj6aeiOE4pOevP512dx4as3HyAoT6VhX+g3Fplo/3kY64601NMqnjYTdjLRmQ5U4rRt7rzfkbhh2rMwM4wacGZW3Dr61Vzpcbq6NvmnVBbzebGD37ip6RkFGKKKAENUdQPCirxqhqH8H1NA1uUe1a9txboPasiti2INuh9qZcyWloopGYUUmaM0ALijpRSdqAFpKMimkgdaEA6oLiATLjHI6GpgRRzii9gMNlKMVbg0dq0L2Dcu9RyOtZ/Xn1p3NU007iUtJTq9GhU5o26nymaYX2NbmWzCiiiug8oKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigA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3yf3IznB9z0qJry5lysKLboTn5OT+Z5rxMZxBhMNeKfM/L/M9fDZLiay5pe6vP8AyLPkSAEsNgXg7ztx+dRtJaxkh7pDxx5YLZNVhZtI26RmZj1LHNTJYjsv6V89X4rxEtKUUvxPXp5FhofxJN/gJ9stADjz2OePkA4/OlN7abcCO4DepxirCaZIRlYWP/AaedKnAz5D/gK5Hn+ZS1T/AA/4Bussy9acv4srfbLAgcXCnvkAio2urcH5Zcj3GKsvpzqMmJh+FV3sV7rj6inDiTHwfvO/qhSyjAzWia9GOSWN/uuD9DTqpvYY5Xj6URyTW5w48xf1r2MLxXTlpXhbzX+X/BOCvw896E7+T/z/AOAXKKfE1vdD9zKEcDmOU4JPsaZX02GxdHEw56Uro8HEYarh5ctVWCiiiuk5wooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKSlopA0IRRilpKwrUk1c9XAY+VGST2FVipBHUVNLdPIgB6Y5qv3oPNec9z6uPv2l3DHapYoWlOACPeiCMSyhScCtZI1RQB2pClK2hHDbpCuMZbvU2PelxS0GYmaWiigAo70UlACOQoJPasaeQyysfyrRvX2QkdzWVnHNNGkO5c0ywa/uxHj5Afmru7eFIIljRQqgYAFYGjtFpejzX9ywSNVLsx7AV4N40+N+s6jqEsGhv9kslJCvj5396wm7ni4qq5zsfTwKnjNLgV8bad8U/F2n3PnDVZZuclZeQa+hPhp8TYPHFtJbzxiDUoFDPHnhx6j8ag5j0UgVk63p63tq3y/vFGVNawximuuQR601oVCTjK6PM8YJBGMHp7irNlJsmx61NrFt9m1KVRwrc1SiO2VPrXSnofQRlz00zcFMljEkZU96cO1LjikR1MORTGxU8YqS1uZbS5WeE/MOvuKt3dr5g3qeRWftKnmq6GjtOPKztbHXLW5jG5tj9w1XxcwYz5i4+ted47/wAqXzJOznH1rLkOCWXJvQ72bVbSEZaVeOwNYGo+I3kBjtcqp6vWAST1OTSY4x3pqFjSngIR1YpYsxZ2JJ/i9aVVLuFXvQiNIQqqTWnb2qwjnljWiOvmSVkPghWJAoqYUY5pakzCiiigApDS0lAMz9Qj5Vx24qjjJrZnjEsRFY+CCQfWmjSDui/YS5Qxt1XpV3GaxopDFKGH41sI29Aw70EyWojIrD5lBHuKYLaEMGWJQfUDFTY4oFIm4gAFLS0UAJSU6j8KQWEzRS/hRQAU00tMlbbEx9BTAx5DmVj703vQTliaSqW6LqaQfoOooor10vdsfBy1k2FFFFMkKKKe7R20Ill+Zn/1cYPLe59BWGJxNPDU3VquyRtQoVK9RU6au2GESLzpm2RZx7n6Cq0lzNcqYogYoD1A6t9T+NIFlvJfMmOfRR0Uegq/FbgLk4AHJJ6CvzzNM8rYyXJT0h27+p9jgsuo4Ncz1n37ehUgswvatW10qWbkLtX1Nc7f+PNE0d2it0OoXKnBCHCA/WsSf4p69K5+zWltDHn5QRkiuShgL+9WfyNKuKk9IHqcGjwRjL/OavxwQxj5YlH4V4unxM8To+WW3dfTbg1sad8XZUkVNU04bCeZIz0r1KUKNPSCRxT9rLVnq1OzWPoviLTNeg82wuUkP8SZ+Za1c10qZhYeQD1ANRyW0Ev34lP4U7NLmm3GWjQK62M2fQ7aXmPKGsa80SeHkKHX1FdZmiuOrl9CpsrPyN6eKqQ63POprPk8EGhLySJRFdKZYx91ujL/AI/jXb3el290CdoR+zLXM3+mSW7EOvyno3Y153Jisvn7Sm/mv1PQjWo4qHs6iv5MrFQUWRHV0P8AEp6fX0NNqsplsZvMjAK/xIwyrD3FWlZJohLESV/iU9VPvX2mUZ3DGr2dTSf5nzeZZTLDfvKesPyEooor6A8UKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKDRSUgCkpT1pDXHXq9EfRZZgLfvZoDUghcpvA4qS2tzKdz/drTVQFAxXGe7zmXbRs0y4B45rXApoUL0FPpEN3CiiigQUUUUgCgUUlAFHUfuCs8gY/GtLUFzEDWaR+VUjWK91mv4vgll+GeoR2wJkNucY+lfHjcf56V9vaO0d7o4hcBlIKspHUV82fE74ZX/hrVZ72xge40qZjIrxrnyz6GuaW589VTVR3PMh1ruPhLez2fxH0ryWI85zG4HcEf8A1q4uOF5JAkaM7Hoqgkmvc/gr8Ob+HVE8RarbNbxRqfsyScMx/vYpEH0KOQPpQetHamu21SSelAdbHG+Jcf2mMf3eax1Hzr9auavcfadRkYHIHAqrAu6ZRXTDY9+jG1JI2V6Cl9qQdKO9ABjmoJrVJhnGG9asUUBtsZbWMiklTmo/sso/grYwKMCi5XMzHFrKT9zFWI7Du5rQxRii4c7I4oljGFGKkooxRckKWkpaQBRRRQAUlLSUAJWZewmN946GtQVFNF5qFfypji7GN1q9ZXGD5bHHpVN1KOUI5HWkGRyD05oNGro3c0Cqdrdh1CucGrYoMmrDqKKSgBaKSigBaSik79aAAmqt9Lsh255arDyBELMeKyZpTK5Y/SgqKuR0lKaXtW9CPNM5MyrqnQeu4CiiivSPjgoop8ahm+Y4QcsfQd6UpKEXKWyHGLk1FbsA8dvH58oDAHCx/wB44/lVWON7iUzS8s36UFjeXG/GIl4RfQVpQxBQK/Ms5zWWNrWXwLZfqfcYHBxwdK32nu/0Fgg6ADk1c1HQf7W0WfT1uzavMMGVRnHtU9rEFG8jntVsGuXBxUGqjWpNebl7qOGs/hBYwj9/rEr/AO4gH/6/0rRHwt0IY/066yO4Irqg1OzXqfWYv7KOXll3OOk+FWmtnydUmX03Csi9+E+oIpNnfw3A7K42mvSQacHI71SrU3vH7he+tmeDT6H4n8JajHeQWE8cqNndEu5WHoSK920y7lvNMtbiePy5pI1Z09DjmpxcPjBII9xmk3ZOat1IW90l3b1JQ1KGqEGl3UKYuUnzS5qENWdrPiDTdAtRcalciFDwoxksfYVamTY180yWJJoykgyprhP+FteHvN2BLnb2Ypwa2NO8e+HdTcRx3wjkPRZRir5k1ZhZrUj1PS2t2JAzGeh9Kw282zlMkRIB4ZezD0rv2EVzD1V42HBByK5bUbEwSspHynoa8PFUHhpqrS0X5Hq4XEKouSev6lUhZIlniz5TcDPUHuDTKrxSfY5yrD9zJwwx09xVuSMxyFDzjofUetfeZLmix1G0vjW/+Z8xmuA+q1OaHwS2/wAhlFFFe0eSFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQMKQ0E0mfWuetU5EenlmE9vU5pLRBU1tAZpP9kVGkZkcIO9a8MQiUKK8/d3Pq3orIVUCDaBxTx70Y5pcUjMO1AzS0ZpAFFGaKQBRRRQAUlLRQBDcJvhYVjFeqnjtW8RWbewFG8xRkHrVIqDLOh6iLK62Pny3/SuxKw3MWGCyRsOQRkGvOTWpp+t3FlhH/eR9h6VnOHY5MXhHJ80Tp4tB0mKbzU0+2WTOQwjGa0doAwAAPQVjReJbJ1G9ih9CKWXxJYquVcsfYGs+Vnm+wqbWNncAKwdd1ZYIjBCwMjdcdqzL7xHLOCsClE/vd6xGYyMWYszHuaqMDtw+Dbd5CZOcnmrlhHuJfHFVoo2lYIvWteJBGoVRituh6U3pZEgFJjmlpaRmJS0daKQAKKBRQAUlKaKAEpaKKACiiigAooooAKKKM0AFJS5pKYFS7tvMXcv3h+tZpzuOeD6Vu4qnc2ocFkHzUFxl0M7BBBHWrlteYO1/wA6pkFWwwwaTGKCrXN1XVhkHNLnNYsc0kfRjVlL9hgOmfcUGbizRpapLfx98j8KG1CPsrGgLMt5FRSzpECSaoyXzuPlGKrFixyxyaClAlmnaZvaoc0ZoxVJXdkU5KCbYUtGKWvRoQ5I+Z8hmOK9vU8kFFFFbHnBTbt9sSWyZDvzJn07CpoWWN/Nb7sYLn8On64qrbhriZpn5ZjmvluJse6VJYeG8t/Q+hyLCKUniJbR29S3aw7QOK0Ik5AqOFMAVLJPFaxNPM4SNBlmPavgErs+gqTLy8AAdBWffeIdJ0w4u7+GM/3S3NcNqfiPVfEczW2kl7WxzjzhkPIMdvQU2y8DRfflQvIeSz8k/nX02Gyqco81V28up5FTFJO0dTpf+FjeG84+1ufT92f59Kv2HjLQNQkEUOpwiUjOxztP61z/APwh8IQDyx+VZuoeDIXTmFcjkZHSu15VStpJmX1mXVHpyuGGVIIPcGn7q8ftNT1zwlKTGzXVln5oZOSB7HNek6Jrtnrtgt1aSA5HzpnlD6GvMxOGqYfV6rudFOrGp6mxupd1Q7qUGudVDTlJw1LuqHdShqtVBOJMGrG8R+EtM8V28Ud88kckJJSRD0rV3Uu6t6dbldyHG55pffCO7hUtp17FcD+5INp/r/SuM1Pw7f6XIY76xlhI/jAyv5ivoAOR0NLN5N3CYbuFJ4yMEOM1tz0p+T/AFKcd9TwnQ/Fms+HJlMdw9xad4ZOePY16xpmv6b4t0syWkgFwgy8J+8p+lYniD4Z29zG1xoUgicDJt2GQfoe1eb291qXhHXUnVZIJ42xJE38S9/rRUptx5Z6p9Sk03zQ3R6feQZUgiktHM9q0R5lg9uWT/wCtVlbyDVrKHULb/VTrux6HuKz932W8SUjKH5XHqDXmZdipYDGJvZOz9Dur0VjMM6b36epYop0ibHK5Bx3Hem1+ppqSuj4Npp2YUUUUxBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSUtJUyfKrmkIuo1BbgaQelL1qe0h8yQMRwK8upLndz7XC0VQppIt2cAjTLDDGrWKRRTsVncpt3ClpKWgAoooxQAUUYopAFFFGKACgUYopgFNZQww3Ip1IaARm3FkVyyciqZBU4IxW9io5II5PvKKehSm0YvbpQOe9aTWMZ7kUDT4x3NIvnM76ZPtU0Vu8hxggHvV9LWOPkDn3qcLgU7kuXYhhgWIEL9496nAooFIgKWiikAUUUUAFFFFMAooopAFFFFABRRRQAUUUUAFFFGKACkpcUlABSd6WjFMRDPbJMpyMN61ny2rp0GRWtigjNBUZNGCevIxR71tPbxv1UZqu1hGTnJFBfOZ3vRmrclpHEuWf8KqeuOlA07hRikpe1NK+iCTUVdiYpaKWu+hSUdWfM5lmTqy9nDYKKKK6TxgooooER3hKWiqOszY/Adf1xU9pHtQVXvx/p8cXaJAPx6mr1uOK/Ls8xHt8bN9Fovkfd4Cj7HCQj1ev3lyMVxviCabXtZXR4D/osXMxH8TZBA/SutmnW3tZZmOFjQsT9BWJ4D08zo15Mv72ZjI31Jz/WtckwyqVHVl9nb1OXHVHFKK6m9ovh2O2gRRGBgeldFDpiKB8tXreFVUcVznjvxrb+DdIaUJ517IMQwjueeT7cV9UeUbZ09cdKqz6YGB+WvnPUvi/46uLszRXcVsmcrHFHwPz616j8MPiqPFbf2TrKiLVFHyPjAmH4DANAGvq2iJKjAoK4BJbjwf4gS7i3GzlYJPF2we/4V7fd2qup4rzzxhpCTWcvy9QaipTjUi4S2Y4ycXdHURypLGsiNlGAZT6g0/dXJ+Cb6S88NwLKSZICYmz7V0Ydh3r4irJ0qkqcujsezBc0VJFoNTt1VhN6iniQHvTjVTBwZOGpd1Zepa3p2jxeZf3ccQ7AnJP4Vylz8TbfdtsNMubgdnYbQfzrso0a1XWEbmM5wjuz0ENShq83X4lXYIMmhyBe+JM5rV034jaNeyCG5Sexl9J0+X/vocVvLC4iCu4kKrTezO1VypypwfasvxH4b07xXZ+Vd/urlR+7nUDI+vtVyOZJYxJG6ujDIIOc0/dU08RKGnQpwT1OZ0PwzN4a0M2U9ys5EhYMo4wahvYsqa6e6+aBs1g3SZU15mMknV5l1O/CNpWIEfzrSGQnkDY31H/1sUUyxJ+z3MXGFZZOT+HH50+v0jJMQ6+BhJ7rT7j5TN6KpYuSWz1+8KKKK9Y8wKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooGFIaU9KbXJialvdPcybD80vbPpsGM8dzxWvbxiOMKOuKo2cXmS5I4FagGK4T6GTF70tFFIgKKKTNAC0UmaKAFopKKQC0UUUIAooopgFBooNACdqKKKQgxS0UUIYUgpaKYBRRRSAKKKKACiiigAoooxQAUUUUAFFFFABRRRQAUUUUAFFFFABQaKSmAtAopM0gFpDRTWcKMk4piHE4qrcXaxjC8t6VBcX/AFWMfjVLLE5JzQWojnkaRyzE02iiqUW9ipzjSjdhilopa9CjRUVdny+PzGVVunDYKKKK6DyU7KzCiiigQU+L/XJxn5hTKmtBm7hx/fFTJ2i2VFXaRUuTv1ac/wC1V2I8VnyHOpTn/bNXozgV+PYt3rSfmz9FUfcivJDNW3Nol6FGW8lsCrvgYAaTCevyjmolRbhZIGAIlQoQfcVW8EXRhjeyl4kgcoQfavd4fqLlnDrozxcxi1NM9FjYYFeMfFq3aXxbaedkxtB8men0/n+dewRyZrH8V+GLbxTpfkSMY7iP5oZQfun/AAr6M84+ep9DBHC1L4V0uS28caM0APmfaVHGRxnn8MV2B8CeMI5WthawuoztlLjBHr3rt/BfgA6DeHU9SmWe9wQiqPlj9xQB3cgytcp4lgU2UmfSupd+K47xhfJb6fIWPY0Act4FUraX47faCRx/n/JrrKwPB1o9r4dieVdstyzTsPqeP0xW/XwmPmp4qo13Pbw6apIK5vxL4mbSytnYIJr+ToO0Y9TW1qN6mnadPdv0jUn6muY8K6FJf3Emo3eWmmcuSewJ4A9q7MpwEcTNzqfCvxZjiq7prljuzPsPC1zqVx9t1J2nuG5LNyB7Cunt/C8KKAIh+ArsrTTFRR8oq+toijkCvrkklZbHlN31ZwcnhqPHEY/KsPVPCcUsbAxA59q9W8mCQlUdGYdQGBNVLnTlYHimB4vZahqvg67BV5bjTgfngYlto/2cnivUNN1O21WwjvLSQPFIMgg9PasvW9EWWNgUBz7VyPhW7k8P+Jn0qQ4tLwkxgk/K/tXlZjg1KDqwWq38zpw9Vp8r2PSJz+6NZNwMg1pTN8uKz5+hr5OtK8j2aKsZlodt7KuD88bDA/Opajtzs1RGAJ+VuB9DUlfecKybwsl2f6HgcQJe3g+6CiiivqDwAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiikpPa5SV2hCeaU9KQ9afEhklVe2a8yrLmmfaYKkqNCNjSs4tkIJ6mrIGKagwMU+sTZhRRSE0CCkxzSNIqjJOKrNeAZCjNOxSi3sWqUkVQN457Un2t6LFeykaFGRVFbvH3hmpkuo2OM0WJcGixS0wMCODTgeKCRaKTNGaQC0Gig0AFFFFIAooooAKKKKACiiigAooooAKKKKACiiimAUUUUgCiiigAooooAKKSkzQA6ikzmjNAC0lGaTvTAXNITTJJUjByaoTXhf5YzihDSuW5blIh1BNZ007ynk4FRnJNB607GijYOlIRS0VpTpOTOfE4ulhleW4nenUYor0KdKMNz5XF46pXlvZBRRRWtzivpruFFFFAgooooAKmtcfa4s9N4qGnwsFmjY9AwJqZq8Wio6NFGQ7dRnH+2auI3FVL9fK1iUepzUqvxX5DjIctaS82fpNP3qUZeSLPmbSCDyOao6iH03Uo9btlJt5sJcqoztYfxVKzVJb3Sxlo5UWSF+HRhkEVOExE8LVVWHzXdHPi8J7anZbo6rTNTju4FdHByK1Fl4rzs2F5pRa70Yi4syctblvmT6YFaVh4ytXbyZ28qZfvRvww/CvtsLi6OKjzUn8uq9T5ucJQdpI7fzfekMtc+viKzZciZT9DWfe+MLG3U/vlJ9Acmukg6W7vkgiZmYDArzi+lk8Ua2trEc2kTbp37Y5wPzqwzat4nJCK9lZfxTSDDMMfwit2xsLbTLVbW0XCDqx6sfU14WZ5vToRdKi7zf4f8ABOmhQc3d7EqosaKiLhFGFHoKXFOxSEV8fznro5vxgxktLO0HSadd30HP8wB+Ndj4fs1gs4wB2rjvFSsLvSJDny1mIPHfHFd5pLD7JH9K+3yRL6nFrq2ePineqzXQACvAPid481bVdTk03RruW1sYCUd4WKtI2SOo7Y/nXvudyFckZGMivnDUNOW016/sZ0EbrM20E9VzxXrHOefQ3euabex3ltqNyJ4zlWZya+l/hf43fxnoDLeKF1G1+SbHRvQ143c6RGFJIAFeg/BTS5be41O8C7bdwEB/vH/OaAPTL+1DoeK8m8bWZtJYryIESQyq6kdetez3ABQ15d8RFX7C65wTxmk0mrMDoY5fPgjl7OoaoJ+hosV8vTbZMYxEox6cU24PBr87krSZ9HS6FC2IGqK2cbVY8fSnUyzYDUJHIyFjbr9MU+v0DhWNsLJ+Z8/xA/30V5BRRRX1B4AUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFACUGlpCayqStBnXgqXtq8Y9BKt2C5kLeg4qp6fWtOwTEG49Sa8tu+p9o3ZaFtc45paSjNIzA1DLOI1PrUkjBUJ9KzJHMr5PQdKaRcIczEkkMhySfpTfwooqzqSS0QUv40UUFCUnNOooBjkldOhzVuK6VuG4NUcikzS5TKVNM2AeKWs+3uCCFbkVfByM1LVjmnFxYvalpAc0VIkLRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRTAKKKKQBRRRQAUUlFABSEUtRTuUiYj0pgBlRTjcKkBBHHNYTEtySQTUy3UiR7c8etFi+Rmo8yIPmIqlLfEnbGMe5qozlzljmk/CqsNRBnZ2yxJpPpS96KajJsmpUhSV5PQTNKOaMUV1U8N1Z4mLzdX5aQtFFFdcYqOx4M6k6kuaUrhRRRVEbsKKKKBBRRRQAUUUUAFFFFAEOt5+0wXH99Bk+9QxvkVcv4/tGj5UfNC2f61l277kFfmWe4f2OLl5n6HlFVVsHF9VoWmaoyeaWkxXinopE0FzLbvujYg1ekubPUECahYQT4OcsoNZiip0FS1Z8y0ZhWoU6nxInGj+H3O42LZ7fOeKuW9lpdswa206FWH8RGTVeIVcjHSlUr1ZK0ptr1Z58sLRi9EWjI0mNx/AU4UxBUoFcpLstgxTSKfimmkJGP4lsWvdDkaMZmtmEyD1x1/StbwxqKXenRMrZyopAwVuRlTwR6iua2y+FdVLJubTbhtyMMnYSehr6jh/GqN8NN76r9UefjKTT50elpJXPeK/Bdh4qRJGf7NeIMLcKuTj0PIzVyx1GK5iVkcHPvWistfVHCeeWfwiTzAdR1eSaMf8s0GA31r0TTrC00mxjs7KFYoYxgKKXzaY84UZJoAkuZQqEk15b4lb+2dftdPTJQyB5COyg5/pXS+JPEkVnbsitukbhVHUk1i6JpsloJb68/4/LnBKn/lmuOn61wZjjI4ai3f3nt/Xkb4ek6s0jbZuMDoKpXL4U1Mz8Vm3kuENfELVn0VOGoyzBPnSepC/wBf8KsUkUflWsSHqRvP40tfqmS4f2GBhF7vX7z4zNq3tcXNrZafcFFFFeqeaFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQO/USkp3am1y4p+7Y9nJaXNXcuwDqK2rddkCD2rHjGXUeprbUYUVwM+jkB60ClpMcUiehUvJONo61UH3RUt0czGoq0R1042QUUUUGgUUUUAFFFFABRRRQAhOP8at2s2fkbtVWlU7WyO1DRnUjdGsOlApkTb0Bp9Qzl2FopKWkIKKKKQBRRRQAUUUUAFFFFABRRRQAUUUUwCiiikAUUUUAJRRR2oAp3V00bBEH1NUGlkk+85x6Vo3Vr5uGB5quLB+7AVRceWxUpCauS2ZiiZgdxFU/ahFp30QDmlxSU6uylQi1dngY3M60JunHSwmKWiiuqMYx2R4dWtUqu82FFFFWYhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAE9sQWaJsbZF281gtGbW8eE8AHj6VsZwc1Fq8H2iFLuMfOo+avmeI8D7Wl7WO6PpOHsaqVV0ZbSKy8inhagt3DKKuqua/PpaH183YasdTIlOVKnRKzbOeUxY06VbjWmRR5IFcNrnxBurPVJLTTLSORYTh3lJ5PtSpUZ15csEcdWokeiKKkxxXn+n/ABRtmwup6bNbnu8XzrXWad4n0PVQPseowsx/gY7W/I1NXC1qfxROdzTNSo24qYjK5GCPUc1DJXOiou5A7YqNpInhe3uY1lgcYZGGaWQ1UkatYo6FTU1ZlNtJv9OkM2jXBuLfr9ncgFfp0qWPxfNa/u76zuIHHXfGcfn0P50gnkibKOVPsal/tm4xtfbIP9oV72GzrE0o8s0pr7mclTKW3emxT44tWB2CRiOCAhzVSTW9Z1X93YWTqp/5azfKq1ZOsScEQxKw6EIMio31C4n+/KcegroqZ9WatCml6u/+REcoqfaZHZ6VBZTfabqU3d9/eJ+WM+wq7vJOTyTVVGp5fivDrValafPUd2ejSw0KS5Yj5ZMCqcERvL1UzhF5Y+gpLmbAwDV2GL7Fp4BH76f5m9lr08nwDxeIUei3MsdiVhaDn1ew2Vw8rMOmePpTKKK/U4pRVkfAttu7CiiimIKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigaEpO9LSVxYp6JH0ORx0myW2G6dB71sjpWRZj/SVrXFcTPbnuFIelLSGkiTMn/wBcaZTpv9c31ptanbDYKKKKCgooooAKKKKACiiigApOM0tFAF2zYmMj0qyKpWZ5YVeFQzjmrSYUtFFIgKKKKQBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUwCiikoAawypHtWLIhjlZT2rcIrNv48OHHQ9aEVF2KdOptLXbhZ2908TOsO9KqFooorsPnd9QooopgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFTW7ruMb/cfg+1Q0VE4KcXF9SoScJKSKN3bNYXRGDsY/lVmBwwFXAqXcJgk5b+H39qzNr2c3lv07GvzjOsrlhajnFe6z7vLswji6SjL4kasYzVhEqpBIGA5q9GRivmpG9S6JY1wQTXGeIPh/cXWpTahpUkbCY7mhk4w3sf/AK1dsoqVSR0opV50Zc0GclRX1PGb3QNSsCRdafMoH8SruH6c1kSWUErHgbhx6EV9BeYSu1gGX0YZrOvtA0bUh/pNjHu/vKMEV3081a+NfcZ3fVHjNpqWt6WR9h1OdFHRHO9fyNdJpHxHv/tsNrq9vC0cjBBNHkEZ9RW9ffDi1kBOn3zxHHCSfMP8f1rHtvhrffb0kv7iAW0bBvkPzNj2reVfB1otzt92orrodzIcjI6HpVKWr0gAACjCgAAVTlFeTE9Ckyk9V261bkFV2Wt0d0GRinqabilBxVFsnDU2SYKOtQvLtGaLO2k1GfaPliXlmNaUaE6s1CCu2ZTcacXObskWNNtvtMpuZh+4j55/iPpVmWRpZC7Hk/p7U+aSPYkMK7YkHHqfeoa/TMoy6OCo2+09z4LM8e8XVuvhWwUUUV6x5gUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAYpp607vTa4MVufT5J/CkWbL/j5H0rVNZVj/wAfArVNcrPWluJQelFKelIkzbkYl+tRVZvF6GqtaI66buhaKKKDQKKKKACiiigAooooAKSijNAFq0HJNXhVSzX93n1q3moZx1HeQtFHaikQFFFFIAooooAKKKKACiiigAooopgFFFFAAaKKKQCUtFFMApM0EjFNBB7igQ6iigUDFqtdpvgb2qzTHG5WHqKAMPoKUHNDriRh6Gkrak7TRljqftKDQ6iiivT3Z8U1ZWCiiimIKKKKACiiigAooooAKKKKACiiigAooooAKKKKADpVgrHeReXJ/rexPf8A+vVeisK+HhXg4TRtRrToz5oMgKy2cmHyV9cVft7lWA5o85JU2Trn0bGT+NVprGWA74uVPIx0NfAZpw/UotzpK6PrcHmlPELlqOzNiOUHvVlWBrnobwodr5U+9aEV2D3r5adJxdmds6T3RqUVVS4B71L5wPesuUwcGh5NRuSe9BkGKjZxQkOKInHWqsgqy7iqzsK1ijphcrSCq7CppHFVZZQO9bRR2QTGsQKhkmCjrUbSPK2yJSx9q0LXRwuJr18DstehhMBWxMrQQsRiaOGjzVX8irZ2MuoPuY7IR1Y1sO8cUQt7YbYx1P8AeP8AhSSTblCRjZEOiioa+/yvJ6eDjzPWR8TmebVMY+VaR7BRRRXtHjhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQNBTadTe9cGK3Ppckf7qRYsji4Fa3Wsa1OLha2RXIz157hig0ClzQSQzJvjIrM5HB6itc9KpXUOG3qOO9Uma052ditRSZpapHUgooooAKKKKACiiimDENKBkgetIantY977j0FBEnZFyBNkYFSjrRQKyuce7FooooAKKKKACiiigAooopAFFFFABmjNFFABRRRTAKKKKQCUZopAOetNAZ2saj/AGbaGUDLHhRWDY+KLp7tY51Uo5AGB0qx4ulAhhjz1bNczZrm9hHrIKqx2UaMXTcmemK25QT39acKYP8AVinikcQtJS0nSpGZF4u24OO9QVcvxiVT7VTq4vU0a5oNDqKSlr1YO6Pha8eWbXmFFFFWZBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFPjlePIU8HqCMg0yik0mrMabTuiw6WtyAP8AVv3z0/Oqsljc25yhyO3vTqfHNJF9xiPbtXjYzJMPidbWZ6mGzWtR03RXFzNF99GHvUq6j9asfaVYfPChPqvFIRZtyY3U98YNfO1uFJp/u2etDPKMvjiMGoL/AHqDfr60rW9kSMMTn1SkNrZAZ35PptNcb4YxP9XN1m+FInvl9arvek/dBP0FXxDZLzyeey04SW6AhIMn1Y/4VvS4Wrv4mKWeYeHwq5lCO6nPyx4B7mrEejH791LgdcE4q4bqX+Dan+6OfzqEkk5JyfWvawvDVCnrUdzgr8QVpK1NWJEMFsNtvGM/3iP6UxmZ2LMSSe5ptFfQ0aFOiuWCseFVrVKr5pu4UUUVsZBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUDCmnrS0lcWKWlz6DI5fFEfCcTL9a2weKweQQfetuE7olPtXGz3JD6KWipJENNYbgQelOoNNAZ08BiOQODUNajLu61UmtG5ZPyqrm8KltGVqM0hBXgjFFUbp9hcUUmaKAFopM+1PSNpGwBQDkkIql3AFaUUYjTApkMAjH+1U2OKls5ak+ZijmigdKDUGYE0Z9qQ9KoahqlvpygzPyeijrTBJt2W5oZ9qM1j2XiKzvJREpKOegbvWt15FA2nH4kPopOlGaBC4oxRRQAUUUUgDFGKKKYBRRRQAUYoooASk7UrdKrXtytpZyTMcbRx9aAabskcb4muPP1HYOVjGKo6Uhl1S3AHRqrTStPM8jH5nJJrc8KW3m38kxHEYwPqao9NrkpanadB+FOFJ1pR1qTy0LSUtJSGUNRHCmqFaGofdT61n1SNY7C0tIOlLXqUvhR8VjUliJrzCiiitDkCiiimAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABTadTTXPiVeJ6+T1OXEJdxcZxWrZNutl9uKyQKvafJjcn4ivO6H1EvI0KWkFLUmYlHNKKKYCdqb3p9JigTI3hVwciqzWf8AdNXcUYpp2LUmjP8Askg7ij7I59K0MCgUcw/aSKaWY6k1ZWNUAxxUlNIpEtthSjpQBxS0CEFBpaQ9aAEPArgPEZk/tmXzMngFPpXfngZrA8S6d9otBPGP3sX6ig2w81Gpc4tWKMHUkMOQa7vQtVW/tlVjiVBgj1964T9M9amtLqWzuFniYhhwR6ig769H2kbo9N7UDpzWbperQ6jDlTiTupNaWc/Sg8uScXZjqKTNANAgxS4oooAKKKKACikJpM0AOpM0hOKM0CbEZgAcmuM8S6r9plW1ib92nXHc1o67rqwRtbwMDIeCR2rjixbJJ+buaDuw1C75mAByMck9q7/QdP8AsFiit99vmY/yrnPD2lNdXInkGIk557mu4AwMflTuTi6nM+VATS0hFLSZydBaSlpD0pAUNQ/gFUKuagf3ij0qnVI1jsKOlLSClr1aWkUfE42V8RNhRRRVnKFFFFMAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAE70GlpDWdRXgzow83Tqxn2EHSprd9kwPrxUPSgEjn05ry2tbH3CalG6N0cinVDbSeZCGqapsZCUtFFABSUtFIBKKWigBKWiigAooooAKKKKACkNLQKAGmmugkUqwyCMGnmmjOaYHCa5o7WFwZI1Jgc5z6VkD2r026t47mFo5FDKRjpXC6pos+nuWCl4ezDtTsd9CvpaRQt7iS2mEsLFWHOfWuv0rxJDcKsVziKX1PQ1xQIznPFA4x1NI2qUY1Fc9UVlZdwII9RSg157Y63eWWAHLIP4WrobTxXayACdWjag4J0JwOipaoQ6tZTfcuUP44qyLiFukiH8aDJp9ibNJkUzzo/76/nUT3lvH96dB/wKgVn2J+poOBWXPr+nwZ/fqx9qx7zxaxyttF9Gag0VGctkdRNPFboXlcIB3Ncpq3iVpMw2hIU8GSsO8v7q9OZ5SR6Z4qsQAeMig66OG5dZiklySzZPc+taGlaXLqVwoAxEv3nxU+laFPfSCSVSkXcnvXaW1pFaRCKJQFFAVsQkuWI6C3S2gWKNQFXoKnpOfWnCg4N9WJRS0UAFJ2paY7bUY+goAy7tt85HYVXp7tvYt60yqhq7GkpcsGx1FFFetHRWPha0uapKXmFFFFUZsKKKKBBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFJ7WHcaetFKRSHivOrw5Zn12WYj2tHl6ouWEu1vLPQ9K0Qc1hoSrBh1FbMDiSMMKwO+S6okHWlpKWkQgooopMAooooAKKKKACiiigAooooAKBRRQAUGigUwE7VHLEsqFGAIYcg1LRQByeo+Ft7GS0bHfYelc3cW01rIUmRlI9RxXp+aguLSC6TbNGrj3FB008TKOjPMevv/ACoxx/QV2lz4VtZcmImMn8qypvCt6hPlsrj60HXDE03uYHHTGKcHk7SMPoxrQl0LUUPNuze4pn9jah/z6yflQac8H1RT82Uf8tH/AO+jTSxb7xLfWrw0bUCcfZX/ACqzF4a1GQcxhR/tGgl1Ka6mNx/+qnfzrpbbwkxx583HotbNpoFjbYxGGYd2oMpYmEdjjbTSby8I8uEgf3jXT6Z4ahtsSXGJZffoK3ljVVAUAAelOHFO5yVMTOew1VCAKBgDtTqUUtBjuIKWiikAUUUlAATVW9k2Q7QeTVkng9hWTdyiWXg8DpQhx1IBxSgZpMUvSt6EeaVzkzKsqdC3Viiikpa9I+O82FFFFMYUUUUCCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACkNLSVhXhzR0PSy3FOjUXmJ6Vcsp9jGM9DVPGKAcHPpXnM+vaTWhvD1paq2swkQZPI4qzmoMrWFopKWgQUUUUAFFFFABRRRQAUUUUAFFFFABQKKKACiik60wDFFLRQAlIadRQAyjFPwKKAshopRS4oxQFhKKWigLCClxRRQAUUUUAFFFFABSUmaR5AiFm6CgCveTCKMjuay6kmlMrlu3pUeKaNI+7qwFLSYpwr0cNT5Y3Z8pmmKdaqo9EFFFFbnmBRRRTEFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSUtFLdj2VxDSU6kPSuHEU7ao+pyvGqrH2Unr0HxSmJ93atWKQSoGHFYwqaC4MT/7PeuQ9Zx6GvSimRuJFDL0NPoMhaKKKACiiigAooopAFFFFABRRRQAUUUUAFFFFABRRRTAKKM0ZoAKKKKACiiigAooooAKKKKQBRSUtABRRTS2FJJ4FMBDwM9u9ZlzcmViq/dHFOursyNsjOB3qpzT6GkY9WGKUUgp1dNCk5as8vM8b7KPs47sKKKK77W0R8rcKKKKBBRRRTAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiikPdBSUGik0mrMqFR05c0ROnelrJ1TWUsZVjUbmz82Owq/a3UV3CssTAqevqDXkzlDncUz7nCupUoRqSVrl2C4aBhjlT29K1I5VkUFTWLn0p8UzRNkH5fSk1YtxubO7mlqvBcJKPerANFjO1haKSlpAFFFFABQaKDQAUUUUgCiijFABRRRQAUUUUwCiiikAUUUUwCiiigAooooAKSgnFFIAzR2pM4qCa7SMYzk0w3ZLJIEXLHisy5ujKdoPy+lRySvKcseOwqPtkUGiWlwpe1VL6/isITJI3PZR1NJpuoJqNt5ifeH3l9K0pOMqijcwx1WdGh7SKLmKWm06vVSSVkfFVKjnNyk7sKKKKCQooopiCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKM0guHWqWp362FqXyN7cIPWrZZUUuxwFGTXEarfm+vGbP7tThB7Vw47EqjC3Vnt5JlzxtXX4Y6spzSvNK0jsdzHJqxYX81hNvRjtPVexqp2xU9tCZXyRwK+YVSXNzXP0l06fJypaHa2d7HeQiRcBj2NWsn2zXKRyNCwZCc1tWmqJNhJcK47nvXpUsUnozx6tBp3iaQYryDirkF6wwr8j1qkCCMjkUdvrXZvqjjce5uJKsgyppwNYiSNGflJq5DqHaT9KkhxZoUVGkySDKnNPoJegtBpKKAFoFJRmkAtFJmimAtFGKMUgCiiimAUUZozQAUUUmaAFpM0UfhQAtIaQsM8nFQyXMcY5IJ9qAJqZJOkY+Yj6V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mkmnZhRRRmmSFFFFIAooopgFFFFABRRRQAUUUZpAFFFFMAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoopPpyaQ1e9kLRmpFt5W6Rk0rW0y9YzU88e5r7Cr0REKKUqy9VIptNNPYzcZLdC0UCiqEFFGaOwoAKSpYraWU5VTj1NXodORQDKd3tWFStGJ10cFVq9NDOVGkOEXNWotOkblztFaKIicKoA+lP5zmuWeKk9Inq0cqhHWepXSzgjx8uT71OFAXCjH4U7ikJx3rnc5S3Z6EKNOCtBAPelPSmkgjk4FVrnUILeF2Y5Crk4o5Xa45ThGSTdmyzwOtZ2pa5Y6dFmSUF+yqck1xWpeLL67LRwN5MWccdSKwGdncsxLE9zXDVxbXupHsUcslUSnUdka2o6i+taj5pBVF6A0/1x0qtZpsj3Hqas1wuTk7s9O0YLljsgFFFIOtJhcWkpaSkAUtJS0AJRRS0AHakoooAKKKKYmKOKOvagUvakNCfhSU40lMTDPtRQaSj5gkgox70UtA7JB+NFJRRqAUvakooAKKKKQBSikooAU0lFFABRRRQAUUUtACUtFJTExkqB4yp6msphtJHpWwf1rPvI9sgfHBpbamtOVisOBXoPg7UvtNh9mkbMkJ49x2rz70rT0DUP7P1WORjiNjtatMNU5J27mOOoKpSfkeqYHFKM+tRRzxSqCjg5qSvakpJnzCkpaIY0KP95AarSacjZKHFXAc0EU41Jx2M6mHpzVpJGPJZTpzt3D2qA5BwRit/n1qKS3il+8vNdUMW+qPMrZV1pmLRV2XTmXJjOfaqbo8Zwy7fc10xqQntueVVw1SnuhKKTOR/WlFaWOdBRRQaLXBhRSc9qesbsPlUn6VLaW7LjCUtkNoqUWsxHCGmPHJH95cD3oU4vYt0aiV2htFA/WirMQooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigaDNT2UYkucEDA5qDrUlrL5M4Y/dPFZ1E3F2NsM4qpHmNsdOBij601ZFcZUg07n0rympXPrIuDXusayIw+ZQaqy2ED8plWq4CTxRjPWqjUnF7kVMPSqL3kY0tpLD1XI9RUGT/wDWroCvryPSofssPmb9nNdMcWvtHl1spu703oZcNrLMeFwPU1oRWEcf3/marPA6cU7HFZVMRKe2x10Mup01ruIFx049qWijr6CufWTO5JRVugcUhz+FQyXEUIOWyfSqUuoO/wDq/lFbQoSlqctbG0qXW7NB5EjGWcCqc2pKDiJc+5rPdmc5Y5orqhhox+I8mvmk56UySS5lkPLHHtWH4huvs+n7AfnlO38K1/rXG+ILrz9RKp92MbRWOPnClR5VozqyPDzxmMTqO6RlDpT40MkqqKb7VcsY8/vD9K+ZTb1Z+jyehbAAAHpThRRTObcDSDrRQOtIBaSlooASlpKWgApKKKAF7UlFFABSikooAKKKKACiiigAooooAKKKKAFpKWkpgLSUUUgCiiigApRSUUAKaSiigAooooAKKXFGKAEp1JRQAYqK5j8yEjuKmpp9KY1uY2exo5ByB0qWePy5mHqcioqjZ3OnSUdTudIuzc6fE4OGAwcVrxX00ZxncPeuM8NXWy5e3J4bkfWupr6rCVIV6KclsfmWa06uDxbjHZ6mvDexSdflPpVkNnoQRXP96lSeSI5Vj9KqeFvrFioZpKPu1dTc4/Gl7VnxaipwJFx7irsbpIuVYGuWdKUN0etRxVKovdY6myRxuuGXdTzjNIRUJtbaG0oKa1KEunZy0Jx7VQeN4zhgRW/0HFMeNZU2uARXRDEyT9482vlkJ6w0MIIWwFBNXIrB3wXO0elXo7eKL7i1KByaupim9IkYbK4x1qEEVpDF0XJ96nUAdAB9KWjntXLJzlq2elGjCGyEyajlQSxsrDtkVIPfioLm4WGNjkEkYGKumpOSIrOmoNOxkEYOKSjOTk9TRXqrY+SluwooopkhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUDCkpaSgBysV+6xB+tOFzMOkjD3zUeKt29kZPmf5V9KxqOmleZ00IVqkrRbsLBc3bsAh3D1Naa5I+brSIiRrhBgU5a8+rKMn7q0Po8LQlSj7zuLSGl70HrWS0OrRaiDml4xk1UmvUhJUDLVRmu5ZepwvtXRHDuepwYjH0qWnU0ZryKIddx9qz5r6SXO35RVekrrhh4xWp49fMKtT0Ddk980uKKK2tbRHA9Xdh0FBooqgK93OLa1klPQD9a4GR2kkZyeWJNdR4mudlssA6scn6Vy3Svm82rc9RQXQ+/4Ywrhh3VktZaCDk1rQp5cKrWfbpvmUfjWoOlebFWPoqrtoFFBpKDIU0g60UUgFpKM0UAFLSUtABikozRQAtGKSjNABSikozQAGgUUUAKaSiigBTSUZooAWkoooAWkpaSgBaSiigBRRikzRmgANKKSigBTSUUUAKaSjNFABRRRQAtJRRQAtFFFMClfJkK461SFa00YeJlrJ6Eikb0noya1mNtdRyg/dYZrv4pBJEsg6MM150f512egXHn6aq5yyHBr18prWbgz5bijC81OFdLbc1AKWkH8qWvoHufCrRaCGnK7RkFWIpKMUmk0OMnF3TL0OosOJVyPUVdSeOVco2fY1h0qsyHKkg1zzwykj0aOZ1KatU1R0HYdqKyotQdAA/wAwrQgmS4TKde4rjnRlDU9mhi6Va3K9SWjtSZ4pRWK8zrIbgzhMwhSR2NZb3dxnDMynuMVsk44qC4t0nXB4b1ropTinZo87GYerNc0GZLTSt1kb86bkk8nNPmgeA4bp2NR16EeR7Hz9Vzi7TvcUUUCirMbWCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKTGtwpO/1pans4w9yAeg5pSlyxuXSg5yUSxZ2Y/wBZIPoK0BkDnGKQH24oGS2MV5VSrKcj6uhQVGFkHU4pRgHHf0qtc3SwjA5f+VJZbmRpXPLGm6bUbi+sxdX2aLfTrTJH2Rsx7U4jJ4qnqD7YQo6k1NOPNJFYiahTbZmMxZyx6k0UUV66Vkkj5GT5m5MKKKKGSFFFFCAKTrRUdzIIbaWUnG1SaU2oq5pSg51FFdWcfrtz5+osOyfKKzP5Usj+Y7uTyxzSYyPxr46tU56jfc/WsHR9jQhTL1inyl/yq5UUC7IlFSis1oFR3YGkpTSUCFpKKKAFpKKXFACUtJS0AFFFFABRRRQAlLSUUAFFFFAC0lFFAC0lFFAC4pKM0UALSUtJQAuKKM0UAFFFFACUtJRQAtFFFABSUUUAFFLikoAXFJS5pKAFooooEB5rKuE8uc+hrVqnfJ91/wA6DSm7Mo1u+GbnZePBnh1JH1rC71PYz/Z7+GXOMMAfpW2Eqezq3Mczw/t8LOPkegDvSikByoI70or7BNNXPyZprRhRRRTEFJilopAJVqwk8u5AJ4biq1CttZW7g1NRc0WjehU5KiZv9DS0xSGVWHSndxXktWdmfXRleCkgBB5BBFBAPpWfLO9rdEdVNXY5FlUMhyO/tVOnJRujCjiYVG4X1CSNJUKuOKybi2a3b1Q1sknHSo5UEsLKR2zV0qzjKxljcLGpByMQUUfyor0z5dqzsFFFFMQUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFA0FLFIYpVYHpSUmKTSasVFuLTRsx3kLrkvtPcVBc3w27YTyeprO6Ulc6oRTud08xqShyikk5YnJ9609PkVodmfmFZeOeacrmM7lODWlSnzRsjHDYh0anPLqbxPtWRfSebccHgUhvJ2GC3FV+e5zWNHDuDuzqxmOVaNoC96KKK62zyulgooooAKKKKQCdjWT4iuPJ0woDzIcCtauW8UT77mGDsik1xY6p7Oiz2MjoKtjILojBxxT4l3TIvbNNqxYrulZj0Ar5Q/Tm7K/U0QOKKB0oqzlSCkpc0lIYUUUUAFLRSUALRRmigAoozRmgApKXNJQAUUUtACUUUUAFFFFABRS0lABiilzSUALSUuaSgBcUlLmkoAKKKKACiiigAooooAKKWkoAXNJRiigBcUlLmkoAWkpc0UAGKhuU3wuKnHSmtyCp70wW9zFI6UHv/OpJU2SkVGRn61OiZ0vWJ3mlXH2jToX6naAfrV2uf8LzbreSEn7pyK6Cvr8JU56SZ+V5rR9li5qwUUUV0HmhRRRTAKO+faiihDuamny74fLJ+YVa5PXisJHZGBU4qVruZ1KluK4qmGblzI9nD5lGnT5Zbj7+QST/ACngVBDO8D7lP1FNJJpMV0xp+5ZnmTrylV9ojYivYZI8s20+lRXd6oTbEck8ZrN/CkHvWaoRTudcsxqSp8ooFFAorc85u4UUUUxBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUDCiiigLhRRRSAKKKKYXCilpKQBRSUc00gtbcWijNJmkFrK4tFLRTEN6c1wuqzGfU5264OBXaXUghtZZD2XNefsxdmbu2TXiZvO0YxPsOFKPvTq220EFaFkmId3rVDvxWrCuyEDvjNeFY+0qbElJR2opnOgopaKBiUUUUAGKKWkoAKXNJRQAYopaSgAopc0lABRiiloASiiigAooooAMUUtJQAUUuaSgAxRS0lABRRRQAUtJRigAoopRQAlFKaSgAooooAXNJRRQAUUuaSgApaKKAFHSk70o6UhoAzr5NsoYd6rc1fvlyit6VQzmlY6Iao2PDk3lalsJ4cYrsK8/spTDfQyDs1d+p3AMO4zX0OUzvTcex8HxRR5cRGotmhaKKU16x8sJRRRTAKKKKACiiilbW47hRRRTDcKMUUUB5BRRRQAUUUUCCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigYUUUUhID9aDSEcVds7QPiSQcdgaipNQRvQoOvLliVo4JJT8qn61MdPnxnAP41qhVUYUACnHNcUsVK+h7VPKaSXvbmE0Lp99cVHW+yqwIcZFZ93ZlPnjHy9xW1LE82jOPFZdKmuaGxSzSE0E0g611rU8u2tjL1+Yxaay5wXOK4vt+FdJ4on/ANTD+JrmyK+XzOfNXt2P0fhujyYNPuSRLulVfU1rYx+WKzbNd0wPoK0jXCj2am9hRwKKSlFBkhKKWikMSilNIOtABRS0lABS0UUAJRS0UAJRS0UAJRQetLQAlFLRQAlFKaQdaACilpKACilNJQAUUtJQAUUtFACUopKKAA0opKUUABpKU0lABRQOtLQAlFLRQAlFLSUALRRSUAKKDQKKBMhuF3wsPQVljpWwRlCPWshhtdl9DQb0noAOCCOxzXfafKJrGJ/9muA9K7Dw5KZNN2n+A4r1Mpnaq49z5vimjfDKp2ZsUUlLX0R8DbUKKKKYgooooAKKKKACiiigYUUUUCCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooGFFA5ppIpCWo7vSE4o/rR3FFn1HfoiW3i86YL+JraC7cKBwBxWfpq/OzelaXavOxMm5H0eWU1Gnz9wxQDntTS21ST2rKe8lMxZWwuelZ06LnqjoxOKhQa5jWOc0MRtx1qOCYTRB8c96lwDUO8WdCcZwv0ZjXkPlT9MA81X61p6mP3aNWZwOTwK9OjK8LnzGNpKFdxRx3iGUSaoyjkIMVlVPfy+dezyf3nNQV8liJc1WTP1DAUvZ4anDyLlivDNV3tVezXEA96n7VC0Km9RaKKKCEFFFFIYUUUUAFFFFABRRRQAUUUUAFFFFABRSHrS0AFFFFABRRRQAUUUGgAopKWgAooooAKKSlFABRSUtABRRRQAUUlFAC0Ug60tABRRRQAUUUUAFFJSigAoopDQIKy7hds5961Ko34xIp9aGaUnZlSui8LTfPNDnqN1c6OK1fD0nl6tGP74IrpwM+SupHHnNL2uDnH5/cdl/OlpB/Slr60/LEFFFFMQUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSGloo6gPghaeYIv41qLZwKMFNxqnppAnYE9elagAFcGIqS5rI9/LsPTlT5pbmfdWKqpeLt1FZ9dAcEEHoetY1zbmGVmx8h6Yq8NVumpGGY4TlanTWhZ03HzjPatAYzisa0l8qYEng1sAfNkHINYYiLTO3LKilS5Owy5Um3cL1xWJgkkd638ZzVdrKMzCTH4U6NbkQsdgnXaYtmhjtwG6nmrPak7Uh469Kxk+ZndTjyU0uxR1JvkVc81j3knlWcznshq9eS+ZPnPA4FY+vOY9ImbGA2F/Ouy/sqLPE5frGNil3OJY5bNJ1oHApyDLgepr5Nu5+nRXLBLsakQxEg9KkoHAAoqjnlqw7UUUUgCg0UUAFFFFABRRRQAUUUUAJS0UUAFFJSigAooooAKKKKACiiigAooooAKKKKACiiigAopKUUAFFJS0AFFFFABRQaQdaAFooooAKKKKACiiigAooooAKKKDQAcVUv1PlBu4NWqiuV3QMKCo7mX3qzp8ph1CCX+64/nVYUuSCpHYg04PlmmaVoc9KUe6Z6MDnn1pahtZBLbRSD+JQamr7SLvFH5BUjyzcX0CiiiqMwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigY5HMbh16g9K2opFljDqc+tYdTW1wbdyeqmuetS5ldHoYHF+ylZ7Gx9BQyhlw6gimxyLIoKmnZ55rzdYux9GnGa01RUfT4mOVYpVqJDGgUtux3p3BpQMVcqjkrMiGHhB3iAFIBQSRRk46VmtTbVCkn0pGHFLn6UlDTQr3IxBD12DNct46mEenwQKB8z5/Kusxh/auD8cTbr+3hH8Kkms8VOSp6vc3y6jD6wuVK+5y2OKkt13ToKjqzYrmYk9hXi9T6meiNCiiiqOYKKKKACiiigAooooAKKKKACiiigAooooAMUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAGKKTNLQAUUlLQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAJTXGUYe1O70daaBPUx+hI96QnHNPkXbMw96Zzn2qG+p1LU7fRZRLpUBHUDFaNYfhl91gyf3WNblfY4WXNRR+UZpS9ni5rzCiiiug88KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKQBRRRTAKKKKACiiigAooopAFFFFABRRRTAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKQBRRRTAKOtFFK4bjopXibKNg+lXY9SHSRMe9UMUmKznShPc6qOLq0vhZsLewMOHxTvtUP/PQVi0tYfVY3OyOa1FujVkv4VHBLVTlv5JOFG0VV6dKCM1tChGJhVx9WfWxIJpF5EjZ+tOF1P/z0NQ0tW4Q7HL7eoluyU3M+MCQ81w3iCYzavJuJYqAvNdnxjPpXBahJ5moTN/tmvJzXljTSSPqOF+eeJc5PZFbPNXLEZ3n3xVPFaFkMQk+9eAj7eo9CzRQOlFUc4UUUUhhRRR1oABRRRQAUUUUAFFFFACZpaMUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAYooooAKKKKACiiigAooooAKKKKACiiigAooooAKSloxQAlAHOfSlopgZl2Ns7H1qHOatXy/OD61U71LR0w1R0XhaTDSx57Zrpa5Dw44XUiCfvCuvHp+NfTZbVToas/OOIqXJjX5oWiiiu/nj3PAClpMijcKPaQ7gLiik3CjcPWlzw7gFFJkUZHrT9pDuAtFNyPWl3D1o9pDugFpaQMPUUbh6il7WHdALSUbh6ikJHqKPaw7oBaKTcPUUbh6ij2sP5kAtLTdw9aN49aXtaa+0gHUYpu8etG9fWj21P+ZAOxRik3ik3j1oVan3QDsUlJvB70bh60/a0/5kAtFJuHrR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"
}
~~~~

#### URL
`https://localhost:8443/api/units/{id}/contents/{content_id}/update`
##### Notes
- {id} is where unit id is written. (In this example is 3)
- {content_id} is where the content id which is going to be delete is written. (In this example is 28)
#### Body
~~~~
{
	"title": "Conteni2",
	"desc": "Descripción"
}
~~~~
#### Request
~~~~
{
	"title": "Conteni2",
	"desc": "Descripción"
}
~~~~

## Itinerary
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Itinerary list | https://localhost:8443/api/itinerary | GET |
| Specific itinerary | https://localhost:8443/api/units/{unit_id}/itinerary/{id} | GET |
| Itineary list from a specific unit | https://localhost:8443/api/units/{unit_id}/itineraries | GET |
| New itinerary | https://localhost:8443/api/units/{unit_id}/newItinerary | POST |
| Delete specific itinerary | https://localhost:8443/api/units/{unit_id}/itinerary/{itinerary_id}/deleteItinerary | DELETE 
| Edit itinerary | https://localhost:8443/api/units/{id}/itineraries/{itinerary_id}/update | PUT

### Request examples (JSON)

#### URL
`https://localhost:8443/api/itinerary`

#### Request
~~~~
[
    {
        "id": 8,
        "name": "Primeros pasos"
    },
    {
        "id": 9,
        "name": "Uso avanzado"
    },
    {
        "id": 10,
        "name": "Eventos"
    },
    {
        "id": 11,
        "name": "Cumpleaños de famosos"
    },
    {
        "id": 12,
        "name": "Calendario"
    },
    {
        "id": 13,
        "name": "Historia"
    },
    {
        "id": 14,
        "name": "Principales líneas de investigación"
    },
    {
        "id": 15,
        "name": "Futuros proyectos"
    },
    {
        "id": 16,
        "name": "Datos adicionales"
    },
    {
        "id": 17,
        "name": "Biografía"
    },
    {
        "id": 18,
        "name": "World Wide Web"
    },
    {
        "id": 19,
        "name": "Cálculo diferencial"
    },
    {
        "id": 20,
        "name": "Algoritmos matemáticos"
    },
    {
        "id": 21,
        "name": "Psicobiología"
    },
    {
        "id": 22,
        "name": "Comportamiento humano"
    },
    {
        "id": 23,
        "name": "Psicometría"
    },
    {
        "id": 24,
        "name": "Terapia cognitivo conductual"
    }
]
~~~~

#### URL
`https://localhost:8443/api/units/{unit_id}/itinerary/{id}`
##### Notes
- {unit_id} is where unit id is written. (In this example is 1)
- {id} is where the itinerary is written. (In this example is 8)

#### Request
~~~~
{
    "id": 8,
    "name": "Primeros pasos"
}
~~~~

#### URL
`https://localhost:8443/api/units/{unit_id}/itineraries`
##### Notes
- {unit_id} is where unit id is written. (In this example is 1)

#### Request
~~~~
[
    {
        "id": 8,
        "name": "Primeros pasos"
    },
    {
        "id": 9,
        "name": "Uso avanzado"
    }
]
~~~~

#### URL
`https://localhost:8443/api/units/{unit_id}/newItinerary`
##### Notes
- {unit_id} is where unit id is written. (In this example is 1)
#### Body
~~~~
{
	"name": "De principiante a maestro"
}
~~~~
#### Request
~~~~
{
    "id": 52,
    "name": "De principiante a maestro"
}
~~~~

#### URL
`https://localhost:8443/api/units/{unit_id}/itinerary/{itinerary_id}/deleteItinerary`
##### Notes
- {unit_id} is where unit id is written. (In this example is 1)
- {itinerary_id} is where the itinerary id which is going to be delete is written. (In this example is 8)

#### Request
~~~~
{
    "id": 8,
    "name": "Primeros pasos"
}
~~~~

#### URL
`https://localhost:8443/api/units/{id}/itineraries/{itinerary_id}/update`
##### Notes
- {id} is where unit id is written. (In this example is 1)
- {itinerary_id} is where the itinerary id which is going to be delete is written. (In this example is 8)
#### Body
~~~~
{
	"name": "Experto"
}
~~~~
#### Request
~~~~
{
    "id": 8,
    "name": "Experto"
}
~~~~
## Log in & log out
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Log in | https://localhost:8443/api/logIn | GET |
| Log out | https://localhost:8443/api/logOut | GET |

#### Log in
To log in, you have to go to Authorization, on Postman, and set to "Basic Auth" the field "TYPE". Then, set the user name and the password. If it does not work, enter the request url `https://localhost:8443/api/logIn`.
#### Log out
To log out, set to "No Auth" the field "TYPE" told before and enter the request url `https://localhost:8443/api/logOut`.

## Unit
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Unit list | https://localhost:8443/api/units | GET |
| Specific unit | https://localhost:8443/api/units/{id} | GET |
| New unit | https://localhost:8443/api/units/newUnit | POST |
| Delete unit | https://localhost:8443/api/units/{id}/deleteUnit | DELETE |
| Edit unit | https://localhost:8443/api/units/{id}/update | PUT

### Request examples (JSON)
#### URL
`https://localhost:8443/api/units`
#### Request
~~~~
[
    {
        "name": "Javascript",
        "itineraries": [
            {
                "id": 8,
                "name": "Primeros pasos"
            },
            {
                "id": 9,
                "name": "Uso avanzado"
            }
        ],
        "contents": [
            {
                "id": 26,
                "title": "¿Qué?",
                "desc": "JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ? basado en prototipos, imperativo, débilmente tipado y dinámico.",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 39,
                "title": "Title 3",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 44,
                "title": "Title 8",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 47,
                "title": "Title 11",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 43,
                "title": "Title 7",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 27,
                "title": "Historia",
                "desc": "JavaScript fue desarrollado originalmente por Brendan Eich de Netscape con el nombre de Mocha, el cual fue renombrado posteriormente a LiveScript, para finalmente quedar como JavaScript.",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 42,
                "title": "Title 6",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 46,
                "title": "Title 10",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 36,
                "title": "Title 0",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 41,
                "title": "Title 5",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 40,
                "title": "Title 4",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 48,
                "title": "Title 12",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 37,
                "title": "Title 1",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 45,
                "title": "Title 9",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 38,
                "title": "Title 2",
                "desc": "Pichulo",
                "hasImage": false,
                "imageRaw": null
            }
        ]
    },
    {
        "name": "CERN",
        "itineraries": [
            {
                "id": 14,
                "name": "Principales líneas de investigación"
            },
            {
                "id": 13,
                "name": "Historia"
            },
            {
                "id": 16,
                "name": "Datos adicionales"
            },
            {
                "id": 15,
                "name": "Futuros proyectos"
            }
        ],
        "contents": [
            {
                "id": 28,
                "title": "¿Qué?",
                "desc": "La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1? comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 30,
                "title": "Historia",
                "desc": "Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 29,
                "title": "¿Cómo?",
                "desc": "El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 31,
                "title": "Premios",
                "desc": "El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.",
                "hasImage": false,
                "imageRaw": null
            }
        ]
    },
    {
        "name": "Tim Berners Lee",
        "itineraries": [
            {
                "id": 17,
                "name": "Biografía"
            },
            {
                "id": 18,
                "name": "World Wide Web"
            }
        ],
        "contents": [
            {
                "id": 32,
                "title": "¿Qué?",
                "desc": "Timothy \"Tim\" John Berners-Lee, KBE es un científico de la computación británica, conocido por ser el padre de la World Wide Web",
                "hasImage": false,
                "imageRaw": null
            }
        ]
    },
    {
        "name": "Año 1989",
        "itineraries": [
            {
                "id": 11,
                "name": "Cumpleaños de famosos"
            },
            {
                "id": 10,
                "name": "Eventos"
            },
            {
                "id": 12,
                "name": "Calendario"
            }
        ],
        "contents": [
            {
                "id": 33,
                "title": "¿Qué?",
                "desc": "Este año marca un giro en la historia del mundo por las revoluciones que derrocaron a los estados comunistas de Bloque del Este, son conocidos como las Revoluciones de 1989",
                "hasImage": false,
                "imageRaw": null
            }
        ]
    },
    {
        "name": "Matemáticas",
        "itineraries": [
            {
                "id": 19,
                "name": "Cálculo diferencial"
            },
            {
                "id": 20,
                "name": "Algoritmos matemáticos"
            }
        ],
        "contents": [
            {
                "id": 34,
                "title": "Historia",
                "desc": "Las matemáticas o la matemática1? (del latín mathemat?ca, y este del griego ??????????, derivado de ??????, ‘conocimiento’) es una ciencia formal que, partiendo de axiomas y siguiendo el razonamiento lógico",
                "hasImage": false,
                "imageRaw": null
            },
            {
                "id": 35,
                "title": "Aspectos formales",
                "desc": "Es muy posible que el arte del cálculo haya sido desarrollado antes incluso que la escritura,14? relacionado fundamentalmente con la contabilidad y la administración de bienes, el comercio, en la agrimensura y, posteriormente, en la astronomía.",
                "hasImage": false,
                "imageRaw": null
            }
        ]
    },
    {
        "name": "Psicología",
        "itineraries": [
            {
                "id": 23,
                "name": "Psicometría"
            },
            {
                "id": 24,
                "name": "Terapia cognitivo conductual"
            },
            {
                "id": 22,
                "name": "Comportamiento humano"
            },
            {
                "id": 21,
                "name": "Psicobiología"
            }
        ],
        "contents": []
    }
]
~~~~
#### URL
`https://localhost:8443/api/units/{id}`
##### Notes
- {id} is where unit id is written. (In this example is 4)

#### Request
~~~~
{
    "name": "Tim Berners Lee",
    "itineraries": [
        {
            "id": 17,
            "name": "Biografía"
        },
        {
            "id": 18,
            "name": "World Wide Web"
        }
    ],
    "contents": [
        {
            "id": 32,
            "title": "¿Qué?",
            "desc": "Timothy \"Tim\" John Berners-Lee, KBE es un científico de la computación británica, conocido por ser el padre de la World Wide Web",
            "hasImage": false,
            "imageRaw": null
        }
    ]
}
~~~~

#### URL
`https://localhost:8443/api/units/newUnit`
#### Body
~~~~
{
	"name": "Programación en C"
}
~~~~
#### Request
~~~~
{
    "name": "Programación en C",
    "itineraries": null,
    "contents": null
}
~~~~

#### URL
`https://localhost:8443/api/units/{id}/deleteUnit`
##### Notes
- {id} is where unit id is written. (In this example is 3)

#### Request
~~~~
{
    "name": "CERN",
    "itineraries": [
        {
            "id": 15,
            "name": "Futuros proyectos"
        },
        {
            "id": 14,
            "name": "Principales líneas de investigación"
        },
        {
            "id": 16,
            "name": "Datos adicionales"
        },
        {
            "id": 13,
            "name": "Historia"
        }
    ],
    "contents": [
        {
            "id": 29,
            "title": "¿Cómo?",
            "desc": "El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 28,
            "title": "¿Qué?",
            "desc": "La Organización Europea para la Investigación Nuclear (nombre oficial en francés: Organisation européenne pour la recherche nucléaire),1? comúnmente conocida por la sigla CERN (Conseil Européen pour la Recherche Nucléaire",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 31,
            "title": "Premios",
            "desc": "El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 30,
            "title": "Historia",
            "desc": "Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.",
            "hasImage": false,
            "imageRaw": null
        }
    ]
}
~~~~
#### URL
`https://localhost:8443/api/units/{id}/update`
##### Notes
- {id} is where unit id is written. (In this example is 3)
#### Body
~~~~
{
	"name": "C"
}
~~~~
#### Request
~~~~
{
    "id": 3,
    "name": "C",
    "itineraries": [
        {
            "id": 14,
            "name": "Principales líneas de investigación"
        },
        {
            "id": 15,
            "name": "Futuros proyectos"
        },
        {
            "id": 13,
            "name": "Historia"
        },
        {
            "id": 16,
            "name": "Datos adicionales"
        }
    ],
    "contents": [
        {
            "id": 28,
            "title": "Conteni2",
            "desc": "Descripción",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 31,
            "title": "Premios",
            "desc": "El centro fue premiado en 2013 con el Premio Príncipe de Asturias de Investigación Científica y Técnica junto a Peter Higgs, y François Englert.",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 30,
            "title": "Historia",
            "desc": "Fundado en 1954 por 12 países europeos, el CERN es hoy en día un modelo de colaboración científica internacional y uno de los centros de investigación más importantes en el mundo.",
            "hasImage": false,
            "imageRaw": null
        },
        {
            "id": 29,
            "title": "¿Cómo?",
            "desc": "El CERN se encuentra en Suiza, cerca de Ginebra, y próximo a la frontera con Francia. Cuenta con una serie de aceleradores de partículas entre los que destaca el, ya desmantelado, LEP",
            "hasImage": false,
            "imageRaw": null
        }
    ]
}
~~~~
