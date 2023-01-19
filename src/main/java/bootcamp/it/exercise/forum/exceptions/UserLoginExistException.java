package bootcamp.it.exercise.forum.exceptions;

public class UserLoginExistException extends RuntimeException {
    @Override
    public String getMessage() {
        return "That login exists";
    }
}
