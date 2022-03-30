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

    @Path("")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentWithId(@PathParam("id") Long id) {
        Student student = studentService.getStudentWithId(id);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok().build();
    }


}
