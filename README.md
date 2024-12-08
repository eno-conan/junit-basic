# junit-basic
```sh
mvn clean jacoco:prepare-agent test jacoco:report
```

### MockBeanが非推奨になっていた
```
The type MockBean has been deprecated since version 3.4.0 and marked for removal
```
- [github issue](https://github.com/spring-projects/spring-boot/issues/43348)
- [spring Docs](https://docs.spring.io/spring-boot//api/java/org/springframework/boot/test/mock/mockito/MockBean.html)
- [@MockitoBean and @MockitoSpyBean](https://docs.spring.io/spring-framework/reference/testing/annotations/integration-spring/annotation-mockitobean.html)

##### 現在
```java
import org.springframework.boot.test.mock.mockito.MockBean;

@MockBean
private ApiServiceSub apiServiceSub; 
```

##### 今後
```java
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@MockitoBean
private ApiServiceSub apiServiceSub; 
```

### SpyとMock
- [検証についてまとめたノート](https://www.notion.so/8f7d364ff51c4ca193573295a0051836?v=fde9a4afda514095a3081cfea540bcb5&p=1568580db19580dcbc54d54c52d6f1a6&pm=s)