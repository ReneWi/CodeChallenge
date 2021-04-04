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
		System.out.println("�berall liegt KLEIDUNG rum, in der Kochnische stapelt sich das Geschirr und die Fenster k�nnten auch mal wieder geputzt werden.");
		if(this.exists("KAMM") != -1) {
			System.out.println("Ein roter KAMM liegt auf deinem Nachttisch.");
		}
		if(this.exists("PIZZA") != -1) {
			System.out.println("Als du nach oben guckst entdeckst du ein St�ck PIZZA unter der Decke h�ngen.");
			System.out.println("'Etwas zum Fr�hst�ck w�re schon nicht schlecht', denkst du dir.");
		}
	}

	@Override
	public void exit() {
		System.out.println("'So ich glaube ich habe alles erledigt. Auf geht's zum ersten Gespr�ch!'");
		
	}
	
	

	
}
