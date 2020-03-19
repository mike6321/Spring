package me.choi.dynamically_registerbeans.using_injection_otherbean;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/19
 * Time : 11:54 오후
 */
public class MyBean {
    private OtherBean otherBean;

    public void setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }

    public void doSomething() {
        otherBean.doSomething();
    }

}
