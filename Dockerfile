FROM openjdk:8
ADD target/KafkaPublish.jar KafkaPublish.jar
EXPOSE 8082
ENTRYPOINT [ "java","-jar","KafkaPublish.jar" ]