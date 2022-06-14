package BZU.WebServices.Assiment2.repository;

import BZU.WebServices.Assiment2.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Long> {
    List<Order> findByCustomerId(long customerId);

}
