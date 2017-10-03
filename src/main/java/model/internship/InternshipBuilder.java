package model.internship;

import model.blog.Blog;
import model.school.School;
import model.user.User;

import java.util.Date;

public class InternshipBuilder {

    private Blog blog;
    private School school;
    private User user;
    private int semester = 0;
    private Date startDate;
    private Date endDate;

    public InternshipBuilder blog(Blog blog){
        this.blog = blog;
        return this;
    }

    public InternshipBuilder school(School school){
        this.school = school;
        return this;
    }

    public InternshipBuilder user(User user){
        this.user = user;
        return this;
    }

    public InternshipBuilder semester(int semester){
        this.semester = semester;
        return this;
    }

    public InternshipBuilder startDate(Date startDate){
        this.startDate = startDate;
        return this;
    }

    public InternshipBuilder endDate(Date endDate){
        this.endDate = endDate;
        return this;
    }

    public Internship build(){
        return new Internship(blog,school,user,semester,startDate,endDate);
    }


}
