/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : Group.java
 Author(s)   : Alessandro Parrino, Canton Dylan
 Date        : 16.04.2021

 Description : Group of Persons
 -----------------------------------------------------------------------------------
*/

package application.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * A group is composed of N address
 */
public class Group {

    private final List<Person> groupMembers = new ArrayList<>();

    public void addMember(Person person){
        groupMembers.add(person);
    }

    public List<Person> getMember(){
        return new ArrayList<>(groupMembers);
    }
}
