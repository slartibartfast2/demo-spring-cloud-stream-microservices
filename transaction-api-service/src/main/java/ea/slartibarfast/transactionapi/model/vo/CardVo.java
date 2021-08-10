package ea.slartibarfast.transactionapi.model.vo;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class CardVo {

    private UUID transactionId;
    private String cardNumber;
    private String cardHolderName;
}
