# Use Alpine Linux as base image
FROM openjdk:11-jdk-alpine

# Install Tomcat
RUN apk add --no-cache wget \
    && wget https://archive.apache.org/dist/tomcat/tomcat-10/v10.1/bin/apache-tomcat-10.1.tar.gz \
    && tar -xvf apache-tomcat-10.1.tar.gz \
    && mv apache-tomcat-10.1 /usr/local/tomcat \
    && rm apache-tomcat-10.1.tar.gz

# Copy your JSP/Servlet project
COPY MemberRegistration.war /usr/local/tomcat/webapps/

# Expose ports
EXPOSE 8080

# Start Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
