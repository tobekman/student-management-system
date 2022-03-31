package se.iths.errors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class StudentNotFoundMapper implements ExceptionMapper<StudentNotFoundException> {
    @Override
    public Response toResponse(StudentNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
