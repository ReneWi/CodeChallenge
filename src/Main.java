import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		 
		Scanner sc = new Scanner(System.in);
		Game game = new Game(sc);
		game.intro();
		sc.nextLine(); 
		game.create();
		game.atHome();
		game.atGold(); 
		game.atBar();
		game.atYolawo();
	}
	
}