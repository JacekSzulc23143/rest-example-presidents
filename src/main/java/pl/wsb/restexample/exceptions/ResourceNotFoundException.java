package pl.wsb.restexample.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Nie znaleziono zasobu!");
    }
}
