package org.gluecoders.ipat.teacherspysche.db;

import org.gluecoders.ipat.teacherspysche.models.StaffMember;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class StaffMemberDao {

    public boolean save(StaffMember member, String token){
        return true;
    }

    public StaffMember getByToken(String uniqueIdToken) {
        return new StaffMember();
    }
}
