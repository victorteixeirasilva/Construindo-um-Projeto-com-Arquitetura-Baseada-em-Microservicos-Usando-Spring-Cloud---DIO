package one.digitalinnovation.exoerts.shopping_cart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.exoerts.shopping_cart.domain.dto.request.ItemRequestDTO;
import one.digitalinnovation.exoerts.shopping_cart.domain.entity.Cart;
import one.digitalinnovation.exoerts.shopping_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Cart addItemOnCart(@PathVariable Integer id, @RequestBody ItemRequestDTO item){
        return service.addItem(item, id);
    }

    @Operation(
            summary =
                    "Adicionar um item um novo Carrinho",
            description =
                    "Retorna um carrinho com seu item")
    @PostMapping()
    public Cart addItem(@RequestBody ItemRequestDTO itemRequestDTO){
        return service.addItem(itemRequestDTO);
    }

    @Operation(
            summary =
                    "Procurando um Carrinho por Id",
            description =
                    "Retorna um carrinho com todos os seus itens")
    @GetMapping("/{id}")
    public Cart findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @Operation(
            summary =
                    "Deletar um Carrinho por Id",
            description =
                    "Retorna o carrinho que foi deletado")
    @DeleteMapping("/{id}")
    public String clear(@PathVariable Integer id){
        return service.delete(id);
    }




}
