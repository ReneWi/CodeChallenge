package Interface;

import Abstract.Player;
import Items.Inventory;

public interface Item {
	
	public String getDescription(); 
	public String getName(); 
	public boolean take(); 
	public boolean use(Inventory i, Player p); 
}

