package ea.slartibarfast.transactionapi.model.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Basket {

    private List<Item> items;
}
