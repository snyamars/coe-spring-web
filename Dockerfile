FROM java:8
RUN mkdir -p /usr/src/myapp
WORKDIR .
ADD ./target/coe-spring-web-0.1.0.jar /usr/src/myapp/coe-spring-web-0.1.0.jar
WORKDIR /usr/src/myapp
VOLUME /tmp
EXPOSE 8090
RUN java -jar coe-spring-web-0.1.0.jar
