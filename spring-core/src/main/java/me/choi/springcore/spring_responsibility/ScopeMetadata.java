package me.choi.springcore.spring_responsibility;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/07
 * Time : 10:50 오후
 */
public class ScopeMetadata {
    private String scopeName = BeanDefinition.SCOPE_SINGLETON3;


    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }
}
