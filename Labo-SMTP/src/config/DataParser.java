/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : DataParser.java
 Author(s)   : Alessandro Parrino, Dylan Canton
 Date        : 16.04.2021

 Description : Parser for extracting email and messages from data files (.txt)
               and convert them into objects
 -----------------------------------------------------------------------------------
*/

package config;

import application.mail.Person;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

/**
 * Manage configuration's files, get datas in files and store them in lists
 */
public class DataParser {

    /**
     * Retrieve people's emails from a text file and store them
     * in a list of "Person"
     *
     * @param path to the file containing the emails
     * @return the list of person
     */
    public static LinkedList<Person> parseEmails(String path) {

        LinkedList<Person> emails = new LinkedList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8));
            String line;

            while ((line = reader.readLine()) != null) {
                emails.add(new Person(line));
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        return emails;
    }

    /**
     * Retrieve messages from a text file and store them
     * in a list of String
     * Note: each message must be separated with a line
     * containing the delimiter "---".
     *
     * @param path to the file containing the messages
     * @return the list of messages
     */
    public static LinkedList<String> parseMessages(String path){

        LinkedList<String> messages = new LinkedList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {

                if (line.equals("---")) {
                    messages.add(content.toString());
                    content.setLength(0);
                } else {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return messages;
    }
}