package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostDAO {
     List<Post> getPosts();

    void savePost(Post post);
    void editPost(Post post);
    Optional<Post> getPostById(int id);


}
