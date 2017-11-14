package repository.blog;

import data.Database;
import model.blog.Blog;
import model.blog.BlogDate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateBlogRepository implements BlogRepository {

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Blog ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Blog find(int id) {
        Session session = Database.SESSION.openSession();

        Blog blog = session.find(Blog.class, id);

        session.close();

        return blog;
    }

    public BlogDate getDate() {
        Session session = Database.SESSION.openSession();

        BlogDate date = session.find(BlogDate.class, 1);

        session.close();

        return date;
    }
}
