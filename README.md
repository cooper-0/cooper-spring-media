# Cooper 음성 채널 서버

WebRTC 시그널링 서버 + ~~Kurento 미디어 서버 (구현중)~~


# Getting Started

### Prerequisites

src/main/resources/ 위치에 `application.properties` or `application.yml` 추가
* application.properties
  ```
  spring.application.name=cooper-media
  server.port = 0

  spring.datasource.url=jdbc:mysql://{your db adress}
  spring.datasource.username={your username}
  spring.datasource.password={your password}
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

  spring.jpa.hibernate.ddl-auto=update

  spring.thymeleaf.prefix=classpath:/templates/
  spring.thymeleaf.suffix=.html
  spring.thymeleaf.check-template-location=true

  eureka.client.register-with-eureka=true
  eureka.client.fetch-registry=true
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka
  eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
  ```
* application.yml
  ```
  server:
    port: 0

  spring:
    application:
      name: cooper-media
  
    datasource:
      url: {your db adress}
      username: {your username}
      password: {your password}
      driver-class-name: com.mysql.cj.jdbc.Driver
  
    devtools:
      livereload:
        enabled: true
  
    thymeleaf:
      prefix: classpath:/templates/
      suffix: .html
      cache: false
      check-template-location: true
  
  eureka:
    client:
      register-with-eureka: true
      fetch-registry: true
      service-url:
        defaultZone: http://localhost:8761/eureka
    instance:
      instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}
  ```
  
### Reference Documentation

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [WebSocket](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#messaging.websockets)
