package online.shop.example.OnlineShop.security;


//import online.shop.example.OnlineShop.cart.model.Cart;
//import online.shop.example.OnlineShop.cart.service.CartService;
import online.shop.example.OnlineShop.product.model.Product;
import online.shop.example.OnlineShop.product.service.ProductService;
import online.shop.example.OnlineShop.user.model.Role;
import online.shop.example.OnlineShop.user.model.User;
import online.shop.example.OnlineShop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class LoginController {
    public static Long userID;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProductService productService;
//    @Autowired
//    private CartService cartService;

    @RequestMapping(value = {"/register/newUser"}, method = RequestMethod.GET)
    public String registerNewMemer(
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("telephoneNumber") String telephoneNumber,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   @RequestParam("passwordRepeat") String repeatedPassword) {

        if (password.equals(repeatedPassword)) {
            User user = new User(firstName, lastName, telephoneNumber, email, passwordEncoder.encode(password));
            try {
                userService.createUser(user);
//                Cart cart = new Cart(0, user.getId());
//                cart.setUser(user);
//                cart.setIdOfUser(user.getId());
//                cartService.createCart(cart);
                user.setRole(Role.User);
            } catch (Exception e) {
                return "redirect:/eror";
            }
        } else {
            return "redirect:/register";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"/login"})
    public String getLoginPage() {
        return "login";
    }





    @RequestMapping(value = {"/register"})
    public String getRegisterPage() {
        return "register";
    }

    @RequestMapping(value = {"/index"})
    public String getHomePage(Model model) {
        userID = (Long)model.getAttribute("id");
        List <Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "index";
    }
//не работает пока
    @RequestMapping(value = "value/{category}")
    public String getAllItems(String category, Model model){
        model.getAttribute(category);
        return "index";
    }
    @RequestMapping(value = "/sortBy/{category}")
    public String sortByCategory(){

        return "redirect:/index";
    }



}