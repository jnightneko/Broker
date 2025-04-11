# Servicio de filtrado de peticiones - Broker (SFPB)

Este servicio está conectado a un componente de hardware externo (arduino), 
esto para filtrar si las peticiones que está recibiendo son correctas o son 
fraudulentas. Funciona para saber si el equipo o usuario está autorizado para 
realizar una transacción.

## Arquitectura de microservicios

Arquitectura implementada para el servicio **SFPB**

<img src="assets/SFPN.png" style="border-radius: 15px;" />

### Micro Servicios

| MicroServicio | Descripción                                                                                           | PUERTO    |
|---------------|-------------------------------------------------------------------------------------------------------|-----------|
| GATEWAY       | La puerta de entrada para los cliente que utilizán o requieren de este servicio                       | **3761**  |
| EUREKA        | Es el servicio encargado de redirigir las peticiones a su destino                                     | 8761      |
| CONFIG        | Microservicio encargado de gestionar las configuración de todos los microservicios utilizadas         | 8888      |
| EXAMPLE       | Un microservicio _**muestra**_ que ejemplifica; como se conecta con todos los microservicios internos | 8090      |

## Iniciar Proyecto

Para iniciar el proyecto (realizar pruebas - testeo), primero se tiene que inicializar los
siguientes módulos de la siguiente manera (ordenada):

1. CONFIG
2. EUREKA
3. GATEWAY
4. EXAMPLE (Otros servicios)

Ya iniciado los servicios, podemos empezar a utilizar el broker: http://localhost:3761/
