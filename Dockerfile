FROM java:8
LABEL mantainer="leandroamarillo95@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/tp01AmarilloZianni-0.0.1-SNAPSHOT.jar tp01AmarilloZianni-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "tp01AmarilloZianni-0.0.1-SNAPSHOT.jar"]