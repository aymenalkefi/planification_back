# --- Étape 1 : compilation ---
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY eplanification/pom.xml .
RUN mvn -B dependency:go-offline
COPY eplanification/src ./src
RUN mvn -B clean package -DskipTests

# --- Étape 2 : image finale légère ---
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]