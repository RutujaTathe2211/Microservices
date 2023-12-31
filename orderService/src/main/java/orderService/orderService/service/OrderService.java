package orderService.orderService.service;

import lombok.RequiredArgsConstructor;
import orderService.orderService.dto.OrderLineItemsDto;
import orderService.orderService.dto.OrderRequest;
import orderService.orderService.model.Order;
import orderService.orderService.model.OrderLineItems;
import orderService.orderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());


        List<OrderLineItems> orderLineItems=orderRequest.
                getOrderLineItemsList().
        stream().
        map(orderLineItemsDto ->
                mapToDto(orderLineItemsDto)).collect(Collectors.toList());

        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }
}
