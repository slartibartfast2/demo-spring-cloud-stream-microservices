package ea.slartibartfast.paymentapi.controller;

import ea.slartibartfast.paymentapi.model.vo.PaymentResultVo;
import ea.slartibartfast.paymentapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{userTransactionId}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResultVo retrievePayment(@PathVariable String userTransactionId) {
        return paymentService.retrievePaymentByUserTransactionId(userTransactionId);
    }
}
