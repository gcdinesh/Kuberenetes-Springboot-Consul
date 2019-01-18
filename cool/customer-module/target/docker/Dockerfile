FROM java:8
VOLUME /tmp
COPY customer-module-1.0-SNAPSHOT.jar /customer.jar
ADD application.yml /customer.yml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer.jar"]