package one.digitalinnovation.exoerts.gateway.controller;

import feign.FeignException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.exoerts.gateway.service.client.ProductCatalogClientServer;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.response.ErrorResponseDTO;
import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Catalog", description = "Gerenciador dos end-poits do serviço de product-catalog")
@RestController
@RequestMapping("/api/product")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogClientServer service;

    @Operation(summary = "Criar novo Produto", description = "Retorna o Produto criado")
    @PostMapping
    public ResponseEntity create(@RequestBody ProductRequestDTO productDTO){
        return ResponseEntity.ok(service.create(productDTO));
    }

    @Operation(summary = "Ver Todos", description = "Retorna todos os Produtos criados")
    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Não existe produtos cadastrados!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }

    @Operation(summary = "Recuperar um os produto", description = "Retorna o produto indicado pelo id informado")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Produto não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }
}
