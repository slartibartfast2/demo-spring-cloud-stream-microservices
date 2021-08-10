package ea.slartibarfast.transactionapi.model.converter;

import ea.slartibarfast.transactionapi.model.entity.UserTransaction;
import ea.slartibarfast.transactionapi.model.vo.UserTransactionVo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserTransactionVoConverter implements Function<UserTransactionVo, UserTransaction> {

    @Override
    public UserTransaction apply(UserTransactionVo userTransactionVo) {
        return UserTransaction.builder()
                              .username(userTransactionVo.getUsername())
                              .transactionType(userTransactionVo.getTransactionType())
                              .basket(userTransactionVo.getBasket())
                              .card(userTransactionVo.getCard())
                              .build();
    }
}
