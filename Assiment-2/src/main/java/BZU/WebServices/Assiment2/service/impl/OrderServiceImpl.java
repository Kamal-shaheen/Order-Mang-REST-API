package BZU.WebServices.Assiment2.service.impl;
import BZU.WebServices.Assiment2.DTO.OrderDto;
import BZU.WebServices.Assiment2.entity.Customer;
import BZU.WebServices.Assiment2.entity.Order;
import BZU.WebServices.Assiment2.exception.BlogAPIException;
import BZU.WebServices.Assiment2.exception.ResourceNotFoundException;
import BZU.WebServices.Assiment2.repository.CustomerRepository;
import BZU.WebServices.Assiment2.repository.OrderRepository;
import BZU.WebServices.Assiment2.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderDto createOrderRecords(OrderDto orderDto , long customerId) {
        Order order = mapToEntity(orderDto);
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Id",customerId));
        order.setCustomer(customer);
        // Save Order Entity to DB
        Order newOrder = orderRepository.save(order);
        System.out.println(newOrder);
        return mapToDTO(newOrder);
    }
    @Override
    public List<OrderDto> getOrderByCustomerId(long customerId) {
        // Retrieve comment by PostId
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(long customerId, long orderId, OrderDto orderRequest) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Id",customerId));
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new ResourceNotFoundException("Order","Id",orderId)
        );

        if (!order.getCustomer().getId().equals(customer.getId()))
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Order Doesn't Related To Customer");

        order.setDateTime(orderRequest.getDateTime());
        Order updateOrder =orderRepository.save(order);
        return mapToDTO(updateOrder);
    }


    @Override
    public OrderDto getOrderById(long orderId, long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Id",customerId));
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new ResourceNotFoundException("Order","Id",orderId)
        );

            if (!order.getCustomer().getId().equals(customer.getId()))
                throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Order Doesn't Related To Customer");
            return mapToDTO(order);

    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order>list = orderRepository.findAll();
        return list.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public void deleteOrderById(long id) {
        Order order =  orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order","Id",id)
        );
        orderRepository.delete(order);
    }

    @Override
    public void deleteOrder(long customerId , long orderId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Id",customerId));
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new ResourceNotFoundException("Order","Id",orderId)
        );

        if (!order.getCustomer().getId().equals(customer.getId()))
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Order Doesn't Related To Customer");

        orderRepository.delete(order);

    }

    private OrderDto mapToDTO (Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setDateTime(order.getDateTime());

        return orderDto;
    }

    private Order mapToEntity (OrderDto orderDto){
        Order order = new Order();
        order.setDateTime(orderDto.getDateTime());

        return order;
    }
}
