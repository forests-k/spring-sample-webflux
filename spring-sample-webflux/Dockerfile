FROM openjdk:11-jdk-slim-sid

# recommended by spring boot
VOLUME /tmp

# create directory for output log
RUN mkdir /var/log/app

# create directory for application
RUN mkdir /app
WORKDIR /app

# jar target
ENV JAR_TARGET "spring-sample-webflux-0.0.1-SNAPSHOT.jar"

# set entrypoint to execute spring boot application
CMD ["sh","-c","java -jar -Dspring.profiles.active=docker build/libs/${JAR_TARGET}"]