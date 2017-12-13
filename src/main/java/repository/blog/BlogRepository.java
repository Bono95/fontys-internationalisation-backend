package repository.blog;

import model.blog.Blog;

import java.util.List;

public interface BlogRepository {

    List getAll();

    Blog find(int id);
}
