# Bean 동작원리 (3) - refresh()

~~~java
public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
		this();
		register(componentClasses);
		refresh();
	}
~~~

### 여기에서 refresh(); 를 살펴 볼 것이다. 

------

~~~java
ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
~~~



ConfigurableListableBeanFactory 타입의 beanFactory 초기화 (실제론 **ConfigurableListableBeanFactory** 타입)

- *DefaultListableBeanFactory* 에서 *serialiaztionId* 초기화

![image](https://user-images.githubusercontent.com/33277588/75787365-f5a04900-5da9-11ea-8107-3b4834288bae.png)

*AbstractApplicationContext* 하위의 *GenericApplicationContextdp*에도 *BeanFactory* 설정 

![image](https://user-images.githubusercontent.com/33277588/75787513-2da78c00-5daa-11ea-8392-5752cc326670.png)

------



### prepareBeanFactory

```java
beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
beanFactory.ignoreDependencyInterface(EnvironmentAware.class);
beanFactory.ignoreDependencyInterface(EmbeddedValueResolverAware.class);
beanFactory.ignoreDependencyInterface(ResourceLoaderAware.class);
beanFactory.ignoreDependencyInterface(ApplicationEventPublisherAware.class);
beanFactory.ignoreDependencyInterface(MessageSourceAware.class);
beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);
```

beanFactory에 대한 기본 정보를 저장한다.

```java
if (!beanFactory.containsLocalBean(ENVIRONMENT_BEAN_NAME)) {
   beanFactory.registerSingleton(ENVIRONMENT_BEAN_NAME, getEnvironment());
}
if (!beanFactory.containsLocalBean(SYSTEM_PROPERTIES_BEAN_NAME)) {
   beanFactory.registerSingleton(SYSTEM_PROPERTIES_BEAN_NAME, getEnvironment().getSystemProperties());
}
if (!beanFactory.containsLocalBean(SYSTEM_ENVIRONMENT_BEAN_NAME)) {
   beanFactory.registerSingleton(SYSTEM_ENVIRONMENT_BEAN_NAME, getEnvironment().getSystemEnvironment());
}
```

이때 환경설정 정보는 미리 싱글톤에 등록한다.

------

