package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.sequence.IIdSequence;
import bootcamp.it.exercise.forum.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDao {
    @Autowired
    IIdSequence userIdSequence;

    public  String getThatLoginExists() {
        return thatLoginExists;
    }

    @Override
    public void setThatLoginExists(String thatLoginExists) {
        UserDAO.thatLoginExists = thatLoginExists;
    }




    private static String thatLoginExists = "";
    private static final List<User> users = new ArrayList<>();

    UserDAO() {
        users.add(new User(1, "Michał", "Kruczała", "admin", "21232f297a57a5a743894a0e4a801fc3", User.Role.ADMIN));
        users.add(new User(2, "Joanna", "Kowalska", "minimum", "e383234c8c5c6cf7eb44a3208e26d50f", User.Role.MODERATOR));
        users.add(new User(2, "Natalia", "Krzystanek", "nati123", "e383234c8c5c6cf7eb44a3208e26d50f", User.Role.USER));
    }


    @Override
    public Optional<User> findUserByLogin(String login) {

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void saveUser(User user) throws UserLoginExistException {
        if (findUserByLogin(user.getLogin()).isPresent()) {
            throw new UserLoginExistException();
        }
        user.setId(this.userIdSequence.getUserId());
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        users.add(user);
    }
    @Override
    public void makeUserToModerator(User user) {
        user.setRole(User.Role.MODERATOR);

    }

    @Override
    public void makeUserToAdmin(User user) {
        user.setRole(User.Role.ADMIN);

    }

}
