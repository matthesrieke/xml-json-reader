FROM openjdk:8

COPY target/xml-json-reader-0.0.1-SNAPSHOT.jar /xml-json-reader.jar

CMD ["java", "-jar", "xml-json-reader.jar"]
