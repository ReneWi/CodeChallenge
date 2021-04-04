package Abstract;

import java.util.ArrayList;

import Interface.Item;
import Items.Inventory;

public abstract class Room {

	private ArrayList<Item> items; 
	
	public void setItems(ArrayList<Item> items) {
		this.items = items; 
	}
	
	public abstract void describe(); 
	
	public int exists(String itemName) {
		for(int i = 0; i < this.items.size(); i ++) {
			if(this.items.get(i).getName().toUpperCase().equals(itemName)) {
				return i; 
			}
		}
		
		return -1; 
	}
	
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
