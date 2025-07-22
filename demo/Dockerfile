# Étape 1 : Build de l'application avec Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copier le reste du code et construire l'application
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copier le JAR depuis le build Maven
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port de l’application (à adapter selon ton application)
EXPOSE 8080

# Lancer l’application
ENTRYPOINT ["java", "-jar", "app.jar"]
