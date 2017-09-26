package org.gluecoders.ipat.teacherspysche.externals;

import org.gluecoders.ipat.teacherspysche.externals.models.EmailMessage;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class EmailService {

    private static final String ADMIN_EMAIL_ADDRESS = "...@gmail.com";
    private static final String ADMIN_EMAIL_TAG = "Admin";

    public static void send(Template template, StaffMember member, String token){
        String content = template.getContent();
        switch (template){
            case ONBOARD:
                String link = generateTestLink(token);
                String emailBody = generateOnboardEmailBody(member, link, content);
                send(new EmailMessage(member.getTitle(), member.getName(), template.getSubject(), emailBody, member.getEmail()));
                break;
            default:
                break;
        }
    }

    private static void send(EmailMessage message) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(ADMIN_EMAIL_ADDRESS, ADMIN_EMAIL_TAG));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(message.getTo(), String.format("%s. %s", message.getTitle(), message.getName())));
            msg.setSubject(message.getSubject());
            msg.setText(message.getEmailBody());
            Transport.send(msg);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String generateOnboardEmailBody(StaffMember member, String link, String content) {
        return String.format(content, member.getTitle(), member.getName(), link, member.getSchool());
    }

    private static String generateTestLink(String token) {
        return token;
    }

}
