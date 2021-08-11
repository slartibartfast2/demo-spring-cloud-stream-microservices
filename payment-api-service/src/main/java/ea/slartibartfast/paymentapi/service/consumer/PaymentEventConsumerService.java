package ea.slartibartfast.paymentapi.service.consumer;

import ea.slartibartfast.paymentapi.model.vo.BasketVo;
import ea.slartibartfast.paymentapi.model.vo.ItemVo;
import ea.slartibartfast.paymentapi.model.vo.PaymentVo;
import ea.slartibartfast.paymentapi.model.vo.bank.BankTransactionVo;
import ea.slartibartfast.paymentapi.service.BankTransactionService;
import ea.slartibartfast.paymentapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentEventConsumerService {

    private final BankTransactionService transactionService;
    private final PaymentService paymentService;

    @Bean
    public Consumer<PaymentVo> paymentEventConsumer() {
        return payment -> {
            log.info("Received new payment transaction from Kafka topic");
            paymentService.savePayment(payment);
            var paymentData = BankTransactionVo.builder()
                                               .cardHolderName(payment.getCardHolderName())
                                               .cardNumber(payment.getCardNumber())
                                               .amount(calculateTotalAmount(payment.getBasket()))
                                               .build();

            transactionService.sendPaymentToBank(paymentData);
        };
    }

    private BigDecimal calculateTotalAmount(BasketVo basketVo) {
        return basketVo.getItems().stream().map(ItemVo::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
