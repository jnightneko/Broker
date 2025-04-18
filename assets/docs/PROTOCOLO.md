# Protocolo de comunicación SFPB

Cualquier comunicación con el servicio SFPB, se tiene que adoptar el siguientes
estándar (estas restricciones y protocolos es para garantizar una comunicación
por igual y segura/garantizada):

## Maquetación

1. Toda petición hacia el servicio, tiene que maquetar la petición de la siguiente manera:

```json5
{
    "metadata": {
        "uri": "MY_ENDPOINT"
    },
    "request": {
        /* EL OBJETO REQUERIDO POR EL SERVICIO EXTERNO */
    }
}
```
#### [ TABLA DE DATOS ]

| PROPIEDAD          | DESCRIPCIÓN                                                                                                                                                      | TIPO         | MUESTRA          |
|--------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|------------------|
| metadata           | Son todos los datos que el servicio SFPB necesita para procesar su petición.                                                                                     | Object       | -                |
| uri                | La ruta de destino (endpoint), es decir; donde desea comunicarse. Dicha ruta es propuesta por los servicios externos (**_vea el documento compartido_**).        | String       | bomb/list/active |
| request            | El objeto que recibe la petición (depende del destinatario), este objeto puede estar vacío si no hay un objeto rquerido por parte del destinatario (**_body_**). | Object/Array | -                |

2. Toda petición tiene una respuesta, con el formato siguiente (maquetado):
```json5
{
    "metadata": {
        "uri": "MY_ENDPOINT"
    },
    "response": {
        "data": {
          /* RESPUETA DEL SERVICIO DESTINO. */
        },
      "_broker_session_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9", /* OPCIONAL */
      "_broker_status": 200,
      "_broker_message": "OK"

    }
}
```

#### [ TABLA DE DATOS ]

| PROPIEDAD             | DESCRIPCIÓN                                                                                                                                               | TIPO         | MUESTRA                              |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|--------------------------------------|
| metadata              | Son todos los datos utilizados por el servicio SFPB para procesar su petición.                                                                            | Object       | -                                    |
| uri                   | La ruta de destino (endpoint), es decir; donde se conectó. Dicha ruta es propuesta por los servicios externos (**_vea el documento compartido_**).        | String       | bomb/list/active                     |
| response              | La respueta del servicio SFPB                                                                                                                             | Object       | -                                    |
| data                  | El objeto que devuelve la petición (depende del destinatario), este objeto puede estar vacío si no hay una respueta por parte del destinatario.           | Object/Array | -                                    |
| _broker_session_token | Sólo existirá cuando se hace un inicio de sesión (el token de autenticación), de lo contrario no estará presente en el cuerpo de la respuesta (response). | String       | eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 |
| _broker_status        | Estado de la petición, el mismo estándar definida por el protocolo [HTTP](https://developer.mozilla.org/es/docs/Web/HTTP/Reference/Status)                | Int          | 200                                  |
| _broker_message       | Mensaje por parte del BROKER (SFPB)                                                                                                                       | String       | OK                                   |
