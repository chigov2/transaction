package SpringBoot.transaction.repository;

import SpringBoot.transaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryInterface extends JpaRepository<Order, Long>{}
