package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.model.User;

import java.util.Optional;

public interface IUserDao {

    Optional<User> findUserByLogin(String login);
   void saveUser(User user) throws UserLoginExistException;
   String getThatLoginExists();
   void setThatLoginExists(String thatLoginExists);

}
