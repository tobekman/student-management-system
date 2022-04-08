# student-management-system

## Labb 2

**_Endpoints_**

## - Subject -

###**_Create subject_**
POST request:
- http://localhost:8080/student-management-system/api/v1/subjects

_JSON body:_

{

    "name": "firstName",

}

###**_Get all subjects_**
GET request:
- http://localhost:8080/student-management-system/api/v1/subjects

###**_Find subject by ID_**
GET request:
- http://localhost:8080/student-management-system/api/v1/subjects/{ID}

- _Replace {ID} with the correct ID_

###**_Assign teacher to subject_**
PUT request:
- http://localhost:8080/student-management-system/api/v1/subjects/{SUBJECTID}/set-teacher/{TEACHERID}
- - _Replace {SUBJECTID} with the ID of the subject_
- - _Replace {TEACHERID} with the ID of the teacher_

###**_Add student to subject_**
PUT request:
- http://localhost:8080/student-management-system/api/v1/subjects/{SUBJECTID}/add-student/{STUDENTID}
- - _Replace {SUBJECTID} with the ID of the subject_
- - _Replace {STUDENTID} with the ID of the teacher_

###**_Remove student from subject_**
PUT request:
- http://localhost:8080/student-management-system/api/v1/subjects/{SUBJECTID}/remove-student/{STUDENTID}
- - _Replace {SUBJECTID} with the ID of the subject_
- - _Replace {STUDENTID} with the ID of the teacher_

###**_Get subject by teacher id_**
GET request:
- http://localhost:8080/student-management-system/api/v1/subjects/teacher/{TEACHERID}
- - _Replace {TEACHERID} with the ID of the teacher_

## - Teacher -

###**_Create teacher_**
POST request:
- http://localhost:8080/student-management-system/api/v1/teachers

_JSON body:_

{

    "firstName": "firstName",
    "lastName": "lastName",
    "email": "email",
    "phoneNumber": "phoneNumber"
}
- _phoneNumber is optional_
  
###**_Get all teachers_**  
GET request:
- http://localhost:8080/student-management-system/api/v1/teachers

###**_Find teacher by ID_**  
GET request:
- http://localhost:8080/student-management-system/api/v1/teachers/{ID}

- _Replace {ID} with the correct ID_

###**_Delete teacher_**
DELETE request:
- http://localhost:8080/student-management-system/api/v1/teachers/{ID}

- _Replace {ID} with the correct ID_

###**_Update teacher_**
PUT request:
- http://localhost:8080/student-management-system/api/v1/teachers

_JSON body:_

{

    "id": id,
    "email": "email",
    "firstName": "firstName",
    "lastName": "lastName",
    "phoneNumber": "phoneNumber"
}

- _All fields are required_

## - Student - 
####**Create student** 
POST request:
- http://localhost:8080/student-management-system/api/v1/students

_JSON body:_

{

    "firstName": "firstName",
    "lastName": "lastName",
    "email": "email",
    "phoneNumber": "phoneNumber"
}
- _phoneNumber is optional_


###**_Get all students_**  
GET request:
- http://localhost:8080/student-management-system/api/v1/students


###**_Find student by ID_**  
GET request:
- http://localhost:8080/student-management-system/api/v1/students/{ID}

- _Replace {ID} with the correct ID_


###**_Delete student_** 
DELETE request:
- http://localhost:8080/student-management-system/api/v1/students/{ID}

- _Replace {ID} with the correct ID_


###**_Update student_** 
PUT request:
- http://localhost:8080/student-management-system/api/v1/students

_JSON body:_

{

    "id": id,
    "email": "email",
    "firstName": "firstName",
    "lastName": "lastName",
    "phoneNumber": "phoneNumber"
}

- _All fields are required_


###**_Find students by last name_**  
GET request:
- http://localhost:8080/student-management-system/api/v1/students/name?lastname={LASTNAME}

- _Replace {LASTNAME} with your search query_
