package SpringBoot.transaction.service.impl;

import SpringBoot.transaction.dto.OrderRequest;
import SpringBoot.transaction.dto.OrderResponse;
import SpringBoot.transaction.entity.Order;
import SpringBoot.transaction.entity.Payment;
import SpringBoot.transaction.exception.PaymentException;
import SpringBoot.transaction.repository.OrderRepositoryInterface;
import SpringBoot.transaction.repository.PaymentRepositoryInterface;
import SpringBoot.transaction.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        //create order tracking number
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        //bad payment
        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not supported");
        }
        //ok payment
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
