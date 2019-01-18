FROM java:8
VOLUME /tmp
COPY shop-module-1.0-SNAPSHOT.jar /shop.jar
ADD application.yml /shop.yml
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/shop.jar"]