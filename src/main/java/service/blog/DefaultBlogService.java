package service.blog;

import model.blog.Blog;
import repository.blog.BlogRepository;

import java.util.List;

public class DefaultBlogService implements BlogService {
    private BlogRepository repository;


    public List getAll() {
        return repository.getAll();
    }

    public Blog find(int id) {
        return repository.find(id);
    }


    //region Getters & Setters
    public void setRepository(BlogRepository repository) {
        this.repository = repository;
    }
}
