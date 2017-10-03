package model.blog;

import model.Crudable;
import model.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Entity
public class Blog implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private User creator;
    private User approvedBy;
    private String title;
    private String summary;
    private byte[] summaryImage;
    private byte[] content;

    public Blog() {

    }

    Blog(User creator, User approvedBy, String title, String summary, byte[] summaryImage, byte[] content) {
        this.creator = creator;
        this.approvedBy = approvedBy;
        this.title = title;
        this.summary = summary;
        this.summaryImage = summaryImage;
        this.content = content;
    }

    public boolean isIncomplete() {
        return creator == null ||
                approvedBy == null ||
                title == null ||
                summary == null ||
                summaryImage == null ||
                content == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (creator == null) list.add("creator");
        if (approvedBy == null) list.add("approvedBy");
        if (title == null) list.add("title");
        if (summary == null) list.add("summary");
        if (summaryImage == null) list.add("summaryImage");
        if (content == null) list.add("content");


        return list;
    }

    //region Getters & Setters

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }


    //endregion

}
