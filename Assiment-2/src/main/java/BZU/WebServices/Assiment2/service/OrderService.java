package BZU.WebServices.Assiment2.service;

import BZU.WebServices.Assiment2.DTO.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrderRecords (OrderDto orderDto , long customerId);
    List<OrderDto> getOrderByCustomerId (long customerId);
    OrderDto updateOrder (long customerId , long orderId ,OrderDto orderRequest);
    OrderDto getOrderById (long orderId ,long customerId);
    List<OrderDto> getAllOrders ();
    void deleteOrderById (long id);
    void deleteOrder (long customerId , long orderId);


}
