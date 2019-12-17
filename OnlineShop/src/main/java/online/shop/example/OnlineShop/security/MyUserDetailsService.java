package online.shop.example.OnlineShop.security;

import online.shop.example.OnlineShop.user.model.Role;
import online.shop.example.OnlineShop.user.model.User;
import online.shop.example.OnlineShop.user.service.UserRepository;
import online.shop.example.OnlineShop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserService userService;
    GrantedAuthority authority;

    @Autowired
    private MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User member = userService.loadByEmail(email);
        if(member.getRole().equals(Role.Admin)){
            authority = new SimpleGrantedAuthority("ADMIN");
        }
        else{
            authority = new SimpleGrantedAuthority("USER");
        }
        if (member != null) {
            return member;
        } else {
            throw new UsernameNotFoundException("User with the email '" + email + "' not found.");
        }
    }
}