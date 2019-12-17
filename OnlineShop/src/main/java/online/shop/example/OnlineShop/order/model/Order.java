package online.shop.example.OnlineShop.order.model;

import online.shop.example.OnlineShop.common.BaseEntity;
import online.shop.example.OnlineShop.item.Item;
import online.shop.example.OnlineShop.user.model.User;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends BaseEntity<Long> {

    private long itemId;
    private String name;
    private int amount;
    private String userId;

}
