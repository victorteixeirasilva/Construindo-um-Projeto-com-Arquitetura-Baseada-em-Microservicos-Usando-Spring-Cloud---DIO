package one.digitalinnovation.exoerts.shopping_cart.repository;

import one.digitalinnovation.exoerts.shopping_cart.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
