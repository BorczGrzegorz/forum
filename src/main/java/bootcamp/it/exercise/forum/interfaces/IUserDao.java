package bootcamp.it.exercise.forum.interfaces;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.model.User;

import java.util.Optional;

public interface IUserDao {

    Optional<User> findUserByLogin(String login);
   void saveUser(User user) throws UserLoginExistException;

}
