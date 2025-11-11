# 🔹 Stage 1: Build with Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the full source
COPY . .

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# 🔹 Stage 2: Run with minimal JDK
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/cmd-football-backend-1.0.0.jar app.jar

EXPOSE 8080
ENV PORT=8080

ENTRYPOINT ["java", "-jar", "app.jar"]


