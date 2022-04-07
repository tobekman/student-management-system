package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.errors.MissingInformationException;
import se.iths.errors.StudentNotFoundException;
import se.iths.errors.SubjectNotFoundException;
import se.iths.errors.TeacherNotFoundException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Inject
    public SubjectRest(SubjectService subjectService, TeacherService teacherService, StudentService studentService) {
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @POST
    public Response createSubject(Subject subject) {
        if (subject.nameIsMissing()) {
            throw new MissingInformationException("You need to provide a name");
        }

        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @GET
    public Response getAllSubjects() {
        List<Subject> foundSubjects = subjectService.getAllSubjects();
        return Response.ok(foundSubjects).build();
    }

    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id") Long id) {
        Subject subject = subjectService.getSubjectById(id);
        if (subject == null) {
            throw new SubjectNotFoundException(id);
        }
        return Response.ok(subject).build();
    }

    @Path("{subjectId}/set-teacher/{teacherId}")
    @PUT
    public Response setTeacherToSubject(@PathParam("subjectId") Long subjectId, @PathParam("teacherId") Long teacherId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if (subject == null) {
            throw new SubjectNotFoundException(subjectId);
        }
        if (teacher == null) {
            throw new TeacherNotFoundException(teacherId);
        }

        subject.setTeacher(teacher);
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{subjectId}/add-student/{studentId}")
    @PUT
    public Response addStudentToSubject(@PathParam("subjectId") Long subjectId, @PathParam("studentId") Long studentId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);

        if (subject == null) {
            throw new SubjectNotFoundException(subjectId);
        }
        if (student == null) {
            throw new StudentNotFoundException(studentId);
        }

        subject.addStudent(student);
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{subjectId}/remove-student/{studentId}")
    @PUT
    public Response removeStudentFromSubject(@PathParam("subjectId") Long subjectId, @PathParam("studentId") Long studentId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);

        if (subject == null) {
            throw new SubjectNotFoundException(subjectId);
        }
        if (student == null) {
            throw new StudentNotFoundException(studentId);
        }

        subject.removeStudent(student);
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("/teacher/{id}")
    @GET
    public Response getSubjectByTeacherId(@PathParam("id") Long id) {
        List<Subject> subjects = subjectService.getSubjectByTeacherId(id);
        if (subjects.isEmpty()) {
            throw new TeacherNotFoundException(id);
        }
        return Response.ok(subjects).build();
    }


}
