package org.gluecoders.ipat.teacherspysche.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
@Entity
public class StaffMember {

    @Id
    private String email;
    private String title;
    private String name;
    private String school;
    private String profession;
    private String mobile;
    private String linkToken;
    private boolean takenQuiz;


    public String getLinkToken() {
        return linkToken;
    }

    public void setLinkToken(String linkToken) {
        this.linkToken = linkToken;
    }

    public boolean isTakenQuiz() {
        return takenQuiz;
    }

    public void setTakenQuiz(boolean takenQuiz) {
        this.takenQuiz = takenQuiz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
