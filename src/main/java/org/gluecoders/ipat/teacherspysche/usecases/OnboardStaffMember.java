package org.gluecoders.ipat.teacherspysche.usecases;

import org.gluecoders.ipat.teacherspysche.db.StaffMemberDao;
import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.externals.EmailService;
import org.gluecoders.ipat.teacherspysche.externals.Template;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class OnboardStaffMember {

    private static final Logger log = Logger.getLogger(OnboardStaffMember.class.getName());

    private final StaffMemberDao staffMemberDao;

    public OnboardStaffMember(StaffMemberDao staffMemberDao) {
        this.staffMemberDao = staffMemberDao;
    }

    public void onboard(StaffMember member) throws ResourceAlreadyExistsException {
        log.info("Onboarding member: "+member.getEmail());
        uniqueCheck(member.getEmail());
        String uniqueIdToken = generateToken(member);
        log.info("Generated uniqueToken "+uniqueIdToken + " for user "+member.getEmail());
        save(member, uniqueIdToken);
        log.info("Member saved in database");
        sendEmail(member, uniqueIdToken);
        log.info("Email sent to member");
    }

    protected void uniqueCheck(String email) throws ResourceAlreadyExistsException {
        if(staffMemberDao.getByEmail(email) != null){
            log.info("Member "+email +" is already registered in system");
            throw new ResourceAlreadyExistsException("Member already exists in system "+email);
        }
        log.info("Unique check passed");
    }

    protected void sendEmail(StaffMember member, String uniqueIdToken) {
        log.info("Sending email to member " + member.getEmail());
        EmailService.send(Template.ONBOARD, member, uniqueIdToken);
    }

    protected void save(StaffMember member, String uniqueIdToken) {
        log.info("Saving member "+member.getEmail());
        staffMemberDao.save(member, uniqueIdToken);
    }

    private String generateToken(StaffMember member) {
        return UUID.randomUUID().toString();
    }
}
