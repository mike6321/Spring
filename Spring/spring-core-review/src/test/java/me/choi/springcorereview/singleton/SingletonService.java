package me.choi.springcorereview.singleton;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:04 오전
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
class SingletonRun {
    // private 접근제어자가 있기 떄문에 인스턴스 생성이 안된다.
    //SingletonService singletonService = new SingletonService();
}
