package BZU.WebServices.Assiment2.repository;

import BZU.WebServices.Assiment2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
