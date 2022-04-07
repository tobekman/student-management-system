package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.errors.EmailNotUniqueException;
import se.iths.errors.MissingInformationException;
import se.iths.errors.TeacherNotFoundException;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;
import se.iths.util.ResponseMessage;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    private final TeacherService teacherService;
    private final SubjectService subjectService;

    @Inject
    public TeacherRest(TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @POST
    public Response createTeacher(Teacher teacher) {
        if(teacher.informationIsMissing()) {
            throw new MissingInformationException("You need to provide first name, last name and email.");
        }
        List<Teacher> existingTeacher = teacherService.getTeacherByEmail(teacher.getEmail());
        if(existingTeacher.isEmpty()) {
            teacherService.createTeacher(teacher);
            return Response.status(Response.Status.CREATED).entity(teacher).build();
        } else {
            throw new EmailNotUniqueException("Email address already exists in database.");
        }
    }

    @GET
    public Response getAllTeachers() {
        List<Teacher> foundTeachers = teacherService.getAllTeachers();
        return Response.ok(foundTeachers).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacherById(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.getTeacherById(id);
        if(foundTeacher == null) {
            throw new TeacherNotFoundException(id);
        }
        return Response.ok(foundTeacher).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.getTeacherById(id);
        if(foundTeacher == null) {
            throw new TeacherNotFoundException(id);
        }
        List<Subject> subjects = subjectService.getSubjectByTeacherId(id);
        if(!subjects.isEmpty()) {
            for(Subject subject : subjects) {
                subject.setTeacher(null);
                subjectService.updateSubject(subject);
            }
        }
        teacherService.deleteTeacher(id);
        ResponseMessage responseMessage = new ResponseMessage(Response.Status.OK, "Teacher deleted");
        return Response.ok(responseMessage).build();
    }

    @PUT
    public Response updateTeacher(Teacher teacher) {
        Teacher foundTeacher = teacherService.getTeacherById(teacher.getId());
        if(foundTeacher == null) {
            throw new TeacherNotFoundException(teacher.getId());
        }
        if(teacher.informationIsMissing() || teacher.phoneNumberIsMissing()) {
            throw new MissingInformationException("All fields needed to update.");
        }
        teacherService.updateTeacher(teacher);
        return Response.ok(teacher).build();
    }
}
