package ea.slartibartfast.paymentapi.model.vo.bank;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BankTransactionVo {

    private String cardNumber;
    private String cardHolderName;
    private BigDecimal amount;
}
