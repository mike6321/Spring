package me.choi.advancedspring.trace.template;

import me.choi.advancedspring.trace.TraceStatus;
import me.choi.advancedspring.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {
    
    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }
    
    public T execute(String message, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            // 로직 호출
            T result = call(itemId);
            // 로직 호출

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call(String itemId);

}
