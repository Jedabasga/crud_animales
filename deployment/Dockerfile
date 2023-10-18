#FROM amazoncorretto:17-alpine
#VOLUME /tmp
#RUN sh -c 'touch /animales.jar'
#ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar animales.jar" ]
FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY *.jar animales.jar
RUN adduser -D -g '' appuser && chown appuser: /animales.jar
USER appuser
RUN sh -c 'touch /animales.jar'
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar animales.jar" ]