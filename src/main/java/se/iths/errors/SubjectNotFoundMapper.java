package se.iths.errors;

import se.iths.util.ResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SubjectNotFoundMapper implements ExceptionMapper<SubjectNotFoundException> {
    @Override
    public Response toResponse(SubjectNotFoundException e) {
        ResponseMessage errorMessage = new ResponseMessage(Response.Status.NOT_FOUND, e.getMessage());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
