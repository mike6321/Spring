package me.choi.advancedspring.app.v4;

import me.choi.advancedspring.trace.logtrace.LogTrace;
import me.choi.advancedspring.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV4 extends AbstractTemplate<String> {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    public OrderControllerV4(LogTrace trace, OrderServiceV4 orderService) {
        super(trace);
        this.orderService = orderService;
        this.trace = trace;
    }

    @GetMapping("/v4/request")
    public String request(String itemId) {
        return execute("OrderControllerV4.request()", itemId);
    }

    @Override
    protected String call(String itemId) {
        orderService.orderItem(itemId);
        return "OK";
    }

}
