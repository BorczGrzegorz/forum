package bootcamp.it.exercise.forum.services;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.model.User;

public interface IAuthenticatorService {
    void authenticate(String login, String password);
    void logout();
    void registerUser(User user) throws UserLoginExistException;
}
