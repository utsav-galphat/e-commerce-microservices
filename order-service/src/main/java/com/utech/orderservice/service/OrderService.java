package com.utech.orderservice.service;

import com.utech.orderservice.dto.OrderLineItemsDto;
import com.utech.orderservice.dto.OrderRequest;
import com.utech.orderservice.model.Order;
import com.utech.orderservice.model.OrderLineItems;
import com.utech.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional                       /*Automatically create and commit the transaction */
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto).toList();
        order.setOrderLineItemsList(orderLineItems);

        /* call to inventory service and place order if product is available
           using webclient
         */

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems= new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return  orderLineItems;
    }
}
