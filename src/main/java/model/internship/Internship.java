package model.internship;


import model.Crudable;
import model.blog.Blog;
import model.school.School;
import model.user.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Internship implements Crudable {

    @Id
    private int id;

    @OneToOne(targetEntity = Blog.class, fetch = FetchType.EAGER)
    private Blog blog;

    @OneToOne(targetEntity = School.class, fetch = FetchType.EAGER)
    private School school;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
    private int semester = 0;
    private Date startDate;
    private Date endDate;

    public Internship() {
    }
    
    Internship(Blog blog, School school, User user, int semester, Date startDate, Date endDate) {
        this.blog = blog;
        this.school = school;
        this.user = user;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isIncomplete() {
        return blog == null ||
                school == null ||
                user == null ||
                semester == 0 ||
                startDate == null ||
                endDate == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (blog == null) list.add("blog");
        if (school == null) list.add("school");
        if (user == null) list.add("user");
        if (semester == 0) list.add("semester");
        if (startDate == null) list.add("startDate");
        if (endDate == null) list.add("endDate");


        return list;
    }

    //region Getters & Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //endregion
}
