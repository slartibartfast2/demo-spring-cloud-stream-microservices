package ea.slartibarfast.transactionapi.model.converter;

import ea.slartibarfast.transactionapi.model.entity.UserTransaction;
import ea.slartibarfast.transactionapi.model.vo.CardVo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CardVoConverter implements Function<UserTransaction, CardVo> {

    @Override
    public CardVo apply(UserTransaction userTransaction) {
        return CardVo.builder()
                     .transactionId(userTransaction.getId())
                     .cardHolderName(userTransaction.getCard().getCardHolderName())
                     .cardNumber(userTransaction.getCard().getCardNumber())
                     .build();
    }
}
