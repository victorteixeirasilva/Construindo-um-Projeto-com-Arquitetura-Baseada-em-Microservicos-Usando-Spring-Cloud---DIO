package one.digitalinnovation.exoerts.gateway.service.client;

import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-catalog", url = "http://localhost:8083/api/product")
public interface ProductCatalogClientServer {
    @PostMapping
    public ResponseEntity create(@RequestBody ProductRequestDTO productDTO);

    @GetMapping
    public ResponseEntity getAll();

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id);
}
