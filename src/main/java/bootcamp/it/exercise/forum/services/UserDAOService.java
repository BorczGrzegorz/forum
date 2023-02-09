package bootcamp.it.exercise.forum.services;
import bootcamp.it.exercise.forum.dataBaseObjects.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDAOService implements IUserDAOService {
    @Autowired
    IUserDao userDao;

    @Override
    public Optional<User> findUserByLogin(String login) {
        return this.userDao.findUserByLogin(login);
    }

    @Override
    public void saveUser(User user) {
        this.userDao.saveUser(user);
    }

    @Override
    public void makeUserToModerator(User user) {
        this.userDao.makeUserToModerator(user);
    }

    @Override
    public void makeUserToAdmin(User user) {
        this.userDao.makeUserToAdmin(user);
    }

    @Override
    public String getThatLoginExists() {
        return this.userDao.getThatLoginExists();
    }

    @Override
    public void setThatLoginExists(String thatLoginExists) {
        this.userDao.setThatLoginExists(thatLoginExists);

    }
}
