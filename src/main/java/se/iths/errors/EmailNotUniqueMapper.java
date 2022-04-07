package se.iths.errors;

import se.iths.util.ResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmailNotUniqueMapper implements ExceptionMapper<EmailNotUniqueException> {
    @Override
    public Response toResponse(EmailNotUniqueException e) {
        ResponseMessage errorMessage = new ResponseMessage(Response.Status.BAD_REQUEST, e.getMessage());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .build();
    }
}
