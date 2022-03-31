package se.iths.errors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingInformationMapper implements ExceptionMapper<MissingInformationException> {
    @Override
    public Response toResponse(MissingInformationException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
