package bootcamp.it.exercise.forum;

import bootcamp.it.exercise.forum.interfaces.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class UserDAO implements IUserDao {
        private final List<User> users = new ArrayList<>();

        @Override
        public void saveUser(User user) {
            users.add(user);
        }

        @Override
        public boolean findUserByLogin(String login) {
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    return true;
                }
            }
            return false;
        }
}
