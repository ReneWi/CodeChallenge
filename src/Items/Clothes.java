package Items;

import Abstract.Player;
import Interface.Item;

public class Clothes implements Item {

	@Override
	public String getDescription() {
		return "'Ein paar von den Sachen sind noch gut. Vielleicht kann ich sie zum Gespr�ch tragen.'";
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
		System.out.println("Du findest ein Hemd und eine Hose unter einem Stapel B�cher.");
		System.out.println("Sie liegen dort schon so lange, dass man sie nicht B�geln muss.");
		System.out.println("'Perfekt!', denkst du, als du sie dir anziehst.");
		p.isDressed();
		i.remove(this); 
		return true;
	}

}
