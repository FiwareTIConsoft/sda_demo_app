package com.tilab.ca.sda.sda_demo_app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tilab.ca.sda.sda_demo_app.utils.CustomDateSerializer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_data")
@JsonInclude(Include.NON_NULL)
public class TwData implements Serializable{
    
    @Id
    @Column(name="post_id")
    private long postId;
    
    @Column(name="user_id")
    private long userId;
    
    private String name;
    
    @Column(name="screen_name")
    private String screenName;
    
    @Column(name="profile_image_url")
    private String profileImageUrl;
    
    @JsonSerialize(using = CustomDateSerializer.class)
    @Column(name="createdAt")
    private Date createdAt;
    
    private String text;
    
    @Column(name="retweet_of_post_id")
    private Long retweetOfPostId;
    
    @Column(name="in_reply_to_post_id")
    private Long inReplyToPostId;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRetweetOfPostId() {
        return retweetOfPostId;
    }

    public void setRetweetOfPostId(Long retweetOfPostId) {
        this.retweetOfPostId = retweetOfPostId;
    }

    public Long getInReplyToPostId() {
        return inReplyToPostId;
    }

    public void setInReplyToPostId(Long inReplyToPostId) {
        this.inReplyToPostId = inReplyToPostId;
    }
}
