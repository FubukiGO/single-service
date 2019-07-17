FROM java:8-jre
MAINTAINER baba <wzysz888@gmail.com>
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

ADD ./target/single-admin.jar /app/

EXPOSE 8025

CMD ["java", "-Xmx500m", "-jar", "-Dspring.profiles.active=test", "/app/single-admin.jar"]