package se.iths.errors;

import javax.ws.rs.WebApplicationException;

public class StudentNotFoundException extends WebApplicationException {
    public StudentNotFoundException(Long id) {
        super("The student with ID " + id + " wasn't found in the database.");
    }
    public StudentNotFoundException(String name) {
        super("No students with the last name " + name + " was found in the database.");
    }

}
