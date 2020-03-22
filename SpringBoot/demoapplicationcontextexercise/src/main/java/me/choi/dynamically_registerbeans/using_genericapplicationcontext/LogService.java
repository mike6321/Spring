package me.choi.dynamically_registerbeans.using_genericapplicationcontext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 6:39 오후
 */
public interface LogService {
    void log(String msg);

    class LogServiceImpl implements LogService{

        @Override
        public void log(String msg) {

        }

        public void init() {
            System.out.printf("%s, init method called :: "+this.getClass().getName(), System.identityHashCode(this));

        }
    }
}
