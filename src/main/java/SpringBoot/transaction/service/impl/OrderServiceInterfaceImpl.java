package SpringBoot.transaction.service.impl;

import SpringBoot.transaction.dto.OrderRequest;
import SpringBoot.transaction.dto.OrderResponse;
import SpringBoot.transaction.repository.OrderRepositoryInterface;
import SpringBoot.transaction.repository.PaymentRepositoryInterface;
import SpringBoot.transaction.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceInterfaceImpl implements OrderServiceInterface
{
    private OrderRepositoryInterface orderRepository;
    private PaymentRepositoryInterface paymentRepository;

    @Autowired
    public OrderServiceInterfaceImpl(OrderRepositoryInterface orderRepository, PaymentRepositoryInterface paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        //lets get info from orderRequest
        return null;
    }
}
