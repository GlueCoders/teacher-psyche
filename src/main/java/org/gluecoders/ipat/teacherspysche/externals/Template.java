package org.gluecoders.ipat.teacherspysche.externals;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public enum Template {

    ONBOARD(
            "Dear %s %s\n Please click on the below link to access your psychometric test.\n Link : %s\n\nYour Sincerely,\nAptitude India\nOn behalf of %s",
            "Aptitude India: Psychometric Test");

    private String content;
    private String subject;

    Template(String content, String subject) {
        this.content = content;
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }
}
