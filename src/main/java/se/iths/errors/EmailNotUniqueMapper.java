package se.iths.errors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmailNotUniqueMapper implements ExceptionMapper<EmailNotUniqueException> {
    @Override
    public Response toResponse(EmailNotUniqueException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
