package ea.slartibartfast.paymentapi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    private Payment payment;
}
