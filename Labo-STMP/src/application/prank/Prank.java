/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Prank.java
 Author(s)   : Alessandro Parrino, Canton Dylan
 Date        : 16.04.2021

 Description : Contains sender, recipients and message
 -----------------------------------------------------------------------------------
*/

package application.prank;

import application.mail.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains sender, recipients and message
 */
public class Prank {

    private String victimSender;
    private List<Person> victimRecipients = new ArrayList<>();
    private String message;

    //victimSender getter & setter
    public String getVictimSender(){
        return victimSender;
    }

    public void setVictimSender(String victimSender){
        this.victimSender = victimSender;
    }

    //victimRecipients getter & setter
    public List<Person> getVictimRecipients(){
        return new ArrayList<>(victimRecipients);
    }

    public void setVictimRecipients(List<Person> victimRecipients){
        this.victimRecipients = victimRecipients;
    }

    //message getter & setter
    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
