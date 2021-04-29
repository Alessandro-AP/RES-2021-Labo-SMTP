[comment]: <> "### Design de l'application"

[comment]: <> "**Protocol SMTP** :"

[comment]: <> " https://tools.ietf.org/html/rfc5321#appendix-D"



[comment]: <> "**Fichiers de configuration : &#40;texte&#41;** "

[comment]: <> "* Fichier texte de config pour les mails victimes"

[comment]: <> "* Fichier texte de config pour les messages"



[comment]: <> "**Traitement des fichiers de config : **"

[comment]: <> "* Une classe de configuration pour les paramètres du serveur : "

[comment]: <> "  * Adresse du serveur"

[comment]: <> "  * Port"

[comment]: <> "  * Nombre de groupes"

[comment]: <> "* Une classe de configuration pour traiter les fichiers de config &#40;Va parser les données et mettre les adresses dans une liste <Person>&#41;"



[comment]: <> "**Création des pranks :** "

[comment]: <> "* Objet Group : contient des Person"

[comment]: <> "* Objet Person : représente une personne &#40;adresse mail&#41;"

[comment]: <> "* Objet Message : contient le message &#40;En-tête : From, To, Cc, Subject et le texte du message&#41;"

[comment]: <> "* Objet Prank qui contient l'envoyeur, le&#40;s&#41; destinataire&#40;s&#41; et le message."

[comment]: <> "* Un fichier PrankMaker va créer un Prank d'après les classes Groupe, Victimes, Message"



[comment]: <> "**Client SMTP :**"

[comment]: <> "* Connecter au serveur SMTP avec un socket"

[comment]: <> "* Récupérer un objet Prank et l'utiliser pour envoyer un mail. "



[comment]: <> "---"


# RES-2021-Labo-SMTP

###### Alessando Parrino & Dylan Canton

###### 30.04.2021

---
### Description of project
This application allows you to send fake prank emails to a group of people.
To do this, you can specify a list of victims to form groups of people. Each group must consist of at least two receivers and one sender belonging to the list of victims, the number of groups created will be specified by the user. The sender victim will send the prank mail to each receiver, the email will contain a subject and content taken randomly from a list of messages. The main purpose is to make the receivers believe that the sender was the author of the message



---

### Setting up a mock SMTP server





---

### Instructions configuration

To change the application settings you can edit the **configuration.properties** file where you can define 3 parameters :
- server address
- server port
- number of people groups that the application should create



##### Configure text files

To modify the victims list or the message list that will compose the emails,
it is possible to edit the files contained in the **/data** folder, in this folder we find :
- **email.txt :** text files containing the emails of the victims, each email must be separated by a line return.
- **messages.txt :** text file containing the list of messages, as a convention we decided that the first line of the message represents the subject and the rest of the message represents the content of the mail. Each message is separated by a line return and a delimiter "---".

*Exemple: <br />
Dear Tina <br />
I love you. <br />
---*

#####  Launching a prank campaign





---

### Implementation
#### The application has been structured according to the following UML diagram: <br /><br />
![UML_diagram.png](figures/UML_diagram.png)

#### Class descriptions :

* **Person** : This class represents the person victim, it has an email address (the address should be valid).<br />
* **Group** : This class represents groups of people who are victims.<br />
* **Prank** : This class represents the prank that will appear in the email, it is composed of the **victim sender**, a list of **victim receivers** and the **prank message**.<br />
* **Email** : This class represents a real email, it consists of a recipient a list of recipients, a list of CC, a subject and a content.<br />
* **DataParser** : Class that takes care of parse our **.txt** files (contained in the /data folder) into Java objects.<br />
* **AppConfiguration** : This class contains the system configurations defined in the file **config.proprieties**.<br />
* **PrankMaker** : This class generates **"Prank"** randomly.<br />
* **SmtpClient** : **SMTP client** that takes care of sending emails, it is built using **Java Sockets** and requires an **IP address** and a **port**.<br />
* **MainApplication** : The main class of the application, it generates emails using **PrankMaker** and uses the SMTP client to send them. <br />

