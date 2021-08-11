package ea.slartibartfast.transactionapi.model.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemVo {

    private String name;
    private BigDecimal price;
}
