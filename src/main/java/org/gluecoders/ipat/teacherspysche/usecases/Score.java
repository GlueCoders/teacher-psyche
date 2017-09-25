package org.gluecoders.ipat.teacherspysche.usecases;

import org.gluecoders.ipat.teacherspysche.models.JWTMember;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class Score {

    public boolean score(JWTMember member, String answers){
        boolean authenticated = authenticate(member);
        if(authenticated){
            calculateScore(answers, member);
            return true;
        }
        return false;
    }

    private void calculateScore(String answers, JWTMember member) {

    }

    private boolean authenticate(JWTMember member) {
        return false;
    }

}
