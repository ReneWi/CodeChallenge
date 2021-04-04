import java.util.Scanner;

import Abstract.Player;
import Abstract.Room;

public class CommandParser {
	
	// list of valid commands
	private final String[] cmds = {"ENDE", "HILFE", "NIMM", "RAUS", "BENUTZE", "INVENTAR", "SCHAU" }; 

	private Scanner sc; 
	
	public CommandParser(Scanner sc) {
		this.sc = sc; 
	}
	
	
	//Parse room commands 
	public void parseCmds(Room room, Player player) {
		String cmd = ""; 
		boolean exit = false; 
		boolean matched; 
		
		while(!exit) {
			cmd = sc.nextLine(); 
			cmd = cmd.toUpperCase(); 
			matched = false; 
			
			for(String command : cmds) {
				if (cmd.contains(command)){
					matched = true; 
				}
			}
			
			if(!matched) {
				System.out.println("Befehl nicht verstanden. Versuche den Befehl 'Hilfe', wenn du nicht weiter kommst.");
				continue; 
			}
			
			parseGlobal(cmd);
			
			if(cmd.contains("NIMM")) {
				cmd = cmd.replaceAll("\s+"," "); 
				try {
					String item = cmd.split("\s+")[1]; 
					room.take(item, player); 
				}catch(Exception e) {
					System.out.println("(Beispiel für NIMM-Befehl: 'Nimm Skelettarm')");
				}
				
			}
			
			if(cmd.contains("BENUTZE")) {
				cmd = cmd.replaceAll("\s+"," "); 
				try {
					String item = cmd.split("\s+")[1]; 
					room.use(item, player); 
				}catch(Exception e) {
					System.out.println("(Beispiel für BENUTZE-Befehl: 'Benutze Skelettarm')");
				}
				
			}
			
			if(cmd.equals("SCHAU")) {
				room.describe();
			}
			
			if(cmd.equals("INVENTAR")) {
				player.showInventory();
			}
			
			if(cmd.equals("RAUS")) {
				System.out.println("Raum verlassen? [j|n]");
				
				if( parseOpt(sc.nextLine(), new String[] {"N", "J"}) == 1) {
					room.exit(); 
					exit = true; 
				}
				
			}
			
			
		}
	}
	
	//parse decisions
	public int parseOpt(String cmd, String[] options ) {
		cmd = format(cmd); 
		parseGlobal(cmd); 
		
		if(options.length != 0) {
			for (int i = 0; i < options.length; i ++) {
				if(cmd.equals(options[i])) {
					return i; 
				}
			}
		}
		return -1; 
	}
	
	//parse global commands 
	public void parseGlobal(String cmd) {
		cmd = format(cmd); 
		if(cmd.equals("ENDE")) {
			System.out.println("Soll das Spiel beendet werden? [j|n]");
			String confirm = this.sc.nextLine(); 
			if(confirm.toUpperCase().contains("J")) {
				System.out.println("Vielen Dank fürs Spielen!");
				System.exit(0);
			}
		}
		
		if(cmd.equals("HILFE")) {
			System.out.println("Ende               - Beendet das Spiel");
			System.out.println("Hilfe              - Ruft Hilfe auf. Aber das weißt du ja offenbar.");
			System.out.println("Raus               - Verlässt Raum.");
			System.out.println("Schau              - Damit schaust du dich im Raum um.");
			System.out.println("Nimm GEGENSTAND    - Damit nimmst du einen Gegenstand auf.");
			System.out.println("Benutze GEGENSTAND - Damit benutzt du einen Gegenstand.");
			System.out.println("Inventar           - Zeigt dir deine gesammelten Gegenstände an");
		}
		
	}
	
	// format command for parsing
	private String format(String cmd) {
		cmd = cmd.replaceAll("\\s", ""); 
		cmd = cmd.toUpperCase(); 
		return cmd; 
	}

}
