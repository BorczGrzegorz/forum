package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.interfaces.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostDAO implements IPostDAO {

    private final List<Post> newsList = new ArrayList<>();

    @Override
    public Optional<List<Post>> getPosts() {
        return Optional.of(newsList);
    }

    @Override
    public void addPost(Post news) {
        newsList.add(news);
    }


}
