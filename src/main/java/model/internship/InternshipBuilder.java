package model.internship;

import model.blog.Blog;
import model.internshipRoute.InternshipRoute;
import model.school.Institution;
import model.user.User;

import java.util.Date;

public class InternshipBuilder {

    private Blog blog = null;
    private InternshipRoute internshipRoute;
    private Institution institution;
    private User user;
    private String title;
    private String summary;
    private int semester = 0;
    private Date startDate;
    private Date endDate;

    public InternshipBuilder blog(Blog blog){
        this.blog = blog;
        return this;
    }

    public InternshipBuilder internshipRoute(InternshipRoute internshipRoute){
        this.internshipRoute = internshipRoute;
        return this;
    }

    public InternshipBuilder institution(Institution institution){
        this.institution = institution;
        return this;
    }

    public InternshipBuilder user(User user){
        this.user = user;
        return this;
    }

    public InternshipBuilder title(String title){
        this.title = title;
        return this;
    }

    public InternshipBuilder summary(String summary){
        this.summary = summary;
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
        return new Internship(blog, internshipRoute, institution,user, title, summary,semester,startDate,endDate);
    }


}
