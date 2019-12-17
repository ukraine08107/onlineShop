package online.shop.example.OnlineShop.account.controller;

import online.shop.example.OnlineShop.user.model.User;
import online.shop.example.OnlineShop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    UserService userService;
    protected User tempUser;

    @RequestMapping(value = "/account-info", method = {RequestMethod.GET})
    public String getMyAccount(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        User loggedInUser = userService.loadByEmail(username);
        model.addAttribute("user", loggedInUser);
        tempUser = loggedInUser;
        return "myAccount";
    }


    @RequestMapping(value = "/addBalance", method = {RequestMethod.GET})
    public String getBalance() {
        return "addBalance";

    }

    @RequestMapping(value = "/updateBalance", method = {RequestMethod.POST})
    public String updateBalance(@RequestParam("balance") double balance) {
        tempUser.setBalance(balance);
        userService.createUser(tempUser);
        return "redirect:/account-info";
    }




}
