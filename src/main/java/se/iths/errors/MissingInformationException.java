package se.iths.errors;

import javax.ws.rs.WebApplicationException;

public class MissingInformationException extends WebApplicationException {
    public MissingInformationException(String message) {
        super(message);
    }
}
