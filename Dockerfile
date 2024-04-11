FROM openjdk:21-slim-buster

VOLUME /tmp

EXPOSE 8091

ADD ./target/yookassa-0.0.1-SNAPSHOT.jar Yookassa.jar

ENTRYPOINT ["java","-jar","/Yookassa.jar"]