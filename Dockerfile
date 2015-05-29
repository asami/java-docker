FROM java
MAINTAINER asami

RUN apt-get update
RUN apt-get install -y redis-server

COPY entrypoint.sh /opt/entrypoint.sh

ENV COMMAND_JAR_DIR /opt/command.d

ENV COMMAND_JAR_NAME command.jar

ENV JAVA_OPTIONS=

VOLUME [$COMMAND_JAR_DIR"]

ENTRYPOINT ["/opt/entrypoint.sh"]
