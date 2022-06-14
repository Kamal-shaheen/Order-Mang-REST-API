package BZU.WebServices.Assiment2.repository;

import BZU.WebServices.Assiment2.DTO.OrderDto;
import BZU.WebServices.Assiment2.DTO.ProductDto;
import BZU.WebServices.Assiment2.entity.Order;
import BZU.WebServices.Assiment2.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository <ProductOrder, Long>{

    List<ProductOrder>findAllByOrder(OrderDto orderDto);
    List<ProductOrder>findAllByProduct(ProductDto productDto);
    Integer countAllByOrder(Order Order);

}
