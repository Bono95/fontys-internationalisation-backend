package repository.blog;

import model.blog.Blog;
import model.blog.BlogDate;

import java.util.List;

public interface BlogRepository {

    List getAll();

    Blog find(int id);

    BlogDate getDate();
}
