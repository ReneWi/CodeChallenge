package Items;

import Abstract.Player;
import Interface.Item;

public class Pizza implements Item {

	@Override
	public String getDescription() {
		return "Pizza! Der Käse ist so fettig, dass sie unter der Decke kleben konnte... Genau richtig!";
	}

	@Override
	public boolean take() {
		return true;
	}

	@Override
	public String getName() {
		return "Pizza"; 
	}

	@Override
	public boolean use(Inventory i, Player p) {
		System.out.println("Kalte Pizza ist die wichtigste Mahlzeit des Tages!");
		System.out.println("'Gulp!'");
		p.isPoisoned();
		i.remove(this); 
		return true;
	}

}
