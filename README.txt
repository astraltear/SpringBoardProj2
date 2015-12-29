Spring MVC 4.1.7
spring jdbc
mysql connector
mybatis mybatis-config.xml
log4jdbc-log4j2  log4jdbc.log4j2.properties
logback.xml
jackson
spring tx
spring aop

## database + mybatis 설정 
	sqlSessionTemplate+sqlSessionFactoryBean(mybatis)
	
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
		<property name="url" value="jdbc:log4jdbc:mysql://127.0.0.1/book_ex?useUnicode=true&amp;characterEncoding=utf8"></property>
		<property name="username" value="test" />
		<property name="password" value="test" />
	</bean>
	
	
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:/mybatis-config.xml"></property>
		<property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"></property>
	</bean>
	
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
	</bean>

## 트랜잭션 매니저(http://blog.outsider.ne.kr/870)
	 com.youngjee.service.MessageServiceImpl
	 tx:advice : 선언적 트랜잭션
	 tx:annotation-driven : 명시적 어노테이션 지정 방법 
	 
	 @Transactional
	 
	 <tx:annotation-driven/>
		
	 <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	 </bean>

## AOP
	com.youngjee.aop.SampleAdvice
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	@Aspect
	@Before("execution(* com.youngjee.service.MessageService*.*(..))")
	@Around("execution(* com.youngjee.service.MessageService*.*(..) )")
	@After("execution(* com.youngjee.service.MessageService*.*(..))")
	
## com.youngjee.controller.CommonExceptionAdvice
	@ControllerAdvice
	@ExceptionHandler(Exception.class)

## com.youngjee.controller.MessageController
## com.youngjee.controller.RestSampleController
	@RestController
	ResponseEntity
	@Inject
