package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    StudentService studentService;

    @Inject
    public StudentRest(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    public Response createStudent(Student student) {

        if(student.informationIsMissing()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("You need to provide first name, last name and email.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }

        List<Student> existingStudent = studentService.getStudentWithEmail(student.getEmail());
        if(existingStudent.isEmpty()) {
            studentService.createStudent(student);
            return Response.status(Response.Status.CREATED).entity(student).build();
        } else {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Email address already exists in database.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }

    }

    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentWithId(@PathParam("id") Long id) {
        Student student = studentService.getStudentWithId(id);
        if(student == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("The student with ID " + id + " wasn't found in the database.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }
        return Response.ok(student).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student student = studentService.getStudentWithId(id);
        if(student == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("The student with ID " + id + " wasn't found in the database.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }
        studentService.deleteStudent(id);
        return Response.ok("Student deleted.").build();
    }

    @PUT
    public Response updateStudent(Student student) {
        if(student.informationIsMissing() || student.phoneNumberIsMissing()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("All fields needed to update.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }

        studentService.updateStudent(student);
        return Response.ok("Student updated").build();
    }

    @Path("name")
    @GET
    public Response getStudentWithLastName(@QueryParam("lastname") String lastName) {
        List<Student> students = studentService.getStudentWithLastName(lastName);
        if(students.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students with the last name " + lastName + " was found in the database.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }
        return Response.ok(students).build();
    }

    @Path("email")
    @GET
    public Response getStudentWithEmail(@QueryParam("email") String email) {
        List<Student> student = studentService.getStudentWithEmail(email);
        if(student.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("The student with email " + email + " wasn't found in the database.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }
        return Response.ok(student).build();
    }


}
