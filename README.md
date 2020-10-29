# PROJET DE GESTION ECOLE CAS : ENSUP 

## PREREQUIS: 

Installer [tomcat 8](https://tomcat.apache.org/download-80.cgi)

Installer [mysql](https://dev.mysql.com/downloads/installer/)

## POCEDURES:

### ETAPE 1 : 
  Clonez le projet a partir du repository ```git clone https://github.com/timziba/AuditPartiel.git```

### ETAPE 2 : 
  Créer la base de donnée : ```create database demojpa;```

  Executer le fichier .sql situé dans la répertoire BDD du repository.

  Ouvrir le fichier de configuration AuditPartiel/gesensup-dao/src/main/resources/META-INF/persistencce.xml

  Changer les parametres de connection de la base de données selon votre configuration.

  Paramètres par défaut
    
  > url : localhost:3306/demojpa
  >
  > login : root
  >
  > password :

### ETAPE 3 :
  Ouvrir une ligne de commande depuis la racine du repository local
  
  Exécuter la commande ```mvn clean package```
  
  Récupérer et déployer dans tomcat le fichier "AuditPartiel/gesensup-web/target/gesensup-web.war"
  
### ETAPE 4 : 
  Accéder à "localhost:8080/gesensup-web/"
  
  Connecter vous à l'application avec 
  
  > login : admin 
  > 
  > password : admin


