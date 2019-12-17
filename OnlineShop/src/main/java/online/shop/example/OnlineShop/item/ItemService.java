package online.shop.example.OnlineShop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void createItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteeItem(Item item) {
        itemRepository.delete(item);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }

    public List <Item> getAllItems() {
        return itemRepository.findAll();
    }
}
