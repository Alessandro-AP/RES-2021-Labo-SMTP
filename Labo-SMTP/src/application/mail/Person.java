/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Person.java
 Author(s)   : Alessandro Parrino, Canton Dylan
 Date        : 16.04.2021

 Description : Class for mail's representation
 -----------------------------------------------------------------------------------
*/

package application.mail;

/**
 * Mail address from a person
 */
public class Person {

    //Mail address
    private final String address;

    /** Constructor */
    public Person(String address){ this.address = address; }

    /** Address getter */
    public String getAddress() { return address;}
}