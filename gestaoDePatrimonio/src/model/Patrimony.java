package model;

public abstract class Patrimony {
	
	// ATRIBUTES	
	
	private String name;
	private double value;
	private int amount = 1;
	
	//Constructors
	
	public Patrimony(String name, int amount, double value) {
		setName(name);
		setAmount(amount);
		setValue(value);
	}
	
	public Patrimony(String name) {
		this(name, 1, 0);
	}

	public Patrimony(String name, double value) {
		this(name,1,value);
	}
	
	public Patrimony(String name, int amount) {
		this(name,amount,0);
	}
	
	// GETTERS AND SETTERS
	
	public void setName(String name) {
		if(name == null) {
			this.name = "Nao informado";
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public void setValue(double value) {
		if(value > 0){
			this.value = value;
		}
	}

	public double getValue() {
		return value;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount > 1) {
			this.amount = amount;
		}
	}
	
	//Methods
	
	//Method that edits the name, the amount and the value
	public void edit(String name, int amount, double value) {
		setName(name);
		setAmount(amount);
		setValue(value);
	}
	
	//Method that edits the name 
	public void edit(String name) {
		setName(name);
	}
	
	//Method that edits the value
	public void edit(double value) {
		setValue(value);
	}
	
	//Method that edits the amount 
	public void edit(int amount) {
		setAmount(amount);
	}
	
	//Method that edits the name and the value
	public void edit(String name, double value) {
		setName(name);
		setValue(value);
	}
	
	//method that edits the name and the amount
	public void edit(String name, int amount) {
		setName(name);
		setAmount(amount);
	}
	
	//method that edits the name and the value
	public void edit(int amount, double value) {
		setAmount(amount);
		setValue(value);
	}
		
	//Method toString that returns the name and value of a Patrimony into a formated String
	public String toString() {
		String patrimony = String.format("Nome: %s, Unidades: %d, Valor unitario: %.2f",getName(),getAmount(),getValue());
		return patrimony;
	}
	
	
}