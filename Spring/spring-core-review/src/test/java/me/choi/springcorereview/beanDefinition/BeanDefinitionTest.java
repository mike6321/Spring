package me.choi.springcorereview.beanDefinition;

import me.choi.springcorereview.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:19 오전
 */
public class BeanDefinitionTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * beanDefinitionName = appConfigbeanDefinition = Generic bean: class [me.choi.springcorereview.AppConfig$$EnhancerBySpringCGLIB$$4891aa30]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null
     * beanDefinitionName = memberServicebeanDefinition = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberService; initMethodName=null; destroyMethodName=(inferred); defined in me.choi.springcorereview.AppConfig
     * beanDefinitionName = orderServicebeanDefinition = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=orderService; initMethodName=null; destroyMethodName=(inferred); defined in me.choi.springcorereview.AppConfig
     * beanDefinitionName = memberRepositorybeanDefinition = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberRepository; initMethodName=null; destroyMethodName=(inferred); defined in me.choi.springcorereview.AppConfig
     * beanDefinitionName = discountPolicybeanDefinition = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=discountPolicy; initMethodName=null; destroyMethodName=(inferred); defined in me.choi.springcorereview.AppConfig
     * */
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " +beanDefinitionName
                                 + "beanDefinition = " + beanDefinition);
            }
        }
    }


    /**
     * beanDefinitionName = memberServicebeanDefinition = Generic bean: class [me.choi.springcorereview.member.MemberServiceImpl]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [AppConfig.xml]
     * beanDefinitionName = orderServicebeanDefinition = Generic bean: class [me.choi.springcorereview.order.OrderServiceImpl]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [AppConfig.xml]
     * beanDefinitionName = memberRepositorybeanDefinition = Generic bean: class [me.choi.springcorereview.member.MemoryMemberRepository]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [AppConfig.xml]
     * beanDefinitionName = discountPolicybeanDefinition = Generic bean: class [me.choi.springcorereview.discount.RateDiscountPolicy]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [AppConfig.xml]
     * */
    GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("AppConfig.xml");
    @Test
    @DisplayName("빈 설정 메타정보 확인 (xml)")
    void findApplicationBeanXml() {
        String[] beanDefinitionNames = genericXmlApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = genericXmlApplicationContext.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " +beanDefinitionName
                        + "beanDefinition = " + beanDefinition);
            }
        }
    }
}
