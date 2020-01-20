package springBoot;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// rest controller
@RestController
@RequestMapping("/item")   //Determines access
public class ItemController {
	
	@Autowired  
	private ItemDAO itemDao;
	private Item item;
	
	
	// Create new item
	@PostMapping("/addItem")
	public 	Item createNewItem(@Valid @RequestBody Item item) {
		 return itemDao.addItem(item);
	}
	
	// Read all items details
	@GetMapping
	public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
	
		
	// Read item details by item no and return http response
	@GetMapping("{itemNo}")
	public ResponseEntity<Item> getItemByItemNo(@PathVariable(value="itemNo")int itemNo) {
		 item = itemDao.getItem(itemNo);
		
		// check if item exist
		if (item == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		 return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	
	// Deposit quantity of a specific item
	@PutMapping("/deposit/{amount}")
	public ResponseEntity<Item> deposit(@PathVariable(value="amount")int amount,@Valid @RequestBody Item item ) {
		item = itemDao.getItem(item.getItemNo());
		
		// check if item exist
		if (item == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		itemDao.Deposit(item, amount);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	
	// Withdrawal quantity of a specific item
	@PutMapping("/Withdrawal/{amount}")
	public ResponseEntity<Item> withdrawal(@PathVariable(value="amount")int amount,@Valid @RequestBody Item item ){
		item = itemDao.getItem(item.getItemNo());
			
		// check if item exist
		if (item == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		itemDao.Withdrawal(item, amount);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
		
	//  Delete quantity of a specific item
	@DeleteMapping("/delete/{itemNo}")
	public ResponseEntity<Item> delete(@PathVariable(value="itemNo")int itemNo) {
		item = itemDao.getItem(itemNo);
			
		// check if item exist
		if (item == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		itemDao.deleteItem(item);
		return new ResponseEntity<Item>(HttpStatus.OK);
	}	
		
		
}
