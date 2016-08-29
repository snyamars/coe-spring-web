FROM java:8
RUN mkdir -p /usr/src/myapp
COPY target/coe-spring-web-0.1.0.jar /usr/src/myapp/
WORKDIR /usr/src/myapp
EXPOSE 8090
RUN java -jar coe-spring-web-0.1.0.jar
