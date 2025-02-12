FROM openjdk:21

# definition des arguments
ARG USERNAME
ARG PASSWORD

# variables d'environnement
ENV APP_HOME=/app
# Définir des variables d'environnement
# cela permet de forcer le paramétrage de Springboot pour coller
# à notre conteneur
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql_server:3306/springboot
# ce n'est pas parfait car donnée sensible
ENV SPRING_DATASOURCE_USERNAME=$USERNAME
ENV SPRING_DATASOURCE_PASSWORD=$PASSWORD
# ici ce sont des parametres Dialect de Springboot pour la connexion BDD
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQL8Dialect
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true

# Créer un répertoire pour l'application
WORKDIR $APP_HOME

# Exposer le port sur lequel l'application va tourner
EXPOSE 9000

# Copier le fichier JAR de l'application Spring Boot
# Copie du fichier JAR recuperer de l'artefact de votre projet dans le conteneur
COPY apiprojet-0.0.1-SNAPSHOT.jar /app/apiprojet-0.0.1-SNAPSHOT.jar

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "apiprojet-0.0.1-SNAPSHOT.jar"]