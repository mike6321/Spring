package me.choi.advancedspring.app.v4;

import me.choi.advancedspring.trace.logtrace.LogTrace;
import me.choi.advancedspring.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV4 extends AbstractTemplate<Void> {

    private OrderRepositoryV4 orderRepository;
    private LogTrace trace;

    public OrderServiceV4(LogTrace trace, OrderRepositoryV4 orderRepository) {
        super(trace);
        this.orderRepository = orderRepository;
        this.trace = trace;
    }

    public void orderItem(String itemId) {
        execute("OrderServiceV4.orderItem()", itemId);
    }

    @Override
    protected Void call(String itemId) {
        orderRepository.save(itemId);
        return null;
    }

}
