FROM openjdk:14
VOLUME /tmp
EXPOSE 9090
COPY cobenapp-1.0.0.jar /cobenapp-1.0.0.jar
ENTRYPOINT ["java","-jar","cobenapp-1.0.0.jar"]