package online.shop.example.OnlineShop.common;

import online.shop.example.OnlineShop.product.model.Product;
import online.shop.example.OnlineShop.user.model.Role;
import online.shop.example.OnlineShop.user.model.User;
import online.shop.example.OnlineShop.product.service.ProductService;
import online.shop.example.OnlineShop.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;


@Configuration
public class InitialData {

    private static final Logger log = LoggerFactory.getLogger(InitialData.class);

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private ProductService productService;
//    private CartService cartService;

    @Autowired
    public InitialData(UserService userService,
                       ProductService productService,
                      // CartService cartService,
                       PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.productService = productService;
        this.passwordEncoder = passwordEncoder;
//        this.cartService = cartService;
    }


    @PostConstruct
    public void init() {

        User userOne = new User("Test First Name",
                "Test Last Name", "+15545454547",
                "test@email.com", passwordEncoder.encode("test"));

        userOne.setRole(Role.User);

//        Cart cart = new Cart(0, userOne.getId());
//        cart.setUser(userOne);
//        cart.setIdOfUser(userOne.getId());



        User admin = new User("Test Admin Name",
                "Test Admin Name", "+15545454547",
                "admin@email.com", passwordEncoder.encode("admin"));

        userOne.setRole(Role.Admin);
        try {
            userService.createUser(userOne);
           // cartService.createCart(cart);
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        Product product = new Product("Asus", "laptop", 799, 0, "computers and laptops");
        Product product1 = new Product("Lenovo", "laptop", 749, 15.5, "computers and laptops");
        Product product2 = new Product("Apple", "laptop", 1300, 1, "computers and laptops");
        Product product3 = new Product("Apple", "smartphone", 1200, 0, "smartphones");
        Product product4 = new Product("Asus", "smartphone", 300, 40, "smartphones");
        Product product5 = new Product("Xiaomi", "smartphone", 150, 4, "smartphones");
        Product product6 = new Product("Nokia", "smarthone", 355, 17, "smartphones");
        Product product7 = new Product("Fantastic jorney", "book", 17, 3, "books");
        Product product8 = new Product("Great Gatsby", "book", 25, 14, "books");
        Product product9 = new Product("Spring in action", "book", 30, 13, "books");
        try {
            productService.createProduct(product);
            productService.createProduct(product1);
            productService.createProduct(product2);
            productService.createProduct(product3);
            productService.createProduct(product4);
            productService.createProduct(product5);
            productService.createProduct(product6);
            productService.createProduct(product7);
            productService.createProduct(product8);
            productService.createProduct(product9);
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }


    }

}