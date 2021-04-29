/*
 -----------------------------------------------------------------------------------
 Project     : RES-2021-Labo-SMTP
 File        : AppConfiguration.java
 Author(s)   : Alessandro Parrino, Canton Dylan
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
    private String serverAddress;
    //Port number
    private int noPort;
    //Number of groups
    private int nbGroups ;

    /** Constructor */
    public AppConfiguration(String configFilePath) throws IOException {
        FileInputStream file = new FileInputStream(configFilePath);
        Properties properties = new Properties();
        properties.load(file);

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