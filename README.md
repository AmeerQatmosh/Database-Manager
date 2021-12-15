## Database Manager Java Application Report
## 1. Introduction

Database Manager is an Java Application for a database management system that aims to control and manage a database for any given database (Oracle, MySQL, SQLite ... etc.). 
Database Manager provides a connection environment between database and the user and it makes the interaction between them easy, we will review some of the features that we use to build our system. 

## 2. Database Manager Features
### 2.1 Connection Profile 

In this feature, the user can choose between two options, either create a connection or choice to connect to a previously database from a List of databases.

### 2.2 Managing the database tables

In this feature, the user should be able to access all tables and he/she can modify the tables. This feature also includes capability to change the database connection at runtime, however, the database should be supported by the Application.

### 2.3 Import data to the database

In this feature, the user should be able to upload a file which contains data. 

### 2.4 Export the database tables and data

In this feature, the user shall be able to export files containing data, schema, or both in CSV format. This feature includes exporting the locale files which are the uploaded and
SQL files.

### 2.5 User authentication and authorization 

All users should authenticate themself before accessing Application.

Each user should be able to access to the database manager based on their permissions:
a. Admin: Full permission
b. Staff: Read/Write but can’t delete tables.
c. Reader: Read only.
