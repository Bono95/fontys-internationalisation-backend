package model.blog;

import model.Crudable;
import model.user.User;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@Entity
public class Blog implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private User creator;
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private User approvedBy;
    private String title;
    private String summary;
    private boolean accepted = false;
    private boolean rejected = false;
    private Date date;
    @Type(type="text")
    private String content;
    private byte[] summaryImage;
    private byte[] contentImage;

    public Blog() {

    }


    Blog(User creator, User approvedBy, String title, String summary, boolean accepted, boolean rejected, Date date, String content, byte[] summaryImage, byte[] contentImage) {
        this.creator = creator;
        this.approvedBy = approvedBy;
        this.title = title;
        this.summary = summary;
        this.accepted = accepted;
        this.rejected = rejected;
        this.date = date;
        this.content = content;
        this.summaryImage = summaryImage;
        this.contentImage = contentImage;
    }

    public boolean isIncomplete() {
        return creator == null ||
//                approvedBy == null ||
                title == null ||
                summary == null;
//                summaryImage == null ||
//                contentImage == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (creator == null) list.add("creator");
//        if (approvedBy == null) list.add("approvedBy");
        if (title == null) list.add("title");
        if (summary == null) list.add("summary");
//        if (summaryImage == null) list.add("summaryImage");
//        if (contentImage == null) list.add("contentImage");


        return list;
    }

    //region Getters & Setters


    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public byte[] getSummaryImage() {
        return summaryImage;
    }

    public void setSummaryImage(byte[] summaryImage) {
        this.summaryImage = summaryImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.contentImage = contentImage;
    }

    public byte[] getContentImage() {
        return contentImage;
    }

    public void setContentImage(byte[] contentImage) {
        this.contentImage = contentImage;
    }

    //endregion

}
