
package com.cramazin;

import java.sql.Date;

public class User {
 
    private int id;
    private String email;
    private String username;
    private String password;
    private Date created_at;
    private String firstname;
    private String lastname;
    private int profileimageid;

    public User() {
    }

    public User(int id, String email, String username, String password, String firstname, String lastname, int profileimageid) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profileimageid = profileimageid;
    }

    public User(String email, String username, String password, String firstname, String lastname, int profileimageid) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profileimageid = profileimageid;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getProfileimageid(){
        return profileimageid;
    }
    public void setProfileimageid(){
        this.profileimageid = profileimageid;
    }
 
}
