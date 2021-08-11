package ea.slartibartfast.transactionapi.model.entity;

import ea.slartibartfast.transactionapi.model.vo.BasketVo;
import ea.slartibartfast.transactionapi.model.vo.CardVo;
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
