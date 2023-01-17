package bootcamp.it.exercise.forum.services;

public class UserValidationException extends RuntimeException {

    @Override
    public String getMessage() {
       return "****  Niepomyśłnie zvalidowano usera  ****";
    }
}
