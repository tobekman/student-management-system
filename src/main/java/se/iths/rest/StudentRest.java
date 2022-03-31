package se.iths.rest;

import se.iths.entity.Student;
import se.iths.errors.EmailNotUniqueException;
import se.iths.errors.MissingInformationException;
import se.iths.errors.StudentNotFoundException;
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
            throw new MissingInformationException("You need to provide first name, last name and email.");
        }

        List<Student> existingStudent = studentService.getStudentWithEmail(student.getEmail());
        if(existingStudent.isEmpty()) {
            studentService.createStudent(student);
            return Response.status(Response.Status.CREATED).entity(student).build();
        } else {
            throw new EmailNotUniqueException("Email address already exists in database.");
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
            throw new StudentNotFoundException(id);
        }
        return Response.ok(student).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student student = studentService.getStudentWithId(id);
        if(student == null) {
            throw new StudentNotFoundException(id);
        }
        studentService.deleteStudent(id);
        return Response.ok("Student deleted.").build();
    }

    @PUT
    public Response updateStudent(Student student) {
        Student foundStudent = studentService.getStudentWithId(student.getId());
        if(foundStudent == null) {
            throw new StudentNotFoundException(student.getId());
        }
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
            throw new StudentNotFoundException(lastName);
        }
        return Response.ok(students).build();
    }


}
