package Abstract;

import java.util.ArrayList;

import Interface.Item;
import Items.Inventory;

// abstract room class
// defines all shared room attributes and functions
public abstract class Room {

	private ArrayList<Item> items; 
	
	// for room initialization
	public void setItems(ArrayList<Item> items) {
		this.items = items; 
	}
	
	// room description
	public abstract void describe(); 
	
	// does item exist in room?
	public int exists(String itemName) {
		for(int i = 0; i < this.items.size(); i ++) {
			if(this.items.get(i).getName().toUpperCase().equals(itemName)) {
				return i; 
			}
		}
		
		return -1; 
	}
	
	// what happens if item is taken
	public boolean take(String itemName, Player player) {
		int index = this.exists(itemName);
		if(index != -1) {
			player.add(this.items.remove(index));
			System.out.println(itemName + " wurde eingesteckt!");
			return true; 
		}else {
			System.out.println("'Ich sehe diesen Gegenstand nicht...'");
			return false; 
		}
		
	}
	
	// what happens if item is used
	// defined for room if some items are dependent on environment (not implemented)
	public void use(String itemName, Player player) {
		Inventory inv = player.getInventory(); 
		
		for( int i = 0; i < inv.size(); i ++ ) {
			if(inv.get(i).getName().toUpperCase().equals(itemName)) {
				inv.get(i).use(inv, player); 
				return; 
			}
		}
		System.out.println("'Ich kann das nicht benutzen.'");
		
	}
	
	public abstract void exit(); 
	
	
}
