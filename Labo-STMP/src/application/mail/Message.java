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

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Mail's message, include header (From, to, cc, subject) and text
 */
public class Message {

    private String from;
    private String[] to = new String[0];
    private String[] cc = new String[0];
    private String subject;
    private String text;

    //From getter & setter
    public String getFrom(){
        return from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    //To getter & setter
    public String[] getTo(){
        String[] toTab = Arrays.copyOf(to, to.length);
        return toTab;
    }

    public void setTo(String[] toSrc){
        this.to = Arrays.copyOf(toSrc, toSrc.length);
    }

    //cc getter & setter
    public String[] getCc(){
        String[] ccTab = Arrays.copyOf(cc, cc.length);
        return ccTab;
    }

    public void setCc(String[] ccSrc){
        this.cc = Arrays.copyOf(ccSrc, ccSrc.length);
    }

    //Subject getter & setter
    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    //Text getter & setter
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

}
