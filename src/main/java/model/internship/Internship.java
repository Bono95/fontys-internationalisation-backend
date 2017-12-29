package model.internship;


import model.Crudable;
import model.blog.Blog;
import model.internshipRoute.InternshipRoute;
import model.school.Institution;
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

    @OneToOne(targetEntity = InternshipRoute.class, fetch = FetchType.EAGER)
    private InternshipRoute internshipRoute;

    @OneToOne(targetEntity = Institution.class, fetch = FetchType.EAGER)
    private Institution institution;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    private String title;
    private String summary;

    private int semester = 0;
    private Date startDate;
    private Date endDate;
    private boolean isActive = true;

    public Internship() {
    }
    
    Internship(Blog blog,InternshipRoute internshipRoute, Institution institution, User user, String summary, String title, int semester, Date startDate, Date endDate) {
        this.blog = blog;
        this.internshipRoute = internshipRoute;
        this.institution = institution;
        this.user = user;
        this.title = title;
        this.summary = summary;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isIncomplete() {
        return  internshipRoute == null ||
                institution == null ||
                user == null ||
                semester == 0 ||
                startDate == null ||
                endDate == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (internshipRoute == null) list.add("internshipRoute");
        if (institution == null) list.add("institution");
        if (user == null) list.add("user");
        if (semester == 0) list.add("semester");
        if (startDate == null) list.add("startDate");
        if (endDate == null) list.add("endDate");


        return list;
    }

    //region Getters & Setters


    public InternshipRoute getInternshipRoute() {
        return internshipRoute;
    }

    public void setInternshipRoute(InternshipRoute internshipRoute) {
        this.internshipRoute = internshipRoute;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
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
