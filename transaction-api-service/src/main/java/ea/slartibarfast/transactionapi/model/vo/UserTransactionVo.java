package ea.slartibarfast.transactionapi.model.vo;

import ea.slartibarfast.transactionapi.model.entity.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTransactionVo {

    private TransactionType transactionType;
    private String username;
    private BasketVo basket;
    private CardVo card;
}
