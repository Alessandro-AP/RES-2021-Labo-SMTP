FROM openjdk:8-jre
MAINTAINER Dylan Canton <dylan.canton@heig-vd.ch>

#
# When we build the image, we copy the executable jar in the image file system. 
#
COPY executables/MockMock.jar /opt/app/SMTPmockServer.jar

#
# The mockserver use port 8282 for web interface and the port 25 for SMTP messages
#
EXPOSE 8282
EXPOSE 25

#
# This is the command that is executed when the Docker container starts
#
CMD ["java", "-jar", "/opt/app/SMTPmockServer.jar"]
