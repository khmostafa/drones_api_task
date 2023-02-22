
# Drone Control System

An API interface for control and manage medical drones navigation, loading with medical items and delevaring for critical cases which has logistic defeculties.

## Acknowledgements

 - [Get All Registered Drones](http:localhost:8080/api/drones/all)
 - [Get All Registered Medical Items](http:localhost:8080/api/medicals/all)
 


## API Reference

### Get All Drones

```http
GET /api/drones/all
```
Request body: None

Return: JSON Array

| Serial No | Model     | Carried Load | Battery Charge|     State      |
| :-------- | :------- | :------------|:------------| :-------------
| `api_key` | `Enum` | `Double`| `Percentage`| `Enum` |


### Add a Drone

```http
POST /api/drones/add
```
Request body: JSON

```http
{
 "serialNo": String (Not exceed 100 character),
 "model": Enum("", "", "", "",""),
 "batteryCharging": double -> percentage (0 to 100)
}
```
Return: JSON Object

| Serial No | Model     | Carried Load | Battery Charge|     State      |
| :-------- | :------- | :------------|:------------| :-------------
| `api_key` | `Enum` | `Double`| `Percentage`| `Enum` |

### Get a Drone

```http
Get /api/drones/get
```
Request body: JSON
```http
{
"serialNo": String (Not exceed 100 character)
}
```
Return: JSON Object

| Serial No | Model     | Carried Load | Battery Charge|     State      |
| :-------- | :------- | :------------|:------------| :-------------
| `api_key` | `Enum` | `Double`| `Percentage`| `Enum` |


### Delete a Drone

```http
Delete /api/drones/delete
```
Request body: JSON
```http
{
"serialNo": String (Not exceed 100 character)
}
```
Return: JSON Object
```http
{ "Delete Success" }
```
### Get All Available Drones

```http
Get /api/drones/All-available
```
Request body: None

Return: JSON Array

| Serial No | Model     | Carried Load | Battery Charge|     State      |
| :-------- | :------- | :------------|:------------| :-------------
| `api_key` | `Enum` | `Double`| `Percentage`| `Enum` |


### Assign Medics to a Drone

```http
POST /api/drones/upload-medics
```
Request body: JSON
```http
{
"serialNo": String (Not exceed 100 character)
"medics":["", "", ""]
}
```

Return: JSON Object, Or Null

| Serial No | Model     | Carried Load | Battery Charge|     State      |
| :-------- | :------- | :------------|:------------| :-------------|
| `api_key` | `Enum` | `Double`| `Percentage`| `Enum` |

### Get Medics for a Drone

```http
Get /api/drones/check-load
```
Request body: JSON
```http
{
"serialNo": String (Not exceed 100 character)
}
```

Return: JSON ARRAY

| Name | Weight     | Code | Image|
| :-------- | :------- | :------------|:------------|
| `api_key` | `Double` | `String`| `String`|

### Get Battery Charging for a Drone

```http
Get /api/drones/check-battery
```
Request body: JSON
```http
{
"serialNo": String (Not exceed 100 character)
}
```

Return: Double
{"50.0"}

### Add a Medical Item

```http
POST /api/medicals/add
```
Request body: JSON

```http
{
 "name": string,
 "weight": double,
 "code": String,
 "image": String
}
```
Return: JSON Object

```http
{
 "name": string,
 "weight": double,
 "code": String,
 "image": String
}
```

### Delete a Medical Item

```http
Delete /api/medicals/delete
```
Request body: JSON

```http
{
 "name": string,
}
```
Return: JSON Object

```http
{"Delete Success"}
```

### Get a Medical Item

```http
GET /api/medicals/get
```
Request body: JSON

```http
{
 "name": string,
}
```
Return: JSON Object

```http
{
 "name": string,
 "weight": double,
 "code": String,
 "image": String
}
```

### Get all Medical Items

```http
GET /api/medicals/get
```
Request body: None

Return: JSON Arraye

```http
[
    {
    "name": string,
    "weight": double,
    "code": String,
    "image": String
    }
]
```


## Authors

- [@KhaledMostafa](https://www.github.com/octokatherine)
    
## Deployment

To deploy this project run this cmd in the applicatin path.

```bash
  mvn spring-boot:start
```


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`JAVA_HOME`

`Java_PATH`

`MAVEN_PATH`


## Running Tests

To run tests, run the following command, in the application path

```bash
  mvn test
```


## Related

Here are some related projects

[Awesome README](https://github.com/matiassingers/awesome-readme)

