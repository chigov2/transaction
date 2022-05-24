package SpringBoot.transaction.repository;

import SpringBoot.transaction.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryInterface extends JpaRepository<Payment, Long> {
}
