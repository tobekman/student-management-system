package se.iths.errors;

import javax.ws.rs.WebApplicationException;

public class SubjectNotFoundException extends WebApplicationException {
    public SubjectNotFoundException(Long id) {
        super("The Subject with ID " + id + " wasn't found in the database.");
    }
}
