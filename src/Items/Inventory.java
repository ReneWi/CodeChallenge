package Items;
import java.util.ArrayList;

import Interface.Item;

public class Inventory extends ArrayList<Item> {
	
	// information for player
	public void show() {
		if(this.size() == 0) {
			System.out.println("Dein Inventar ist leer.");
		}
		for(int i = 0; i < this.size(); i ++) {
			System.out.println(this.get(i).getName() + ": " + this.get(i).getDescription()); 
		}
	}
}
