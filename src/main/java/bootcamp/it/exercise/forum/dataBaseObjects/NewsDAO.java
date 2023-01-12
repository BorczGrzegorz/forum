package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.interfaces.INewsDAO;
import bootcamp.it.exercise.forum.model.News;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsDAO implements INewsDAO {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public Optional<List<News>> getNews() {
        return Optional.of(newsList);
    }

    @Override
    public void addNews(News news) {
        newsList.add(news);
    }


}
