package ea.slartibartfast.paymentapi.model.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentResultVo {

    private BasketVo basket;
}
