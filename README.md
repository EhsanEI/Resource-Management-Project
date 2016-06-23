# Resource-Management-Project
### Database Setup
1- Download and install MS Sql Server 2014 Management Studio (it worked for me, but probably any version higher that 2008 will also work).

2- Make sure that you check both SQL Server Authentication and Windows Authentication and set username="sa" and password="Database123456" when installing it.

3- Create a database and name it "OOD".

4- Extract driver file (jtds-1.3.1-dist) somewhere in your pc (it is recommended to place it in C:\Program Files\Microsoft JDBC Driver for SQL Server\jtds-1.3.1-dist)

5- Run CreateOODDatabaseSchema from ormsamples package.

6- Initialize objects and their attributes in CreateOODData and then run it.
