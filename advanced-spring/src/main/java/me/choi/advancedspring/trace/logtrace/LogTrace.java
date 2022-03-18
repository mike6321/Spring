package me.choi.advancedspring.trace.logtrace;

import me.choi.advancedspring.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
