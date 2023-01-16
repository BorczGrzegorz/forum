package bootcamp.it.exercise.forum.services;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
    public void validateUser(String login, String password) throws UserValidationException {
        validateLogin(login);
        validatePassword(password);
    }


    private void validateLogin(String login) throws UserValidationException {
        String regex = "^[a-zA-Z0-9]{5,}&$";
        if (login.matches(regex)) {
            throw new UserValidationException();
        }
    }

    private void validatePassword(String password) throws UserValidationException {
        String regex = "^[a-zA-Z0-9]{5,}&$";
        if (password.matches(regex)) {
            throw new UserValidationException();

        }

    }
}
