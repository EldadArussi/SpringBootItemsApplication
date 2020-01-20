package springBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	// define for get item by item no
	Item getItemByItemNo(int itemNo);

}