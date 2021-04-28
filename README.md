# RES-2021-Labo-SMTP

###### Alessando Parrino & Dylan Canton

###### 02.04.2021

---

### Design de l'application

**Protocol SMTP** :

 https://tools.ietf.org/html/rfc5321#appendix-D



**Fichiers de configuration : (texte)** 

* Fichier texte de config pour les mails victimes

* Fichier texte de config pour les messages



**Traitement des fichiers de config : **

* Une classe de configuration pour les paramètres du serveur : 

  * Adresse du serveur

  * Port

  * Nombre de groupes

* Une classe de configuration pour traiter les fichiers de config (Va parser les données et mettre les adresses dans une liste <Person>)



**Création des pranks :** 

* Objet Group : contient des Person
* Objet Person : représente une personne (adresse mail)
* Objet Message : contient le message (En-tête : From, To, Cc, Subject et le texte du message)

* Objet Prank qui contient l'envoyeur, le(s) destinataire(s) et le message.
* Un fichier PrankMaker va créer un Prank d'après les classes Groupe, Victimes, Message



**Client SMTP :**

* Connecter au serveur SMTP avec un socket
* Récupérer un objet Prank et l'utiliser pour envoyer un mail. 



---

### Description of project





---

### Setting up a mock SMTP server





---

### Instructions configuration

##### Configure text files

#####  Launching a prank campaign





---

### Implementation

