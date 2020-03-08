

# Bean 동작원리 (3) - refresh()

> 굉장히 장황할 것이다. 그냥 코드 분석이기에... 
>
> 어느정도 이해가 간다면 블로그에 간추려서 정리할 것이다.
>
> 얼마가 걸려도 완벽하게 한번 해보자



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



ConfigurableListableBeanFactory 타입의 beanFactory 초기화 (실제론 **DefaultListableBeanFactory** 타입)

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

- ENVIRONMENT_BEAN_NAME
- SYSTEM_ENVIRONMENT_BEAN_NAME
- SYSTEM_PROPERTIES_BEAN_NAME

* *DefaultListableBeanFactory* 에서 싱글톤 등록 (registerSingleton)

------

### invokeBeanFactoryPostProcessors(beanFactory);

#### 등록된 BeanFactoryPostProcessor의 모든 bean들을 초기화하고 invoke 한다.

해당 메서드에서 특이한 점은 postProcessor 핸들링을 PostProcessorRegistrationDelegate로 위임했다.

PostProcessorRegistrationDelegate는 **final** 클래스이다.

final 클래스라는것은 해당 클래스는 상속이 불가하다는 것이다. 위임한 책임을 어느 누구에게도 책임지우지 않고 자신이 책임진다라고 생각하겠다.



던지는 아규먼트는 

1. DefaultListableBeanFactory에 저장된 BeanFactory 정보

2. BeanFactoryPostProcessor 



BeanDefinitionRegistry인지 타입 체킹을 한다. DefaultListableBeanFactory는 구현체 임을 알 수 있다.

![image](https://user-images.githubusercontent.com/33277588/75788400-875c8600-5dab-11ea-8aa6-59c139c7311f.png)

------



#### beanFactory에 등록된 postProcessor 명을 가지고 온다.

```java
String[] postProcessorNames =
      beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
```

BeanDefinitionRegistryPostProcessor 클래스를 아규먼트로 전송한다.

![image](https://user-images.githubusercontent.com/33277588/75898147-053c9200-5e7d-11ea-8ad6-9a4125493a0f.png)



결론적으로 internalConfigurationAnnotaionProcessor를 가지고온다.

![image](https://user-images.githubusercontent.com/33277588/75793864-51230480-5db3-11ea-9e48-5fa4c6eb1111.png)

------

### 해당 결과를 가져오는 과정을 살펴보자

BeanDefinitionRegistryPostProcessor 클래스에 대한 정보를 중심으로 처리한다.

**DefaultListableBeanFactory** 클래스에 모든 과정이 이루어진다.



### **doGetBeanNamesForType**

해당 클래스에는 이전에 처리하였던 bean에 대한 정보들이 있다.

![image](https://user-images.githubusercontent.com/33277588/75794276-e58d6700-5db3-11ea-9dda-48616439a113.png)

##### 위의 bean들을 루프를 돌면서 factoryBean인지에 대한 여부 체크

------



#### 1. RootBeanDefinition의 초기화

```java
RootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);
```

RootBeanDefinition의 객체를 생성하고 해당 객체에 singleton임을 set 한다. (AbstractBeanFactory)

```java
private final Map<String, RootBeanDefinition> mergedBeanDefinitions = new ConcurrentHashMap<>(256);
```

그리고 이전에 저장하였던 bean에 대한 이름과 RootBeanDefinition의 정보를 put한다.

![image](https://user-images.githubusercontent.com/33277588/76142868-2091e200-60b5-11ea-986a-d5a87384ef70.png)

![image](https://user-images.githubusercontent.com/33277588/76142915-71093f80-60b5-11ea-9adc-1cb2ff5d209f.png)

scope이 싱글톤이고 beanClass가 ConfigurationClassPostProcessor인 점에 주목하자!

ConfigurationClassPostProcessor은 이전에 DefaultListatbleBeanFactory의 beanDefinitionMap에 저장되어있는 key와 일치하는 정보를 가져오는 것이다.

예를 들자면 internalConfigurationAnnotaionProcessor의 value는 ConfigurationClassPostProcessor 이다.

internalConfigurationAnnotaionProcessor : ConfigurationClassPostProcessor

![image](https://user-images.githubusercontent.com/33277588/76160623-061c3f00-616f-11ea-95ca-e08722588b9c.png)

------



#### 팩토리 빈에 대한 검증 (AbstractFactory에서 진행)



타입체킹은 AbstractAutowireCapableBeanFactory에서 이루어진다. - predictBeanType



AbstractBeanDefinition에 저장되어있는 ConfigurationClassPostProcessor를 가지고 온다.

![image](https://user-images.githubusercontent.com/33277588/75900155-d5db5480-5e7f-11ea-93d7-258e847c3d8f.png)

FactoryBean와 ConfigurationClassPostProcessor 비교하여 팩토리 빈임을 결정하는데 아쉽게도 아니다.



> **factoryBean**
>
> Spring의 일반적인 DI패턴으로 생성하기 힘든 객체를 Spring에서 생성/관리하고자 할 때 Wrapping 기능 제공( 타 객체에 의존성 주입 등 )
>
> Spring을 대신하여 사용자가 getObject를 구현하고 적절히 Instance를 생성하여 리턴하여 준다.



```java
FactoryBean.class.isAssignableFrom(beanType)
```

여기 위의 모든 빈들은 팩토리빈이 아니다.



```java
return typeToMatch.isAssignableFrom(predictedType);
```



**ConfigurationClassPostProcessor**와 **BeanDefinitionRegistryPostProcessor**를 비교하여 할당가능한지를 체크한다.

가능하다면 true를 리턴하여 리스트에 저장한다.

결과적으로 internalConfigurationAnnotaionProcessor만이 저장된다.

------



### isTypeMatch

```java
predictedType = predictBeanType(beanName, mbd, typesToMatch);
```

여기서 리턴결과를 받아서

```java
return typeToMatch.isAssignableFrom(predictedType);
```

typeToMatch를 실행해서 해당 타입이 할당가능한지 여부를 판단해서 

true이면 List<String> result = new ArrayList<>(); 해당 리스트에 저장한다.



해당 과정은 **AbstractAutowireCapableBeanFactory**에서 진행한다.

```java
@Override
@Nullable
protected Class<?> predictBeanType(String beanName, RootBeanDefinition mbd, Class<?>... typesToMatch) {
   Class<?> targetType = determineTargetType(beanName, mbd, typesToMatch);
   // Apply SmartInstantiationAwareBeanPostProcessors to predict the
   // eventual type after a before-instantiation shortcut.
   if (targetType != null && !mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
      boolean matchingOnlyFactoryBean = typesToMatch.length == 1 && typesToMatch[0] == FactoryBean.class;
      for (BeanPostProcessor bp : getBeanPostProcessors()) {
         if (bp instanceof SmartInstantiationAwareBeanPostProcessor) {
            SmartInstantiationAwareBeanPostProcessor ibp = (SmartInstantiationAwareBeanPostProcessor) bp;
            Class<?> predicted = ibp.predictBeanType(targetType, beanName);
            if (predicted != null &&
                  (!matchingOnlyFactoryBean || FactoryBean.class.isAssignableFrom(predicted))) {
               return predicted;
            }
         }
      }
   }
   return targetType;
}
```



즉 결론적으로 아규먼트로 전송한 BeanDefinitionRegistryPostProcessor와 RootBeanDefinition에서 받아온 ConfigurationClassPostProcessor와 비교한다.

![image](https://user-images.githubusercontent.com/33277588/76143045-ee817f80-60b6-11ea-8abc-bf0898931a09.png)

결론적으로 internalConfigurationAnnotaionProcessor만이 BeanDefinitionRegistryPostProcessor와 타입 할당이 가능하여 result에 add 된다.

![image](https://user-images.githubusercontent.com/33277588/76143078-55069d80-60b7-11ea-854e-08fd57f8bc6c.png)

------

### invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);

이전에 **PriorityOrdered** 클래스와 타입매치를 비교하여 true가 나왔으므로 

currentRegistryProcessors 리스트에 해당 정보를 저장한다. 저장되는 정보는 ConfigurationClassPostProcessor이다.



```java
invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
```

이제 해당 메서드를 실행한다. 빈에대한 정보와 ConfigurationClassPostProcessor를 가져간다.



```java
private static void invokeBeanDefinitionRegistryPostProcessors(
      Collection<? extends BeanDefinitionRegistryPostProcessor> postProcessors, BeanDefinitionRegistry registry) {

   for (BeanDefinitionRegistryPostProcessor postProcessor : postProcessors) {
      postProcessor.postProcessBeanDefinitionRegistry(registry);
   }
}
```

![image](https://user-images.githubusercontent.com/33277588/76143174-8df34200-60b8-11ea-962f-4b2a86a61fe9.png)



해당 과정은 BeanDefinitionRegistryPostProcessor 하위의 **ConfigurationClassPostProcessor**에서 진행한다.

registry에 대한 해쉬코드값을 계산하여  Set에 입력한다.

해당과정 이후에

```java
processConfigBeanDefinitions(registry);
```

위의 메서드를 실행한다.

------

### processConfigBeanDefinitions



```java
public void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
		List<BeanDefinitionHolder> configCandidates = new ArrayList<>();
		String[] candidateNames = registry.getBeanDefinitionNames();

		for (String beanName : candidateNames) {
			BeanDefinition beanDef = registry.getBeanDefinition(beanName);

			else if (ConfigurationClassUtils.checkConfigurationClassCandidate(beanDef, this.metadataReaderFactory)) {
				configCandidates.add(new BeanDefinitionHolder(beanDef, beanName));
			}
		}
```

아래 체크 메서드에서 AnnotaionBeanDefinition에 대한 타입인지 체킹하는 validation 과정이 이루어 진다.

```java
checkConfigurationClassCandidate
```



**AnnotationBeanDefinition**의 타입이고 해당 클래스의 메타 데이터에 해당 클래스가 존재하는 것은 우리가 생성한 BookFactory밖에 없다. (메타 데이터는 AnnotatedGenericBeanDefinition에 저장되어있다. - StandardAnnotaionMetadata)

```java
beanDef instanceof AnnotatedBeanDefinition
```



BookFactory의 메타데이터 정보를 가져온다.

가져온 메타데이터에서 Configuration 어노테이션에대한 정보를 뽑아온다.

![image](https://user-images.githubusercontent.com/33277588/76144281-04e10880-60c2-11ea-892c-254131579eab.png)

해당 정보가 NULL이 아니고 **proxyBean**이 아니면 beanDefinition에 **Configuration** 정보를 set 한다.

```java
beanDef.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_FULL);
```

![image](https://user-images.githubusercontent.com/33277588/76161259-fdc70280-6174-11ea-83a0-1de68f11814c.png)



그 결과를 beanDefinition (빈의 정보), beanName(빈의 이름) 의 파라미터로 가지는 beanDefinitionHolder 객체를 생성해서 

```java
List<BeanDefinitionHolder> configCandidates = new ArrayList<>();
```

위의 리스트에 add 한다.

```java
configCandidates.add(new BeanDefinitionHolder(beanDef, beanName));
```

이제 configCandidates에 담긴 정보를 가지고 가공을 한다.

------

```java
Set<BeanDefinitionHolder> candidates = new LinkedHashSet<>(configCandidates);
```

BookFactory에 대한 정보를 담는 리스트 객체를 생성한다.

------



### parser.parse(candidates); : Configuration 클래스를 파싱한다.



```java
ConfigurationClassParser parser = new ConfigurationClassParser(
      this.metadataReaderFactory, this.problemReporter, this.environment,
      this.resourceLoader, this.componentScanBeanNameGenerator, registry);
```

ConfigurationClassParser 객체를 생성한다.

이때 생성자의 파라미터에 registry와 componentScanBeanNameGenerator - AnnotationBeanNameGenerator의 인스턴스를 전달한다는 것에 주목하자

------

### 파싱시작 (ConfigurationClassParser)

```java
parser.parse(candidates);
```

canditates에는 BeanDefinitionHoler객체 (빈 이름, 빈정보) 가 담겨있다. 

담겨있는 정보는 이전에 validation 을 통과한 BookFactory 정보이다.

![image](https://user-images.githubusercontent.com/33277588/76161845-8bf1b780-617a-11ea-92ee-19ff8d8d07cc.png)



ConfigurationClass 객체 생성 후 파싱 메세지 전달

```java
processConfigurationClass(new ConfigurationClass(metadata, beanName));
```



Meta데이터 정보에서 introspect에 저장되어있는 클래스 정보를 가져온다.

```java
private Set<MethodMetadata> retrieveBeanMethodMetadata(SourceClass sourceClass) {
   AnnotationMetadata original = sourceClass.getMetadata();
   Set<MethodMetadata> beanMethods = original.getAnnotatedMethods(Bean.class.getName());
   if (beanMethods.size() > 1 && original instanceof StandardAnnotationMetadata) {
      // Try reading the class file via ASM for deterministic declaration order...
      // Unfortunately, the JVM's standard reflection returns methods in arbitrary
      // order, even between different runs of the same application on the same JVM.
      try {
         AnnotationMetadata asm =
               this.metadataReaderFactory.getMetadataReader(original.getClassName()).getAnnotationMetadata();
         Set<MethodMetadata> asmMethods = asm.getAnnotatedMethods(Bean.class.getName());
         if (asmMethods.size() >= beanMethods.size()) {
            Set<MethodMetadata> selectedMethods = new LinkedHashSet<>(asmMethods.size());
            for (MethodMetadata asmMethod : asmMethods) {
               for (MethodMetadata beanMethod : beanMethods) {
                  if (beanMethod.getMethodName().equals(asmMethod.getMethodName())) {
                     selectedMethods.add(beanMethod);
                     break;
                  }
               }
            }
            if (selectedMethods.size() == beanMethods.size()) {
               // All reflection-detected methods found in ASM method set -> proceed
               beanMethods = selectedMethods;
            }
         }
      }
      catch (IOException ex) {
         logger.debug("Failed to read class file via ASM for determining @Bean method order", ex);
         // No worries, let's continue with the reflection metadata we started with...
      }
   }
   return beanMethods;
}
```

1. Bean 어노태이션이 있는지 확인 (getAnnotatedMethods -> StandardAnnotationMetadate)

```java
original.getAnnotatedMethods(Bean.class.getName());
```

getAnnotatedMethod를 진행하면 @Bean으로 생성된 모든 메서드를 가져오게 된다.

우리는 아래와 같이 네가지 메서드를 빈으로 등록하였다.

```java
@Configuration
public class BookFactory {

    @Bean
    public BookService bookService() {
        return new BookService(connectionMaker());
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(connectionMaker());
    }
    @Bean
    public MessageService messageService() {
        return new MessageService(connectionMaker());
    }

    @Bean
    public AConnectionMaker connectionMaker() {
        return new AConnectionMaker();
    }
}
```

![image](https://user-images.githubusercontent.com/33277588/76161958-ad06d800-617b-11ea-9193-7083b484bc1b.png)



여기서 잠깐 **AnnotationBeanDefinition** 의 타입이면 Configuration 으로 등록된다는 점을 다시한번 상기하고 가자!

파싱결과 configurationClass 정보는 하기와 같은 정보가 담겨지게 된다.

![image](https://user-images.githubusercontent.com/33277588/76162063-de33d800-617c-11ea-8ce8-fa0a6edf6d1a.png)

------

```java
Set<ConfigurationClass> configClasses = new LinkedHashSet<>(parser.getConfigurationClasses());
```

해당정보를 Set에 담는다.

### [ConfigurationClassBeanDefinitionReader]

여기서 beanDefinition에 대한 정보를 담는다 autowired인지... 등등 현재는 autowired가 사용되지 않았기 떄문에 NO이다.

```java
for (BeanMethod beanMethod : configClass.getBeanMethods()) {
   loadBeanDefinitionsForBeanMethod(beanMethod);
}
```





