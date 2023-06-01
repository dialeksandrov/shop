FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM bellsoft/liberica-openjdk-alpine-musl:17
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/*.jar run.jar
ENTRYPOINT ["java","-jar","run.jar"]