package ea.slartibartfast.paymentapi.model.converter;

import ea.slartibartfast.paymentapi.model.entity.Basket;
import ea.slartibartfast.paymentapi.model.entity.Item;
import ea.slartibartfast.paymentapi.model.entity.Payment;
import ea.slartibartfast.paymentapi.model.vo.BasketVo;
import ea.slartibartfast.paymentapi.model.vo.ItemVo;
import ea.slartibartfast.paymentapi.model.vo.PaymentResultVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentToResultVoConverter implements Function<Payment, PaymentResultVo> {

    @Override
    public PaymentResultVo apply(Payment payment) {
        return PaymentResultVo.builder()
                              .basket(prepareBasket(payment.getBasket()))
                              .build();
    }

    private BasketVo prepareBasket(Basket basket) {
        return BasketVo.builder()
                       .items(prepareItems(basket.getItems()))
                       .build();
    }

    private List<ItemVo> prepareItems(List<Item> items) {
        return items.stream().map(this::prepareItem).collect(Collectors.toList());
    }

    private ItemVo prepareItem(Item item) {
        return ItemVo.builder()
                     .name(item.getName())
                     .price(item.getPrice())
                     .build();
    }
}
