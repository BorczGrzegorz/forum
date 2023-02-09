package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.model.Saveable;
import bootcamp.it.exercise.forum.sequence.IIdSequence;
import bootcamp.it.exercise.forum.model.User;
import jakarta.persistence.NoResultException;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO extends EntityManager implements IUserDao {
    @Override
    public String getThatLoginExists() {
        return thatLoginExists;
    }
    @Override
    public void setThatLoginExists(String thatLoginExists) {
        UserDAO.thatLoginExists = thatLoginExists;}
    private static String thatLoginExists = "";

    public UserDAO(@Autowired SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery(
                "FROM bootcamp.it.exercise.forum.model.User WHERE login =:login", User.class);
        query.setParameter("login", login);
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public void saveUser(User user){
      //  if (findUserByLogin(user.getLogin()).isPresent()) {
       //     throw new UserLoginExistException();
      //  }
        super.persist(user);
    }


  // tych narazie nie używam
    @Override
    public void makeUserToModerator(User user) {
        user.setRole(User.Role.MODERATOR);
    }
    @Override
    public void makeUserToAdmin(User user) {
        user.setRole(User.Role.ADMIN);
    }
}
