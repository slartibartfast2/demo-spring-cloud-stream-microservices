package ea.slartibarfast.transactionapi.service;

import ea.slartibarfast.transactionapi.model.converter.CardVoConverter;
import ea.slartibarfast.transactionapi.model.converter.PaymentVoConverter;
import ea.slartibarfast.transactionapi.model.converter.UserTransactionVoConverter;
import ea.slartibarfast.transactionapi.model.entity.UserTransaction;
import ea.slartibarfast.transactionapi.model.vo.UserTransactionVo;
import ea.slartibarfast.transactionapi.repository.UserTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserTransactionService {

    private final UserTransactionRepository userTransactionRepository;
    private final UserTransactionVoConverter userTransactionVoConverter;
    private final PaymentVoConverter paymentVoConverter;
    private final CardVoConverter cardVoConverter;
    private final StreamBridge streamBridge;

    @Transactional
    public void createUserTransaction(UserTransactionVo userTransactionVo) {
        var userTransaction = userTransactionVoConverter.apply(userTransactionVo);
        userTransactionRepository.save(userTransaction);

        sendEvents(userTransaction);

    }

    private void sendEvents(UserTransaction userTransaction) {
        streamBridge.send("paymentSupplier-out-0", paymentVoConverter.apply(userTransaction));
        streamBridge.send("cardSupplier-out-0", cardVoConverter.apply(userTransaction));
        streamBridge.send("basketSupplier-out-0", userTransaction.getBasket());
    }
}
