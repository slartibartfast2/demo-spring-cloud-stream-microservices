package ea.slartibartfast.paymentapi.model.vo;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class BasketVo {

    private List<ItemVo> items;
}
