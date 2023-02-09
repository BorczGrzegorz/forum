package bootcamp.it.exercise.forum.dataBaseObjects;


import bootcamp.it.exercise.forum.model.Post;
import bootcamp.it.exercise.forum.model.Saveable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class EntityManager {
    public final SessionFactory sessionFactory;

    protected EntityManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void persist(Saveable o) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Saveable o) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(o);
        session.getTransaction().commit();
        session.close();
    }
}
