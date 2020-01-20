package springBoot;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity // JPA entity
@Table(name="Items")
public class Item {
	
	@Id // Auto-generated primery key
	@GeneratedValue(strategy=GenerationType.AUTO) // Id incremented whenever new item generated 
	
	private int id;
	@Min(0)
	private int itemNo;
	//@NotBlank
	private String name;
	//@Min(0)
	private int amount;
	//@NotBlank
	private String inventoryCode;
	
	public Item() {}
	
	public Item(@Min(0) int itemNo, @NotBlank String name, @Min(0) int amount, @NotBlank String inventoryCode) {
		this.itemNo = itemNo;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	
	
	

}
