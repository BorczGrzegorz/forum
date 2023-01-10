package bootcamp.it.exercise.forum.services;

import bootcamp.it.exercise.forum.interfaces.IUserIdSequence;
import org.springframework.stereotype.Service;

@Service
public class UserIdSequenceService implements IUserIdSequence {
    int id = 0;
    @Override
    public int getId() {
       return ++id;
    }
}
