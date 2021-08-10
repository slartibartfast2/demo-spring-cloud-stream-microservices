package ea.slartibarfast.transactionapi.repository;

import ea.slartibarfast.transactionapi.model.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, UUID> {

}
