package SpringBoot.transaction.controller;

import SpringBoot.transaction.dto.OrderRequest;
import SpringBoot.transaction.dto.OrderResponse;
import SpringBoot.transaction.service.OrderServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderServiceInterface orderService;

    public OrderController(OrderServiceInterface orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){

        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
