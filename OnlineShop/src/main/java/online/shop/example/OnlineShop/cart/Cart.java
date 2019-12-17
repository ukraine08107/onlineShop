package online.shop.example.OnlineShop.cart;

import online.shop.example.OnlineShop.common.BaseEntity;
import online.shop.example.OnlineShop.item.Item;
import online.shop.example.OnlineShop.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart extends BaseEntity<Long> {

    @OneToMany
    private List<Item> items;

    @OneToOne
    private User user;

    public List <Item> getItems() {
        return items;
    }

    public void setItems(List <Item> items) {
        this.items = items;
    }
}
