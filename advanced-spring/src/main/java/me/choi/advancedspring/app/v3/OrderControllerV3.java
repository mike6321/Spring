package me.choi.advancedspring.app.v3;

import lombok.RequiredArgsConstructor;
import me.choi.advancedspring.trace.TraceStatus;
import me.choi.advancedspring.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV3.request()");
            orderService.orderItem(itemId);
            trace.end(status);

            return "OK";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
