package springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ItemDAO {
	
	@Autowired
    private ItemRepository itemRepository;
	Item item;
	
	
	// get item
	public Item getItem(int itemNo) {
		return itemRepository.getItemByItemNo(itemNo);
				
	}
	
	// return all items
	public List<Item> getAllItems() {  
        itemRepository.findAll();
        return itemRepository.findAll();
    }

	
	// Withdrawal amount
	public void Withdrawal(Item item,int amount) {
		item.setAmount(item.getAmount() - amount);
		itemRepository.save(item);
					
	}
	
	// Deposit amount
	public void Deposit(Item item,int amount) {
		item.setAmount(item.getAmount() + amount);
		itemRepository.save(item);
	}
	
	// add item
	public Item addItem(Item item) {
		item = new Item(item.getItemNo(),item.getName(),item.getAmount(),item.getInventoryCode());
		return itemRepository.save(item);	
	}
	
	
	// delete item
	public void deleteItem(Item item) {
		 itemRepository.delete(item);
					
	}
	
	
}
