# API Rest documentation
## Introduction
These are the status codes that are returned by the application in this cases:
* Everything is correct: 200 OK
* Something is created properly: 201 Created
* User does not have permission to access: 401 Unauthorized
* Something is not found: 404 Not Found
## Content
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Contents list | https://localhost:8443/api/contents | GET 
| Specific content | https://localhost:8443/api/units/{id}/contents | GET 
| New content | https://localhost:8443/api/units/{id}/newContent | POST 
| Delete content | https://localhost:8443/api/units/{id}/contents/{content_id}/deleteContent | DELETE 
| Upload image | https://localhost:8443/api/units/{id}/contents/{content_id}/uploadImage | POST 

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

#### Request
~~~~
~~~~

### Itinerary
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Itinerary list | https://localhost:8443/api/itinerary | GET |
| Specific itinerary | https://localhost:8443/api/units/{unit_id}/itinerary/{id} | GET |
| Itineary list from a specific unit | https://localhost:8443/api/units/{unit_id}/itineraries | GET |
| New itinerary | https://localhost:8443/api/units/{unit_id}/newItinerary | POST |
| Delete specific itinerary | https://localhost:8443/api/units/{unit_id}/itinerary/{itinerary_id}/deleteItinerary | DELETE 

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

### Log in & log out
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Log in | https://localhost:8443/api/logIn | GET |
| Log out | https://localhost:8443/api/logOut | GET |

#### Log in
To log in, you have to go to Authorization, on Postman, and set to "Basic Auth" the field "TYPE". Then, set the user name and the password. If it does not work, enter the request url `https://localhost:8443/api/logIn`.
#### Log out
To log out, set to "No Auth" the field "TYPE" told before and enter the request url `https://localhost:8443/api/logOut`.

### Unit
| Resource | URL | Supported operations |
|----------|-----|----------------------|
| Unit list | https://localhost:8443/api/units | GET |
| Specific unit | https://localhost:8443/api/units/{id} | GET |
| New unit | https://localhost:8443/api/units/newUnit | POST |
| Delete unit | https://localhost:8443/api/units/{id}/deleteUnit | DELETE |

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
