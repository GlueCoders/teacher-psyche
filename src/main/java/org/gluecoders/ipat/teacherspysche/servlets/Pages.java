package org.gluecoders.ipat.teacherspysche.servlets;

public enum Pages {

    ONBOARD_SUCCESS(""),
    TEST_PAGE("");

    private final String htmlPage;

    Pages(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String get(){
        return this.htmlPage;
    }
}
