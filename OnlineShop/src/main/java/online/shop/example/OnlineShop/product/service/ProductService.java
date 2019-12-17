package online.shop.example.OnlineShop.product.service;

import online.shop.example.OnlineShop.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteeProduct(Product product) {
        productRepository.delete(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List <Product> getAllProducts() {
        return productRepository.findAll();
    }


}
