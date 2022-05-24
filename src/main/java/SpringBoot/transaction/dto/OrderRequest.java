package SpringBoot.transaction.dto;

import SpringBoot.transaction.entity.Order;
import SpringBoot.transaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
