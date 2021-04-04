package Interface;

import Abstract.Player;
import Items.Inventory;

public interface Item {
	
	// item description
	public String getDescription(); 
	
	// item name
	public String getName(); 
	
	// can item be taken?
	public boolean take(); 
	
	// defines what happens if item is used
	public boolean use(Inventory i, Player p); 
}

