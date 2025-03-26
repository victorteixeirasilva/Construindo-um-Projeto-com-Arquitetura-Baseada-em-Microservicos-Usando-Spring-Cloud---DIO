package one.digitalinnovation.exoerts.shopping_cart.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @EmbeddedId
    private ItemId productId;
    private Integer amount;

    // Relacionamento com a entidade Cart
    @ManyToOne
    @MapsId("cartId") // Vincula 'cartId' da chave composta ao relacionamento Cart
    @JoinColumn(name = "cart_id") // Define a chave estrangeira que conecta com o Cart
    @JsonIgnore // Ignora a serialização da relação bidirecional com Cart
    private Cart cart;


}
