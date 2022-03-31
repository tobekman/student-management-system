# student-management-system

Endpoints

Create student - 
POST request:
http://localhost:8080/student-management-system/api/v1/students

JSON body:

{

    "firstName": "firstName",
    "lastName": "lastName",
    "email": "email",
    "phoneNumber": "phoneNumber"
}
- phoneNumber is optional


Get all students - 
GET request:
http://localhost:8080/student-management-system/api/v1/students


Find student by ID - 
GET request:
http://localhost:8080/student-management-system/api/v1/students/{ID}

- Replace {ID} with the correct ID


Delete student - 
DELETE request:
http://localhost:8080/student-management-system/api/v1/students/{ID}

- Replace {ID} with the correct ID


Update student - 
PUT request:
http://localhost:8080/student-management-system/api/v1/students

JSON body:
{

    "id": id,
    "email": "email",
    "firstName": "firstName",
    "lastName": "lastName",
    "phoneNumber": "phoneNumber"
}

- All fields are required


Find students by last name - 
GET request:
http://localhost:8080/student-management-system/api/v1/students/name?lastname={LASTNAME}

- Replace {LASTNAME} with your search query
