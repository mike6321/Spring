package me.whiteship.demospring51singletonapplication;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {
    /*
    * 프로토타입 scope은 매번 새로운 빈을 생성해야할때 사용합니다.*/
}
