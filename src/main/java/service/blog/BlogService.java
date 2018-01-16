package service.blog;

import model.blog.Blog;

import java.util.List;


public interface BlogService {
    List getAll();
    Blog find(int id);
    boolean update(Blog blog);
}

