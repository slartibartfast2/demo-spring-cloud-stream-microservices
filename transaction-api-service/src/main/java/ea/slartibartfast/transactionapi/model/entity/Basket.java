package ea.slartibartfast.transactionapi.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class Basket {

    private List<Item> items;
}
