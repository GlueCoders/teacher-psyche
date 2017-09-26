package org.gluecoders.ipat.teacherspysche.servlets;

public enum Pages {

    GENERIC_ERROR("");

    private final String htmlPage;

    Pages(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String get(){
        return this.htmlPage;
    }
}
