package online.shop.example.OnlineShop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

    @RequestMapping(value = {"/adminPage"})
    public String getRegisterPage() {
        return "admin-page";
    }

}
