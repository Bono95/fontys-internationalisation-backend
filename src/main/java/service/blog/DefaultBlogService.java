package service.blog;

import mailclient.MailClient;
import model.blog.Blog;
import repository.blog.BlogRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultBlogService implements BlogService {
    private BlogRepository repository;

    ExecutorService pool;

    public DefaultBlogService(){
        pool = Executors.newFixedThreadPool(1);
    }

    public List getAll() {
        return repository.getAll();
    }

    public Blog find(int id) {
        return repository.find(id);
    }

    public boolean update(Blog blog){
        boolean result = repository.update(blog);

        if(!blog.isAccepted() && blog.isRejected()){
            if(result){
                Runnable mail = new MailClient(blog);
                pool.execute(mail);
            }
            pool.shutdown();
        }
        return result;
    }


    //region Getters & Setters
    public void setRepository(BlogRepository repository) {
        this.repository = repository;
    }
}
