package Rooms;

import java.util.ArrayList;
import java.util.Arrays;

import Abstract.Player;
import Abstract.Room;
import Interface.Item;
import Items.Clothes;
import Items.Comb;
import Items.Inventory;
import Items.Pizza;

public class Home extends Room {

	public Home() {
		this.setItems(new ArrayList<Item>(Arrays.asList(new Comb(), new Pizza(), new Clothes()))); 
	}

	@Override
	public void describe() {
		System.out.println("Du stehst in deiner Einzimmerwohnung. Es herrscht leichtes Chaos: ");
		System.out.println("Überall liegt KLEIDUNG rum, in der Kochnische stapelt sich das Geschirr und die Fenster könnten auch mal wieder geputzt werden.");
		if(this.exists("KAMM") != -1) {
			System.out.println("Ein roter KAMM liegt auf deinem Nachttisch.");
		}
		if(this.exists("PIZZA") != -1) {
			System.out.println("Als du nach oben guckst entdeckst du ein Stück PIZZA unter der Decke hängen.");
			System.out.println("'Etwas zum Frühstück wäre schon nicht schlecht', denkst du dir.");
		}
	}

	@Override
	public void exit() {
		System.out.println("'So ich glaube ich habe alles erledigt. Auf geht's zum ersten Gespräch!'");
		
	}
	
	

	
}
