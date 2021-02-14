package me.choi.springcorereview.requestscope.web;

import lombok.RequiredArgsConstructor;
import me.choi.springcorereview.requestscope.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 3:43 오후
 */
// TODO: request Scope Example1 - 서버 기동 시 오류 발생 2021/02/14 3:51 오후
/**
 * 오류발생이유
 * MyLogger의 Scope은 현재 request이다.
 * request의 생명주기는 요청이 들어오고 요청이 끝날때 까지이다.
 *
 * 근데 서버를 기동하면 스프링컨테이너에 LogDemoController를 Bean들을 등록 후
 * 의존관계에 있는 Bean들도 등록하게 되는대
 *
 * MyLogger는 request Scope이기에 요청이 아직 들어오지 않은 상태에서는 빈을 생성할 수 없기에
 * 스프링은 오류를 뱉어버린다.
 *
 * Error creating bean with name 'logDemoService' defined in file [/Applications/WorkingDirectory/repository/Spring/Spring/spring-core-review/out/production/classes/me/choi/springcorereview/requestscope/web/LogDemoService.class]:
 * Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.support.ScopeNotActiveException: Error creating bean with name 'myLogger': Scope 'request' is not active for the current thread;
 * consider defining a scoped proxy for this bean if you intend to refer to it from a singleton; nested exception is java.lang.IllegalStateException: No thread-bound request found:
 * Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? If you are actually operating within a web request and still receive this message, your code is probably running outside of DispatcherServlet: In this case, use RequestContextListener or RequestContextFilter to expose the current request.
 * */

// TODO: request Scope Example1 - ObjectProvider의 사용 2021/02/14 4:09 오후
//@Controller
//@RequiredArgsConstructor
//public class LogDemoController {
//
//    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
//
//    @RequestMapping("log-demo")
//    @ResponseBody
//    public String logDemo(HttpServletRequest request) throws InterruptedException {
//        MyLogger myLogger = myLoggerObjectProvider.getObject();
//        String requestURL = request.getRequestURI().toString();
//        myLogger.setRequestURL(requestURL);
//
//        myLogger.log("controller test");
//        Thread.sleep(1000);
//        logDemoService.logic("testId");
//
//        return "OK";
//    }
//}

// TODO: proxyMode 적용 2021/02/14 4:20 오후
/**
 * @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
 *
 * my Loggerclass me.choi.springcorereview.requestscope.common.MyLogger$$EnhancerBySpringCGLIB$$f05d6583
 * [df339add-f454-4d7e-bfb5-bec9b56744b2] request scope bean create : me.choi.springcorereview.requestscope.common.MyLogger@617f32f8
 * [df339add-f454-4d7e-bfb5-bec9b56744b2] [/log-demo] [controller test]
 * [df339add-f454-4d7e-bfb5-bec9b56744b2] [/log-demo] [service id = testId]
 * [df339add-f454-4d7e-bfb5-bec9b56744b2] request scope bean close : me.choi.springcorereview.requestscope.common.MyLogger@617f32f8
 *
 * 진짜 MyLogger가 아닌 가짜 MyLogger를 CGLIB을 통해 주입한다.
 *
 * 정리하자면
 * 1. 서버 구동 시 request 요청이 없기에 오류가 발생한다.
 * 2. proxyMode를 적용하면 가짜 Proxy 인스턴스를 생성해서 오류를 방지하여 서버를 구동할 수 있다.
 * 3. myLogger.setRequestURL(requestURL); 해당 요청이 들어오는 시점에 진짜 인스턴스를 생성한다.
 * - 가짜 프록시 객체는 요청이 들어오면 그때 내부에서 진짜 빈을 요청하는 Delegation 로직이 들어있다.
 *
 * 이 가짜 프록시 객체는 빈으로 등록되었기에 계속 재사용한다.
 * EnhancerBySpringCGLIB$$f05d6583
 * EnhancerBySpringCGLIB$$f05d6583
 * */
@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURI().toString();

        System.out.println("my Logger" + myLogger.getClass());

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");

        return "OK";
    }
}
