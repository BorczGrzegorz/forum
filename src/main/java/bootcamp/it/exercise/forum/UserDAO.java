package bootcamp.it.exercise.forum;

import bootcamp.it.exercise.forum.interfaces.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class UserDAO implements IUserDao {
        private static final List<User> users = new ArrayList<>();
        UserDAO(){

        }


        @Override
        public void saveUser(User user) {
            users.add(user);
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
}
