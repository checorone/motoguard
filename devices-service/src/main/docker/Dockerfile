FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/devicesservice
ADD @project.build.finalName@.jar /usr/local/devicesservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
