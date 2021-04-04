package Items;

import Abstract.Player;
import Interface.Item;

public class Comb implements Item {

	@Override
	public String getDescription() {
		return "Ein roter Kamm. Ein paar Zacken sind abgebrochen, aber sonst ist er noch gut.";
	}

	@Override
	public boolean take() {
		return true;
	}

	@Override
	public String getName() {
		return "Kamm"; 
	}

	@Override
	public boolean use(Inventory i, Player p) {
		System.out.println("Du k‰mmst dir erfolgreich die Haare.");
		System.out.println("Leider brechen dabei die restlichen Zacken des Kamms ab.");
		System.out.println("'Der hat es hinter sich', denkst du, als du ihn wegschmeiﬂt");
		p.isCombed();
		i.remove(this); 
		return true;
	}
	

}
