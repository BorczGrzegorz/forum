package bootcamp.it.exercise.forum.services;

import bootcamp.it.exercise.forum.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostDAOService {
    List<Post> getPosts();
    void savePost(Post post);
    void editPost(Post post, int oldID);

    Optional<Post> getPostById(int id);
}
