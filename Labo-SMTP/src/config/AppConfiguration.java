/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : AppConfiguration.java
 Author(s)   : Alessandro Parrino, Dylan Canton
 Date        : 16.04.2021

 Description : Application's settings configuration
 -----------------------------------------------------------------------------------
*/

package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains configuration's datas about the application
 */
public class AppConfiguration {

    //Server address
    final private String serverAddress;
    //Port number
    final private int noPort;
    //Number of groups
    final private int nbGroups ;

    /**
     * Constructor
     *
     * @param configFilePath Path to the file containing the configuration
     * @throws IOException
     */
    public AppConfiguration(String configFilePath) throws IOException {

        FileInputStream file = new FileInputStream(configFilePath);
        Properties properties = new Properties();

        //Load the configuration file
        properties.load(file);

        //Get informations from the loaded configuration file
        serverAddress   = properties.getProperty("serverAddress");
        noPort          = Integer.parseInt(properties.getProperty("serverPort"));
        nbGroups        = Integer.parseInt(properties.getProperty("numberOfGroups"));
    }

    /** Server address getter */
    public String getServerAddress() {
        return serverAddress;
    }
    /** Server port getter */
    public int getNoPort() {
        return noPort;
    }
    /** Number of groups getter */
    public int getNbGroups() {
        return nbGroups;
    }
}