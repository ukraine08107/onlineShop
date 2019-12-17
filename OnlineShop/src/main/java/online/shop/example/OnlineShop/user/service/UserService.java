package online.shop.example.OnlineShop.user.service;

import online.shop.example.OnlineShop.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User findById(Long id){
       return userRepository.findById(id).get();
    }

    public User loadByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
