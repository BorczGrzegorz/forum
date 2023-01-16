package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.interfaces.IUserDao;
import bootcamp.it.exercise.forum.interfaces.IUserIdSequence;
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
    IUserIdSequence userIdSequence;

        private static final List<User> users = new ArrayList<>();
        UserDAO(){
            users.add(new User(1,"Michał","Kruczała","admin","21232f297a57a5a743894a0e4a801fc3", User.Role.ADMIN));
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
        if(findUserByLogin(user.getLogin()).isPresent()) {
            throw new UserLoginExistException();
        }
        user.setId(this.userIdSequence.getId());
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        users.add(user);
    }

}
