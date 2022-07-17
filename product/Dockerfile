FROM azul/zulu-openjdk-alpine:11.0.13-11.52.13-jre-headless-x86
ENV JAR_PATH = /opt/product

RUN mkdir -p $JAR_PATH

#RUN addgroup -S shopper_product && adduser -S -g shopper_product shopper_product
#USER shopper-product

ADD target/product-1.0-SNAPSHOT.jar /opt/product.jar
ADD target/classes/application.yml /opt/application.yml

# 4452 -> health check, 8890 -> application http start port
EXPOSE 4452 8890

ENTRYPOINT ["java", "-jar", "/opt/product.jar"]