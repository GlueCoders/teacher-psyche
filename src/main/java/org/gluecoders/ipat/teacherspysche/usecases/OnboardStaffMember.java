package org.gluecoders.ipat.teacherspysche.usecases;

import org.gluecoders.ipat.teacherspysche.db.StaffMemberDao;
import org.gluecoders.ipat.teacherspysche.externals.EmailService;
import org.gluecoders.ipat.teacherspysche.externals.Template;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

import java.util.UUID;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class OnboardStaffMember {

    private final EmailService emailService;
    private final StaffMemberDao staffMemberDao;

    public OnboardStaffMember(EmailService emailService, StaffMemberDao staffMemberDao) {
        this.emailService = emailService;
        this.staffMemberDao = staffMemberDao;
    }


    public boolean onboard(StaffMember member){
        String uniqueIdToken = generateToken(member);
        boolean saved = save(member, uniqueIdToken);
        if(saved){
            sendEmail(member, uniqueIdToken);
        }
        return saved;
    }

    private void sendEmail(StaffMember member, String uniqueIdToken) {
        emailService.send(Template.ONBOARD, member, uniqueIdToken);
    }

    private boolean save(StaffMember member, String uniqueIdToken) {
        return staffMemberDao.save(member, uniqueIdToken);
    }

    private String generateToken(StaffMember member) {
        return UUID.randomUUID().toString();
    }
}
