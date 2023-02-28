# Distance Calculator
Web service (REST) application for distance calculation.

## 1. Technologies
1. SpringBoot + Tomcat
2. Java 17
3. MySQL 
4. Liquibase
5. Hibernate
6. JAXB

## 2. Database
1. City 
   * Name 
   * Latitude 
   * Longitude
2. Distance 
   * From_city 
   * To city 
   * Distance
   
Database name `distance-calculator` login: `root` password: `root`

## 3. Functionality
1. Display cities list
2. Calculate the distance in two ways
   * "CrowFlight" straight distance between cities
   * Display the distance via "distance matrix" (distance table in database)
3. Upload XML file with cities and distances and stores it into database.


## 4. Endpoints
API has 3 endpoints


1. `GET /city` - display all cities in database

   **Response**

   JSON array of cities id and names:

   `[{ "id": Int, "name": String}, {...}]`

   **Response example**

   `[{"id":1,"name":"Samara"},{"id":2,"name":"Penza"},{"id":3,"name":"Kazan"},{"id":4,"name":"Togliatti"}]`
   
   

2. `POST /distance` - display distance between two cities

   **Request body**
   ```
   {
   "calculation_type": String,
   "from_city_list": [ "name": String, ...],
   "to_city_list": [ "name": String, ...]
   }
   ```
   There are three options of `calculation_type` parameter in request body: `CROW_FLIGHT`, `DISTANCE_MATRIX`, `ALL`
   
      
   **Response**
   ```
   [
    {
        "city_from": String,
        "city_to": "String,
        "distance_crow_fright": double,
        "distance_matrix": double
    },
    {
    ...
    }
   ]
   ```
   
   **Request example**
   ```
   {
   "calculation_type": "ALL",
   "from_city_list": ["Samara", "Penza", "Kazan"],
   "to_city_list": ["Penza","Kazan","Samara"]
   }
   ```
   
   **Response example**
   ```
   [
    {
        "city_from": "Samara",
        "city_to": "Penza",
        "distance_crow_fright": 347.2538284031449,
        "distance_matrix": 348.0
    },
    {...}
   ]
   ```
   

3. `POST /upload` - upload cities and distances from *.xml file to database

    **Request** 
    
    file.xml (example is in the data folder)
    
    **Response**
    
    Http response 200 without body
