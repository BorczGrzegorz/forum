package bootcamp.it.exercise.forum.services;

import bootcamp.it.exercise.forum.model.User;

import java.util.Optional;

public interface IUserDAOService {
    Optional<User> findUserByLogin(String login);

    void saveUser(User user);

    void makeUserToModerator(User user);

    void makeUserToAdmin(User user);

    String getThatLoginExists();

    void setThatLoginExists(String thatLoginExists);
}
