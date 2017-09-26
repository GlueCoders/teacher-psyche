package org.gluecoders.ipat.teacherspysche.db;

import com.googlecode.objectify.Key;
import org.gluecoders.ipat.teacherspysche.models.StaffMember;
import static com.googlecode.objectify.ObjectifyService.ofy;
/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class StaffMemberDao {

    public void save(StaffMember member, String token){
        member.setLinkToken(token);
        ofy().save().entity(member).now();
    }

    public StaffMember getByToken(String uniqueIdToken) {
        return ofy().load().type(StaffMember.class).filter("linkToken", uniqueIdToken).first().now();
    }

    public void update(StaffMember member){
        ofy().save().entity(member);
    }

    public StaffMember getByEmail(String email){
        return ofy().load().key(Key.create(StaffMember.class, email)).now();
    }
}
