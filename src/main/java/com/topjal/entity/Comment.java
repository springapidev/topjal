package com.topjal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Please Enter Post Description")
    @Column(name = "description",length = 10000)
    private String description;

    @Column(name = "status")
    private boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "comment_date")
    private Date commentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String ipAddress;
    @Column(name = "mac_address")
    private  String macAddress;
    @Column(name = "country")
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return isStatus() == comment.isStatus() &&
                Objects.equals(getId(), comment.getId()) &&
                Objects.equals(getDescription(), comment.getDescription()) &&
                Objects.equals(getCommentDate(), comment.getCommentDate()) &&
                Objects.equals(getUpdateDate(), comment.getUpdateDate()) &&
                Objects.equals(getPost(), comment.getPost()) &&
                Objects.equals(getUser(), comment.getUser()) &&
                Objects.equals(getIpAddress(), comment.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), isStatus(), getCommentDate(), getUpdateDate(), getPost(), getUser(), getIpAddress());
    }
}
