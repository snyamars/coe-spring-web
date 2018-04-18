FROM java:8
RUN mkdir -p /usr/src/myapp
WORKDIR .
ADD ./target/coe-spring-webpromote-0.0.1-SNAPSHOT.jar /usr/src/myapp/coe-spring-webpromote-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/myapp
VOLUME /tmp
EXPOSE 8091
#RUN java -jar coe-spring-web-0.1.0.jar
CMD java -jar coe-spring-webpromote-0.0.1-SNAPSHOT.jar
