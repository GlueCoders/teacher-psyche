package org.gluecoders.ipat.teacherspysche.externals;

/**
 * Created by Anand Rajneesh on 9/26/2017.
 */
public enum Template {

    ONBOARD("Dear %s %s\n Please click on the below link to access your psychometric test.\n Link : %s\n\nYour Sincerely,\nAptitude India\nOn behalf of %s");

    private String content;

    Template(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
