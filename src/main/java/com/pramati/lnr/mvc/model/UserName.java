package com.pramati.lnr.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: narendral
 * Date: 2/5/14
 * Time: 4:59 PM
 */

@Entity
@Table(name = "USER_NAME")
public class UserName {

    @Id
    @Column(name = "FIRSTNAME")
    private String firstName;


    @Column(name = "MIDDLENAME")
    private String middleName;

    @Column(name = "LASTNAME")
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
