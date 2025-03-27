package one.digitalinnovation.exoerts.shopping_cart.service;

import one.digitalinnovation.exoerts.shopping_cart.domain.dto.request.ItemRequestDTO;
import one.digitalinnovation.exoerts.shopping_cart.domain.entity.Cart;
import one.digitalinnovation.exoerts.shopping_cart.domain.entity.Item;
import one.digitalinnovation.exoerts.shopping_cart.domain.entity.ItemId;
import one.digitalinnovation.exoerts.shopping_cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public Cart addItem(ItemRequestDTO itemRequestDTO, Integer id) {
        Cart cart = repository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Carrinho informado não encontrado!"
                        ));

        var item = new Item();
        ItemId itemId = new ItemId(itemRequestDTO.productId(), cart.getId());
        item.setProductId(itemId);
        item.setAmount(itemRequestDTO.amount());


        for (Item itemBd: cart.getItems()) {
            long idLong = itemId.getProductId();
            if (itemBd.getProductId().getProductId() == idLong){
                for (int i = 0; i < cart.getItems().size(); i++){
                    if (cart.getItems().get(i).getProductId().getProductId() == idLong) {
                        cart.getItems().get(i)
                                .setAmount(item.getAmount() + itemBd.getAmount());
                    }
                }

                item.setCart(cart);
                return repository.save(cart);
            }
        }

        // Atualizar a relação bidirecional
        item.setCart(cart);

        cart.getItems().add(item);
        return repository.save(cart);
    }

    public Cart addItem(ItemRequestDTO itemRequestDTO) {
        // Cria um novo Cart
        Cart cart = new Cart();
        cart.setItems(new ArrayList<>()); // Garante que a lista de itens seja inicializada
        cart = repository.save(cart); // Salva o carrinho no banco


        var item = new Item();
        ItemId itemId = new ItemId(itemRequestDTO.productId(), cart.getId());
        item.setProductId(itemId);
        item.setAmount(itemRequestDTO.amount());

        // Atualizar a relação bidirecional
        item.setCart(cart);
        cart.getItems().add(item);

        return repository.save(cart);
    }

    public Cart findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado!"));
    }
}
