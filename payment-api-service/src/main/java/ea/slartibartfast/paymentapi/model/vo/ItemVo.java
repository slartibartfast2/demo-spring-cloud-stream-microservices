package ea.slartibartfast.paymentapi.model.vo;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class ItemVo {

    private String name;
    private BigDecimal price;
}
