package me.choi.springcorereview.lifecycle;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:18 오전
 */
// TODO: 빈의 생명주기  
// TODO: [InitializingBean, DisposableBean] junwoochoi 2021/02/14 12:49 오후
/**
 * 내 코드가 스프링에 너무 의존적이게 된다.
 * 이름변경 불가
 * 내가 코드를 고칠 수 없는 외부 라이브러리에 적용 불가
 * */
public class NetworkClient {//implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect " + url);
    }

    public void call(String message) {
        System.out.println("call " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close" + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient destroy");
//        disconnect();
//    }

    // TODO: [설정 정보 사용] junwoochoi 2021/02/14 12:57 오후
    /**
     * @Bean(initMethod = "init", destroyMethod = "close")
     * */
    public void init() throws Exception {
        System.out.println("NetworkClient init");
        connect();
        call("초기화 연결 메세지");
    }
    public void close() throws Exception {
        System.out.println("NetworkClient close");
        disconnect();
    }
}
