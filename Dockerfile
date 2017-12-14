FROM isortegah/standalone_firefox_debug

MAINTAINER ISORTEGAH <isortegah@gmail.com>

COPY entry_point.sh /opt/bin/entry_point.sh

RUN mkdir -p /home/seluser/testing
ADD  poc_setecudo.tar.gz /home/seluser/testing
WORKDIR /home/seluser/testing/poc_setecudo

RUN mvn install -DskipTests=true