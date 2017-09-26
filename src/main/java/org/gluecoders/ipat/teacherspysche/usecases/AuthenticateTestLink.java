package org.gluecoders.ipat.teacherspysche.usecases;

import org.gluecoders.ipat.teacherspysche.db.StaffMemberDao;
import org.gluecoders.ipat.teacherspysche.exceptions.ResourceAlreadyExistsException;
import org.gluecoders.ipat.teacherspysche.exceptions.ValidationException;
import org.gluecoders.ipat.teacherspysche.helpers.CryptoUtil;
import org.gluecoders.ipat.teacherspysche.models.JWTMember;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

import java.util.logging.Logger;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class AuthenticateTestLink {

    private static final Logger log = Logger.getLogger(AuthenticateTestLink.class.getName());

    private final StaffMemberDao staffMemberDao;

    public AuthenticateTestLink() {
        this.staffMemberDao = new StaffMemberDao();
    }

    public String authenticate(String uniqueIdToken) throws ValidationException, ResourceAlreadyExistsException {
        log.info("Authenticating token "+uniqueIdToken);
        StaffMember member = getByToken(uniqueIdToken);
        log.info("Got member "+member.getEmail());
        if (hasNotAppearedForTest(member)) {
            log.info("Generating id for member "+member.getEmail());
            return generateId(member);
        }else{
            log.info("Member has already given test "+member.getEmail());
            throw new ResourceAlreadyExistsException("Member has already given test");
        }
    }

    private boolean hasNotAppearedForTest(StaffMember member) {
        return !member.isTakenQuiz();
    }

    private String generateId(StaffMember member) {
        return CryptoUtil.encrypt(member.getEmail());
    }

    private StaffMember getByToken(String token) throws ValidationException {
        StaffMember member = staffMemberDao.getByToken(token);
        if(member == null){
            log.info("Member is null for token "+token);
            throw new ValidationException("Member is null");
        }
        return member;
    }


}
