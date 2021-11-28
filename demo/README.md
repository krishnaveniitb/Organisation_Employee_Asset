# Requirement

Create Spring Boot app with Spring security
Organization entity (parent), employee and asset are child entities (h2 database)
CRUD operation for org, employee, asset in xml form output (REST).
Project setup document, application build and deployment steps.

## Story Wall

Organization ( It can have many employee / asset )
Employee (It can have many asset, But It can have only one organization )
Asset (It can have one to one relationship with Organization and Employee)
e.g. laptop, printer, monitor

## Mapping tables

To trial

* -> Mapping table


ORGANIZATION_ID   | ORGANIZATION_NAME  |	ORGANIZATION_TYPE  
| -------------  | ------------------ | -----------------|
|      1         | `siemens`          | Product-company  |
|      2         | `Flatirons`        | Product-company  |
|      3         | `Google`           | Product-company  |


EMPLOYEE_ID      |EMPLOYEE_NAME  	|*EMPLOYEE_ORGANIZATION_ID*
| -------------  | ------------------ | -----------------|
|      4         | `Krishna`          |       1          |
|      5         | `Veni`             |       2          |
|      6         | `Krish`            |       1          |


ASSERT_ID        |	ASSERT_NAME  	  | *ASSET_ORGANIZATION_ID* | *ASSET_EMPLOYEE_ID* 
| -------------  | ------------------ | ----------------------| -----------------|
|      1         | `Laptop`           |       3               |         4        |
|      2         | `Monitor`          |       2               |         4        |
|      4         | `Headset`          |       1               |         6        |


These tables are used in the code and in the following examples too.

## Requirements

The project requires [Java 1.8] or higher.

The project makes use of Maven

## Useful Maven commands

mvn clean install -DskipTests

### Build the project

Compiles the project, runs the test and then creates an executable JAR file

Run the application using Java and the executable JAR file produced by the Maven `build`. The application will be
listening to port `8080`.


### Run the application

Run the application which will be listening on port `8080`.


## API

Below is a list of API endpoints with their respective input and output. 

### Store Organisation

Endpoint

```text
POST organization/add
```

Example of body

```json
{
  "employeeList":[
          {
          "employeeName": "Krish"
          },
          { 
          "employeeName": "Krishna"
          }
      ],
  "organizationType": "Siemens",
  "organizationName": "Product-based"
}
```

Parameters

| Parameter         | Description                                           |
| --------------    | ----------------------------------------------------- |
| `employeeList`    | list of employees                                     |
| `organizationName`| name of the Organisation                              |
| `organizationName`| type of Organisation                                  |

The above command return xml based output.
```xml
<object>
	<employeeList>
		<object>
			<employeeId>6</employeeId>
			<employeeName>Krishna</employeeName>
		</object>
		<object>
			<employeeId>7</employeeId>
			<employeeName>krish</employeeName>
		</object>
	</employeeList>
	<organizationId>8</organizationId>
	<organizationName>Product-based</organizationName>
	<organizationType>Siemens</organizationType>
</object>
```

### Get organisation by ID

Endpoint

```text
GET /organization/list/<id>
```

Parameters

| Parameter      | Description                              |
| -------------- | ---------------------------------------- |
| `id`           | One of the organisation' id listed above |


Example output

```xml
<object>
	<assetList>
	</assetList>
	<employeeList>
		<object>
			<assetList>
			</assetList>
			<employeeId>6</employeeId>
			<employeeName>Krishh</employeeName>
		</object>
		<object>
			<assetList>
			</assetList>
			<employeeId>7</employeeId>
			<employeeName>veni</employeeName>
		</object>
	</employeeList>
	<organizationId>8</organizationId>s
	<organizationName>Prod</organizationName>
	<organizationType>Siemens</organizationType>
</object>

```
