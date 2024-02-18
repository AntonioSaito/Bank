FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/sua-aplicacao.jar .

CMD ["java", "-jar", "SaitoBank.jar"]