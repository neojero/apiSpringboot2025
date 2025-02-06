FROM openjdk:21

# Exposer le port 9000
EXPOSE 9000

# Répertoire de travail dans le conteneur pour stocker le jar
WORKDIR /app

# Copie du fichier JAR recuperer de l'artefact de votre projet dans le conteneur
COPY apiprojet-0.0.1-SNAPSHOT.jar /app/apiprojet-0.0.1-SNAPSHOT.jar

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "apiprojet-0.0.1-SNAPSHOT.jar"]