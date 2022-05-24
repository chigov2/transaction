package SpringBoot.transaction.service;

import SpringBoot.transaction.dto.OrderRequest;
import SpringBoot.transaction.dto.OrderResponse;

public interface OrderServiceInterface {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
