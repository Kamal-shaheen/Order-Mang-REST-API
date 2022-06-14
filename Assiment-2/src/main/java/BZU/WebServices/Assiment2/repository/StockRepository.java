package BZU.WebServices.Assiment2.repository;

import BZU.WebServices.Assiment2.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByProductId(long productId);

}
