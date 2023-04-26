
## Tencnologías a usar:
- Java version: 1.8
- Gradle version: 6.8.3
- Spring Boot version: 2.2.1.RELEASE


## Objetivo
1. Utilizando JAVA y spring boot se requiere la construcción de una RESTful API donde se consuma los servicios provee la api de The Movie database. 
 2. Crear Endpoints donde exponga la data ya procesada (Incluir métodos POST, PUT, DELETE, UPDATE).

3. Las respuestas de los endpoints deben estar estandarizadas para una mayor legibilidad.

4. no mostrar más 20 películas en la carga inicial, Construir un paginador para controlar la cantidad de data          proveniente de la API (GET)

5. Construir endpoint de detalle de cada película usando toda la información que ofrece la Api (GET por ID).

6. El proyecto se debe subir a un repositorio Público en GitHub o GitLab, se debe compartir el link del proyecto a este mismo correo.

7. Desplegar proyecto en cualquier tipo de nube (AWS, AZURE).


## Uso de los servicios http
- para consumir los servicios es necesario importar en el PostMan el archivo .json que se encuentra en la carpeta postman del proyecto
  https://github.com/JefersonCaceres/pelis-navas/tree/main/postman
  donde se encontrara los servicios postman
- Saldra una carpeta llamada Movie con los siguientes servicios 
  1. consulta lista de detalles (get list movie details)
  2. consulta lista de peliculas (get list-movie)
  3. crear una lista de peliculas (create movie)
  4. actualizar una lista de peliculas (put movie) # OBSERVACION solo se puede actualizar lista de peliculas creadas por el usuario
  5. eliminar una lista de pelicula (delete) # OBSERVACION solo se puede actualizar lista de peliculas creadas por el usuario
  6. consulta trae el numero de de peliculas de una lista menor a 20 menos igual a 20 peliculas (pagination)

## get list movie details
/list-movie-details/{id}
para el uso de este servicio se requiere el id de la lista de peliculas

## get list-movie
/list-movie/2
para el uso de este servicio se requiere el id de la lista de peliculas

## create movie
/createMovie
requiere un cuerpo tipo json
{"name":"My Cool List","iso_639_1":"en"}
donde name es el nombre de la lista, y iso_639_1 es el lenguaje 

## put movie
/updateMovie/{id}
para este servicio se requiere cuerpo y un id teniendo en cuenta la observacion 
{
  "description": "This list is pretty awesome."
}

## pagination
para este servicio se requiere cuerpo y un id de la lista
{"size":5}
en el cuerpo se envia el numero de peliculas que desea traer de una lista


## Aspectos a evaluar:
1. Semántica.
2. Patrones de Diseño.
3. DRY (Don't repeat yourself).
4. Organización y legibilidad.
5. Documentación en readme.

Se Considera un Plus:
1. Arquitectura orientada al dominio (DDD).
2. Unit Testing.
3. Uso de Swagger.
4. Uso en Docker.

           

