FROM selenium/node-firefox-debug:3.5.3-astatine
LABEL authors=ISORTEGAH

USER root


RUN apt-get install tar ca-certificates wget

ENV MAVEN_VERSION=3.5.2

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

ENV MAVEN_HOME /usr/lib/mvn
#ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $MAVEN_HOME/bin:$PATH

#====================================
# Scripts to run Selenium Standalone
#====================================
COPY entry_point.sh /opt/bin/entry_point.sh
RUN chmod +x /opt/bin/entry_point.sh

USER seluser

EXPOSE 4444
EXPOSE 5900