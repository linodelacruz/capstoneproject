
package com.cramazin;

import java.sql.Date;

public class UserPost {
   private int id;
   private String username;
   private int picturepostid;
   private String textpost;
   private Date dateposted;
   private int profileimageid;
   

    public UserPost() {
    }

    public UserPost(int id, String username, int picturepostid, String textpost, Date dateposted, int profileimageid) {
        this.id = id;
        this.username = username;
        this.picturepostid = picturepostid;
        this.textpost = textpost;
        this.dateposted = dateposted;
        this.profileimageid = profileimageid;
    }

    public int getProfileimageid() {
        return profileimageid;
    }

    public void setProfileimageid(int profileimageid) {
        this.profileimageid = profileimageid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPicturepostid() {
        return picturepostid;
    }

    public void setPicturepostid(int picturepostid) {
        this.picturepostid = picturepostid;
    }

    public String getTextpost() {
        return textpost;
    }

    public void setTextpost(String textpost) {
        this.textpost = textpost;
    }

    public Date getDateposted() {
        return dateposted;
    }

    public void setDateposted(Date dateposted) {
        this.dateposted = dateposted;
    }

    @Override
    public String toString() {
        return "UserPost{" + "id=" + id + ", username=" + username + ", picturepostid=" + picturepostid + ", textpost=" + textpost + ", dateposted=" + dateposted + ", profileimageid=" + profileimageid + '}';
    }

    
   
   
}
