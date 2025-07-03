# Database Manager Java Application Report #
## 1. Introduction ##

Database Manager is an Java Application for a database management system that aims to control and manage a database for any given database (Oracle, MySQL, SQLite ... etc.). 
Database Manager provides a connection environment between database and the user and it makes the interaction between them easy, we will review some of the features that we use to build our system. 

## 2. Database Manager Features ##
### 2.1. Connection Profile ###
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/1.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/2.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/3.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/4.png?raw=true)

In this feature, the user can choose between two options, either create a connection or choice to connect to a previously database from a List of databases.

### 2.2. Managing the database tables ###
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/14.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/6.png?raw=true)
In this feature, the user can be able to access all tables and he/she can modify the tables. This feature also includes capability to change the database connection at runtime, however, the database should be supported by the Application.

### 2.3. Import data to the database ###

In this feature, the user can be able to upload a file which contains data. 
The application accepts three types of files:

1. CSV file
2. JSON file
3. SQL file

The user should send the table name to the file analyzer, the results of file analysis:

1. Adding the data to the database
2. A SQL file that contains all queries (create and insert queries)
3. Both the uploaded and SQL files should be stored in the local storage.

### 2.4. Export the database tables and data ###
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/7.png?raw=true)
In this feature, the user can be able to export files containing data, schema, or both in CSV format. This feature includes exporting the locale files which are the uploaded and SQL files.

### 2.5. Version control ###

The application runs with one branch/point/snapshot. The user shall be able to create a point/snapshot for the database at any moment. The user shall be able to revert to any point/snapshot he/she wants.
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/9.png?raw=true)
1. The user shall be able to create a point/snapshot for the database at any moment.
2. The user shall be able to revert to any point/snapshot he/she wants.

### 2.6. User authentication and authorization ###
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/15.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/16.png?raw=true)
All users should authenticate themself before accessing Application, each user should be able to access to the database manager based on their permissions:
1. Admin: Full permission
2. Staff: Read/Write but can’t delete tables.
3. Reader: Read only.

## 3. Using Design Patterns ##
### 3.1 Factory Method ###
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/5.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/8.png?raw=true)

The application uses a Factory method which deal with the problem of creating objects without having to specify the exact class of the object that will be created, factory method used to deal with Managing Database objects (ReadSchema, InsertData, ReadTable, DeleteTable, DeleteData, ExportData).
And anthor factory methods uesd in Version Control

## 4. Logger ## 
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/10.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/11.png?raw=true)
The application use a logger to record every action that happens in the application.

## 5. Exception handling ## 
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/12.png?raw=true)
![alt text](https://github.com/zaidmelhem/project_advance/blob/main/img/13.png?raw=true)
The code use exception handling properly, in the whole application.
and we create custom exception handling for connection 

## 6. Concrete architecture ##



![Concrete Architecture](https://user-images.githubusercontent.com/68341128/146270724-baa80f29-4123-4970-a9a6-69fa35e48f7b.jpg)







