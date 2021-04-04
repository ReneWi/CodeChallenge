package Items;

import Abstract.Player;
import Interface.Item;

public class Beer implements Item {

	@Override
	public String getDescription() {
		return "Ein kühles, vollmundiges Weizen. Das kondensierte Wasser läuft am Glas herunter.";
	}

	@Override
	public boolean take() {
		return true;
	}

	@Override
	public String getName() {
		return "Bier"; 
	}

	@Override
	public boolean use(Inventory i, Player p) {
		System.out.println("Warum nicht? Du hast es dir schließlich bereits verdient!!");
		System.out.println("Du trinkst das Bier genüsslich und freust dich über die Gastfreundschaft. Es ist 12:17 Uhr.");
		p.isDrunk();
		i.remove(this); 
		return true;
	}

}
