package one.digitalinnovation.exoerts.gateway.service.client;

import one.digitalinnovation.exoerts.shopping_cart.domain.dto.request.ItemRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "shopping-cart", url = "http://localhost:8081/api/cart")
public interface ShoppingCartClientServer {

    @PostMapping("/{id}")
    public ResponseEntity addItemOnCart(@PathVariable Integer id, @RequestBody ItemRequestDTO item);

    @PostMapping()
    public ResponseEntity addItem(@RequestBody ItemRequestDTO itemRequestDTO);

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id);

    @DeleteMapping("/{id}")
    public ResponseEntity clear(@PathVariable Integer id);
}
