package me.choi.advancedspring.app.v4;

import me.choi.advancedspring.trace.logtrace.LogTrace;
import me.choi.advancedspring.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV4 extends AbstractTemplate<Void> {

    private LogTrace trace;

    public OrderRepositoryV4(LogTrace trace) {
        super(trace);
        this.trace = trace;
    }

    public void save(String itemId) {
        execute("OrderRepositoryV4.save()", itemId);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Void call(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
        return null;
    }
}
