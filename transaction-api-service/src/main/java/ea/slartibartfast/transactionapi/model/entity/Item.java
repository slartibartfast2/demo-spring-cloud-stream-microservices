package ea.slartibartfast.transactionapi.model.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private String name;
    private BigDecimal price;
}
