package ea.slartibarfast.transactionapi.model.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ItemVo {

    private String name;
    private BigDecimal price;
}
