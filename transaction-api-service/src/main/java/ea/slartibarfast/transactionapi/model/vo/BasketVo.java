package ea.slartibarfast.transactionapi.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BasketVo {

    private List<ItemVo> items;
}
