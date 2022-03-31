package se.iths.errors;

import javax.ws.rs.WebApplicationException;

public class EmailNotUniqueException extends WebApplicationException {
    public EmailNotUniqueException(String message) {
        super(message);
    }
}
