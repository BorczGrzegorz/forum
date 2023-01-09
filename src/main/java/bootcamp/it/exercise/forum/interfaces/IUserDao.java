package bootcamp.it.exercise.forum.interfaces;

import bootcamp.it.exercise.forum.model.User;

public interface IUserDao {
    void saveUser(User user);
    boolean findUserByLogin(String login);

}
