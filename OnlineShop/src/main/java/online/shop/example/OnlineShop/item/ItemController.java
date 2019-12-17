package online.shop.example.OnlineShop.item;

import online.shop.example.OnlineShop.product.model.Product;
import online.shop.example.OnlineShop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/addToCart/{id}"})
    public String getHomePage(@PathVariable("id") Long productId) {

        Product productToAdd = productService.findById(productId);

        Item item = new Item(productToAdd, 1);

        itemService.createItem(item);
        return "redirect:/index";
    }
}
