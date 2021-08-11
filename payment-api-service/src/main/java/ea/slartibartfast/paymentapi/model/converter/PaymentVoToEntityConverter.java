package ea.slartibartfast.paymentapi.model.converter;

import ea.slartibartfast.paymentapi.model.entity.Basket;
import ea.slartibartfast.paymentapi.model.entity.Item;
import ea.slartibartfast.paymentapi.model.entity.Payment;
import ea.slartibartfast.paymentapi.model.vo.BasketVo;
import ea.slartibartfast.paymentapi.model.vo.ItemVo;
import ea.slartibartfast.paymentapi.model.vo.PaymentVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentVoToEntityConverter implements Function<PaymentVo, Payment> {

    @Override
    public Payment apply(PaymentVo paymentVo) {
        Payment payment = new Payment();
        payment.setUserTransactionId(paymentVo.getTransactionId());
        payment.setBasket(prepareBasket(payment, paymentVo.getBasket()));
        return payment;
    }

    private Basket prepareBasket(Payment payment, BasketVo basketVo) {
        Basket basket = new Basket();
        basket.setPayment(payment);
        basket.setItems(prepareItems(basketVo.getItems(), basket));
        return basket;
    }

    private List<Item> prepareItems(List<ItemVo> items, Basket basket) {
        return items.stream().map(item -> prepareItem(item, basket)).collect(Collectors.toList());
    }

    private Item prepareItem(ItemVo item, Basket basket) {
        return Item.builder()
                   .name(item.getName())
                   .price(item.getPrice())
                   .basket(basket)
                   .build();
    }
}
