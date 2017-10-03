package model.blog;

import model.user.User;

public class Blog {

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
