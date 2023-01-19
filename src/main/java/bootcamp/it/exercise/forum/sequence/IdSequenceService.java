package bootcamp.it.exercise.forum.sequence;

import bootcamp.it.exercise.forum.sequence.IIdSequence;
import org.springframework.stereotype.Service;

@Service
public class IdSequenceService implements IIdSequence {
    int userId = 0;
    int postId = 0;

    @Override
    public int getUserId() {
        return userId++;
    }

    @Override
    public int getPostId() {
        return postId++;
    }
}
