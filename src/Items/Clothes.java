package Items;

import Abstract.Player;
import Interface.Item;

public class Clothes implements Item {

	@Override
	public String getDescription() {
		return "'Ein paar von den Sachen sind bestimmt noch gut. Vielleicht kann ich sie zum Gespr�ch tragen.'";
	}

	@Override
	public boolean take() {
		return true;
	}

	@Override
	public String getName() {
		return "Kleidung"; 
	}

	@Override
	public boolean use(Inventory i, Player p) {
		System.out.println("In dem W�schehaufen hast du eine Hose und ein Hemd gefunden.");
		System.out.println("Sie riechen in Ordnung und m�ssen nicht geb�gelt werden.");
		System.out.println("'Perfekt!', denkst du, als du sie dir anziehst.");
		p.isDressed();
		i.remove(this); 
		return true;
	}

}
