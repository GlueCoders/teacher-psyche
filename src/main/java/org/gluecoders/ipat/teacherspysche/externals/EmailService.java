package org.gluecoders.ipat.teacherspysche.externals;

import org.gluecoders.ipat.teacherspysche.models.StaffMember;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class EmailService {

    public void send(Template template, StaffMember member, String token){
        String content = template.getContent();
        switch (template){
            case ONBOARD:
                String link = generateTestLink(token);
                String emailBody = generateOnboardEmailBody(member, link, content);
                send(member.getEmail(), emailBody);
                break;
            default:
                break;
        }

        //replace
    }

    private void send(String email, String emailBody) {

    }

    private String generateOnboardEmailBody(StaffMember member, String link, String content) {
        return String.format(content, member.getTitle(), member.getName(), link, member.getSchool());
    }

    private String generateTestLink(String token) {
        return token;
    }

}
