package online.shop.example.OnlineShop.item;

import online.shop.example.OnlineShop.cart.Cart;
import online.shop.example.OnlineShop.common.BaseEntity;
import online.shop.example.OnlineShop.product.model.Product;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Item extends BaseEntity<Long> {

    @OneToOne
    private Product product;
    private int amount;

    public Item(Product productToAdd, int amount){
        this.product = productToAdd;
        this.amount = amount;
    }

    @ManyToOne
//    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Item(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
