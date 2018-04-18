FROM java:8
RUN mkdir -p /usr/src/myapp
WORKDIR .
ADD ./target/coe-spring-web-0.0.1-SNAPSHOT.jar /usr/src/myapp/coe-spring-web-0.1.0.jar
WORKDIR /usr/src/myapp
VOLUME /tmp
EXPOSE 8090
RUN java -jar coe-spring-web-0.1.0.jar
#CMD echo "The application will start in 3s..." && \
 #       java -jar coe-spring-web-0.1.0.jar
