/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Prank.java
 Author(s)   : Alessandro Parrino, Dylan Canton
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

    private Person victimSender;
    private List<Person> victimRecipients = new ArrayList<>();
    private String message;

    /** Victim sender getter */
    public Person getVictimSender(){
        return victimSender;
    }

    /** Victim sender getter */
    public void setVictimSender(Person victimSender){
        this.victimSender = victimSender;
    }

    /** Victims receivers getter */
    public List<Person> getVictimRecipients(){
        return new ArrayList<>(victimRecipients);
    }

    /** Victims receivers getter in String format*/
    public List<String> getVictimRecipientsStr(){
        List<String> victimRecipientsStr = new ArrayList<>();
        for(Person p : victimRecipients){
            victimRecipientsStr.add(p.getAddress());
        }
        return victimRecipientsStr;
    }

    /** Victims receivers setter */
    public void setVictimReceiver(List<Person> victimRecipients){
        this.victimRecipients = victimRecipients;
    }

    /** Message getter */
    public String getMessage(){
        return message;
    }

    /** Message setter */
    public void setMessage(String message){
        this.message = message;
    }
}