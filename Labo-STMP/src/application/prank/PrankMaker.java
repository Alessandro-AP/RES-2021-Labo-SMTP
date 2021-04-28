/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : PrankMaker.java
 Author(s)   : Alessandro Parrino, Canton Dylan
 Date        : 16.04.2021

 Description : Building a prank with message and group
 -----------------------------------------------------------------------------------
*/

package application.prank;

import application.mail.Group;
import application.mail.Person;
import config.AppConfiguration;
import java.util.*;

import static config.DataParser.parseEmails;
import static config.DataParser.parseMessages;

/**
 * Building a prank with message and group
 */
public class PrankMaker {

    //Configuration Settings
    AppConfiguration config;

    /** Constructor */
    public PrankMaker(AppConfiguration config) {
        this.config = config;
    }

    /**
     * Generate a random list of "Prank"
     * @return the list of pranks
     */
    public LinkedList<Prank> generatePranks() throws InvalidPropertiesFormatException {
        LinkedList<Prank> pranks = new LinkedList<>();
        LinkedList<Person> people = parseEmails("src/data/emails.txt");
        LinkedList<String> messages = parseMessages("src/data/messages.txt");
        int nbGroups = config.getNbGroups();

        // Check if there are enough people to form a group
        if(people.size() / nbGroups < 3){
            throw new InvalidPropertiesFormatException("Not enough people to create a prank");
        }

        // Randomise list of victims
        Collections.shuffle(people, new Random());

        //Get the number of people per group
        int nbPeopleInGroup = people.size() / nbGroups;

        //Number of persons remaining
        int nbrPersonRemaining = people.size();

        //List for number of persons in each group
        List<Integer> nbPeopleInGroupList = new ArrayList<>();

        //Assign the correct number of persons in each group
        while(nbrPersonRemaining >= nbPeopleInGroup * 2){
            nbPeopleInGroupList.add(nbPeopleInGroup);
            nbrPersonRemaining -= nbPeopleInGroup;
        }
        //Add the remaining persons to the last group
        nbPeopleInGroupList.add(nbrPersonRemaining);

        // Create groups
        LinkedList<Group> groups = new LinkedList<>();
        for(int i = 0 ; i < nbGroups; ++i){
            Group group = new Group();

            // Add group components
            for(int j = 0; j < nbPeopleInGroupList.get(i); ++j){
                group.addMember(people.pop());
            }

            groups.add(group);
        }

        // Create pranks
        for(Group group : groups){
            Prank prank = new Prank();
            int sizeGroup = group.getMember().size();

            // Take random message
            Random rand = new Random();
            int randomIndex = rand.nextInt(messages.size());
            prank.setMessage(messages.get(randomIndex));

            // Set victim sender
            prank.setVictimSender(group.getMember().get(0));

            // Set victim receiver
            prank.setVictimReceiver(group.getMember().subList(1,sizeGroup));

            // Add to prank list
            pranks.add(prank);
        }

        return pranks;
    }
}