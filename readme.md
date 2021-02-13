# Simply 를 테스트 하기 위한 환경 구성

## 사전 준비

1. JVM 설치 jdk 11 이상
2. docker 및 docker-compose의 설치
3. mariadb의 설치
4. kafka의 설치

### JVM 설치
1. 생략

### docker 설치
- https://docs.docker.com/engine/install/ubuntu/ 참고
  
### docker-compose 설치
- https://docs.docker.com/compose/install/ 참고

### Mariadb 설치
```shell
> docker pull mariadb
> docker container run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mariadb mariadb
```

dbeaver등의 client를 통해 Mariadb를 연결 후 database 및 계정을 생성한다.
```sql
CREATE DATABASE producer;
CREATE USER 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON producer.* TO 'test'@'%';
FLUSH PRIVILEGES;
```

### kafka 설치
docker-compose.yaml 을 생성한다.
```shell
vi docker-compose.yaml
```

하단의 내용을 붙여 넣는다.
```yaml
version: '2'
services:
  zookeeper:
    container_name: local-zookeeper
    image: wurstmeister/zookeeper:3.4.6
    ports:
      - "2181:2181"
  kafka:
    container_name: local-kafka
    image: wurstmeister/kafka:2.12-2.3.0
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 127.0.0.1
      KAFKA_ADVERTISED_PORT: 9092
      KAFKA_CREATE_TOPICS: "test_topic:1:1" # Topic명:Partition개수:Replica개수
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock

```

docker-compose를 통한 kafka 실행(docker-compose.yaml 이 존재하는 directory에서 실행)

```shell
[실행]
> docker-compose up -d

[종료]
> docker-compose down  
```

## 구현 과정
### 기본 UserService 생성
demo-user-spec의 User Entity를 사용하는 Service를 만든다.
- UserService
```java
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
}
```

```java
@Service
public class UserService extends AbstractServiceable<User, Long> {

    protected UserService(UserRepository repository) {
        super(repository);
    }
}
```

### Restful API 생성
UserService를 사용햐는 Controller를 만든다.
- Application.java
- UserController.java

Application.java
```java
@EnableSwagger2
@EnableSimplyControllable // <- 이것
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

```java
@RestController
@SimplyControllableResponse 
@RequestMapping("/users")
public class UserController extends AbstractControllable<User, Long> {
    public UserController(UserService service) {
        super(service);
    }

}
```

### Restful API Client 생성
UserController를 호출할 Client를 만든다.
- UserClient

UserService의 CUD를 전파할 Kafka Producer를 만든다.
- Application
```java
@EnableSwagger2
@EnableSimplyProducer // <- 이것 
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### Producer Kafka를 통해 Entity의 변경 전파 기능 생성
```java
@SimplyProducer // <- 이것
@Service
public class UserService extends AbstractServiceable<User, Long> {

    protected UserService(UserRepository repository) {
        super(repository);
    }
}
```

### Producer Kafka를 통해 Entity의 변경 수신 기능 생성
변경을 전파할 Entity 설정 
- Eventable 인터페이스를 구현한다. Long은 ID의 Type이다.

```java

@Getter
@Setter
@ToString
@Entity
public class User implements Eventable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
}
```

```java
@Slf4j
@Component
public class UserListener extends AbstractSimplyConsumer<User, Long> {
    protected UserListener() {
        super(User.class);
    }

    @Override
    public User onUpdate(String key, User entity) {
        log.info("UPDATE {}", entity.toString());
        return null;
    }

    @Override
    public User onCreate(String key, User entity) {
        log.info("CREATE {}", entity.toString());
        return entity;
    }

    @Override
    public Boolean onDelete(String key) {
        log.info("DELETE {}", key);
        return null;
    }
}
```