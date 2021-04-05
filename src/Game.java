import java.util.Scanner;

import Abstract.Player;
import Abstract.Room;
import Char.Nerd;
import Char.Social;
import Char.Sport;
import Rooms.Bar;
import Rooms.Home;

public class Game {
	
	private Scanner sc; 
	private CommandParser cp; 
	private Player player; 
	private Room roomHome = new Home(); 
	private Room roomBar = new Bar(); 
	
	public Game(Scanner sc) {
		this.sc = sc; 
		this.cp =  new CommandParser(this.sc); 
	}
	
	
	//Game introduction
	public void intro() {
		
		System.out.println("Willkommen bei meiner Lösung der Code-Challange!");
		System.out.println("Ich habe ein kleines Text-Adventure programmiert, welches man über die Kommandozeile spielen kann.");
		System.out.println("Über den Befehl 'Hilfe' können grundlegende Aktionen nachgeschaut werden.");
		System.out.println("Über den Befehl 'Ende' kann das Spiel jederzeit beendet werden.");
		System.out.println("Und nun viel Spaß! :)");
		System.out.println("(Drücke Enter, um zu beginnen)");
		
	}
	
	//Character creation
	public void create() {
		System.out.println("");
		int input = -1; 
		
		System.out.println("Der Wecker klingelt. 8:00 Uhr. Warum hattest du ihn nochmal so früh gestellt?");
		System.out.println("Ach richtig! Du brauchst einen Job! Und heute hast du gleich drei Bewerbungsgespräche.");
		System.out.println("'Na dann steh ich mal auf', denkst du dir, nachdem du den Wecker mit viel Schwung ausgeschaltet hast.");
		System.out.println("Mühsam schaffst du es die schwere Decke von dir zu wuchten und aus deinem Bett zu steigen.");
		System.out.println("Direkt vor deinem Bett steht ein Spiegel, in dem du so langsam erkennst wer und wo du bist.");

		String name = ""; 
		while (input < 1) {
			System.out.println("(Wie heißt du?)");
			name = sc.nextLine(); 
			System.out.println("Dein Name ist " + name + "? [j|n]" );
			input = cp.parseOpt(sc.nextLine(), new String[] {"N", "J"}); 
		}
		
		System.out.println("Dein Name ist " + name + " und du bist topfit! Oder so...");
		
		//Choose player class for alternative endings
		System.out.println("(Wähle eine Klasse: [Sportlich|Nerdig|Sozial])");
		input = cp.parseOpt(sc.nextLine(), new String[] {"SPORTLICH", "NERDIG","SOZIAL"});
		
		while( input == -1 ) {
			System.out.println("Falsche Eingabe!");
			System.out.println("(Wähle eine Klasse: [Sportlich|Nerdig|Sozial])");
			input = cp.parseOpt(sc.nextLine(), new String[] {"SPORTLICH", "NERDIG","SOZIAL"}); 
		}; 
		System.out.println("");
		
		switch (input) {
		case 0: 
			System.out.println("'Jap du bist schon eine Sportskanone. Sie werden dir nicht widerstehen können.', denkst du dir während du dich so betrachtest.");
			player = new Sport(); 
			break; 
			
		case 1: 
			System.out.println("'Mit meinem Allgemein- und Fachwissen bin ich gut gerüstet. Die Gespräche werden ein Klacks!', denkst du dir während du dich so betrachtest.");
			player = new Nerd(); 
			break;
			
		case 2: 
			System.out.println("'Die wickel ich mit meinen Social-Skills easy um den Finger.', denkst du dir während du dich so betrachtest.");
			player = new Social(); 
			break;
		}
		
		player.setName(name); 
		
		System.out.println("Jetzt wo du wach bist und weißt wer du bist, rufst du dir langsam den Plan für den heutigen Tag ins Gedächtnis.");
		System.out.println("Das erste Bewerbungsgespräch hast du über einen Freund bekommen. Es handelt sich wohl um einen sehr lukrativen Promoterjob.");
		System.out.println("Irgendwas mit Gold. Dein Kumpel hatte dir eine super lange Rede gehalten, welche dich überzeugen konnte, dass das der perfekte Job ist."); 
		System.out.println("Man bekommt wohl sogar Geld dafür, wenn man weitere Freunde als Mitarbeiter findet. Das Goldgeschäft scheint zu boomen!");
		System.out.println("Lange hast du nicht mehr. Du könntest dich noch etwas herrichten oder schon einmal los gehen, um pünktlich da zu sein.");
		
	}
	
	//Start room home
	public void atHome() {
		System.out.println("");
		System.out.println("(Du stehst in deiner Einzimmerwohnung. Was tust du?)");
		cp.parseCmds(this.roomHome, this.player); 	
	}
	
	//Start gold part of story 
	public void atGold() {
		System.out.println("");
		if(this.player.getDressed() && this.player.getCombed()) {
			System.out.println("Nachdem du dich angekleidet und deine Haare in Form gebracht hast, verlässt du deine Wohnung.");
			System.out.println("Noch hält sich die Aufregung in Grenzen und du trittst mutig deinen Weg zum ersten Gespräch an.");
		}else {
			System.out.println("Ohne groß Zeit zu verlieren stürmst du aus dem Haus.");
			System.out.println("Du bist zwar eigentlich recht früh dran, aber was, wenn du dich verläufst?");
		}
		
		System.out.println("");
		System.out.println("Nach einer Weile kommst du am Ort des ersten Gesprächs an.");
		System.out.println("Etwas verwundert musst du feststellen, dass es sich um ein Café handelt.");
		System.out.println("Doch als du dich etwas verwirrt umguckst siehst du, wie ein junger, hipper Typ dich von drinnen zu sich winkt.");
		System.out.println("(Reingehen? [j|n])");
		System.out.println("");
		
		if( cp.parseOpt(sc.nextLine(), new String[] {"N", "J"})  == 0) {
			System.out.println("Das ist dir nicht geheuer. Du spazierst am Café vorbei als hättest du nie vorgehabt hinein zu gehen");
			System.out.println("und setzt dich bis zum nächsten Gespräch in einen Park");
		}else{
			System.out.println("'Das ist wohl Gang und Gebe bei so modernen Unternehmen', denkst du und betrittst das Café.");
			System.out.println("Der junge, dynamische Typ im Café heißt Gideon und kann dir so einiges über die Investition in Gold erzählen.");
			System.out.println("Seine Firma ist beraterisch tätig und hilft Privatleuten dabei ihr Geld vernünftig anzulegen.");
			System.out.println("Das Geschäftsmodell basiert dabei auf Provision und so weiter.");
			System.out.println("Aber das hat dir dein Freund eigentlich schon alles erklärt. Du schweifst also zwischendurch gedanklich etwas ab.");
			System.out.println("Es wird noch irgendwas Neues über Ägypten und Aufstiegsmöglichkeiten erzählt, aber du schaust dir lieber die schöne Innenausstattung des Cafés an.");
			System.out.println("Plötzlich und ohne dass du irgendwas gesagt hättest, liegt ein Vertrag vor dir. 'Du hast mich überzeugt!', sagt Gideon.");
			System.out.println("'Wenn du unterschreibst, kannst du gleich morgen anfangen.', sagt er lächelnd.");
			System.out.println("(Vertrag unterschreiben? [j|n])");
			System.out.println("");
			
			if( cp.parseOpt(sc.nextLine(), new String[] {"N", "J"}) == 0) {
				System.out.println("Du sagst du möchtest nochmal drüber nachdenken und verlässt möglichst bald das Café.");
				System.out.println("Gideon versucht dich zwar zu überreden zu unterschreiben, aber das hinterlässt ein noch mulmigeres Gefühl, als du sowieso schon hast.");
			}else {
				//bad ending
				System.out.println("'Klar bin ich dabei!', rufst du und unterschreibst entzückt.");
				System.out.println("Leider bist du damit auf ein Pyramidensystem reingefallen und verlierst nach und nach alle deine Freunde. Schade " + player.getName() + "!");
				gameOver();
			}
		};
		
	
	}
	
	//Start bar part of story
	public void atBar() {
		
		System.out.println("");
		System.out.println("Du hast das Gefühl grade eine gute Entscheidung getroffen zu haben. Dein nächster Stop ist die Bar 'MacLarens'.");
		System.out.println("Dort wird eine studentische Hilfskraft hinter der Theke gesucht und du wolltest schon immer mal lernen, wie man Cocktails mixt.");
		System.out.println("Du fährst mit der Bahn zur Bar und als du dort ankommst sagt dir eine Kellnerin du sollst erst einmal an der Theke warten.");
		System.out.println("Nach einer Weile setzt sich ein kleiner, durchtrainierter Mann mittleren Alters zu dir.");
		System.out.println("Er stellt sich als Moe vor und ist offenbar der Chef des Pubs.");
		System.out.println("Er sagt dir, dass dein Können eigentlich egal ist und jeder Barkeeper werden kann.");
		System.out.println("Das Einzige, was wichtig sei, ist ein gut trainierter Körper und eine soziale Ader.");
		
		System.out.println("");
		
		//bad ending
		if(!player.getDressed()) {
			System.out.println("Plötzlich mustert dich Moe von oben bis unten.");
			System.out.println("'Gibt es einen Grund warum du nur ein T-Shirt und Unterwäsche trägst?'");
			System.out.println("Oh nein! Das kann nicht sein! Dein schlimmster Albtraum ist wahr geworden:");
			System.out.println("Du hast vergessen dich anzuziehen!!");
			System.out.println("Du läufst nach Hause, ziehst dir die Decke über den Kopf und verlässt die Wohnung eine Woche nicht.");
			gameOver();
		}
		
		System.out.println("'Lass dich mal ansehen', sagt Moe.");
		if(player.getStrength() >= 10 && player.getCharisma() >= 10) {
			System.out.println("Er mustert dich kurz. 'Du scheinst mir als könntest du gut mit Menschen. Und athletisch bist du auch. Du kannst nächstes Wochenende anfangen, wenn du willst!'");
			System.out.println("(Den Job annehmen und nach Hause gehen? [j|n])");
			
			if( cp.parseOpt(sc.nextLine(), new String[] {"N", "J"}) == 0) {
				System.out.println("Du sagst es hört sich verlockend an, aber du wirst eine Nacht drüber schlafen und dich morgen melden.");
				System.out.println("'Kein Problem.', sagt Moe.");
			}else {
				
				// bad ending
				System.out.println("'Klar bin ich dabei!', rufst du.");
				System.out.println("Nachdem ihr die Formalia geklärt habt, gibt dir Moe noch ein Bier aus und du gehst gut gelaunt nach Hause.");
				System.out.println("Von nun an arbeitest du als Barkeeper und schlägst dir mit dem Job die Nächte um die Ohren.");
				System.out.println("Dabei vernachlässigst du dein Studium bis du irgendwann exmatrikuliert wirst.");
				System.out.println("Aber hey: Jetzt weißt du wie man Cocktails mixt!");
				gameOver();
			}
			
		}else if(player.getStrength() >= 10) {
			System.out.println("'Dein Körper ist nicht schlecht, aber an deiner Ausstrahlung musst du noch etwas arbeiten. Komm wieder, wenn du das getan hast.', sagt er.");
			 
		}else if(player.getCharisma() >= 10) {
			System.out.println("'Deine Ausstrahlung ist Top, aber du müsstest mal an deinem Körper arbeiten. Komm wieder, wenn du pumpen warst!', sagt er.");
		}else {
			System.out.println("'Ai, ai, ai. Also du bist ja mal gar nicht für den Job geeignet. Such dir lieber was, wo du nicht mit Menschen zu tun hast.', lacht er.");
			System.out.println("'Sorry, aber mit Nerds können wir in der Gastro leider nichts anfangen. Mach dir nichts draus!'");
		}
		
		System.out.println("");
		System.out.println("'Wenn du willst kannst du hier noch ein Bier trinken, wenn du schonmal her gekommen bist.', sagt Moe und zapft dir auch prombt eins.");
		System.out.println("Du hast noch etwas Zeit bis zum letzten Gespräch. Was tust du?");
		
		//Start room bar
		cp.parseCmds(this.roomBar, this.player); 	
	}
	
	//Start yolawo part of story 
	public void atYolawo() {
		System.out.println("");
		System.out.println("Du hast die Zeit erfolgreich totgeschlagen und kommst pünktlich bei deinem letzten Gespräch an: Die kleine Softwareschmiede Yolawo.");
		System.out.println("Du sollst noch ein paar Minuten im Empfangsbereich warten und dann geht's auch schon los.");
		System.out.println("");
		
		//bad ending
		if(player.getPoisoned()) {
			System.out.println("Während du da so sitzt, bekommst du plötzlich starke Magenkrämpfe und dir wird ganz schwummerig.");
			System.out.println("Es wird so schlimm, dass du dich entschuldigen musst und dich mit letzten Kräften nach Hause schleppst.");
			System.out.println("Du liegst ein paar Tage flach und der Job wird dir weggeschnappt. Blöd gelaufen.");
			System.out.println("Hättest du mal nicht die Pizza gegessen.");
			gameOver();
		}
		
		//bad ending
		if(!player.getCombed()) {
			System.out.println("Während du da so sitzt, entdeckst du dein Spiegelbild in einem Fenster.");
			System.out.println("Du hast dir gar nicht die Haare gekämmt! Oh nein, das kann ja nichts werden!"); 
			System.out.println("Hastig versuchst du irgendwie deine Haare in Ordnung zu kriegen und scheiterst kläglich.");
			System.out.println("Während des Gesprächs bist du deshalb so aufgeregt, dass du kaum ein Wort rausbekommst.");
			System.out.println("Die Jungs von Yolawo wissen so nicht viel mit dir anzufangen und sagen dir ab.");
			System.out.println("Vielleicht bringt die nächste Woche ja einen neuen Job.");
			gameOver();
		}
		
		//bad ending
		if(player.getDrunk()) {
			System.out.println("Nach einer kurzen Wartezeit wirst du zum Gespräch reingebeten.");
			System.out.println("Doch schon beim Händeschütteln wirst du eigenartig gemustert.");
			System.out.println("Es kommen im Gespräch auffällig viele Fragen zu deinen Trinkgewohnheiten.");
			System.out.println("Komisch...");
			System.out.println("Oh nein! Hast du etwa eine Fahne von dem Bier?");
			System.out.println("Du versuchst deinen Biergeruch zu entschuldigen, aber das macht alles nur noch schlimmer.");
			System.out.println("Hättest du doch nur abgelehnt!");
			gameOver();
		}
		
		System.out.println("Nach einer kurzen Wartezeit wirst du zum Gespräch reingebeten.");
		System.out.println("Du führst das Gespräch mit drei netten Jungen Typen und alles läuft glatt.");
		System.out.println("Du kannst mit deinen Erfahrungen in Back- und Frontend-Entwicklung punkten");
		System.out.println("und auch auf einer menschlichen Ebene verstehst du dich super mit deinen Gesprächspartnern.");
		System.out.println("Zuletzt bitten sie dich eine Code-Challenge für sie zu machen und einzureichen.");
		System.out.println("Du sollst eine Java-Anwendung schreiben, welche Interfaces und Abstrakte Klassen nutzt.");
		System.out.println("Auf dem nach Hause Weg grübelst du lange, welche Anwendung du schreiben könntest.");
		System.out.println("Nach ein paar unkreativen Einfällen entscheidest du dich ein kleines Text-Adventure zu schreiben.");
		System.out.println("Als du zu Hause bist, setzt du dich gleich dran und programmierst bis tief in die Nacht hinein.");
		System.out.println("Den Ausgang der Geschichte lässt du offen und die Spieler können ihn selbst entscheiden.");
		System.out.println("Als du fertig bist, sendest du ihnen den Code und hoffst auf das Beste...");

		// good ending
		win(); 
		
	}
	
	// Game over text
	public void gameOver() {
		System.out.println("");
		System.out.println("Game Over");
		System.out.println("Vielen Dank für's Spielen, vielleicht schaffst du's ja nächstes Mal!");
		System.exit(0);
	}
	
	// Game won text
	public void win() {
		System.out.println("");
		System.out.println("Gewonnen!");
		System.out.println("Vielen Dank für's Spielen. Ich hoffe es hat Spaß gemacht :)");
	}

}
