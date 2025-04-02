package one.digitalinnovation.exoerts.gateway.service.client;

import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import one.digitalinnovation.experts.product_catalog.domain.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "productCatalog", url = "http://localhost:8083/api/product")
public interface ProductCatalogClientServer {
    @PostMapping
    public Product create(@RequestBody ProductRequestDTO productDTO);

    @GetMapping
    public List<Product> getAll();

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id);
}
