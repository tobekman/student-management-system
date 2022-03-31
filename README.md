# student-management-system

**_Endpoints_**

**Create student** - 
POST request:
http://localhost:8080/student-management-system/api/v1/students

_JSON body:_

{

    "firstName": "firstName",
    "lastName": "lastName",
    "email": "email",
    "phoneNumber": "phoneNumber"
}
- _phoneNumber is optional_


**Get all students** - 
GET request:
http://localhost:8080/student-management-system/api/v1/students


**Find student by ID** - 
GET request:
http://localhost:8080/student-management-system/api/v1/students/{ID}

- _Replace {ID} with the correct ID_


**Delete student** - 
DELETE request:
http://localhost:8080/student-management-system/api/v1/students/{ID}

- _Replace {ID} with the correct ID_


**Update student** - 
PUT request:
http://localhost:8080/student-management-system/api/v1/students

_JSON body:_

{

    "id": id,
    "email": "email",
    "firstName": "firstName",
    "lastName": "lastName",
    "phoneNumber": "phoneNumber"
}

- _All fields are required_


**Find students by last name** - 
GET request:
http://localhost:8080/student-management-system/api/v1/students/name?lastname={LASTNAME}

- _Replace {LASTNAME} with your search query_
