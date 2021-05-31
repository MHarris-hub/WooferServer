FROM alpine

RUN apk add openjdk8
EXPOSE 9000
COPY build/libs/woofer-server-0.0.1-SNAPSHOT.jar usr/local/tomcat/webapps/woofer-server-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","usr/local/tomcat/webapps/demo-0.0.1-SNAPSHOT.jar"]

