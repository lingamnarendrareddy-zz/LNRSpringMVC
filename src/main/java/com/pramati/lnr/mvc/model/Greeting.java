package com.pramati.lnr.mvc.model;

/**
 * Created with IntelliJ IDEA.
 * User: narendral
 * Date: 2/5/14
 * Time: 4:50 PM
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
