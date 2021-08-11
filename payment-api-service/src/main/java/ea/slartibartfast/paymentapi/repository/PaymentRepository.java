package ea.slartibartfast.paymentapi.repository;

import ea.slartibartfast.paymentapi.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    Optional<Payment> findByUserTransactionId(UUID userTransactionId);
}
