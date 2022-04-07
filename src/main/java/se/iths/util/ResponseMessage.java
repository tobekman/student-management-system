package se.iths.util;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.core.Response;

@Getter
@Setter
public class ResponseMessage {

    private Response.Status httpStatus;
    private String message;

    public ResponseMessage(Response.Status httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
