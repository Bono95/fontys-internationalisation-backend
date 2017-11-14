package service.blog;

import model.blog.Blog;
import model.blog.BlogDate;

import java.util.List;


public interface BlogService {
    List getAll();
    Blog find(int id);
    BlogDate getDate();
}

