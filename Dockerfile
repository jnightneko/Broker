# Usa una imágen base del OpenJDK 17
FROM openjdk:17-jdk-alpine

# Directorio deon se colocará la aplicación en el contenedor
WORKDIR /app

# Crear un nuevo usuario para ejecutar los microservicios
RUN addgroup -S spring && adduser -S spring -G spring

# El nuevo usuario
USER spring:spring

# Argumentos para gestionar las rutas de los microservicios
ARG MICROSERVICE
ARG JAR_FILE=${MICROSERVICE}/target/*.jar

# Copiar el ejecuatble '.jar'
COPY ${JAR_FILE} /app/microservice.jar

# Dispara los bytecode del servicio
ENTRYPOINT ["java","-jar","microservice.jar"]
