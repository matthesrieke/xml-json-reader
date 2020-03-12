# Data Format Reader App

Simple app to read measurements from files in different data formats.

### Description
In this part, both the application (reading files from the hard drive) and the
database functionality are being deployed in one docker compose.
The docker compose has 2 services. The web app and the MySQL database.

### Approach
The database is run as a service in the docker compose file. The application is run from the dockerfile.

### Note
The application ultimately runs and the database is eventually initialized. It takes docker-compose up 2 or 3 iterations for the application to be able to connect to the database.
The Rest endpoints are returning the data available in the files, the database is initialized and the CRUD operations work fine.
There is no need to start the application in intellj at this stage anymore.
To start the application use docker-compose up
