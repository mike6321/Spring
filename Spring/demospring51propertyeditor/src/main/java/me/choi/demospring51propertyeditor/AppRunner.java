package me.choi.demospring51propertyeditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ConversionService conversionService;

    /*
    * 어라? 나는 분명 conversionService 를 빈으로 등록하였는데
    * WebConversionService 이것이 나오네?
    * WebConversionService :: DefaultFormattingConversionService를 상속해서 만든 클래
    * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(conversionService.getClass().toString());
    }
}
