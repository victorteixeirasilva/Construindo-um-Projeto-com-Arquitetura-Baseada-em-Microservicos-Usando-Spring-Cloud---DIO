package one.digitalinnovation.exoerts.shopping_cart.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Product", description = "Gerenciamento de Produtos")
@FeignClient(name = "product-catalog", url = "http://localhost:8083/api/product")
public interface ProductCatalogServiceClient {

    @Operation(summary = "Criar novo Produto", description = "Retorna o Produto criado")
    @PostMapping
    public ResponseEntity create(@RequestBody ProductRequestDTO productDTO);

    @Operation(summary = "Criar novo Produto", description = "Retorna o Produto criado")
    @GetMapping
    public ResponseEntity getAll();

    @Operation(summary = "Recuperar um os produto", description = "Retorna o produto indicado pelo id informado")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id);


}
