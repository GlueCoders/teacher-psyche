package org.gluecoders.ipat.teacherspysche.usecases;

import org.gluecoders.ipat.teacherspysche.db.StaffMemberDao;
import org.gluecoders.ipat.teacherspysche.models.JWTMember;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class AuthenticateTestLink {

    private final StaffMemberDao staffMemberDao;

    public AuthenticateTestLink(StaffMemberDao staffMemberDao) {
        this.staffMemberDao = staffMemberDao;
    }

    public JWTMember authenticate(String uniqueIdToken) {
        StaffMember member = staffMemberDao.getByToken(uniqueIdToken);
        if (member != null && hasNotAppearedForTest(member)) {
            return generateJwt(member);
        }
        return null;
    }

    private boolean hasNotAppearedForTest(StaffMember member) {
        return false;
    }

    private JWTMember generateJwt(StaffMember member) {
        return new JWTMember("jwttoken");
    }


}
