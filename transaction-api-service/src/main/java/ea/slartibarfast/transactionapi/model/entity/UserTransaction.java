package ea.slartibarfast.transactionapi.model.entity;

import ea.slartibarfast.transactionapi.model.vo.BasketVo;
import ea.slartibarfast.transactionapi.model.vo.CardVo;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity(name = "user_transaction")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private TransactionType transactionType;
    private String username;
    @Transient
    private BasketVo basket;
    @Transient
    private CardVo card;
}
