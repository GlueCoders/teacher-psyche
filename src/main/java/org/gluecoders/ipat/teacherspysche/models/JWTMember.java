package org.gluecoders.ipat.teacherspysche.models;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public class JWTMember {

    private String token;

    public JWTMember(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
