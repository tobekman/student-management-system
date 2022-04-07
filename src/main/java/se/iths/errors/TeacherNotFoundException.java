package se.iths.errors;

import javax.ws.rs.WebApplicationException;

public class TeacherNotFoundException extends WebApplicationException {
    public TeacherNotFoundException(Long id) {
        super("The Teacher with ID " + id + " wasn't found in the database.");
    }
}
