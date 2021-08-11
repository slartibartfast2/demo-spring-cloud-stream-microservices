package ea.slartibartfast.transactionapi.repository;

import ea.slartibartfast.transactionapi.model.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, UUID> {

}
