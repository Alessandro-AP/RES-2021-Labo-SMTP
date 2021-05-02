/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : MainApplication.java
 Author(s)   : Alessandro Parrino, Dylan Canton
 Date        : 16.04.2021

 Description : Main program's function
 -----------------------------------------------------------------------------------
*/

import application.mail.Email;
import application.prank.Prank;
import application.prank.PrankMaker;
import config.AppConfiguration;
import smtp.SmtpClient;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Main class for application
 *
 * This class process text files, get a prank's list, build some emails objects
 * with informations in each prank and finally send emails with SMTP
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {

        //Config file path
        String configPath = "src\\config.properties";

        //Instanciate application config
        AppConfiguration config = new AppConfiguration(configPath);

        //Instanciate a prankMaker
        PrankMaker prankMaker = new PrankMaker(config);

        //Get a prank list of pranks generated from the prankMaker function
        LinkedList<Prank> prankList = prankMaker.generatePranks();

        //Create email list
        LinkedList<Email> emails = new LinkedList<>();

        //Create email object with informations from prank
        for(Prank prank : prankList){
            Email email = new Email();

            //Set sender and receiver in header
            email.setFrom(prank.getVictimSender().getAddress());
            email.setTo(prank.getVictimRecipientsStr());

            //Set subject, it's the first line of a message in messages.txt
            String subject = prank.getMessage().substring(0,prank.getMessage().indexOf("\n"));
            email.setSubject(subject);

            //Set message body, it's the full message except the first line in messages.txt
            String messageBody = prank.getMessage().substring(subject.length());
            email.setText(messageBody);

            //Add email object to the list
            emails.add(email);
        }

        //Instanciate STMP Client with address and port from config
        SmtpClient smtpClient = new SmtpClient(config.getServerAddress(), config.getNoPort());

        //Send every email object with SMTP Client
        for(Email email : emails){
            smtpClient.sendSMTPmessage(email);
        }
    }
}