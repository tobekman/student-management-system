package se.iths.errors;



import se.iths.util.ResponseMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TeacherNotFoundMapper implements ExceptionMapper<TeacherNotFoundException> {
    @Override
    public Response toResponse(TeacherNotFoundException e) {
        ResponseMessage errorMessage = new ResponseMessage(Response.Status.NOT_FOUND, e.getMessage());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
