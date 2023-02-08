package bootcamp.it.exercise.forum.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("bootcamp.it.exercise.forum")
public class AppConfiguration {
    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure("/hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }}