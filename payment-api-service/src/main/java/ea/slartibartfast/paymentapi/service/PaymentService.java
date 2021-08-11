package ea.slartibartfast.paymentapi.service;

import ea.slartibartfast.paymentapi.model.converter.PaymentToResultVoConverter;
import ea.slartibartfast.paymentapi.model.converter.PaymentVoToEntityConverter;
import ea.slartibartfast.paymentapi.model.entity.Payment;
import ea.slartibartfast.paymentapi.model.vo.PaymentResultVo;
import ea.slartibartfast.paymentapi.model.vo.PaymentVo;
import ea.slartibartfast.paymentapi.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentVoToEntityConverter paymentVoToEntityConverter;
    private final PaymentToResultVoConverter paymentToResultVoConverter;

    public void savePayment(PaymentVo paymentVo) {
        Payment payment = paymentVoToEntityConverter.apply(paymentVo);
        paymentRepository.save(payment);
    }

    public PaymentResultVo retrievePaymentByUserTransactionId(String userTransactionId) {
        Payment payment = paymentRepository.findByUserTransactionId(UUID.fromString(userTransactionId)).orElse(Payment.builder().build());
        return paymentToResultVoConverter.apply(payment);
    }
}
