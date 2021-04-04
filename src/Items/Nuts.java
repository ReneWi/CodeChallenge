package Items;

import Abstract.Player;
import Interface.Item;

public class Nuts implements Item {

	@Override
	public String getDescription() {
		return "Eine Schüssel Nüsschen. Kann man immer gebrauchen.";
	}

	@Override
	public boolean take() {
		return true;
	}

	@Override
	public String getName() {
		return "Nuesse"; 
	}

	@Override
	public boolean use(Inventory i, Player p) {
		System.out.println("Du knabberst von deinem nie enden wollenden Vorrat Nüsschen!");
		System.out.println("Hmmm, lecker Nüsschen.");
		return true;
	}

}
