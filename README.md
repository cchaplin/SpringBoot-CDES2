# Online Travel Management System (CDE S2 Certification)

**OTMS** is a cloud native web application developed using Spring Boot and Micro Services Architecture. A leading travel company maintains the online application “Online Travel Management System”.
This system manages the below functionalities:-

- Customers should be able to login, book, cancel and track the ride
- Employee should be able to login, register the vehicle, confirm the ride and view the summary of the trip details
- Admin – Manage the application

The module ‘Summary of Trip Details’ is implemented using Spring Boot by considering all the parameters which is mentioned in the Evaluation Rubrics (1.0)

- Admin should be able to view trip detail of all the employees. 
- Employee will view only his/her trip details.


## Micro Services Architecture

OTMS has been designed as a cloud native application based on Micro Services Architecture using Domain Driven Design (DDD).

- The MSA architecture diagram can be found [here](otms/otms_msa.jpg).
- The design diagram for "Trip Details" microservice can be found [here](otms/trip_details_design.jpg).

## Prerequisites

- A Linux virtual machine (preferably CentOS7) with proxy-less connection to Internet
- MySQL server and client installed. MySQL server service running successfully.
- JDK 11, Apache Maven 3.6.0, Web Browser installed in the VM.

## Build and Run the Eureka Service Registry

Clone the Git repository

```
$ git clone https://code.cognizant.com/681222/681222_CDES2_Project_16082019.git $HOME/
$ cd $HOME/681222_CDES2_Project_16082019/eureka-service
```

Build the project to generate the jar file

```
$ mvn clean && ./mvnw clean package
```

Above command will generate the jar file in location: $HOME/681222_CDES2_Project_16082019/eureka-service/target/eureka-0.0.1-SNAPSHOT.jar

Run the Eureka service registry using the following command:

```
java -Dserver.port=8761 -jar $HOME/681222_CDES2_Project_16082019/eureka-service/target/eureka-0.0.1-SNAPSHOT.jar
```

## Build OTMS

Clone the Git repository

```
$ git clone https://code.cognizant.com/681222/681222_CDES2_Project_16082019.git $HOME/
$ cd $HOME/681222_CDES2_Project_16082019/otms
```

Build the project to generate the jar file

```
$ mvn clean && ./mvnw clean package
```
Above command will generate the jar file in location: $HOME/681222_CDES2_Project_16082019/otms/target/otms-0.0.1-SNAPSHOT.jar

## Run OTMS

Log into MySQL server as root. Create a MySQL database named "db_otms". Create a user called "springuser" and note down the password. Also grant all priveleges to "springuser" only for database "db_otms".

```
$ mysql -u root -p <root password>
mysql> create database db_otms;
mysql> create user 'springuser'@'%' identified by 'springPswd0-';
mysql> grant all on db_otms.* to 'springuser'@'%';
mysql> exit
```

OTMS uses Spring JPA to automatically initialize the database when the application is started. This initialization is driven by schema.sql and data.sql files included in the application. No manual action is required. Now, it's time to run the application. This will start the application on port 8443.

```
java -jar $HOME/681222_CDES2_Project_16082019/otms/target/otms-0.0.1-SNAPSHOT.jar
```

If you need to start the application on a different port (i.e. 8081), setup the configuration in environment variable SPRING_APPLICATION_JSON and then start the application

```
SPRING_APPLICATION_JSON='{"server":{"port":"8081"}}' java -jar $HOME/681222_CDES2_Project_16082019/otms/target/otms-0.0.1-SNAPSHOT.jar
```

## 12 Factor App

OTMS has been developed as a cloud native application following the principles of [12 Factor App](https://12factor.net/). The following 5 factors have been implemented:-

- **One codebase tracked in revision control, many deploys:** OTMS has a single code base hosted in Gitlab i.e. code.cognizant.com. The application can be build and deployed to different environment from this single code base.
- **Explicitly declare and isolate dependencies:** OTMS is a Spring Boot Application using Maven for dependencies Management. All dependencies are explicitly declared and isolated in pom.xml. Maven handles the resolution and versioning of dependencies. This way, the application can be easily built and run with different/additional dependencies as per the need.
- **Store config in the environment:** Initial configuration is stored in application.properties so that the application is capable of running with zero configuration. If the configuration needs to be altered to fit the application in a different environment, there is no need to rebuild the application with a different applicattion.properties. This can be easily accomplished by defining a JSON with the new configuration and adding it to the environment variable SPRING_APPLICATION_JSON. For instance if the application needs to be run on a different port 8081, the following command should be used:
SPRING_APPLICATION_JSON='{"server":{"port":"8081"}}' java -jar $HOME/681222_CDES2_Project_16082019/otms/target/otms-0.0.1-SNAPSHOT.jar
- **Strictly separate build and run stages:** OTMS supports externalized configuration. So the application can be built separately, combined with a deploy configuration that suits the environment and finally run the release in the target environment.
- **Export services via port binding:** Since OTMS has been developed as a Spring boot application, it uses an embedded web server (Apache Tomcat) to serve the application. The "Trip Details" service is implemented as RESTful microservice that exposes endpoints at a particular port and path and responds with JSON. This way other Applications and services can consume the "Trip Details" service.

## Coding Standard Report

Find below coding analysis report from static code analyser tool PMD.

```
$ pmd -d ./src -R rulesets/java/quickstart.xml -f text
Aug 23, 2019 8:32:36 AM net.sourceforge.pmd.PMD processFiles
WARNING: This analysis could be faster, please consider using Incremental Analysis: https://pmd.github.io/pmd-6.17.0/pmd_userdocs_incremental_analysis.html
/home/senthilraja_gcp/otms/src/main/java/com/s2/otms/OtmsApplication.java:7:All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
$ 
```

## Security Vulnerability Report

Sonarqube Security Vulnerability analysis is successfully run for this project, with zero security vulnerabilities. Please see the report [here](otms/SonarqubeReport.jpg)

## Performance test Report

OTMS application "/trip.html" endpoint was subjected to load testing using Apache Bench tool (ab). Please see the report [here](otms/load_test_report.md)

## Code Profiling Report

Java code profiling is run for this project using VisualVM tool. Please see the report [here](otms/VisualVM_Report.docx)



