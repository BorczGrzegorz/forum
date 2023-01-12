package bootcamp.it.exercise.forum.interfaces;

import bootcamp.it.exercise.forum.model.News;

import java.util.List;
import java.util.Optional;

public interface INewsDAO {
    Optional<List<News>> getNews();

    void addNews(News news);
}
