FROM azul/zulu-openjdk-alpine:8u282-8.52.0.23

ENV JAR_PATH = /opt/product

RUN mkdir -p $JAR_PATH

#RUN addgroup -S shopper_product && adduser -S -g shopper_product shopper_product
#USER shopper-product

ADD target/product-1.0-SNAPSHOT.jar /opt/product.jar

# 4452 -> health check, 8890 -> application http start port
EXPOSE 4452 8890

ENTRYPOINT ["java", "-jar", "/opt/product.jar"]