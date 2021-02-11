package me.choi.springcorereview.order;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:12 오후
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
