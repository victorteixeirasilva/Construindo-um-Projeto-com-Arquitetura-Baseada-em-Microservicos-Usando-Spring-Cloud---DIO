package one.digitalinnovation.experts.product_catalog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import one.digitalinnovation.experts.product_catalog.domain.dto.response.error.ErrorResponseDTO;
import one.digitalinnovation.experts.product_catalog.domain.entity.Product;
import one.digitalinnovation.experts.product_catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Product", description = "Gerenciamento de Produtos")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Criar novo Produto", description = "Retorna o Produto criado")
    @PostMapping
    public Product create(@RequestBody ProductRequestDTO productDTO){
        return service.create(productDTO);
    }

    @Operation(summary = "Criar novo Produto", description = "Retorna o Produto criado")
    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Recuperar um os produto", description = "Retorna o produto indicado pelo id informado")
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

}
