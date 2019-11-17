package me.choi.demospring51propertyeditor;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 단 Converter Formatter 중 한개가 빈으로 등록 되어잇따면
* 설정파일(WebConfig) 을 삭제해도 됩니다.
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new EventConverter.StringToEventConverter());
//    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new EventFormatter());
    }

}
