# Compilar e Iniciar

## Compilar

Broker no está ligado a un IDE o editor en específico, por lo que puede utilizar culturizar 
entorno de escritorio, si ere un novato se sugiere Intellij IDE, ya que facilita la compilación 
e inicialización de los microservicios

### Maven

Compilación del proyecto para poder empaquetarlo (binario/bytecode).

1. Limpiar el proyecto para tener una empaquetado limpio

```shell
mvn clean
```

2. Empaquetar todo los microservicios en fichero _**JAR**_ ignorando las pruebas unitarios de _**JUnit**_
para evitar problemas en la compilación

```shell
mvn -Dmaven.test.skip=true package
```

### Docker

```shell
docker-composer up -d --build
```


## Configuraciones

Antes de iniciar, primero se tiene que configurar algunas cosas, especialmente la base de datos.

### Base de datos

Para configurar la base de datos, se tiene que localizar el microservicio _**microservice-config**_, 
donde se alojan todas las configuraciones, editar el fichero siguiente:

```
src/main/resources/configurations/msvc-logs.yml
```

Si se opta por usar una base de datos local, se utiliza la siguiente cadena de conexión:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/DB
```

Si se utiliza una conexión remoto:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://<user>:<password>@c<URL>/?retryWrites=true&w=majority&appName=Cluster0
      database: DB
```

### Importación de los modelos

> [!NOTE]  
> La base de datos se encuentra en el [repositorio](../mongodb/DB)


Si se utiliza una conexión local, se puede importar la plantilla de la DB No-SQL con el siguiente comando
```shell
mongorestore --db DB /MY_PATH/broker/assets/mongodb/DB
```

En caso de una conexión con atlas o remoto, se tiene que acceder a su servidor e importarlo de forma manual


## Arrancar

Para inicializar el servicio SFPB. se tiene que cumplir con las dependencias dadas previamente, 
para iniciar el proyecto es importante mantener un orden. Los microservicios se tiene que iniciar de la siguiente manera:

1. **microservice-config**: 

Levantar el microservicios de configuración que es el encargado de 
gestionar las propiedades.

2. **microservice-eureka**:

Levantar el microservicio eureka, es la encargada de seguimiento de los 
servicios internos

3. **microservice-**** 

Levantar el resto de los servicios (en esta etapa no importa el orden ya que son independientes 
entre sí)

## Pruebas

Finalmente, ya levantado todo los microservicios y configurado correctamente, podemos empezar 
con las pruebas utilizado el [protocolo](PROTOCOLO.md) definido, el servicios estará en la escucha en la 
dirección siguiente con el puerto ya definido.

* http://localhost:3761
  * /broker/api/rest
  * /broker/POST/autenticacion
  * /broker/POST/salir

