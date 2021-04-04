package Abstract;

import Interface.Item;
import Items.Inventory;

public abstract class Player {
	private int health;
	private int charisma;
	private int dexterity;
	private int intelligence;
	private int strength;
	private String name;

	private Inventory inventory;

	private boolean poisoned = false;
	private boolean drunk = false;
	private boolean dressed = false;
	private boolean combed = false;

	public Player() {
		inventory = new Inventory();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getName() {
		return name;
	}

	public void add(Item i) {
		this.inventory.add(i);
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void showInventory() {
		this.inventory.show();
	}

	public void isCombed() {
		this.combed = true;
	}

	public void isDressed() {
		this.dressed = true;
	}

	public void isPoisoned() {
		this.poisoned = true;
	}

	public void isDrunk() {
		this.drunk = true;
	}

	public boolean getDrunk() {
		return drunk;
	}

	public boolean getPoisoned() {
		return poisoned;
	}

	public boolean getCombed() {
		return this.combed;
	}

	public boolean getDressed() {
		return this.dressed;
	}
}
