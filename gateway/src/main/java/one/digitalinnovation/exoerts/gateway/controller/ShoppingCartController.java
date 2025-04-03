package one.digitalinnovation.exoerts.gateway.controller;

import feign.FeignException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.exoerts.gateway.service.client.ShoppingCartClientServer;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.request.ItemRequestDTO;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.response.ErrorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Shopping Cart", description = "Gerenciador dos end-poits do serviço de shopping-cart")
@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartClientServer service;

    @Operation(
            summary =
                    "Adicionar um Novo item ao Carrinho Existente",
            description =
                    "Retorna um carrinho com seus itens")
    @PostMapping("/{id}")
    public ResponseEntity addItemOnCart(@PathVariable Integer id, @RequestBody ItemRequestDTO item){
        try {
            return ResponseEntity.ok(service.addItemOnCart(id, item));
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Erro ao adicionar item a um carrinho!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }

    @Operation(
            summary =
                    "Adicionar um item um novo Carrinho",
            description =
                    "Retorna um carrinho com seu item")
    @PostMapping()
    public ResponseEntity addItem(@RequestBody ItemRequestDTO itemRequestDTO){
        try {
            return ResponseEntity.ok(service.addItem(itemRequestDTO));
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Erro ao adicionar item a um carrinho!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }

    @Operation(
            summary =
                    "Procurando um Carrinho por Id",
            description =
                    "Retorna um carrinho com todos os seus itens")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Erro procurar carrinho!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }

    @Operation(
            summary =
                    "Deletar um Carrinho por Id",
            description =
                    "Retorna o carrinho que foi deletado")
    @DeleteMapping("/{id}")
    public ResponseEntity clear(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.clear(id));
        } catch (FeignException.InternalServerError e) {
            // Criar um objeto que contenha a mensagem da exceção
            var errorResponseDTO = new ErrorResponseDTO("Erro ao Deletar o Carrinho!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
        }
    }

}
