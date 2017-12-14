FROM isortegah/openjdk_maven

MAINTAINER ISORTEGAH <isortegah@gmail.com>


RUN mkdir -p /home/seluser/testing
ADD  poc_setecudo.tar.gz /home/seluser/testing
WORKDIR /home/seluser/testing/poc_setecudo

RUN mvn install -DskipTests=true