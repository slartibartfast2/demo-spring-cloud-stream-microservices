package ea.slartibartfast.paymentapi.service;

import ea.slartibartfast.paymentapi.model.vo.bank.BankTransactionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BankTransactionService {

    public void sendPaymentToBank(BankTransactionVo paymentData) {
        log.info("payment data will be sent to bank, totalAmount; " + paymentData.getAmount());
    }
}
