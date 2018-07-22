
package com.cramazin;

public class UserProfile {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String useremail;
    private String aboutuser;
    private int zipcode;
    private int profileimageid;
    private int coverphotoid;

    public UserProfile() {
    }

    public UserProfile(int id, String username, String firstname, String lastname, String useremail, String aboutuser, int zipcode, int profileimageid, int coverphotoid) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.useremail = useremail;
        this.aboutuser = aboutuser;
        this.zipcode = zipcode;
        this.profileimageid = profileimageid;
        this.coverphotoid = coverphotoid;
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

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getAboutuser() {
        return aboutuser;
    }

    public void setAboutuser(String aboutuser) {
        this.aboutuser = aboutuser;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getProfileimageid() {
        return profileimageid;
    }

    public void setProfileimageid(int profileimageid) {
        this.profileimageid = profileimageid;
    }

    public int getCoverphotoid() {
        return coverphotoid;
    }

    public void setCoverphotoid(int coverphotoid) {
        this.coverphotoid = coverphotoid;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", useremail=" + useremail + ", aboutuser=" + aboutuser + ", zipcode=" + zipcode + ", profileimageid=" + profileimageid + ", coverphotoid=" + coverphotoid + '}';
    }

}
