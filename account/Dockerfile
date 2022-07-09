FROM azul/zulu-openjdk-alpine:8u282-8.52.0.23

ENV JAR_PATH = /opt/account

RUN mkdir -p $JAR_PATH

#RUN addgroup -S shopper_account && adduser -S -g shopper_account shopper_account
#USER shopper-account

ADD target/account-1.0-SNAPSHOT.jar /opt/account.jar

# 4452 -> health check, 8890 -> application http start port
EXPOSE 4452 8890

ENTRYPOINT ["java", "-jar", "/opt/account.jar"]