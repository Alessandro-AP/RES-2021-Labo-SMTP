/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : SmtpClient.java
 Author(s)   : Alessandro Parrino, Dylan Canton
 Date        : 16.04.2021

 Description : SMTP client for sending mail
 -----------------------------------------------------------------------------------
*/

package smtp;

import application.mail.Email;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * SMTP client implementation
 */
public class SmtpClient {

    //Logger
    private static final Logger log = Logger.getLogger(SmtpClient.class.getName());
    //Server address and port
    private String serverAddress;
    private int serverPort;

    //socket
    private Socket socket;
    //Writer
    private PrintWriter writer;
    //Reader
    private BufferedReader reader;

    /**
     * Constructor
     *
     * @param serverAddress Server's address
     * @param serverPort    Server's port
     */
    public SmtpClient(String serverAddress, int serverPort){
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    /**
     * Send a SMTP message
     *
     * @param email Email to send, it's a classe with all informations needed to send
     *              a email
     *
     * @throws IOException
     */
    public void sendSMTPmessage(Email email) throws IOException {

        //Create socket
        socket = new Socket(serverAddress, serverPort);
        //Create Writer
        writer = new PrintWriter(socket.getOutputStream());
        //Create Reader
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //String for reading
        String line;

        //Read first line
        line = reader.readLine();
        log.info("<START CONNECTION> REPLY = " + line);

        //Configure the sender
        writer.write("MAIL FROM:");
        writer.write(email.getFrom());
        writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        log.info("<MAIL FROM> REPLY = " + line);

        //Configure the receivers
        for(String to : email.getTo()){
            writer.write("RCPT TO:");
            writer.write(to);
            writer.write("\r\n");
            writer.flush();
            line = reader.readLine();
            log.info("<RCPT TO> REPLY = " + line);
        }

        /*Configure message body*/

        writer.write("DATA:");
        writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        log.info("<DATA> REPLY = " + line);

        //Configure text encoding
        writer.write("Content-Type: text/plain; charset=\"utf-8\"\r\n");

        //Configure message body header <From>
        writer.write("From: " + email.getFrom() + "\r\n");

        //Configure message body header <To>
        writer.write("To: " + email.getTo().get(0));
        for(int i = 0; i < email.getTo().size(); ++i){
            writer.write("," + email.getTo().get(i));
        }
        writer.write("\r\n");

        //Configure message body header <Cc>
        if(email.getCc().size() > 0){
            writer.write("Cc: " + email.getCc().get(0));
            for(int i = 0; i < email.getCc().size(); ++i){
                writer.write("," + email.getCc().get(i));
            }
            writer.write("\r\n");
        }

        //Configure message subject (with encoding UTF-8, it need to convert the
        // string subject into Base64)
        writer.write("Subject: " + "=?utf-8?B?" +
                     Base64.getEncoder().encodeToString(email.getSubject().getBytes())
                     + "?= " + "\r\n");
        writer.flush();

        //Configure message text
        writer.write(email.getText() + "\r\n");
        writer.write("." + "\r\n");
        writer.flush();
        line = reader.readLine();
        log.info("<SEND MAIL REPLY> = " + line);

        //Quit connexion
        writer.write("quit\r\n");
        writer.flush();
        socket.close();
        writer.close();
        reader.close();
    }
}