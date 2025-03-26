package one.digitalinnovation.exoerts.shopping_cart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.request.ItemRequestDTO;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.response.ErrorResponseDTO;
import one.digitalinnovation.exoerts.shopping_cart.domain.entity.Item;
import one.digitalinnovation.exoerts.shopping_cart.repository.CartRepository;
import one.digitalinnovation.exoerts.shopping_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart", description = "Gerenciamento de carrinhos")
@RestController
@RequestMapping("/api/cart")
public class CartController {


    @Autowired
    private CartService service;

    @Operation(
            summary =
                    "Adicionar um Novo item ao Carrinho Existente",
            description =
                    "Retorna um carrinho com seus itens")
    @PostMapping("/{id}")
    public ResponseEntity addItemOnCart(@PathVariable Integer id, @RequestBody ItemRequestDTO item){
        try {
            return ResponseEntity.ok(service.addItem(item, id));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(e.getMessage()));
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
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDTO(e.getMessage()));
        }
    }




}
