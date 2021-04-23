/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Message.java
 Author(s)   : Alessandro Parrino, Canton Dylan
 Date        : 16.04.2021

 Description : Mail's message with heading
 -----------------------------------------------------------------------------------
*/

package application.mail;

import java.util.Arrays;

/**
 * Mail's message, include header (From, to, cc, subject) and text
 */
public class Email {

    private String from;
    private String[] to = new String[0];
    private String[] cc = new String[0];
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
    public String[] getTo(){
        String[] toTab = Arrays.copyOf(to, to.length);
        return toTab;
    }
    /** Receivers setter  */
    public void setTo(String[] toSrc){
        this.to = Arrays.copyOf(toSrc, toSrc.length);
    }

    /** Carbon Copy getter */
    public String[] getCc(){
        String[] ccTab = Arrays.copyOf(cc, cc.length);
        return ccTab;
    }
    /** Carbon Copy setter */
    public void setCc(String[] ccSrc){
        this.cc = Arrays.copyOf(ccSrc, ccSrc.length);
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
