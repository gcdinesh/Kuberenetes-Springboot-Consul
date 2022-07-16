FROM azul/zulu-openjdk-alpine:11.0.13-11.52.13-jre-headless-x86
ENV JAR_PATH = /opt/account

RUN mkdir -p $JAR_PATH

#RUN addgroup -S shopper_account && adduser -S -g shopper_account shopper_account
#USER shopper-account

ADD target/account-1.0-SNAPSHOT.jar /opt/account.jar
ADD target/classes/application.yml /opt/application.yml

# 4452 -> health check, 8890 -> application http start port
EXPOSE 4452 8890

ENTRYPOINT ["java", "-jar", "/opt/account.jar"]