package ea.slartibartfast.paymentapi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userTransactionId;
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Basket basket;
}
