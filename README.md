# Literatura

## Descripción
Literatura es una aplicación desarrollada en Java utilizando Spring Boot, que interactúa con una base de datos PostgreSQL. Permite gestionar y consultar datos relacionados con libros y autores.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.0.0**
- **PostgreSQL**
- **Maven** para gestión de dependencias

## Características
- API REST para manejar operaciones CRUD de libros y autores.
- Conexión a base de datos PostgreSQL utilizando Spring Data JPA.
- Servidor web embebido con Tomcat.

## Requisitos
- JDK 17 o superior
- PostgreSQL instalado y en funcionamiento
- Maven instalado para la gestión de dependencias

## Configuración de la Base de Datos
1. Asegúrate de que PostgreSQL esté corriendo.
2. Crea una base de datos llamada `literatura`.
3. Configura la conexión a la base de datos en el archivo `application.properties` (si es necesario).

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

## Ejecución del proyecto

Clona el repositorio
```
git clone https://github.com/PT015Karen/Literatura.git
cd Literatura
```
Contruye el proyecto
```
mvn clean install
```
Ejecuta la aplicación
```
mvn spring-boot:run
```
## Uso
Una vez que la aplicación esté en funcionamiento, puedes acceder a ella a través de http://localhost:8080. Puedes usar herramientas como Postman para interactuar con la API.
