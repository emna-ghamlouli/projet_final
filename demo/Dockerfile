# Étape 1 : builder
FROM maven:3.9.3-amazoncorretto-17 AS builder
WORKDIR /app

# Copier le projet Maven
COPY . .

# Compiler le projet et générer le JAR
RUN mvn clean package -DskipTests

# Étape 2 : image de production
FROM amazoncorretto:17
WORKDIR /app

# Copier uniquement le fichier JAR généré
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
