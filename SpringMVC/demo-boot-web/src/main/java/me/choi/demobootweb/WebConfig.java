package me.choi.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor()).order(-1)
                                                            .addPathPatterns("/hi");
    }
    // TODO:  junwoochoi 10/02/2020 9:36 오후
    // 리소스 핸들러 추가    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                .addResourceLocations("classpath:/mobile/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }

    // TODO:  junwoochoi 10/02/2020 10:34 오후
    // http 메세지 컨버터 설정
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.
    }
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }
}
