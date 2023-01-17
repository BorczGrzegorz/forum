package bootcamp.it.exercise.forum.services;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidationService {
    public void validateUser(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }


    public static void validateLogin(String login) {
        String regex = "^[a-zA-Z0-9]{5,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(login);
        if (!matcher.matches()) {
            throw new UserValidationException();

        }
    }

    public static void validatePassword(String password) {
        String regex = "^[a-zA-Z0-9]{5,}$";
        if (!password.matches(regex)) {
            throw new UserValidationException();
        }
    }
}

