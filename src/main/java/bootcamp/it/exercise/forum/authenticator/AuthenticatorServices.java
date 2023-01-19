package bootcamp.it.exercise.forum.authenticator;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.authenticator.IAuthenticatorService;
import bootcamp.it.exercise.forum.dataBaseObjects.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticatorServices implements IAuthenticatorService {
    @Autowired
    IUserDao userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userDAO.findUserByLogin(login); //zrwaca mi optoinala od Usera
        if (userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) { //jeżeli optional nie jest pusty i i zgadzają sie hasła
            this.sessionObject.setUser(     //to ustawiamy typka w sesji
                    new User.BudowniczyJOLO()
                            .clone(userBox.get())    // tylko po co go klonować?
                            .password(null)     // nullujemy mu hasło w sesji by nie było go w sesji
                            .build()
            );
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }

    @Override
    public void registerUser(User user) throws UserLoginExistException {
        user.setRole(User.Role.USER);
        this.userDAO.saveUser(user);
    }


}
