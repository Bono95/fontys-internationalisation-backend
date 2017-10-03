package model.blog;

import model.user.User;

public class BlogBuilder {

    private User creator;

    private User approvedBy;

    private String title = "";

    private String summary = "";

    private byte[] summaryImage;

    private byte[] content;

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

    public BlogBuilder summary(String summary) {
        this.summary = summary;
        return this;
    }

    public BlogBuilder summaryImage(byte[] summaryImage) {
        this.summaryImage = summaryImage;
        return this;
    }

    public BlogBuilder content(byte[] content) {
        this.content = content;
        return this;
    }

    public Blog build() { return new Blog(creator, approvedBy, title, summary, summaryImage, content); }

}
