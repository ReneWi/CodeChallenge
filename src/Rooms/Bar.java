package Rooms;

import java.util.ArrayList;
import java.util.Arrays;

import Abstract.Room;
import Interface.Item;
import Items.Beer;
import Items.Comb;
import Items.Nuts;

public class Bar extends Room {

	public Bar() {
		this.setItems(new ArrayList<Item>(Arrays.asList(new Comb(), new Beer(), new Nuts()))); 
	}

	@Override
	public void describe() {
		System.out.println("Die Bar ist relativ leer. Mit dir sitzt eine andere Person an der Theke.");
		System.out.println("Diese sieht jedoch aus als h�tte sie das Geb�ude noch nie verlassen.");
		System.out.println("Neben einer kleinen B�hne gibt es einen Billardtisch und eine Dartscheibe.");
		System.out.println("Alles ist in das Licht der Mittagssonne geh�llt und wirkt dadurch irgendwie falsch.");
		if(this.exists("BIER") != -1) {
			System.out.println("Vor dir steht dein frisch gezapftes BIER.");
		}
		if(this.exists("NUESSE") != -1) {
			System.out.println("Au�erdem entdeckst du eine Sch�ssel NUESSE auf der Theke."); 
		}
	}

	@Override
	public void exit() {
		System.out.println("Auf geht's zum letzten Gespr�ch!");
		
	}
	
	

	
}
