package model.blog;

import model.user.User;

import java.util.Date;

public class BlogBuilder {

    private User creator;

    private User approvedBy;

    private String title = "";

    private String summary = "";

    private boolean accepted = false;

    private boolean rejected = false;

    private Date date;

    private String content;

    private byte[] summaryImage;

    private byte[] contentImage;

    public BlogBuilder creator(User creator) {
        this.creator = creator;
        return this;
    }

    public BlogBuilder approvedBy(User approvedBy) {
        this.approvedBy = approvedBy;
        return this;
    }

    public BlogBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BlogBuilder accepted(boolean accepted) {
        this.accepted = accepted;
        return this;
    }

    public BlogBuilder rejected(boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    public BlogBuilder date(Date date) {
        this.date = date;
        return this;
    }
    public BlogBuilder content(String content) {
        this.content = content;
        return this;
    }

    public BlogBuilder summary(String summary) {
        this.summary = summary;
        return this;
    }

    public BlogBuilder summaryImage(byte[] summaryImage) {
        this.summaryImage = summaryImage;
        return this;
    }

    public BlogBuilder contentImage(byte[] contentImage) {
        this.contentImage = contentImage;
        return this;
    }

    public Blog build() { return new Blog(creator, approvedBy, title, summary,accepted,rejected,date,content, summaryImage, contentImage); }

}
