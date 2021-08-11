package ea.slartibartfast.transactionapi.model.converter;

import ea.slartibartfast.transactionapi.model.entity.UserTransaction;
import ea.slartibartfast.transactionapi.model.vo.PaymentVo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PaymentVoConverter implements Function<UserTransaction, PaymentVo> {

    @Override
    public PaymentVo apply(UserTransaction userTransaction) {
        return PaymentVo.builder()
                        .transactionId(userTransaction.getId())
                        .basket(userTransaction.getBasket())
                        .cardNumber(userTransaction.getCard().getCardNumber())
                        .cardHolderName(userTransaction.getCard().getCardHolderName())
                        .build();
    }
}
