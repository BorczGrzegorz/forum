package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostDAO {
     List<Post> getPosts();

    void addPost(Post post);
    void editPost(Post post);
}
