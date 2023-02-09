package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.model.Saveable;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.sequence.IIdSequence;
import bootcamp.it.exercise.forum.model.Post;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleBiFunction;

@Repository
public class PostDAO extends EntityManager implements IPostDAO {
    public PostDAO(@Autowired SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final List<Post> postList = new ArrayList<>();

    @Override
    public List<Post> getPosts() {
        Session session = this.sessionFactory.openSession();
        Query<Post> query = session.createQuery("FROM bootcamp.it.exercise.forum.model.Post", Post.class);
        List<Post> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void savePost(Post post) {
        super.persist(post);
    }

    @Override
    public void editPost(Post post) {
        super.update(post);

//        Session session = this.sessionFactory.openSession();
//        Query<Post> query = session.createQuery("FROM bootcamp.it.exercise.forum.model.Post WHERE id = :id", Post.class);
//        query.setParameter("id", oldId);
//        Optional<Post> editedPost = Optional.empty();
//        try {
//            editedPost = Optional.of(query.getSingleResult());
//        }catch (NoResultException ignored){}



//        Optional<Post> postById = getPostById(oldId);
//        if (postById.isPresent()) {
//            post.setId(post.getId());
//            post.setHeader(post.getHeader());
//            post.setContent(post.getContent());
//            post.setAuthor(post.getAuthor());
//            postList.set(post.getId(), post);
//            postList.remove(postById.get());
//        }
    }

    @Override
    public Optional<Post> getPostById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Post> query = session.createQuery("FROM bootcamp.it.exercise.forum.model.Post WHERE id = :id", Post.class);
        query.setParameter("id", id);
        Optional<Post> lookedPost = Optional.empty();
        try {
            lookedPost = Optional.of(query.getSingleResult());
        } catch (NoResultException ignored) {
        }
        session.close();
        return lookedPost;
    }
}

