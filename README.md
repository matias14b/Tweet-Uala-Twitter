

# Servicio Tweet

El objetivo de este servicio es el de consultar Tweets en la Base de datos y el de ofrecer la habilidad de que un Usuario X pueda crear un Tweet

### DER Y UML
Para esto se ha modelado 1 tabla:

![image](https://github.com/matias14b/Tweet-Uala-Twitter/assets/127508318/a62c69b4-3e1e-4676-85d6-680b7e3e3e78)

### Dominio
La clase de dominio esta formada por la clase Tweet

![image](https://github.com/matias14b/Tweet-Uala-Twitter/assets/127508318/bd048052-1160-4ebe-a93e-b0fc09cde382)

### Diagrama de servicio

A nivel arquitectura se decidio por MVC 

![image](https://github.com/matias14b/Tweet-Uala-Twitter/assets/127508318/5f116f89-2e0d-4c48-b49e-723ca3eca209)


## API Reference

El servicio Tweet expone los siguientes servicios:

#### Crear Tweet

```http
  POST /api/{username}/tweet
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `String` | **Requerido**. El username del usuario que intenta realizar la accion |
| `tweet`    | `String` | **Requerido**. El mensaje que se quiere guardar. *(texto plano en el body de la peticion)*|

###### Respuesta
```yaml
{
    "id": 56,
    "mensaje": "Tweet de Namba",
    "usuarioCreadorId": 1,
    "fechaCreacion": "26/02/2024 03:22"
}
```

#### obtener Tweets por usuarioID

```http
  GET /api/1/tweets/?page={page}&size={size}&sort={sort}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idUsuario`      | `string` | **Requerido**. id del usuario del que necesitas los seguidores para consultar sus Tweets |
| `page`      | `int` | **Opcional**. numero de la pagina que quieres consultar|
| `size`      | `int` | **Opcional**. cantidad de tweets |
| `sort`      | `string` | **Opcional**. Criterio de ordenamiento, y el clave del objeto Tweet se tendra en cuenta para este ordenamiento (Ejemplo: fechaCreacion,ASC) |


###### Respuesta
```yaml
[
    {
        "id": 43,
        "mensaje": "Hola",
        "usuarioCreadorId": 2,
        "fechaCreacion": "25/02/2024 16:21"
    },
    {
        "id": 44,
        "mensaje": "Tweet de prueba",
        "usuarioCreadorId": 2,
        "fechaCreacion": "25/02/2024 16:21"
    }
]
```

## Running Tests

Para correr los test, usar el siguiente comando:

```bash
  mvn clean test
```




## Tech Stack


**Server:** Java 17, Spring 3.2.2, MySQL
