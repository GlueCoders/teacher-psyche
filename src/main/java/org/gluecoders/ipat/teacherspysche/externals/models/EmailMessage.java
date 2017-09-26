package org.gluecoders.ipat.teacherspysche.externals.models;

public class EmailMessage {

    private String title;
    private String name;
    private String subject;
    private String emailBody;
    private String to;

    public EmailMessage(String title, String name, String subject, String emailBody, String to) {
        this.title = title;
        this.name = name;
        this.subject = subject;
        this.emailBody = emailBody;
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public String getTo() {
        return to;
    }
}
