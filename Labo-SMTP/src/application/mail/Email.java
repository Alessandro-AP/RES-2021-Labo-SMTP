/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Email.java
 Author(s)   : Alessandro Parrino, Dylan Canton
 Date        : 16.04.2021

 Description : Mail's message with heading
 -----------------------------------------------------------------------------------
*/

package application.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mail's message, include header (From, to, cc, subject) and text
 */
public class Email {

    private String from;
    private List<String> to = new ArrayList<>();
    private List<String> cc = new ArrayList<>();
    private String subject;
    private String text;

    /** Sender getter */
    public String getFrom(){
        return from;
    }

    /** Sender setter */
    public void setFrom(String from){
        this.from = from;
    }

    /** Receivers getter */
    public List<String> getTo(){
        List<String> toTab = new ArrayList<>(this.to);
        return toTab;
    }

    /** Receivers setter  */
    public void setTo(List<String> toSrc){
        this.to = new ArrayList<>(toSrc);
    }

    /** Carbon Copy getter */
    public List<String> getCc(){
        List<String> ccTab = new ArrayList<>(this.cc);
        return ccTab;
    }

    /** Carbon Copy setter */
    public void setCc(List<String> ccSrc){
        this.cc = new ArrayList<>(ccSrc);
    }

    /** Subject getter  */
    public String getSubject(){
        return subject;
    }

    /** Subject setter  */
    public void setSubject(String subject){
        this.subject = subject;
    }

    /** Text getter  */
    public String getText(){
        return text;
    }

    /** Text setter  */
    public void setText(String text){
        this.text = text;
    }
}