package model.internship;


import model.blog.Blog;
import model.school.School;
import model.user.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Internship {

    @Id
    private int id;
    private Blog blog;
    private School school;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
    private int semester;
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
