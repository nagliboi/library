package ge.bog.nnagliashvilifinalproject.repository;

import ge.bog.nnagliashvilifinalproject.modules.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find a customer by their username
    Optional<Object> findByName(String username);

    // Find a customer by their ID
    Optional<Customer> findById(Long aLong);
}
